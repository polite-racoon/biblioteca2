import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Prestamo {
    private Usuario usuario;
    private Libro libro;
    private GregorianCalendar fecha;
    private Devolucion devolucion;

    public Prestamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.fecha = new GregorianCalendar();
        this.devolucion = null;
    }

    public Usuario getUsuario() { return usuario; }
    public Libro getLibro() { return libro; }
    public GregorianCalendar getFecha() { return fecha; }
    public Devolucion getDevolucion() { return devolucion; }

    public void asignarDevolucion() {
        this.devolucion = new Devolucion(this);
        libro.devolver();
        usuario.setPrestamo(null);
    }

    public static Prestamo ingresarPrestamo(int ISBN, String RUN, ArrayList<Libro> libros, ArrayList<Usuario> usuarios) {
        Libro libro = buscarLibro(ISBN, libros);
        if (libro == null) {
            throw new IllegalArgumentException("El libro a buscar no existe.");
        }

        Usuario usuario = buscarUsuario(RUN, usuarios);
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario a buscar no existe.");
        }

        if (usuario.getPrestamo() != null) {
            throw new IllegalArgumentException("El usuario ya tiene un préstamo activo.");
        }

        if (!libro.prestar()) {
            throw new IllegalArgumentException("No hay ejemplares disponibles del libro.");
        }

        return new Prestamo(usuario, libro);
    }

    public static void ingresarDevolucion(int ISBN, String RUN, ArrayList<Prestamo> prestamos) {
        Prestamo prestamo = buscarPrestamo(ISBN, RUN, prestamos);
        if (prestamo == null) {
            throw new IllegalArgumentException("El préstamo a buscar no existe.");
        }
        prestamo.asignarDevolucion();
    }

    public static Libro buscarLibro(int ISBN, ArrayList<Libro> libros) {
        for (Libro libro : libros) {
            if (libro.getISBN() == ISBN) {
                return libro;
            }
        }
        return null;
    }

    public static Usuario buscarUsuario(String RUN, ArrayList<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (usuario.getRun().equals(RUN)) {
                return usuario;
            }
        }
        return null;
    }

    public static Prestamo buscarPrestamo(int ISBN, String RUN, ArrayList<Prestamo> prestamos) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getUsuario().getRun().equals(RUN) && prestamo.getLibro().getISBN() == ISBN && prestamo.getDevolucion() == null) {
                return prestamo;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String estadoBase = "Prestamo:\n" +
                "ISBN: " + libro.getISBN() + "\n" +
                "RUN: " + usuario.getRun() + "\n" +
                "Arrendado por: " + (usuario instanceof Docente ? "Docente" : "Estudiante") + "\n" +
                "Estado: ";
        estadoBase += (devolucion == null) ? "En préstamo." : "Devuelto.";
        return estadoBase;
    }
}