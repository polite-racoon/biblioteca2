import java.util.GregorianCalendar;

public class Devolucion {
    private Prestamo prestamo;
    private GregorianCalendar fechaDevolucion;

    public Devolucion(Prestamo prestamo) {
        this.prestamo = prestamo;
        this.fechaDevolucion = new GregorianCalendar();
    }

    public Prestamo getPrestamo() { return prestamo; }
    public GregorianCalendar getFechaDevolucion() { return fechaDevolucion; }

    @Override
    public String toString() {
        return "Devolucion realizada:\n" +
                "Préstamo: " + prestamo.toString() + "\n" +
                "Fecha de devolución: " + fechaDevolucion.getTime();
    }
}