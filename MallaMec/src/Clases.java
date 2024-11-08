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
    private ArrayList<Clases> preRequisitos;
    private ArrayList<Clases> postRequisitos;
    private ArrayList<Clases> coRequisitos;
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
        Color AzulTranslucido = new Color(128, 197, 198, 170);
        //Iniciar array que devolveremos con nuestras clases
        Map<String, Clases> clasesMap = new HashMap<>();

        //Crear las clases que usaremos. -Agregar Co-Pre-PostRequisitos a las clases que corresponden-
        //ALGORITMOS Y PROGRAMACION
        clasesMap.put("ALGORITMOS", new Clases("SIS1401", "ALGORITMOS", 6, AzulTranslucido));
        //CalculoDiferencial
        clasesMap.put("CÁLCULO DIFERENCIAL", new Clases("MAT1402", "CÁLCULO DIFERENCIAL", 6, AzulTranslucido));
        //CALCULO INTEGRAL
        clasesMap.put("CÁLCULO INTEGRAL", new Clases("MAT1403", "CÁLCULO INTEGRAL", 6, AzulTranslucido));
        //CALCULO MULTIVARIADO
        clasesMap.put("CÁLCULO MULTIVARIADO", new Clases("MAT2401", "CÁLCULO MULTIVARIADO", 6, AzulTranslucido));
        //METODOS NUMERICOS
        clasesMap.put("MÉTODOS NUMÉRICOS", new Clases("MAT3402", "MÉTODOS NUMÉRICOS", 3.5, AzulTranslucido));


        //Post-Co-PreRequisitos de las clases Despues de crearlas
        //Calculo Integral
        clasesMap.get("CÁLCULO DIFERENCIAL").postRequisitos.add(clasesMap.get("CÁLCULO INTEGRAL"));
        //Calculo Integral
        clasesMap.get("CÁLCULO INTEGRAL").preRequisitos.add(clasesMap.get("CÁLCULO DIFERENCIAL"));
        clasesMap.get("CÁLCULO INTEGRAL").postRequisitos.add(clasesMap.get("CÁLCULO MULTIVARIADO"));
        clasesMap.get("CÁLCULO INTEGRAL").postRequisitos.add(clasesMap.get("MÉTODOS NUMÉRICOS"));
        //Calculo Multivariado
        clasesMap.get("CÁLCULO MULTIVARIADO").preRequisitos.add(clasesMap.get("CÁLCULO INTEGRAL"));
        //Metodos Numericos
        clasesMap.get("MÉTODOS NUMÉRICOS").preRequisitos.add(clasesMap.get("CÁLCULO INTEGRAL"));
        //ALGORITMOS Y PROGRAMACION
        clasesMap.get("ALGORITMOS").postRequisitos.add(clasesMap.get("MÉTODOS NUMÉRICOS"));

        //Regresar Listas de clases
        return clasesMap;
    }
    public static Map<String, Clases> inicializarMecatronica(Map<String, Clases> clases) {
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
        clases.get("ALGORITMOS").setSemestre(1);   //CalculoDiferencial
        clasesMap.put("ALGORITMOS",clases.get("ALGORITMOS"));


        return clasesMap;  //REGRESAR LAS CLASES
    }
    public static ArrayList<ArrayList<CuadroTexto>> CuadrosSemestre(ArrayList<CuadroTexto> cuadrosTexto) {
        ArrayList<ArrayList<CuadroTexto>> clasesSemestre = new ArrayList<>();
        // Inicializar listas vacías para cada semestre
        for (int i = 0; i < 10; i++) {
            clasesSemestre.add(new ArrayList<>());
        }
        // Asignar cuadros a su correspondiente semestre
        for (CuadroTexto cuadro : cuadrosTexto) {
            int semestre = cuadro.getClase().getSemestre();
            if (semestre >= 1 && semestre <= 10) { // Asegurarse de que el semestre esté en el rango esperado
                clasesSemestre.get(semestre - 1).add(cuadro);
                System.out.print(cuadro.getClase().getSemestre()+" ");
                System.out.println(cuadro.getClase().getNombre());
            }
        }
        return clasesSemestre;
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
    public ArrayList<Clases> getPreRequisitos() {
        return preRequisitos;
    }
    public void setPreRequisitos(ArrayList<Clases> preRequisitos) {
        this.preRequisitos = preRequisitos;
    }
    public ArrayList<Clases> getPostRequisitos() {
        return postRequisitos;
    }
    public void setPostRequisitos(ArrayList<Clases> postRequisitos) {
        this.postRequisitos = postRequisitos;
    }
    public ArrayList<Clases> getCoRequisitos() {
        return coRequisitos;
    }
    public void setCoRequisitos(ArrayList<Clases> coRequisitos) {
        this.coRequisitos = coRequisitos;
    }


}
