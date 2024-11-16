import java.util.GregorianCalendar;

public class Devolucion {
    private Prestamo prestamo;
    private GregorianCalendar fechaDevolucion;

    public Devolucion(Prestamo prestamo) {
        if (prestamo.isDevuelto()) {
            throw new IllegalStateException("El préstamo ya fue devuelto.");
        }
        this.prestamo = prestamo;
        this.fechaDevolucion = new GregorianCalendar();
        prestamo.devolver();
    }

    public Prestamo getPrestamo() { return prestamo; }
    public GregorianCalendar getFechaDevolucion() { return fechaDevolucion; }

    @Override
    public String toString() {
        return "Devolucion{" +
                "prestamo=" + prestamo +
                ", fechaDevolucion=" + fechaDevolucion.getTime() +
                '}';
    }
}