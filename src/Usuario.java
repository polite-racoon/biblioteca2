public abstract class Usuario {
    private String run;
    private String nombreCompleto;
    private char genero;
    private Prestamo prestamo;

    public Usuario(String run, String nombreCompleto, char genero) {
        this.run = run;
        this.nombreCompleto = nombreCompleto;
        this.genero = genero;
    }

    public String getRun() { return run; }
    public String getNombreCompleto() { return nombreCompleto; }
    public char getGenero() { return genero; }
    public Prestamo getPrestamo() { return prestamo; }
    public void setPrestamo(Prestamo prestamo) { this.prestamo = prestamo; }

    @Override
    public String toString() {
        return "Usuario{" +
                "run='" + run + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", genero=" + genero +
                '}';
    }
}
