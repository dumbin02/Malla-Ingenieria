import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

public class Malla extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

    int fondoAncho;
    int fondoLargo;
    int cuadroAncho;
    int cuadroLargo;

    Image backgroundImg;
    Font fuente1;
    Font fuente1B;
    Font cuadroFuente;
    Timer gameLoop;

    int backgroundOriginalAncho;
    int backgroundOriginalLargo;
    double aspectRatio;
    int backgroundAncho;
    int backgroundLargo;
    int backgroundX;
    int backgroundY;
    ArrayList<Clases> claseFocusPost;
    ArrayList<Clases> claseFocusPre;
    ArrayList<Clases> claseFocusCo;

    ArrayList<ArrayList<CuadroTexto>> cuadrosSemestre;



    // Constructor de malla
    Malla() throws FontFormatException, IOException {
        // Configurar el tamaño inicial de la malla
        fondoAncho = 1520;
        fondoLargo = 820;
        cuadroAncho = fondoAncho / 10;
        cuadroLargo = fondoLargo / 12;

        // Cargar la imagen de fondo y calcular su relación de aspecto
        backgroundImg = new ImageIcon(getClass().getResource("background2.jpg")).getImage();
        backgroundOriginalAncho = backgroundImg.getWidth(null);
        backgroundOriginalLargo = backgroundImg.getHeight(null);
        aspectRatio = (double) backgroundOriginalAncho / backgroundOriginalLargo;

        // Ajustar la imagen de fondo para mantener la relación de aspecto
        if (aspectRatio > (double) fondoAncho / fondoLargo) {
            backgroundAncho = (int) (fondoLargo * aspectRatio);
            backgroundLargo = fondoLargo;
            backgroundX = (fondoAncho - backgroundAncho) / 2;
            backgroundY = 0;
        } else {
            backgroundAncho = fondoAncho;
            backgroundLargo = (int) (fondoAncho / aspectRatio);
            backgroundX = 0;
            backgroundY = (fondoLargo - backgroundLargo) / 2;
        }

        // Configurar para recibir eventos de teclado y mouse
        setFocusable(true);
        claseFocusPost =new ArrayList<>();
        claseFocusPre =new ArrayList<>();
        claseFocusCo =new ArrayList<>();



        // Cargar y registrar las fuentes
        InputStream fontStream = getClass().getResourceAsStream("/prmR.ttf");
        fuente1 = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(23f);

        fontStream = getClass().getResourceAsStream("/prmR.ttf");
        fuente1B = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(40f);

        fontStream = getClass().getResourceAsStream("/Helvetica Bold Condensed.otf");
        cuadroFuente = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(11f);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(fuente1);
        ge.registerFont(fuente1B);
        ge.registerFont(cuadroFuente);

        Map<String,Clases> mapa = Clases.inicializarMecatronica(Clases.inicializarClases());
        cuadrosSemestre = Clases.CuadrosSemestre(CuadroTexto.cuadrosLista(mapa,cuadroAncho,cuadroLargo,cuadroFuente));


        // Iniciar el bucle de actualización para la animación, 120 FPS
        gameLoop = new Timer(1000 / 60, this);
        gameLoop.start();
        addMouseListener(this);
        addMouseMotionListener(this);
    }


    public void paintComponent(Graphics g) {
        //Metodo para pintar aun no se como funciona del todo
        super.paintComponent(g);
        //llama la funcion de abajo, dibuja todo
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(backgroundImg, backgroundX, backgroundY, backgroundAncho, backgroundLargo, null);

        // Título
        g.setFont(fuente1B);
        g.setColor(Color.GRAY.darker().darker());
        g.drawString("Malla Mecatronica", centrarTextoX(fondoAncho, "Malla Mecatronica", fuente1B, g), 15 + alturaTexto(fuente1B, g));

        // Líneas y semestres
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gradientPaint = new GradientPaint(0, 0, Color.black.brighter(), 0, 800, Color.red.darker());
        g.setFont(fuente1B);

        for (int i = 1; i < 11; i++) {
            g.setColor(Color.GRAY.darker().darker());
            g.drawString(i + ".°", ((cuadroAncho) - (anchoTexto(String.valueOf(i), fuente1, g))) / 2 + ((i - 1) * (cuadroAncho)), 80 - alturaTexto(fuente1, g));
            g2d.setPaint(gradientPaint);
            g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            if (i != 10) {
                g2d.drawLine((cuadroAncho) * i, 100, (cuadroAncho) * i, fondoLargo - 40);
            }
        }
        //test de materia no terminado
        for(int i=0; i<10; i++){
            int j =0;
            for(CuadroTexto cuadro:cuadrosSemestre.get(i)){
                if(cuadro.isFocused()){cuadro.pintarFocused(5+(i*cuadroAncho),85+j*(cuadroLargo+5),g2d);cuadro.setX(5+(i*cuadroAncho));cuadro.setY(85+j*(cuadroLargo+5));}
                else if(claseFocusPost.contains(cuadro.getClase())){cuadro.pintarPost(5+(i*cuadroAncho),85+j*(cuadroLargo+5),g2d);cuadro.setX(5+(i*cuadroAncho));cuadro.setY(85+j*(cuadroLargo+5));}
                else if(claseFocusPre.contains(cuadro.getClase())){cuadro.pintarPre(5+(i*cuadroAncho),85+j*(cuadroLargo+5),g2d);cuadro.setX(5+(i*cuadroAncho));cuadro.setY(85+j*(cuadroLargo+5));}
                else if(claseFocusCo.contains(cuadro.getClase())){cuadro.pintarCo(5+(i*cuadroAncho),85+j*(cuadroLargo+5),g2d);cuadro.setX(5+(i*cuadroAncho));cuadro.setY(85+j*(cuadroLargo+5));}
                else{cuadro.pintarCuadro( 5+(i*cuadroAncho),85+j*(cuadroLargo+5),g2d);cuadro.setX(5+(i*cuadroAncho));cuadro.setY(85+j*(cuadroLargo+5));}

                j++;
            }
        }

    }


    public int centrarTextoX(int cuadroAncho, String texto, Font fuente, Graphics g) {
        FontMetrics metrics = g.getFontMetrics(fuente);
        int largoTexto = metrics.stringWidth(texto);
        return (int) ((cuadroAncho - largoTexto) / 2);
    }

    public int alturaTexto(Font fuente, Graphics g) {
        FontMetrics metrics = g.getFontMetrics(fuente);
        int altoTexto = metrics.getHeight();
        return altoTexto - 20;
    }

    public int anchoTexto(String texto, Font fuente, Graphics g) {
        FontMetrics metrics = g.getFontMetrics(fuente);
        return metrics.stringWidth(texto);
    }

    public boolean isMouseOver(int x, int y, CuadroTexto b) {
        return x < b.x + b.ancho-10 && x > b.x && y < b.y + b.alto && y > b.y;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Matriz 2d de cuadros de Clases en sus respectivos semestres
        for (ArrayList<CuadroTexto> semestres : cuadrosSemestre) {
            for (CuadroTexto cuadro : semestres) {
                boolean estadoFocus = cuadro.isFocused();
                boolean focused = isMouseOver(e.getX(), e.getY(), cuadro);
                // Si hay un cambio de estado, actualiza y repinta
                if (estadoFocus != focused) {
                    cuadro.setFocused(focused);
                    if(cuadro.isFocused()){
                        claseFocusPost = cuadro.getClase().getPostRequisitos();
                        claseFocusPre = cuadro.getClase().getPreRequisitos();
                        claseFocusCo = cuadro.getClase().getCoRequisitos();}
                    else{claseFocusPre =new ArrayList<>();
                        claseFocusCo =new ArrayList<>();
                        claseFocusPost =new ArrayList<>();
                    }
                    repaint();

                }
            }
        }



    }
}
