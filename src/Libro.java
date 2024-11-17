public class Libro {
    private int ISBN;
    private String titulo;
    private String autor;
    private int cantidadTotal;
    private int cantidadDisponible;
    private String imagen;

    public Libro(int ISBN, String titulo, String autor, int cantidadTotal, String imagen) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadTotal = cantidadTotal;
        this.cantidadDisponible = cantidadTotal;
        this.imagen = imagen;
    }

    public int getISBN() { return ISBN; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getCantidadTotal() { return cantidadTotal; }
    public int getCantidadDisponible() { return cantidadDisponible; }

    public boolean prestar() {
        if (cantidadDisponible > 0) {
            cantidadDisponible--;
            return true;
        }
        return false;
    }

    public void devolver() {
        if (cantidadDisponible < cantidadTotal) {
            cantidadDisponible++;
        }
    }

    @Override
    public String toString() {
        return "Libro{" +
                "ISBN=" + ISBN +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", cantidadDisponible=" + cantidadDisponible +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
