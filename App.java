import javax.swing.*;

public class App {
public static void main(String[] args) throws Exception {
    int cuadroAncho = 1500;
    int cuadroLargo = 600;

    JFrame frame = new JFrame("Malla Ingenieria Mecatronica");
    frame.setVisible(true);
    frame.setSize(cuadroAncho,cuadroLargo);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Malla malla = new Malla();
    frame.add(malla);
    frame.pack();
    frame.setVisible(true);

}
}
