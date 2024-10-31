
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.*;

public class Malla extends JPanel{
    private static final Graphics2D Graphics2D = null;
    int cuadroAncho = 1450;
    int cuadroLargo = 750;
    int lineaAncho  = 200;
    int lineaLargo  = 550;

    Image backgroundImg;
    Image lineaImg;

    Font fuente1;
    Font fuente1B;
    Font fuente2;

    
    //Constructor de malla
    Malla() throws FontFormatException, IOException {
        //Iniciar Largo y Ancho preferido, set focusable para eventos
        setPreferredSize(new Dimension(cuadroAncho,cuadroLargo));
        setFocusable(true);

        //Imagen Background
        backgroundImg = new ImageIcon(getClass().getResource("background2.jpg")).getImage();

        // Cargar las fuentes
        InputStream fontStream = getClass().getResourceAsStream("/font1.ttf");
        fuente1 = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(50f);
        fontStream = getClass().getResourceAsStream("/font2.ttf");
        fuente1B = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(50f);
        fontStream = getClass().getResourceAsStream("/font3.ttf");
        fuente2 = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(50f);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(fuente1);
        
    }

    

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        //Calculos completamente innecesarios para que la imagen quede centrada y sin estirarse
        int backgroundOriginalAncho = backgroundImg.getWidth(null);
        int backgroundOriginalLargo = backgroundImg.getHeight(null);
        double aspectRatio = (double) backgroundOriginalAncho/backgroundOriginalLargo;
        if(aspectRatio > cuadroAncho/cuadroLargo){
            int backgroundAncho = (int) (cuadroLargo * aspectRatio);
            int backgroundLargo = cuadroLargo;
            // Calculate Y position to center the image vertically
            int backgroundX = (cuadroAncho - backgroundAncho) / 2;
            int backgroundY = 0;
            // Draw the image centered without stretching
            g.drawImage(backgroundImg, backgroundX, backgroundY, backgroundAncho, backgroundLargo, null);
        }else{
            int backgroundAncho = cuadroAncho;
            int backgroundLargo = (int) (cuadroAncho / aspectRatio);
            // Calculate Y position to center the image vertically
            int backgroundX = 0;
            int backgroundY = (cuadroLargo - backgroundLargo) / 2;
            // Draw the image centered without stretching
            g.drawImage(backgroundImg, backgroundX, backgroundY, backgroundAncho, backgroundLargo, null);
        }//Termina imagen de fondo

        //lineas
        Graphics2D g2d = (Graphics2D) g;
        for(int i=1; i < 10; i++){
            g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2d.setColor(Color.WHITE);
            g2d.drawLine((cuadroAncho/10)*i, 130, (cuadroAncho/10)*i, 690);
        }
        

        //Titulo
        g.setFont(fuente1B);
        g.setColor(Color.WHITE);
        g.drawString("Malla Mecatronica",  centrarTextoX(cuadroAncho, "Malla Mecatronica", fuente1B, g), alturaTexto(fuente1B, g));
        
        //Lineas

    }
    
    public int centrarTextoX(int cuadroAncho,String texto, Font fuente,Graphics g){
        FontMetrics metrics = g.getFontMetrics(fuente);
        int largoTexto = metrics.stringWidth(texto);
        return (int)((cuadroAncho-largoTexto)/2); 
    }

    public int centrarTextoY(int cuadroAncho, Font fuente, Graphics g){
        FontMetrics metrics = g.getFontMetrics(fuente);
        int altoTexto = metrics.getHeight();
        return (int)((cuadroLargo-altoTexto)/2); 
    }

    public int alturaTexto( Font fuente, Graphics g){
        FontMetrics metrics = g.getFontMetrics(fuente);
        int altoTexto = metrics.getHeight();
        return altoTexto-20;
    }

    public int anchoTexto(String texto, Font fuente, Graphics g){
        FontMetrics metrics = g.getFontMetrics(fuente);
        int anchoTexto = metrics.stringWidth(texto);
        return anchoTexto;
    }
    
    private BufferedImage changeColor(BufferedImage original, Color color) {
        // Create a new buffered image with the same size and type
        BufferedImage newImage = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = newImage.createGraphics();

        // Set the color and alpha
        g2d.setColor(color);
        g2d.setComposite(AlphaComposite.SrcIn); // Apply color only to non-transparent pixels

        // Draw the original image onto the new image with the specified color
        g2d.drawImage(original, 0, 0, null);
        g2d.dispose();

        return newImage;
    }
}