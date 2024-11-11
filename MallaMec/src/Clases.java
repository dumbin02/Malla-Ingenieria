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
        Color bloqueProfCol = new Color(128, 197, 198, 150);
        Color tallerCol = new Color(195, 126, 16, 150);
        Color bloqueAnahuacCol = new Color(248, 122, 12, 150);
        Color bloqueInterCol = new Color(253, 172, 135, 150);
        Color electivaCol = new Color(112, 34, 255, 150);
        Color electivaAnaCol = new Color(255, 245, 20, 150);
        Color electivaProfCol = new Color(255, 0, 0, 150);


        //Iniciar array que devolveremos con nuestras clases
        Map<String, Clases> clasesMap = new HashMap<>();

        //Crear las clases que usaremos. -Agregar Co-Pre-PostRequisitos a las clases que corresponden-
        //CalculoDiferencial
        clasesMap.put("CÁLCULO DIFERENCIAL", new Clases("MAT1402", "CÁLCULO DIFERENCIAL", 6, bloqueProfCol));
        //CALCULO INTEGRAL
        clasesMap.put("CÁLCULO INTEGRAL", new Clases("MAT1403", "CÁLCULO INTEGRAL", 6, bloqueProfCol));
        //CALCULO MULTIVARIADO
        clasesMap.put("CÁLCULO MULTIVARIADO", new Clases("MAT2401", "CÁLCULO MULTIVARIADO", 6, bloqueProfCol));
        //METODOS NUMERICOS
        clasesMap.put("MÉTODOS NUMÉRICOS", new Clases("MAT3402", "MÉTODOS NUMÉRICOS", 3.5, bloqueProfCol));
        //ÁlGEBRA LINEAL
        clasesMap.put("ÁlGEBRA LINEAL", new Clases("MAT1404", "ÁlGEBRA LINEAL", 6, bloqueProfCol));
        //ALGORITMOS Y PROGRAMACION
        clasesMap.put("ALGORITMOS", new Clases("SIS1401", "ALGORITMOS", 6, bloqueProfCol));
        //TALLER O ACTIVIDAD
        clasesMap.put("TALLER O ACTIVIDAD", new Clases("", "TALLER O ACTIVIDAD", 3, tallerCol));
        //QUÍMICA
        clasesMap.put("QUÍMICA", new Clases("QUI1401", "QUÍMICA", 6, bloqueProfCol));
        //LIDERAZGO Y DESARROLLO
        clasesMap.put("LIDERAZGO Y DESARROLLO", new Clases("LDR1401", "LIDERAZGO Y DESARROLLO", 6, bloqueAnahuacCol));
        //FORMACIÓN UNIVERSITARIA A
        clasesMap.put("FORMACIÓN UNIVERSITARIA A", new Clases("CUL1411", "FORMACIÓN UNIVERSITARIA A", 3, bloqueProfCol));
        //SER UNIVERSITARIO
        clasesMap.put("SER UNIVERSITARIO", new Clases("HUM1401", "SER UNIVERSITARIO", 6, bloqueAnahuacCol));
        //PROBABILIDAD Y ESTADISTICA
        clasesMap.put("PROBABILIDAD Y ESTADISTICA", new Clases("MAT2403", "PROBABILIDAD Y ESTADISTICA", 6, bloqueProfCol));
        //DISEÑO POR COMPUTADORA
        clasesMap.put("DISEÑO POR COMPUTADORA", new Clases("IMEC1401", "DISEÑO POR COMPUTADORA", 3, bloqueProfCol));
        //ESTÁTICA
        clasesMap.put("ESTÁTICA", new Clases("FIS1402", "ESTÁTICA", 9, bloqueProfCol));
        //TALLER2
        clasesMap.put("TALLER2", new Clases("", "TALLER", 3, tallerCol));
        //ELECTIVA
        clasesMap.put("ELECTIVA ANAHUAC", new Clases("", "ELECTIVA ANAHUAC", 6, electivaAnaCol));
        //HABILIDADES PARA EL EMPRENDIMIENTO
        clasesMap.put("HABILIDADES PARA EL EMPRENDIMIENTO", new Clases("EMP1401", "HABILIDADES PARA EL EMP", 3, bloqueInterCol));
        //ANTROPOLOGÍA FUNDAMENTAL
        clasesMap.put("ANTROPOLOGÍA FUNDAMENTAL", new Clases("HUM1402", "ANTROPOLOGÍA FUNDAMENTAL", 6, bloqueAnahuacCol));
        //ELECTIVA INTERDISCIPLINARIA
        clasesMap.put("ELECTIVA INTERDISCIPLINARIA", new Clases("", "ELECTIVA INTERDISCIPLINARIA", 6, electivaCol));
        //CIRCUITOS ELÉCTRICOS
        clasesMap.put("CIRCUITOS ELÉCTRICOS", new Clases("IELC1401", "CIRCUITOS ELÉCTRICOS", 9, bloqueProfCol));
        //DINÁMICA
        clasesMap.put("DINÁMICA", new Clases("FIS2401", "DINÁMICA", 9, bloqueProfCol));
        //TALLER3
        clasesMap.put("TALLER3", new Clases("", "TALLER", 3, tallerCol));
        //ECUACIONES DIFERENCIALES
        clasesMap.put("ECUACIONES DIFERENCIALES", new Clases("MAT2402", "ECUACIONES DIFERENCIALES", 6, bloqueProfCol));
        //LIDERAZGO Y EQUIPO...
        clasesMap.put("LIDERAZGO Y EQUIPO...", new Clases("LDR2401", "LIDERAZGO Y EQUIPO...", 3, bloqueAnahuacCol));
        //ÉTICA
        clasesMap.put("ÉTICA", new Clases("HUM1404", "ÉTICA", 9, bloqueAnahuacCol));
        //ELECTRICIDAD Y MAGNETISMO
        clasesMap.put("ELECTRICIDAD Y MAGNETISMO", new Clases("FIS2403", "ELECTRICIDAD Y MAGNETISMO", 6, bloqueProfCol));
        //PROGRAMACIÓN MICROCONTROLADORES
        clasesMap.put("PROGRAMACIÓN MICROCONTROLADORES", new Clases("SIS2402", "PROGRAMACIÓN MICROCONTROLADORES", 6, bloqueProfCol));
        //DISPOSITIVOS SEMICONDCTORES
        clasesMap.put("DISPOSITIVOS SEMICONDCTORES", new Clases("SIS2402", "DISPOSITIVOS SEMICONDCTORES", 7, bloqueProfCol));
        //INGENIERÍA DE MATERIALES
        clasesMap.put("INGENIERÍA DE MATERIALES", new Clases("IMEC1402", "INGENIERÍA DE MATERIALES", 7, bloqueProfCol));
        //TERMODINÁMICA
        clasesMap.put("TERMODINÁMICA", new Clases("QUI2401", "TERMODINÁMICA", 7.5, bloqueProfCol));
        //EMPRENDIMIENTO E INNOVACIÓN
        clasesMap.put("EMPRENDIMIENTO E INNOVACIÓN", new Clases("EMP1402", "EMPRENDIMIENTO E INNOVACIÓN", 6, bloqueInterCol));
        //FORMACIÓN UNIVERSITARIA B
        clasesMap.put("FORMACIÓN UNIVERSITARIA B", new Clases("CUL1412", "FORMACIÓN UNIVERSITARIA B", 3, bloqueProfCol));
        //MEDICIÓN E INTRUMENTA...
        clasesMap.put("MEDICIÓN E INTRUMENTA...", new Clases("IMEC2404", "MEDICIÓN E INTRUMENTA...", 7, bloqueProfCol));
        //SISTEMAS ELECTRONEUMA...
        clasesMap.put("SISTEMAS ELECTRONEUMA...", new Clases("IMEC3408", "SISTEMAS ELECTRONEUMA...", 6, bloqueProfCol));
        //MECÁNICA DE MATERIALES
        clasesMap.put("MECÁNICA DE MATERIALES", new Clases("IMEC2402", "MECÁNICA DE MATERIALES", 7, bloqueProfCol));
        //DISEÑO DE MECANISMOS
        clasesMap.put("DISEÑO DE MECANISMOS", new Clases("IMEC2401", "DISEÑO DE MECANISMOS", 3, bloqueProfCol));
        //PROCESOS DE MANUFACTURA
        clasesMap.put("PROCESOS DE MANUFACTURA", new Clases("IMEC2403", "PROCESOS DE MANUFACTURA", 7, bloqueProfCol));
        //TRANSFORMADAS INTEGRALES
        clasesMap.put("TRANSFORMADAS INTEGRALES", new Clases("MAT3403", "TRANSFORMADAS INTEGRALES", 6, bloqueProfCol));
        //ELECTIVA ANÁHUAC2
        clasesMap.put("ELECTIVA ANÁHUAC2", new Clases("", "ELECTIVA ANÁHUAC2", 3, electivaAnaCol));  //6 ESPACIOS
        //HUMANISMO CLÁSICO Y CONTEMPORÁNEO
        clasesMap.put("HUMANISMO CLÁSICO Y CONTEMPORÁNEO", new Clases("HUM1405", "HUMANISMO CLÁSICO Y CONTEMPORÁNEO", 6, bloqueProfCol));
        //ELECTIVA INTERDISCIPLINARIA2
        clasesMap.put("ELECTIVA INTERDISCIPLINARIA2", new Clases("", "ELECTIVA INTERDISCIPLINARIA2", 6,electivaCol));
        //MANUFACTURA ASISSTIDA POR COMPUTADORA
        clasesMap.put("MANUFACTURA ASISSTIDA POR COMPUTADORA", new Clases("IMEC3407", "MANUFACTURA ASISSTIDA POR COMPUTADORA", 6, bloqueProfCol));
        //DISEÑO DE COMPONENTES MECÁNICOS
        clasesMap.put("DISEÑO DE COMPONENTES MECÁNICOS", new Clases("IMEC3401", "DISEÑO DE COMPONENTES MECÁNICOS", 4.5, bloqueProfCol));
        //ELCTRÓNICA ANALÓGICA
        clasesMap.put("ELCTRÓNICA ANALÓGICA", new Clases("IELC3403", "ELCTRÓNICA ANALÓGICA", 6, bloqueProfCol));
        //CIRCUITOS DIGITALES
        clasesMap.put("CIRCUITOS DIGITALES", new Clases("IELC3402", "CIRCUITOS DIGITALES", 7, bloqueProfCol));
        //DINÁMICA DE SISTEMAS MECATRÓNICOS
        clasesMap.put("DINÁMICA DE SISTEMAS MECATRÓNICOS", new Clases("IMEC3406", "DINÁMICA DE SISTEMAS MECATRÓNICOS", 7, bloqueProfCol));
        //ELECTIVA PROFESIONAL 1
        clasesMap.put("ELECTIVA PROFESIONAL 1", new Clases("", "ELECTIVA PROFESIONAL 1", 6, electivaProfCol));
        //PERSONA Y TRASCENDENCIA
        clasesMap.put("PERSONA Y TRASCENDENCIA", new Clases("HUM1403", "PERSONA Y TRASCENDENCIA", 6, bloqueAnahuacCol));
        //RESPONSABILIDAD SOCIAL
        clasesMap.put("RESPONSABILIDAD SOCIAL", new Clases("SOC3401", "RESPONSABILIDAD SOCIAL", 6, bloqueInterCol));
        //MÁQUINAS ELÉTRICAS
        clasesMap.put("MÁQUINAS ELÉTRICAS", new Clases("IELC3401", "MÁQUINAS ELÉTRICAS", 7, bloqueProfCol));
        //AUTOMATIZACIÓN
        clasesMap.put("AUTOMATIZACIÓN", new Clases("IELC4401", "AUTOMATIZACIÓN", 7, bloqueProfCol));
        //GESSTIÓN DE PROYECTOS DE INVESTIGACIÓN Y PATENTAMIENTO
        clasesMap.put("GESSTIÓN DE PROYECTOS DE INVESTIGACIÓN Y PATENTAMIENTO", new Clases("IMEC4401", "GESSTIÓN DE PROYECTOS DE INVESTIGACIÓN Y PATENTAMIENTO", 4.5, bloqueProfCol));
        //DISEÑO DE INTERFACES ANALÓGICAS Y DIGITALES
        clasesMap.put("DISEÑO DE INTERFACES ANALÓGICAS Y DIGITALES", new Clases("IELC3404", "DISEÑO DE INTERFACES ANALÓGICAS Y DIGITALES", 7, bloqueProfCol));
        //PROCESAMIENTO DIGITAL DE SEÑALES
        clasesMap.put("PROCESAMIENTO DIGITAL DE SEÑALES", new Clases("IELC4402", "PROCESAMIENTO DIGITAL DE SEÑALES", 6, bloqueProfCol));
        //CONTROL APLICADO
        clasesMap.put("CONTROL APLICADO", new Clases("IMEC4404", "CONTROL APLICADO", 7, bloqueProfCol));
        //ELECTIVA PROFESIONAL 2
        clasesMap.put("ELECTIVA PROFESIONAL 2", new Clases("", "ELECTIVA PROFESIONAL 2", 6, electivaProfCol));
        //PRÁCTICUM I METODOLOGIA DISEÑO
        clasesMap.put("PRÁCTICUM I METODOLOGIA DISEÑO", new Clases("INT4466", "PRÁCTICUM I METODOLOGIA DISEÑO", 6, bloqueProfCol));
        //SISTEMAS EMBEBIDOS
        clasesMap.put("SISTEMAS EMBEBIDOS", new Clases("IELC4403", "SISTEMAS EMBEBIDOS", 7, bloqueProfCol));
        //SISTEMAS DE VISIÓN INDUSTRIAL
        clasesMap.put("SISTEMAS DE VISIÓN INDUSTRIAL", new Clases("SIS4405", "SISTEMAS DE VISIÓN INDUSTRIAL", 6, bloqueProfCol));
        //ELECTRÓNICA DE POTENCIA
        clasesMap.put("ELECTRÓNICA DE POTENCIA", new Clases("IELC4404", "ELECTRÓNICA DE POTENCIA", 7, bloqueProfCol));
        //ROBÓTICA INDUSTRIAL Y DE SERVICIO
        clasesMap.put("ROBÓTICA INDUSTRIAL Y DE SERVICIO", new Clases("IMEC4410", "ROBÓTICA INDUSTRIAL Y DE SERVICIO", 6, bloqueProfCol));
        //ELECTIVA PROFESIONAL3
        clasesMap.put("ELECTIVA PROFESIONAL 3", new Clases("", "ELECTIVA PROFESIONAL 3", 6, electivaProfCol));
        //PRÁCTICUM II PROYECTO DE DISEÑO
        clasesMap.put("PRÁCTICUM II PROYECTO DE DISEÑO", new Clases("", "PRÁCTICUM II PROYECTO DE DISEÑO", 6, bloqueProfCol));
        //INNOVACIÓN TECNOLÓGICA
        clasesMap.put("INNOVACIÓN TECNOLÓGICA", new Clases("", "INNOVACIÓN TECNOLÓGICA", 6, bloqueProfCol));
        //REGIONAL
        clasesMap.put("REGIONAL", new Clases("", "REGIONAL", 6, bloqueProfCol));
        //REGIONAL 2
        clasesMap.put("REGIONAL 2", new Clases("", "REGIONAL 2", 6, bloqueProfCol));
        //ELECTIVA INTERDISCIPLINARIA
        clasesMap.put("ELECTIVA INTERDISCIPLINARIA3", new Clases("", "ELECTIVA INTERDISCIPLINARIA", 6, electivaCol));
        //ELECTIVA PROFESIONAL 4
        clasesMap.put("ELECTIVA PROFESIONAL 4", new Clases("", "ELECTIVA PROFESIONAL 4", 6, electivaProfCol));



        //Post-Co-PreRequisitos de las clases Después de crearlas
        //Calculo Diferencial
        clasesMap.get("CÁLCULO DIFERENCIAL").postRequisitos.add(clasesMap.get("CÁLCULO INTEGRAL"));
        //Calculo Integral
        clasesMap.get("CÁLCULO INTEGRAL").preRequisitos.add(clasesMap.get("CÁLCULO DIFERENCIAL"));
        clasesMap.get("CÁLCULO INTEGRAL").postRequisitos.add(clasesMap.get("CÁLCULO MULTIVARIADO"));
        clasesMap.get("CÁLCULO INTEGRAL").postRequisitos.add(clasesMap.get("MÉTODOS NUMÉRICOS"));
        //Calculo Multivariado
        clasesMap.get("CÁLCULO MULTIVARIADO").preRequisitos.add(clasesMap.get("CÁLCULO INTEGRAL"));
        clasesMap.get("CÁLCULO MULTIVARIADO").postRequisitos.add(clasesMap.get("ELECTRICIDAD Y MAGNETISMO"));
        clasesMap.get("CÁLCULO MULTIVARIADO").coRequisitos.add(clasesMap.get("ECUACIONES DIFERENCIALES"));
        //Metodos Numericos
        clasesMap.get("MÉTODOS NUMÉRICOS").preRequisitos.add(clasesMap.get("CÁLCULO INTEGRAL"));
        clasesMap.get("MÉTODOS NUMÉRICOS").preRequisitos.add(clasesMap.get("ALGORITMOS"));
        //ALGORITMOS Y PROGRAMACION
        clasesMap.get("ALGORITMOS").postRequisitos.add(clasesMap.get("MÉTODOS NUMÉRICOS"));
        clasesMap.get("ALGORITMOS").postRequisitos.add(clasesMap.get("PROGRAMACIÓN MICROCONTROLADORES"));
        //QUÍMICA
        clasesMap.get("QUÍMICA").postRequisitos.add(clasesMap.get("INGENIERÍA DE MATERIALES"));
        //LIDERAZGO Y DESARROLLO
        clasesMap.get("LIDERAZGO Y DESARROLLO").postRequisitos.add(clasesMap.get("HABILIDADES PARA EL EMPRENDIMIENTO"));
        clasesMap.get("LIDERAZGO Y DESARROLLO").postRequisitos.add(clasesMap.get("LIDERAZGO Y EQUIPO..."));
        //SER UNIVERSITARIO
        clasesMap.get("SER UNIVERSITARIO").postRequisitos.add(clasesMap.get("ANTROPOLOGÍA FUNDAMENTAL"));
        //HABILIDADES PARA EL EMPRENDIMIENTO
        clasesMap.get("HABILIDADES PARA EL EMPRENDIMIENTO").preRequisitos.add(clasesMap.get("LIDERAZGO Y DESARROLLO"));
        clasesMap.get("HABILIDADES PARA EL EMPRENDIMIENTO").postRequisitos.add(clasesMap.get("EMPRENDIMIENTO E INNOVACIÓN"));
        //ANTROPOLOGÍA FUNDAMENTAL
        clasesMap.get("ANTROPOLOGÍA FUNDAMENTAL").preRequisitos.add(clasesMap.get("SER UNIVERSITARIO"));
        clasesMap.get("ANTROPOLOGÍA FUNDAMENTAL").postRequisitos.add(clasesMap.get("ÉTICA"));
        clasesMap.get("ANTROPOLOGÍA FUNDAMENTAL").postRequisitos.add(clasesMap.get("PERSONA Y TRASCENDENCIA"));
        //CIRCUITOS ELÉCTRICOS
        clasesMap.get("CIRCUITOS ELÉCTRICOS").postRequisitos.add(clasesMap.get("PROGRAMACIÓN MICROCONTROLADORES"));
        clasesMap.get("CIRCUITOS ELÉCTRICOS").postRequisitos.add(clasesMap.get("DISPOSITIVOS SEMICONDCTORES"));
        clasesMap.get("CIRCUITOS ELÉCTRICOS").postRequisitos.add(clasesMap.get("MEDICIÓN E INTRUMENTA..."));
        //ESTÁTICA
        clasesMap.get("ESTÁTICA").postRequisitos.add(clasesMap.get("DINÁMICA"));
        clasesMap.get("ESTÁTICA").postRequisitos.add(clasesMap.get("MECÁNICA DE MATERIALES"));
        //DINÁMICA
        clasesMap.get("DINÁMICA").preRequisitos.add(clasesMap.get("ESTÁTICA"));
        clasesMap.get("DINÁMICA").postRequisitos.add(clasesMap.get("DISEÑO DE MECANISMOS"));
        //ECUACIONES DIFERENCIALES
        clasesMap.get("ECUACIONES DIFERENCIALES").coRequisitos.add(clasesMap.get("CÁLCULO MULTIVARIADO"));
        clasesMap.get("ECUACIONES DIFERENCIALES").preRequisitos.add(clasesMap.get("CÁLCULO INTEGRAL"));
        clasesMap.get("ECUACIONES DIFERENCIALES").postRequisitos.add(clasesMap.get("TRANSFORMADAS INTEGRALES"));
        clasesMap.get("ECUACIONES DIFERENCIALES").postRequisitos.add(clasesMap.get("DINÁMICA DE SISTEMAS MECATRÓNICOS"));
        //LIDERAZGO Y EQUIPO...
        clasesMap.get("LIDERAZGO Y EQUIPO...").preRequisitos.add(clasesMap.get("LIDERAZGO Y DESARROLLO"));
        //ÉTICA
        clasesMap.get("ÉTICA").preRequisitos.add(clasesMap.get("ANTROPOLOGÍA FUNDAMENTAL"));
        clasesMap.get("ÉTICA").postRequisitos.add(clasesMap.get("HUMANISMO CLÁSICO Y CONTEMPORÁNEO"));
        clasesMap.get("ÉTICA").postRequisitos.add(clasesMap.get("RESPONSABILIDAD SOCIAL"));
        //ELECTRICIDAD Y MAGNETISMO
        clasesMap.get("ELECTRICIDAD Y MAGNETISMO").preRequisitos.add(clasesMap.get("CÁLCULO MULTIVARIADO"));
        clasesMap.get("ELECTRICIDAD Y MAGNETISMO").postRequisitos.add(clasesMap.get("MÁQUINAS ELÉTRICAS"));
        //PROGRAMACIÓN MICROCONTROLADORES
        clasesMap.get("PROGRAMACIÓN MICROCONTROLADORES").preRequisitos.add(clasesMap.get("ALGORITMOS"));
        clasesMap.get("PROGRAMACIÓN MICROCONTROLADORES").preRequisitos.add(clasesMap.get("CIRCUITOS ELÉCTRICOS"));
        clasesMap.get("PROGRAMACIÓN MICROCONTROLADORES").postRequisitos.add(clasesMap.get("SISTEMAS DE VISIÓN INDUSTRIAL"));
        //DISPOSITIVOS SEMICONDCTORES
        clasesMap.get("DISPOSITIVOS SEMICONDCTORES").preRequisitos.add(clasesMap.get("CIRCUITOS ELÉCTRICOS"));
        clasesMap.get("DISPOSITIVOS SEMICONDCTORES").postRequisitos.add(clasesMap.get("CIRCUITOS DIGITALES"));
        //INGENIERÍA DE MATERIALES
        clasesMap.get("INGENIERÍA DE MATERIALES").preRequisitos.add(clasesMap.get("QUÍMICA"));
        clasesMap.get("INGENIERÍA DE MATERIALES").postRequisitos.add(clasesMap.get("PROCESOS DE MANUFACTURA"));
        //EMPRENDIMIENTO E INNOVACIÓN
        clasesMap.get("EMPRENDIMIENTO E INNOVACIÓN").preRequisitos.add(clasesMap.get("HABILIDADES PARA EL EMPRENDIMIENTO"));


        
        
        

        //Regresar Listas de clases
        return clasesMap;
    }
    public static Map<String, Clases> inicializarMecatronica(Map<String, Clases> clases) {
        //Iniciar array que devolveremos con nuestras clases
        Map<String, Clases> clasesMap = new HashMap<>();

        //Asignar Semestres de Mecatronica
        clases.get("SER UNIVERSITARIO").setSemestre(1);   //SER UNIVERSITARIO
        clasesMap.put("SER UNIVERSITARIO",clases.get("SER UNIVERSITARIO"));
        clases.get("FORMACIÓN UNIVERSITARIA A").setSemestre(1);   //FORMACIÓN UNIVERSITARIA A
        clasesMap.put("FORMACIÓN UNIVERSITARIA A",clases.get("FORMACIÓN UNIVERSITARIA A"));
        clases.get("LIDERAZGO Y DESARROLLO").setSemestre(1);   //LIDERAZGO Y DESARROLLO
        clasesMap.put("LIDERAZGO Y DESARROLLO",clases.get("LIDERAZGO Y DESARROLLO"));
        clases.get("QUÍMICA").setSemestre(1);   //QUÍMICA
        clasesMap.put("QUÍMICA",clases.get("QUÍMICA"));
        clases.get("TALLER O ACTIVIDAD").setSemestre(1);   //TALLER O ACTIVIDAD
        clasesMap.put("TALLER O ACTIVIDAD",clases.get("TALLER O ACTIVIDAD"));
        clases.get("ÁlGEBRA LINEAL").setSemestre(1);   //ALGEBRA LINEAL
        clasesMap.put("ÁlGEBRA LINEAL",clases.get("ÁlGEBRA LINEAL"));
        clases.get("ALGORITMOS").setSemestre(1);   //ALGORITMOS
        clasesMap.put("ALGORITMOS",clases.get("ALGORITMOS"));
        clases.get("CÁLCULO DIFERENCIAL").setSemestre(1);   //CalculoDiferencial
        clasesMap.put("CÁLCULO DIFERENCIAL",clases.get("CÁLCULO DIFERENCIAL"));
        clases.get("CÁLCULO INTEGRAL").setSemestre(2);   //CÁLCULO INTEGRAL
        clasesMap.put("CÁLCULO INTEGRAL",clases.get("CÁLCULO INTEGRAL"));
        clases.get("CÁLCULO MULTIVARIADO").setSemestre(3);   //CÁLCULO MULTIVARIADO
        clasesMap.put("CÁLCULO MULTIVARIADO",clases.get("CÁLCULO MULTIVARIADO"));
        clases.get("MÉTODOS NUMÉRICOS").setSemestre(4);   //MÉTODOS NUMÉRICOS
        clasesMap.put("MÉTODOS NUMÉRICOS",clases.get("MÉTODOS NUMÉRICOS"));
        clases.get("PROBABILIDAD Y ESTADISTICA").setSemestre(2);   //ALGORITMOS
        clasesMap.put("PROBABILIDAD Y ESTADISTICA",clases.get("PROBABILIDAD Y ESTADISTICA"));
        clases.get("DISEÑO POR COMPUTADORA").setSemestre(2);   //ALGORITMOS
        clasesMap.put("DISEÑO POR COMPUTADORA",clases.get("DISEÑO POR COMPUTADORA"));
        clases.get("ESTÁTICA").setSemestre(2);   //ALGORITMOS
        clasesMap.put("ESTÁTICA",clases.get("ESTÁTICA"));
        clases.get("TALLER2").setSemestre(2);   //ALGORITMOS
        clasesMap.put("TALLER2",clases.get("TALLER2"));
        clases.get("ELECTIVA ANAHUAC").setSemestre(2);   //ALGORITMOS
        clasesMap.put("ELECTIVA ANAHUAC",clases.get("ELECTIVA ANAHUAC"));
        clases.get("HABILIDADES PARA EL EMPRENDIMIENTO").setSemestre(2);   //ALGORITMOS
        clasesMap.put("HABILIDADES PARA EL EMPRENDIMIENTO",clases.get("HABILIDADES PARA EL EMPRENDIMIENTO"));
        clases.get("ANTROPOLOGÍA FUNDAMENTAL").setSemestre(2);   //ALGORITMOS
        clasesMap.put("ANTROPOLOGÍA FUNDAMENTAL",clases.get("ANTROPOLOGÍA FUNDAMENTAL"));
        clases.get("ELECTIVA INTERDISCIPLINARIA").setSemestre(3);   //ELECTIVA INTERDISCIPLINARIA
        clasesMap.put("ELECTIVA INTERDISCIPLINARIA",clases.get("ELECTIVA INTERDISCIPLINARIA"));
        clases.get("CIRCUITOS ELÉCTRICOS").setSemestre(3);   //CIRCUITOS ELÉCTRICOS
        clasesMap.put("CIRCUITOS ELÉCTRICOS",clases.get("CIRCUITOS ELÉCTRICOS"));
        clases.get("DINÁMICA").setSemestre(3);   //DINÁMICA
        clasesMap.put("DINÁMICA",clases.get("DINÁMICA"));
        clases.get("TALLER3").setSemestre(3);   //TALLER3
        clasesMap.put("TALLER3",clases.get("TALLER3"));
        clases.get("ECUACIONES DIFERENCIALES").setSemestre(3);   //ECUACIONES DIFERENCIALES
        clasesMap.put("ECUACIONES DIFERENCIALES",clases.get("ECUACIONES DIFERENCIALES"));
        clases.get("LIDERAZGO Y EQUIPO...").setSemestre(3);   //LIDERAZGO Y EQUIPO...
        clasesMap.put("LIDERAZGO Y EQUIPO...",clases.get("LIDERAZGO Y EQUIPO..."));
        clases.get("ÉTICA").setSemestre(3);   //ÉTICA
        clasesMap.put("ÉTICA",clases.get("ÉTICA"));
        clases.get("ELECTRICIDAD Y MAGNETISMO").setSemestre(4);   //ELECTRICIDAD Y MAGNETISMO
        clasesMap.put("ELECTRICIDAD Y MAGNETISMO",clases.get("ELECTRICIDAD Y MAGNETISMO"));
        clases.get("PROGRAMACIÓN MICROCONTROLADORES").setSemestre(4);   //PROGRAMACIÓN MICROCONTROLADORES
        clasesMap.put("PROGRAMACIÓN MICROCONTROLADORES",clases.get("PROGRAMACIÓN MICROCONTROLADORES"));
        clases.get("DISPOSITIVOS SEMICONDCTORES").setSemestre(4);   //DISPOSITIVOS SEMICONDCTORES
        clasesMap.put("DISPOSITIVOS SEMICONDCTORES",clases.get("DISPOSITIVOS SEMICONDCTORES"));
        clases.get("INGENIERÍA DE MATERIALES").setSemestre(4);   //INGENIERÍA DE MATERIALES
        clasesMap.put("INGENIERÍA DE MATERIALES",clases.get("INGENIERÍA DE MATERIALES"));
        clases.get("TERMODINÁMICA").setSemestre(4);   //TERMODINÁMICA
        clasesMap.put("TERMODINÁMICA",clases.get("TERMODINÁMICA"));
        clases.get("EMPRENDIMIENTO E INNOVACIÓN").setSemestre(4);   //EMPRENDIMIENTO E INNOVACIÓN
        clasesMap.put("EMPRENDIMIENTO E INNOVACIÓN",clases.get("EMPRENDIMIENTO E INNOVACIÓN"));
        clases.get("FORMACIÓN UNIVERSITARIA B").setSemestre(4);   //FORMACIÓN UNIVERSITARIA B
        clasesMap.put("FORMACIÓN UNIVERSITARIA B",clases.get("FORMACIÓN UNIVERSITARIA B"));
        clases.get("MEDICIÓN E INTRUMENTA...").setSemestre(5);   //MEDICIÓN E INTRUMENTA...
        clasesMap.put("MEDICIÓN E INTRUMENTA...",clases.get("MEDICIÓN E INTRUMENTA..."));
        clases.get("SISTEMAS ELECTRONEUMA...").setSemestre(5);   //SISTEMAS ELECTRONEUMA...
        clasesMap.put("SISTEMAS ELECTRONEUMA...",clases.get("SISTEMAS ELECTRONEUMA..."));
        clases.get("MECÁNICA DE MATERIALES").setSemestre(5);   //MECÁNICA DE MATERIALES
        clasesMap.put("MECÁNICA DE MATERIALES",clases.get("MECÁNICA DE MATERIALES"));
        clases.get("DISEÑO DE MECANISMOS").setSemestre(5);   //DISEÑO DE MECANISMOS
        clasesMap.put("DISEÑO DE MECANISMOS",clases.get("DISEÑO DE MECANISMOS"));
        clases.get("PROCESOS DE MANUFACTURA").setSemestre(5);   //PROCESOS DE MANUFACTURA
        clasesMap.put("PROCESOS DE MANUFACTURA",clases.get("PROCESOS DE MANUFACTURA"));
        clases.get("TRANSFORMADAS INTEGRALES").setSemestre(5);   //TRANSFORMADAS INTEGRALES
        clasesMap.put("TRANSFORMADAS INTEGRALES",clases.get("TRANSFORMADAS INTEGRALES"));
        clases.get("ELECTIVA ANÁHUAC2").setSemestre(5);   //ELECTIVA ANÁHUAC2
        clasesMap.put("ELECTIVA ANÁHUAC2",clases.get("ELECTIVA ANÁHUAC2"));
        clases.get("HUMANISMO CLÁSICO Y CONTEMPORÁNEO").setSemestre(5);   //HUMANISMO CLÁSICO Y CONTEMPORÁNEO
        clasesMap.put("HUMANISMO CLÁSICO Y CONTEMPORÁNEO",clases.get("HUMANISMO CLÁSICO Y CONTEMPORÁNEO"));
        clases.get("ELECTIVA INTERDISCIPLINARIA2").setSemestre(6);   //ELECTIVA INTERDISCIPLINARIA2
        clasesMap.put("ELECTIVA INTERDISCIPLINARIA2",clases.get("ELECTIVA INTERDISCIPLINARIA2"));
        clases.get("MANUFACTURA ASISSTIDA POR COMPUTADORA").setSemestre(6);   //MANUFACTURA ASISSTIDA POR COMPUTADORA
        clasesMap.put("MANUFACTURA ASISSTIDA POR COMPUTADORA",clases.get("MANUFACTURA ASISSTIDA POR COMPUTADORA"));
        clases.get("DISEÑO DE COMPONENTES MECÁNICOS").setSemestre(6);   //DISEÑO DE COMPONENTES MECÁNICOS
        clasesMap.put("DISEÑO DE COMPONENTES MECÁNICOS",clases.get("DISEÑO DE COMPONENTES MECÁNICOS"));
        clases.get("ELCTRÓNICA ANALÓGICA").setSemestre(6);   //ELCTRÓNICA ANALÓGICA
        clasesMap.put("ELCTRÓNICA ANALÓGICA",clases.get("ELCTRÓNICA ANALÓGICA"));
        clases.get("CIRCUITOS DIGITALES").setSemestre(6);   //CIRCUITOS DIGITALES
        clasesMap.put("CIRCUITOS DIGITALES",clases.get("CIRCUITOS DIGITALES"));
        clases.get("DINÁMICA DE SISTEMAS MECATRÓNICOS").setSemestre(6);   //DINÁMICA DE SISTEMAS MECATRÓNICOS
        clasesMap.put("DINÁMICA DE SISTEMAS MECATRÓNICOS",clases.get("DINÁMICA DE SISTEMAS MECATRÓNICOS"));
        clases.get("ELECTIVA PROFESIONAL 1").setSemestre(6);   //ELECTIVA PROFESIONAL 1
        clasesMap.put("ELECTIVA PROFESIONAL 1",clases.get("ELECTIVA PROFESIONAL 1"));
        clases.get("PERSONA Y TRASCENDENCIA").setSemestre(6);   //PERSONA Y TRASCENDENCIA
        clasesMap.put("PERSONA Y TRASCENDENCIA",clases.get("PERSONA Y TRASCENDENCIA"));
        clases.get("RESPONSABILIDAD SOCIAL").setSemestre(7);   //RESPONSABILIDAD SOCIAL
        clasesMap.put("RESPONSABILIDAD SOCIAL",clases.get("RESPONSABILIDAD SOCIAL"));
        clases.get("MÁQUINAS ELÉTRICAS").setSemestre(7);   //MÁQUINAS ELÉTRICAS
        clasesMap.put("MÁQUINAS ELÉTRICAS",clases.get("MÁQUINAS ELÉTRICAS"));
        clases.get("AUTOMATIZACIÓN").setSemestre(7);   //AUTOMATIZACIÓN
        clasesMap.put("AUTOMATIZACIÓN",clases.get("AUTOMATIZACIÓN"));
        clases.get("GESSTIÓN DE PROYECTOS DE INVESTIGACIÓN Y PATENTAMIENTO").setSemestre(7);   //GESSTIÓN DE PROYECTOS DE INVESTIGACIÓN Y PATENTAMIENTO
        clasesMap.put("GESSTIÓN DE PROYECTOS DE INVESTIGACIÓN Y PATENTAMIENTO",clases.get("GESSTIÓN DE PROYECTOS DE INVESTIGACIÓN Y PATENTAMIENTO"));
        clases.get("DISEÑO DE INTERFACES ANALÓGICAS Y DIGITALES").setSemestre(7);   //DISEÑO DE INTERFACES ANALÓGICAS Y DIGITALES
        clasesMap.put("DISEÑO DE INTERFACES ANALÓGICAS Y DIGITALES",clases.get("DISEÑO DE INTERFACES ANALÓGICAS Y DIGITALES"));
        clases.get("PROCESAMIENTO DIGITAL DE SEÑALES").setSemestre(7);   //PROCESAMIENTO DIGITAL DE SEÑALES
        clasesMap.put("PROCESAMIENTO DIGITAL DE SEÑALES",clases.get("PROCESAMIENTO DIGITAL DE SEÑALES"));
        clases.get("CONTROL APLICADO").setSemestre(7);   //CONTROL APLICADO
        clasesMap.put("CONTROL APLICADO",clases.get("CONTROL APLICADO"));
        clases.get("ELECTIVA PROFESIONAL 2").setSemestre(7);   //ELECTIVA PROFESIONAL 2
        clasesMap.put("ELECTIVA PROFESIONAL 2",clases.get("ELECTIVA PROFESIONAL 2"));
        clases.get("PRÁCTICUM I METODOLOGIA DISEÑO").setSemestre(8);   //PRÁCTICUM I METODOLOGIA DISEÑO
        clasesMap.put("PRÁCTICUM I METODOLOGIA DISEÑO",clases.get("PRÁCTICUM I METODOLOGIA DISEÑO"));
        clases.get("SISTEMAS EMBEBIDOS").setSemestre(8);   //SISTEMAS EMBEBIDOS
        clasesMap.put("SISTEMAS EMBEBIDOS",clases.get("SISTEMAS EMBEBIDOS"));
        clases.get("SISTEMAS DE VISIÓN INDUSTRIAL").setSemestre(8);   //SISTEMAS DE VISIÓN INDUSTRIAL
        clasesMap.put("SISTEMAS DE VISIÓN INDUSTRIAL",clases.get("SISTEMAS DE VISIÓN INDUSTRIAL"));
        clases.get("ELECTRÓNICA DE POTENCIA").setSemestre(8);   //ELECTRÓNICA DE POTENCIA
        clasesMap.put("ELECTRÓNICA DE POTENCIA",clases.get("ELECTRÓNICA DE POTENCIA"));
        clases.get("ROBÓTICA INDUSTRIAL Y DE SERVICIO").setSemestre(8);   //ROBÓTICA INDUSTRIAL Y DE SERVICIO
        clasesMap.put("ROBÓTICA INDUSTRIAL Y DE SERVICIO",clases.get("ROBÓTICA INDUSTRIAL Y DE SERVICIO"));
        clases.get("ELECTIVA PROFESIONAL 3").setSemestre(8);   //ELECTIVA PROFESIONAL 3
        clasesMap.put("ELECTIVA PROFESIONAL 3",clases.get("ELECTIVA PROFESIONAL 3"));
        clases.get("PRÁCTICUM II PROYECTO DE DISEÑO").setSemestre(9);   //PRÁCTICUM II PROYECTO DE DISEÑO
        clasesMap.put("PRÁCTICUM II PROYECTO DE DISEÑO",clases.get("PRÁCTICUM II PROYECTO DE DISEÑO"));
        clases.get("INNOVACIÓN TECNOLÓGICA").setSemestre(9);   //INNOVACIÓN TECNOLÓGICA
        clasesMap.put("INNOVACIÓN TECNOLÓGICA",clases.get("INNOVACIÓN TECNOLÓGICA"));
        clases.get("REGIONAL").setSemestre(9);   //REGIONAL
        clasesMap.put("REGIONAL",clases.get("REGIONAL"));
        clases.get("REGIONAL 2").setSemestre(9);   //REGIONAL 2
        clasesMap.put("REGIONAL 2",clases.get("REGIONAL 2"));
        clases.get("ELECTIVA INTERDISCIPLINARIA3").setSemestre(9);   //ELECTIVA INTERDISCIPLINARIA3
        clasesMap.put("ELECTIVA INTERDISCIPLINARIA3",clases.get("ELECTIVA INTERDISCIPLINARIA3"));
        clases.get("ELECTIVA PROFESIONAL 4").setSemestre(9);   //ELECTIVA PROFESIONAL 4
        clasesMap.put("ELECTIVA PROFESIONAL 4",clases.get("ELECTIVA PROFESIONAL 4"));
        

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