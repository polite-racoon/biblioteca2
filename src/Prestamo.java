import java.util.ArrayList;

public class Prestamo {
    private Usuario usuario;
    private Libro libro;
    private boolean devuelto;

    public Prestamo(Usuario usuario, Libro libro) {
        if (!libro.prestar()) {
            throw new IllegalArgumentException("No hay ejemplares disponibles del libro.");
        }
        if (usuario.getPrestamo() != null) {
            throw new IllegalArgumentException("El usuario ya tiene un préstamo activo.");
        }
        this.usuario = usuario;
        this.libro = libro;
        this.devuelto = false;
        usuario.setPrestamo(this);
    }

    public Usuario getUsuario() { return usuario; }
    public Libro getLibro() { return libro; }
    public boolean isDevuelto() { return devuelto; }

    public void devolver() {
        if (!devuelto) {
            devuelto = true;
            libro.devolver();
            usuario.setPrestamo(null);
        } else {
            throw new IllegalStateException("El préstamo ya fue devuelto.");
        }
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "usuario=" + usuario.getNombreCompleto() +
                ", libro=" + libro.getTitulo() +
                ", devuelto=" + devuelto +
                '}';
    }
}
