import java.util.ArrayList;
import java.util.Scanner;

// INTERFAZ 
interface Prestable {
    void marcarLeido();
    boolean estaLeido();
    String getResumen();
}

abstract class MaterialBiblioteca implements Prestable {
    protected String titulo;
    protected String autor;
    protected int anio;
    protected boolean leido = false;

    public MaterialBiblioteca(String titulo, String autor, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    public void marcarLeido() {
        leido = !leido;
    }

    public boolean estaLeido() {
        return leido;
    }

    public String getTitulo() {
        return titulo;
    }
}

// LIBRO
class Libro extends MaterialBiblioteca {
    int paginas;
    String genero;

    public Libro(String t, String a, int anio, int p, String g) {
        super(t, a, anio);
        paginas = p;
        genero = g;
    }

    public String getResumen() {
        return "Libro: " + titulo + " | " + genero + " | " + paginas + " pags Leído: " + leido;
    }
}

// REVISTA 
class Revista extends MaterialBiblioteca {
    int edicion;
    String tematica;

    public Revista(String t, String a, int anio, int e, String tema) {
        super(t, a, anio);
        edicion = e;
        tematica = tema;
    }

    public String getResumen() {
        return "Revista: " + titulo + "Edición " + edicion + "Leído: " + leido;
    }
}

// AUDUDOLIBRO
class Audiolibro extends MaterialBiblioteca {
    int duracion;
    String narrador;

    public Audiolibro(String t, String a, int anio, int d, String n) {
        super(t, a, anio);
        duracion = d;
        narrador = n;
    }

    public String getResumen() {
        return "Audiolibro: " + titulo + " | " + duracion + " | Leído: " + leido;
    }
}

// MENU
public class Biblioteca {

    static ArrayList<MaterialBiblioteca> lista = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n BIBLIOTECA");
            System.out.println("\n ====================");
            System.out.println("1. Agregar libro");
            System.out.println("2. Agregar revista");
            System.out.println("3. Agregar audiolibro");
            System.out.println("4. Ver materiales");
            System.out.println("5. Marcar leído");
            System.out.println("6. Buscar por título");
            System.out.println("0. Salir");

            opcion = sc.nextInt();
            sc.nextLine(); 
            switch (opcion) {
                case 1: agregarLibro(); break;
                case 2: agregarRevista(); break;
                case 3: agregarAudio(); break;
                case 4: mostrar(); break;
                case 5: marcarLeido(); break;
                case 6: buscar(); break;
            }

        } while (opcion != 0);
    }

    //  MÉTODOS 

    static void agregarLibro() {
        System.out.print("Titulo:");
        String t = sc.nextLine();
        System.out.print("Autor ");
        String a = sc.nextLine();
        System.out.print("Año:");
        int anio = sc.nextInt();
        System.out.print("Paginas:");
        int p = sc.nextInt();
        sc.nextLine();
        System.out.print("Genero:");
        String g = sc.nextLine();

        lista.add(new Libro(t, a, anio, p, g));
    }

    static void agregarRevista() {
        System.out.print("Titulo:");
        String t = sc.nextLine();
        System.out.print("Autor:");
        String a = sc.nextLine();
        System.out.print("Año:");
        int anio = sc.nextInt();
        System.out.print("Edicion");
        int e = sc.nextInt();
        sc.nextLine();
        System.out.print("Tematica:");
        String tema = sc.nextLine();

        lista.add(new Revista(t, a, anio, e, tema));
    }

    static void agregarAudio() {
        System.out.print("Titulo:");
        String t = sc.nextLine();
        System.out.print("Autor:");
        String a = sc.nextLine();
        System.out.print("Año:");
        int anio = sc.nextInt();
        System.out.print("Duracion:");
        int d = sc.nextInt();
        sc.nextLine();
        System.out.print("Narrador:");
        String n = sc.nextLine();

        lista.add(new Audiolibro(t, a, anio, d, n));
    }
    static void mostrar() {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + " - " + lista.get(i).getResumen());
        }
    }
    static void marcarLeido() {
        mostrar();
        System.out.print("Numero a marcar");
        int i = sc.nextInt();

        lista.get(i).marcarLeido();
    }

    static void buscar() {
        System.out.print("Buscar titulo");
        String busqueda = sc.nextLine();

        for (MaterialBiblioteca m : lista) {
            if (m.getTitulo().toLowerCase().contains(busqueda.toLowerCase())) {
                System.out.println(m.getResumen());
            }
        }
    }
}
