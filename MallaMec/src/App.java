import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class App {
public static void main(String[] args) throws Exception {

    /*
    Map<String,Clases> mapa = Clases.clasesMecatronica(Clases.inicializarClases());
    for (Clases clase : mapa.values()) {
        System.out.println(clase.getClase());
        System.out.println(clase.getNombre());
        System.out.println(clase.getSemestre());
        System.out.println(clase.getColor());
        System.out.println(clase.getCoRequisitos().toString());
        System.out.println(clase.getPostRequisitos().toString());
        System.out.println(clase.getPreRequisitos().toString());
        System.out.println(clase.getCreditos()+"\n");
    }*/

    JFrame frame = new JFrame("Malla Ingenieria Mecatronica");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close

    // Set the frame size to the screen dimensions and maximize it
    frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,    //Obtener lo ancho mas lo largo de la pantalla
                (Toolkit.getDefaultToolkit().getScreenSize().height-Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration()).bottom));
    frame.setUndecorated(false); // Ensure window decorations are shown
    frame.setResizable(false);


    Malla malla = new Malla();
    frame.add(malla);

    // Make the frame visible
    frame.setVisible(true);
}
}
