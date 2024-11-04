import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

public class Malla extends JPanel implements ActionListener {
    Map<String,Clases> mapa = Clases.clasesMecatronica(Clases.inicializarClases());
    ArrayList<Clases> listaClases1 = new ArrayList<>(mapa.values()) ;

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

    // Constructor de malla
    Malla() throws FontFormatException, IOException {
        // Imagen de fondito
        backgroundImg = new ImageIcon(getClass().getResource("background2.jpg")).getImage();
        backgroundOriginalAncho = backgroundImg.getWidth(null);
        backgroundOriginalLargo = backgroundImg.getHeight(null);
        aspectRatio = (double) backgroundOriginalAncho / backgroundOriginalLargo;

        // Nos permite escuchar clics etc.
        setFocusable(true);

        // Cargar las fuentes
        InputStream fontStream = getClass().getResourceAsStream("/prmR.ttf");
        fuente1 = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(23f);
        fontStream = getClass().getResourceAsStream("/prmR.ttf");
        fuente1B = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(40f);
        fontStream = getClass().getResourceAsStream("/font4.otf");
        cuadroFuente = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(17f);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(fuente1B);

        cuadroTexto cuadroTexto = new cuadroTexto(mapa.get("CÁLCULO DIFERENCIAL"),100,100,cuadroFuente);

        //30 frames por segundo timer, loop para la aplicacion(se actualiza la imagen 30 veces por segundo)
        gameLoop = new Timer(1000 / 120, this);
        gameLoop.start();
    }

    public void paintComponent(Graphics g) {
        //Metodo para pintar aun no se como funciona del todo
        super.paintComponent(g);

        //En caso de mal performance optimizar para que esto no se haga cada frame(supongo? xd)
        // Utiliza el largo y ancho del frame para devolver los tamaños
        cuadroAncho = getWidth();
        cuadroLargo = getHeight();

        // Es para conservar el aspect ratio de la imagen de fondo(que no se vea estirada)
        if (aspectRatio > (double) cuadroAncho / cuadroLargo) {
            backgroundAncho = (int) (cuadroLargo * aspectRatio);
            backgroundLargo = cuadroLargo;
            backgroundX = (cuadroAncho - backgroundAncho) / 2;
            backgroundY = 0;
        } else {
            backgroundAncho = cuadroAncho;
            backgroundLargo = (int) (cuadroAncho / aspectRatio);
            backgroundX = 0;
            backgroundY = (cuadroLargo - backgroundLargo) / 2;
        }
        //llama la funcion de abajo, dibuja todo
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(backgroundImg, backgroundX, backgroundY, backgroundAncho, backgroundLargo, null);

        // Título
        g.setFont(fuente1B);
        g.setColor(Color.GRAY.darker().darker());
        g.drawString("Malla Mecatronica", centrarTextoX(cuadroAncho, "Malla Mecatronica", fuente1B, g), 15 + alturaTexto(fuente1B, g));

        // Líneas y semestres
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gradientPaint = new GradientPaint(0, 0, Color.black.brighter(), 0, 800, Color.red.darker());
        g.setFont(fuente1B);

        for (int i = 1; i < 11; i++) {
            g.setColor(Color.GRAY.darker().darker());
            g.drawString(i + ".°", ((cuadroAncho / 10) - (anchoTexto(String.valueOf(i), fuente1, g))) / 2 + ((i - 1) * (cuadroAncho / 10)), 80 - alturaTexto(fuente1, g));
            g2d.setPaint(gradientPaint);
            g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            if (i != 10) {
                g2d.drawLine((cuadroAncho / 10) * i, 100, (cuadroAncho / 10) * i, cuadroLargo - 40);
            }
        }
        //test de materia no terminado
        for(int i=0; i<listaClases1.size(); i++){
            cuadroTexto.pintarCuadro(listaClases1.get(i),g2d,cuadroAncho/10-10,cuadroLargo/12,listaClases1.get(i).getColor(),cuadroFuente, 4,90+(i*90));

        }

    }




    public int centrarTextoX(int cuadroAncho, String texto, Font fuente, Graphics g) {
        FontMetrics metrics = g.getFontMetrics(fuente);
        int largoTexto = metrics.stringWidth(texto);
        return (int) ((cuadroAncho - largoTexto) / 2);
    }

    public int centrarTextoY(int cuadroAncho, Font fuente, Graphics g) {
        FontMetrics metrics = g.getFontMetrics(fuente);
        int altoTexto = metrics.getHeight();
        return (int) ((cuadroLargo - altoTexto) / 2);
    }

    public int alturaTexto(Font fuente, Graphics g) {
        FontMetrics metrics = g.getFontMetrics(fuente);
        int altoTexto = metrics.getHeight();
        return altoTexto - 20;
    }

    public int anchoTexto(String texto, Font fuente, Graphics g) {
        FontMetrics metrics = g.getFontMetrics(fuente);
        int anchoTexto = metrics.stringWidth(texto);
        return anchoTexto;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
