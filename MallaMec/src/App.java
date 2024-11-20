import javax.swing.*;
import java.util.Map;

public class App {
public static void main(String[] args) throws Exception {

    JFrame frame = new JFrame("Malla Ingenieria Mecatronica");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar al salir

    // Set Size al tamaño de la ventana del usuario
    frame.setSize(1520,820);
    frame.setUndecorated(false); // que se vea la pestaña de arriba(x minimizar etc)
    frame.setResizable(false); //que no se pueda modificar el tamaño

    //instancia de Malla, añadir a la ventana
    Malla malla = new Malla();
    frame.add(malla);
    malla.requestFocus();

    // Volver visible
    frame.setVisible(true);
}
}
