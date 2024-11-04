import javax.swing.*;
import java.awt.*;


public class cuadroTexto extends JPanel {
    private Clases clase;  // The class object containing the data to display
    private int width;     // Width of the square
    private int height;    // Height of the square

    public cuadroTexto(Clases clase, int width, int height) {
        this.clase = clase;
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
        setBackground(clase.getColor()); // Set the color from the class color property
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        pintarCuadro(g);
    }

    public void pintarCuadro(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw background color
        g2d.setColor(getBackground());
        g2d.fillRect(0, 0, width, height);

        // Draw text
        g2d.setColor(Color.WHITE);
        Font font = new Font("Arial", Font.BOLD, 12);
        g2d.setFont(font);
        FontMetrics metrics = g2d.getFontMetrics(font);

        int rowHeight = height / 3;
        int yName = rowHeight - metrics.getHeight() / 2 + metrics.getAscent();
        int yCredits = rowHeight * 2 - metrics.getHeight() / 2 + metrics.getAscent();
        int yID = rowHeight * 3 - metrics.getHeight() / 2 + metrics.getAscent();

        drawCenteredString(g2d, clase.getNombre(), width / 2, yName, metrics);
        drawCenteredString(g2d, "Credits: " + clase.getCreditos(), width / 2, yCredits, metrics);
        drawCenteredString(g2d, "ID: " + clase.getClase(), width / 2, yID, metrics);
    }

    private void drawCenteredString(Graphics g, String text, int x, int y, FontMetrics metrics) {
        int textWidth = metrics.stringWidth(text);
        g.drawString(text, x - textWidth / 2, y);
    }
}
