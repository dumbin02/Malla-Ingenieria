import java.awt.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

/*  El proposito de esta clase es inicializar las clases de Mecatronica, con el metodo inicializarClasesMec, en teoria
    se podrian agregar mas carreras/clases
*/

public class Clases {
    private String Clase;
    private String Nombre;
    private double Creditos;
    private int Semestre;
    private Color color;
    private ArrayList<String> preRequisitos;
    private ArrayList<String> postRequisitos;
    private ArrayList<String> coRequisitos;
    public Clases(String Clase, String Nombre, double Creditos, Color color) {
        this.Clase = Clase;
        this.Nombre = Nombre;
        this.Creditos = Creditos;
        this.Semestre = 0;
        this.color = color;
        this.preRequisitos = new ArrayList<>();
        this.postRequisitos = new ArrayList<>();
        this.coRequisitos = new ArrayList<>();
    }

    public static Map<String, Clases> inicializarClases() {
        //Iniciar array que devolveremos con nuestras clases
        Map<String, Clases> clasesMap = new HashMap<>();

        //Crear las clases que usaremos. -Agregar Co-Pre-PostRequisitos a las clases que corresponden-
        //CalculoDiferencial
        clasesMap.put("CÁLCULO DIFERENCIAL", new Clases("MAT1402", "CÁLCULO DIFERENCIAL", 6, Color.BLUE));
        //CALCULO INTEGRAL
        clasesMap.put("CÁLCULO INTEGRAL", new Clases("MAT1403", "CÁLCULO INTEGRAL", 6, Color.BLUE));
        //CALCULO MULTIVARIADO
        clasesMap.put("CÁLCULO MULTIVARIADO", new Clases("MAT2401", "CÁLCULO MULTIVARIADO", 6, Color.BLUE));
        //METODOS NUMERICOS
        clasesMap.put("MÉTODOS NUMÉRICOS", new Clases("MAT3402", "MÉTODOS NUMÉRICOS", 3.5, Color.BLUE));

        //Post-Co-PreRequisitos de las clases Despues de crearlas
        //Calculo Integral
        clasesMap.get("CÁLCULO DIFERENCIAL").postRequisitos.add("CÁLCULO INTEGRAL");
        //Calculo Integral
        clasesMap.get("CÁLCULO INTEGRAL").preRequisitos.add("CÁLCULO DIFERENCIAL");
        clasesMap.get("CÁLCULO INTEGRAL").postRequisitos.add("CÁLCULO MULTIVARIADO");
        clasesMap.get("CÁLCULO INTEGRAL").postRequisitos.add("MÉTODOS NUMÉRICOS");
        //Calculo Multivariado
        clasesMap.get("CÁLCULO MULTIVARIADO").preRequisitos.add("CÁLCULO INTEGRAL");
        //Metodos Numericos
        clasesMap.get("MÉTODOS NUMÉRICOS").preRequisitos.add("CÁLCULO INTEGRAL");

        //Regresar Listas de clases
        return clasesMap;
    }
    public static Map<String, Clases> clasesMecatronica(Map<String, Clases> clases) {
        //Iniciar array que devolveremos con nuestras clases
        Map<String, Clases> clasesMap = new HashMap<>();

        //Asignar Semestres de Mecatronica
        clases.get("CÁLCULO DIFERENCIAL").setSemestre(1);   //CalculoDiferencial
        clasesMap.put("CÁLCULO DIFERENCIAL",clases.get("CÁLCULO DIFERENCIAL"));
        clases.get("CÁLCULO INTEGRAL").setSemestre(2);   //CalculoDiferencial
        clasesMap.put("CÁLCULO INTEGRAL",clases.get("CÁLCULO INTEGRAL"));
        clases.get("CÁLCULO MULTIVARIADO").setSemestre(3);   //CalculoDiferencial
        clasesMap.put("CÁLCULO MULTIVARIADO",clases.get("CÁLCULO MULTIVARIADO"));
        clases.get("MÉTODOS NUMÉRICOS").setSemestre(4);   //CalculoDiferencial
        clasesMap.put("MÉTODOS NUMÉRICOS",clases.get("MÉTODOS NUMÉRICOS"));

        return clasesMap;  //REGRESAR LAS CLASES
    }

    public String getClase() {
        return Clase;
    }
    public void setClase(String Clase) {
        this.Clase = Clase;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public double getCreditos() {
        return Creditos;
    }
    public void setCreditos(double Creditos) {
        this.Creditos = Creditos;
    }
    public int getSemestre() {
        return Semestre;
    }
    public void setSemestre(int Semestre) {
        this.Semestre = Semestre;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public ArrayList<String> getPreRequisitos() {
        return preRequisitos;
    }
    public void setPreRequisitos(ArrayList<String> preRequisitos) {
        this.preRequisitos = preRequisitos;
    }
    public ArrayList<String> getPostRequisitos() {
        return postRequisitos;
    }
    public void setPostRequisitos(ArrayList<String> postRequisitos) {
        this.postRequisitos = postRequisitos;
    }
    public ArrayList<String> getCoRequisitos() {
        return coRequisitos;
    }
    public void setCoRequisitos(ArrayList<String> coRequisitos) {
        this.coRequisitos = coRequisitos;
    }

}
