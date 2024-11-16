import java.util.ArrayList;

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

    // getters
    public String getRun() { return run; }
    public String getNombreCompleto() { return nombreCompleto; }
    public char getGenero() { return genero; }
    public Prestamo getPrestamo() { return prestamo; }

    // setters
    public void setPrestamo(Prestamo prestamo) { this.prestamo = prestamo; }

    // static methods
    public static boolean validarRun(String run) {
        //separar número y digito verificador
        String numero = run.substring(0, run.length() - 1);
        char dvIngresado = run.charAt(run.length() - 1);

        char[] digitos = numero.toCharArray();
        int[] secuencia = {2,3,4,5,6,7};

        int suma = 0;
        int j = 0;
        for (int i = digitos.length - 1; i >= 0; i--) {
            suma += Character.getNumericValue(digitos[i]) * secuencia[j];
            j = (j + 1) % secuencia.length;
        }

        int resto = suma % 11;
        int dvCalculado = 11 - resto;

        char dvEsperado;
        if (dvCalculado == 10) {
            dvEsperado = 'K';
        } else if (dvCalculado == 11) {
            dvEsperado = '0';
        } else {
            dvEsperado = (char) (dvCalculado + '0');
        }

        return dvIngresado == dvEsperado;
    }

    public static boolean existeUsuario(String run, ArrayList<Usuario> usuarios) {
        boolean existe = false;
        for (Usuario usuario : usuarios) {
            if (usuario.run.equals(run)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    @Override
    public String toString() {
        // Los run se almacenan sin puntos ni guion. Para mostrarlos le agregamos el guion
        String runConGuion = run.substring(0, run.length()-1) + "-" +run.substring(run.length()-1);

        // En préstamo mostramos solo el nombre del libro, para facilitar la lectura
        String prestamo = (this.prestamo == null)? null : this.prestamo.getLibro().getTitulo();

        return "Usuario{" +
                "run='" + runConGuion + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", genero=" + genero +
                ", préstamo=" + prestamo;
    }
}
