import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;


public class CuadroTexto {
    private Clases clase;  // La clase(Objeto)
    public int ancho;     // ancho del contenedor(cuadro) Probablemente cambiar por ancho de pantalla para hacerlo mas legible
    public int alto;    // largo del contenedor ---Igual que arriba cambiar probablemente
    public int x;         // Poscicion x
    public int y;         // Poscicion y
    private Font font;
    private boolean isFocused;
    private boolean isDragged;

    CuadroTexto(Clases clase, int ancho, int alto, Font font ) {
        this.clase = clase;
        this.alto = alto;
        this.ancho = ancho;
        this.x = 0;
        this.y = 0;
        this.font = font;
        this.isFocused = false;
        this.isDragged = false;
    }

    public void pintarCuadro(int x,int y, Graphics2D g) {
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // dibujar cuadrito
        ((Graphics2D) g).setColor(clase.getColor());
        ((Graphics2D) g).fillRect(x, y, ancho-10, alto);
        // dibujar borde cuadrito
        //g2d.setColor(clase.getColor().darker());
        //g2d.drawRect(x, y, width-10, height,40,40);

        // dibujar texto
        ((Graphics2D) g).setColor(Color.BLACK.brighter());
        ((Graphics2D) g).setFont(font);
        FontMetrics metrics = ((Graphics2D) g).getFontMetrics(font);

        int alturaStrings = metrics.getAscent()*2;
        int yName =y+metrics.getAscent()+(alto-alturaStrings)/2;
        //int yName2 = yName+metrics.getAscent();
        int yID =yName+metrics.getAscent();


        drawCenteredString((Graphics2D) g, clase.getNombre(), ancho-10, x, yName, metrics);
        g.drawString(clase.getCreditos(),x+ancho-40,y+alto-3);
        if (!clase.getClase().equalsIgnoreCase("")) {
            drawCenteredString((Graphics2D) g, "ID: " + clase.getClase(), ancho-10, x, yID, metrics);
        }
        this.x=x;
        this.y=y;
    }
    public void pintarFocused(int x,int y, Graphics2D g) {
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // dibujar cuadrito
        ((Graphics2D) g).setColor(new Color(255, 255, 255));
        ((Graphics2D) g).fillRect(x, y, ancho-10, alto);
        // dibujar borde cuadrito
        ((Graphics2D) g).setColor(Color.BLACK);
        ((Graphics2D) g).drawRect(x, y, ancho-10, alto);

        // dibujar texto
        ((Graphics2D) g).setColor(Color.BLACK.brighter());
        ((Graphics2D) g).setFont(font);
        FontMetrics metrics = ((Graphics2D) g).getFontMetrics(font);

        int alturaStrings = metrics.getAscent()*3;
        int yName =y+metrics.getAscent()+(alto-alturaStrings)/2;
        //int yName2 = yName+metrics.getAscent();
        int yCredits =yName+metrics.getAscent();
        int yID =yCredits+metrics.getAscent();


        drawCenteredString((Graphics2D) g, clase.getNombre(), ancho-10, x, yName, metrics);
        drawCenteredString((Graphics2D) g, "Creditos: " + clase.getCreditos(), ancho-10, x, yCredits, metrics);
        g.drawString(clase.getCreditos(),x+ancho,y+alto);
        drawCenteredString((Graphics2D) g, "ID: " + clase.getClase(), ancho-10, x, yID, metrics);
        this.x=x;
        this.y=y;
    }
    public void pintarPost(int x,int y, Graphics2D g) {
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // dibujar cuadrito
        ((Graphics2D) g).setColor(new Color(31, 110, 5,200));
        ((Graphics2D) g).fillRect(x, y, ancho-10, alto);
        // dibujar borde cuadrito
        ((Graphics2D) g).setColor(Color.BLACK);
        ((Graphics2D) g).drawRect(x, y, ancho-10, alto);

        // dibujar texto
        ((Graphics2D) g).setColor(Color.BLACK.brighter());
        ((Graphics2D) g).setFont(font);
        FontMetrics metrics = ((Graphics2D) g).getFontMetrics(font);

        int alturaStrings = metrics.getAscent()*3;
        int yName =y+metrics.getAscent()+(alto-alturaStrings)/2;
        //int yName2 = yName+metrics.getAscent();
        int yCredits =yName+metrics.getAscent();
        int yID =yCredits+metrics.getAscent();


        drawCenteredString((Graphics2D) g, clase.getNombre(), ancho-10, x, yName, metrics);
        drawCenteredString((Graphics2D) g, "Creditos: " + clase.getCreditos(), ancho-10, x, yCredits, metrics);
        g.drawString(clase.getCreditos(),x+ancho,y+alto);
        drawCenteredString((Graphics2D) g, "ID: " + clase.getClase(), ancho-10, x, yID, metrics);
        this.x=x;
        this.y=y;
    }
    public void pintarPre(int x,int y, Graphics2D g) {
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // dibujar cuadrito
        ((Graphics2D) g).setColor(new Color(179, 5, 72,200));
        ((Graphics2D) g).fillRect(x, y, ancho-10, alto);
        // dibujar borde cuadrito
        ((Graphics2D) g).setColor(Color.BLACK);
        ((Graphics2D) g).drawRect(x, y, ancho-10, alto);

        // dibujar texto
        ((Graphics2D) g).setColor(Color.BLACK.brighter());
        ((Graphics2D) g).setFont(font);
        FontMetrics metrics = ((Graphics2D) g).getFontMetrics(font);

        int alturaStrings = metrics.getAscent()*3;
        int yName =y+metrics.getAscent()+(alto-alturaStrings)/2;
        //int yName2 = yName+metrics.getAscent();
        int yCredits =yName+metrics.getAscent();
        int yID =yCredits+metrics.getAscent();


        drawCenteredString((Graphics2D) g, clase.getNombre(), ancho-10, x, yName, metrics);
        drawCenteredString((Graphics2D) g, "Creditos: " + clase.getCreditos(), ancho-10, x, yCredits, metrics);
        g.drawString(clase.getCreditos(),x+ancho,y+alto);
        drawCenteredString((Graphics2D) g, "ID: " + clase.getClase(), ancho-10, x, yID, metrics);
        this.x=x;
        this.y=y;
    }
    public void pintarCo(int x,int y, Graphics2D g) {
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // dibujar cuadrito
        ((Graphics2D) g).setColor(new Color(255, 255, 255));
        ((Graphics2D) g).fillRect(x, y, ancho-10, alto);
        // dibujar borde cuadrito
        ((Graphics2D) g).setColor(Color.BLACK);
        ((Graphics2D) g).drawRect(x, y, ancho-10, alto);

        // dibujar texto
        ((Graphics2D) g).setColor(Color.BLACK.brighter());
        ((Graphics2D) g).setFont(font);
        FontMetrics metrics = ((Graphics2D) g).getFontMetrics(font);

        int alturaStrings = metrics.getAscent()*3;
        int yName =y+metrics.getAscent()+(alto-alturaStrings)/2;
        //int yName2 = yName+metrics.getAscent();
        int yCredits =yName+metrics.getAscent();
        int yID =yCredits+metrics.getAscent();


        drawCenteredString((Graphics2D) g, clase.getNombre(), ancho-10, x, yName, metrics);
        drawCenteredString((Graphics2D) g, "Creditos: " + clase.getCreditos(), ancho-10, x, yCredits, metrics);
        g.drawString(clase.getCreditos(),x+ancho,y+alto);
        drawCenteredString((Graphics2D) g, "ID: " + clase.getClase(), ancho-10, x, yID, metrics);
        this.x=x;
        this.y=y;
    }
    private static void drawCenteredString(Graphics g, String text,int anchoCuadro, int xCuadro, int yTexto, FontMetrics metrics) {
        int textWidth = metrics.stringWidth(text);
        g.drawString(text, xCuadro+(anchoCuadro - textWidth)/2, yTexto);
    }


    public Clases getClase() {
        return clase;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    public boolean isFocused() {
        return isFocused;
    }
    public void setFocused(boolean focused) {
        isFocused = focused;
    }
    public boolean isDragged() {
        return isDragged;
    }
    public void setDragged(boolean dragged) {
        isDragged = dragged;
    }

}
