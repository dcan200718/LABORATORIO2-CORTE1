
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CRUDArchivo crud = new CRUDArchivo();

        System.out.println("escriba la opción que desee realizar");
        System.out.println("1. crear usuario");
        System.out.println("2. leer usuario");
        System.out.println("3. actualizar usuario");
        System.out.println("4. eliminar usuario");

        int opcion = sc.nextInt();
        sc.nextLine(); // consumir salto de línea
        switch (opcion) {
            case 1:
                System.out.print("digite su ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("digite su nombre: ");
                String nombre = sc.nextLine();
                System.out.print("digite su email: ");
                String email = sc.nextLine();
                try {
                    crud.crearUsuario(new Usuario(id, nombre, email));
                    System.out.println("Usuario creado.");
                } catch (IOException e) {
                    System.out.println("Error al crear usuario: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Opción no válida.");
        }

        case 2:
            try {
                System.out.println("Usuarios registrados:");
                for (Usuario u : crud.leerUsuarios()) {
                    System.out.println(u);
                }
            } catch (IOException e) {
                System.out.println("Error al leer usuarios: " + e.getMessage());
            }

        sc.close();
    }
}




