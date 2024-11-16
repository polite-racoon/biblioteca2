public class Docente extends Usuario {
    private String profesion;
    private boolean magister;
    private boolean doctor;

    public Docente(String run, String nombreCompleto, char genero, String profesion, boolean magister, boolean doctor) {
        super(run, nombreCompleto, genero);
        this.profesion = profesion;
        this.magister = magister;
        this.doctor = doctor;
    }

    public String getProfesion() { return profesion; }
    public boolean isMagister() { return magister; }
    public boolean isDoctor() { return doctor; }

    @Override
    public String toString() {
        return super.toString() +
                ", profesion='" + profesion + '\'' +
                ", magister=" + magister +
                ", doctor=" + doctor + "}";
    }
}
