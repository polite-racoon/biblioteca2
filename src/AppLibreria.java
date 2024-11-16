import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AppLibreria {

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current Date and Time: " + dtf.format(now));

        final ArrayList<Usuario> usuarios = new ArrayList<Usuario>(
                Arrays.asList(
                        new Estudiante("12341234-1", "Pepito TV", 'M', "Teatro"),
                        new Estudiante("5678567-8", "Cirilo Morrochuca", 'M', "Medicina"),
                        new Docente("4321432-1", "Pepe Machuca", 'M', "Calculator Prompt Engineer", true, false)
                )
        );

        ArrayList<Libro> libros = new ArrayList<Libro>(
                Arrays.asList(
                        new Libro(1, "Libro A", "Autor A", 5),
                        new Libro(2, "Libro B", "Autor B", 3),
                        new Libro(3, "Libro C", "Autor C", 4),
                        new Libro(4, "Libro D", "Autor D", 6),
                        new Libro(5, "Libro E", "Autor E", 2)
                )
        );

        ArrayList<Prestamo> prestamos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int menuBiblioteca, menuUsuario, menuLibro;

        do {
            System.out.println("\nMenu");
            System.out.println("1. Menu Usuario");
            System.out.println("2. Menu Libro");
            System.out.println("3. Menu Prestamo");
            System.out.println("4. Menu Devolucion");
            System.out.println("5. Salir");
            System.out.print("Elige una opcion: ");
            menuBiblioteca = scanner.nextInt();

            switch (menuBiblioteca) {
                case 1: // Menu Usuario
                    do {
                        System.out.println("\nMenu Usuario");
                        System.out.println("1. Crear Usuario");
                        System.out.println("2. Mostrar Usuarios");
                        System.out.println("3. Eliminar Usuario");
                        System.out.println("4. Salir");
                        System.out.print("Elige una opcion: ");
                        menuUsuario = scanner.nextInt();

                        switch (menuUsuario) {
                            case 1: // Crear Usuario
                                scanner.nextLine();
                                System.out.print("Ingrese el nombre del usuario: ");
                                String nombreCompleto = scanner.nextLine();
                                System.out.print("Ingrese el RUN del usuario: ");
                                String run = scanner.nextLine();
                                System.out.print("Ingrese M o F según su género: ");
                                char genero = scanner.next().charAt(0);
                                scanner.nextLine();

                                System.out.println("Es 1) Estudiante o 2) Docente?");
                                int tipoUsuario = scanner.nextInt();
                                scanner.nextLine();

                                if (tipoUsuario == 1) {
                                    System.out.print("Ingrese la carrera del estudiante: ");
                                    String carrera = scanner.nextLine();
                                    usuarios.add(new Estudiante(run, nombreCompleto, genero, carrera));
                                } else if (tipoUsuario == 2) {
                                    System.out.print("Ingrese la profesión del docente: ");
                                    String profesion = scanner.nextLine();
                                    System.out.print("¿Tiene magíster? (true/false): ");
                                    boolean magister = scanner.nextBoolean();
                                    System.out.print("¿Tiene doctorado? (true/false): ");
                                    boolean doctor = scanner.nextBoolean();
                                    usuarios.add(new Docente(run, nombreCompleto, genero, profesion, magister, doctor));
                                }
                                System.out.println("Usuario creado con éxito.");
                                break;

                            case 2: // Mostrar Usuarios
                                System.out.println("\nLista de Usuarios:");
                                for (Usuario usuario : usuarios) {
                                    System.out.println(usuario);
                                }
                                break;

                            case 3: // Eliminar Usuario
                                System.out.println("\nLista de Usuarios:");
                                for (int i = 0; i < usuarios.size(); i++) {
                                    System.out.println((i + 1) + ". " + usuarios.get(i).getNombreCompleto());
                                }
                                System.out.print("Seleccione el número del usuario a eliminar: ");
                                int indiceUsuario = scanner.nextInt();
                                if (indiceUsuario > 0 && indiceUsuario <= usuarios.size()) {
                                    usuarios.remove(indiceUsuario - 1);
                                    System.out.println("Usuario eliminado con éxito.");
                                } else {
                                    System.out.println("Índice no válido.");
                                }
                                break;
                        }
                    } while (menuUsuario != 4);
                    break;

                case 2: // Menu Libro
                    do {
                        System.out.println("\nMenu Libro");
                        System.out.println("1. Crear Libro");
                        System.out.println("2. Mostrar Libros");
                        System.out.println("3. Eliminar Libro");
                        System.out.println("4. Salir");
                        System.out.print("Elige una opcion: ");
                        menuLibro = scanner.nextInt();

                        switch (menuLibro) {
                            case 1: // Crear Libro
                                scanner.nextLine();
                                System.out.print("Ingrese el ISBN del libro: ");
                                int isbn = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Ingrese el título del libro: ");
                                String titulo = scanner.nextLine();
                                System.out.print("Ingrese el autor del libro: ");
                                String autor = scanner.nextLine();
                                System.out.print("Ingrese la cantidad total de ejemplares: ");
                                int cantidadTotal = scanner.nextInt();
                                libros.add(new Libro(isbn, titulo, autor, cantidadTotal));
                                System.out.println("Libro creado con éxito.");
                                break;

                            case 2: // Mostrar Libros
                                System.out.println("\nLista de Libros:");
                                for (Libro libro : libros) {
                                    System.out.println(libro);
                                }
                                break;

                            case 3: // Eliminar Libro
                                System.out.println("\nLista de Libros:");
                                for (int i = 0; i < libros.size(); i++) {
                                    System.out.println((i + 1) + ". " + libros.get(i).getTitulo());
                                }
                                System.out.print("Seleccione el número del libro a eliminar: ");
                                int indiceLibro = scanner.nextInt();
                                if (indiceLibro > 0 && indiceLibro <= libros.size()) {
                                    libros.remove(indiceLibro - 1);
                                    System.out.println("Libro eliminado con éxito.");
                                } else {
                                    System.out.println("Índice no válido.");
                                }
                                break;
                        }
                    } while (menuLibro != 4);
                    break;

                case 3: // Registrar Prestamo
                    System.out.print("Ingrese el ISBN del libro: ");
                    int isbnPrestamo = scanner.nextInt();
                    System.out.print("Ingrese el RUN del usuario: ");
                    String runPrestamo = scanner.next();
                    try {
                        Libro libro = libros.stream().filter(l -> l.getISBN() == isbnPrestamo).findFirst().orElse(null);
                        Usuario usuario = usuarios.stream().filter(u -> u.getRun().equals(runPrestamo)).findFirst().orElse(null);
                        if (libro != null && usuario != null) {
                            Prestamo prestamo = new Prestamo(usuario, libro);
                            prestamos.add(prestamo);
                            System.out.println("Préstamo registrado con éxito: " + prestamo);
                        } else {
                            System.out.println("Usuario o libro no encontrado.");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4: // Registrar Devolucion
                    System.out.print("Ingrese el ISBN del libro: ");
                    int isbnDevolucion = scanner.nextInt();
                    System.out.print("Ingrese el RUN del usuario: ");
                    String runDevolucion = scanner.next();
                    try {
                        Prestamo prestamo = prestamos.stream()
                                .filter(p -> p.getLibro().getISBN() == isbnDevolucion && p.getUsuario().getRun().equals(runDevolucion) && !p.isDevuelto())
                                .findFirst().orElse(null);
                        if (prestamo != null) {
                            Devolucion devolucion = new Devolucion(prestamo);
                            System.out.println("Devolución registrada: " + devolucion);
                        } else {
                            System.out.println("No se encontró el préstamo.");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5: // Salir
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (menuBiblioteca != 5);
    }
}