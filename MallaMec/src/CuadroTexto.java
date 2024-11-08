import java.awt.*;
import java.util.ArrayList;
import java.util.Map;


public class cuadrosDeTexto {
    private Map<String,Clases> mapa;
    private ArrayList<ArrayList<Clases>> clasesSemestres;
    private Clases clase;  // La clase(Objeto)
    public int ancho;     // ancho del contenedor(cuadro) Probablemente cambiar por ancho de pantalla para hacerlo mas legible
    public int alto;    // largo del contenedor ---Igual que arriba cambiar probablemente
    public int x;         // Poscicion x
    public int y;         // Poscicion y
    private Font font;

    cuadrosDeTexto(){
        mapa = Clases.inicializarMecatronica(Clases.inicializarClases());
        clasesSemestres = Clases.ClasesSemestre(mapa);

    }

    public static void pintarCuadro(Clases clase,Graphics g,int width, int height,Font font,int x,int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // dibujar cuadrito
        g2d.setColor(clase.getColor());
        g2d.fillRect(x, y, width-10, height);
        // dibujar borde cuadrito
        //g2d.setColor(clase.getColor().darker());
        //g2d.drawRect(x, y, width-10, height,40,40);

        // dibujar texto
        g2d.setColor(Color.BLACK.brighter());
        g2d.setFont(font);
        FontMetrics metrics = g2d.getFontMetrics(font);

        int alturaStrings = metrics.getAscent()*3;
        int yName =y+metrics.getAscent()+(height-alturaStrings)/2;
        //int yName2 = yName+metrics.getAscent();
        int yCredits =yName+metrics.getAscent();
        int yID =yCredits+metrics.getAscent();


        drawCenteredString(g2d, clase.getNombre(), width-10, x, yName, metrics);
        drawCenteredString(g2d, "Creditos: " + clase.getCreditos(), width-10, x, yCredits, metrics);
        drawCenteredString(g2d, "ID: " + clase.getClase(), width-10, x, yID, metrics);
    }
    public static void pintarFocused(Clases clase,Graphics g,int width, int height, Color color,Font font,int x,int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // dibujar cuadrito
        g2d.setColor(color);
        g2d.fillRect(x, y, width-10, height);
        // dibujar borde cuadrito
        //g2d.setColor(clase.getColor().darker());
        //g2d.drawRect(x, y, width-10, height,40,40);

        // dibujar texto
        g2d.setColor(Color.BLACK.brighter());
        g2d.setFont(font);
        FontMetrics metrics = g2d.getFontMetrics(font);

        int alturaStrings = metrics.getAscent()*3;
        int yName =y+metrics.getAscent()+(height-alturaStrings)/2;
        //int yName2 = yName+metrics.getAscent();
        int yCredits =yName+metrics.getAscent();
        int yID =yCredits+metrics.getAscent();


        drawCenteredString(g2d, clase.getNombre(), width-10, x, yName, metrics);
        drawCenteredString(g2d, "Creditos: " + clase.getCreditos(), width-10, x, yCredits, metrics);
        drawCenteredString(g2d, "ID: " + clase.getClase(), width-10, x, yID, metrics);
    }

    private static void drawCenteredString(Graphics g, String text,int anchoCuadro, int xCuadro, int yTexto, FontMetrics metrics) {
        int textWidth = metrics.stringWidth(text);
        g.drawString(text, xCuadro+(anchoCuadro - textWidth)/2, yTexto);
    }

    public ArrayList<ArrayList<Clases>> getClasesSemestres() {
        return clasesSemestres;
    }

    public Map<String, Clases> getMapa() {
        return mapa;
    }

    public Clases getClase() {
        return clase;
    }
}
