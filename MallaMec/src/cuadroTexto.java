import javax.swing.*;
import java.awt.*;


public class cuadroTexto extends JPanel {
    private Clases clase;  // La clase(Objeto)
    private int ancho;     // ancho de el contenedor(cuadro) Probablemente cambiar por ancho de pantalla para hacerlo mas legible
    private int height;    // largo de el contenedor ---Igual que arriba cambiar probablemente
    private int x;         // Poscicion x
    private int y;         // Poscicion y
    private Font font;

    public cuadroTexto(Clases clase, int width, int height, Font font) {
        this.clase = clase;
        this.ancho = width;
        this.height = height;
        this.font = font;
        setPreferredSize(new Dimension(width, height));
        setBackground(clase.getColor());
    }

    public static void pintarCuadro(Clases clase,Graphics g,int width, int height, Color color,Font font,int x,int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // dibujar cuadrito
        g2d.setColor(clase.getColor());
        g2d.fillRect(x, y, width, height);
        // dibujar borde cuadrito
        g2d.setColor(new Color(0, 0, 0,190));
        g2d.drawRect(x, y, width, height);

        // dibujar texto
        g2d.setColor(Color.BLACK.brighter());
        g2d.setFont(font);
        FontMetrics metrics = g2d.getFontMetrics(font);

        int filaAltura = height / 6;
        int yName =y + filaAltura - metrics.getHeight() / 2 + metrics.getAscent();
        int yCredits =y + filaAltura * 2 - metrics.getHeight() / 2 + metrics.getAscent();
        int yID =y + filaAltura * 3 - metrics.getHeight() / 2 + metrics.getAscent();

        drawCenteredString(g2d, clase.getNombre(), width, x, yName, metrics);
        drawCenteredString(g2d, "Creditos: " + clase.getCreditos(), width, x, yCredits, metrics);
        drawCenteredString(g2d, "ID: " + clase.getClase(), width, x, yID, metrics);
    }

    private static void drawCenteredString(Graphics g, String text,int anchoCuadro, int xCuadro, int yTexto, FontMetrics metrics) {
        int textWidth = metrics.stringWidth(text);
        g.drawString(text, xCuadro+(anchoCuadro - textWidth)/2, yTexto);
    }
}