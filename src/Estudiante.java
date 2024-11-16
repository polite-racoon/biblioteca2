public class Estudiante extends Usuario {
    private String carrera;

    public Estudiante(String run, String nombreCompleto, char genero, String carrera) {
        super(run, nombreCompleto, genero);
        this.carrera = carrera;
    }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    @Override
    public String toString() {
        return super.toString() + ", carrera='" + carrera + "'}";
    }
}
