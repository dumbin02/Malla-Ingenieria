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
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar al salir

    // Set Size al tamaño de la ventana del usuario
    frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,    //Obtener lo ancho mas lo largo de la pantalla
                (Toolkit.getDefaultToolkit().getScreenSize().height-Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration()).bottom));
    frame.setUndecorated(false); // que se vea la pestaña de arriba(x minimizar etc)
    frame.setResizable(false); //que no se pueda modificar el tamaño

    //instancia de Malla, añadir a la ventana
    Malla malla = new Malla();
    frame.add(malla);

    // Volver visible
    frame.setVisible(true);
}
}
