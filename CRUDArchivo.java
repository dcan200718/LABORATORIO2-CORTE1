import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CRUDArchivo {
    private static final String ARCHIVO = "usuarios.txt";

    public CRUDArchivo() {
    }

    public void crearUsuario(Usuario usuario) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            bw.write(usuario.toString());
            bw.newLine();
        }
    }

    public List<Usuario> leerUsuarios() throws IOException {
        List<Usuario> lista = new ArrayList<>();
        File f = new File(ARCHIVO);
        if (!f.exists()) return lista;
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.trim().isEmpty()) continue;
                String[] datos = line.split(",");
                if (datos.length < 3) continue;
                lista.add(new Usuario(
                    Integer.parseInt(datos[0].trim()),
                    datos[1].trim(),
                    datos[2].trim()));
            }
        }
        return lista;
    }

    public void actualizarUsuario(int id, String nuevoNombre, String nuevoEmail) throws IOException {
        List<Usuario> lista = leerUsuarios();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Usuario u : lista) {
                if (u.getId() == id) {
                    u.setNombre(nuevoNombre);
                    u.setEmail(nuevoEmail);
                }
                bw.write(u.toString());
                bw.newLine();
            }
        }
    }

    public void eliminarUsuario(int id) throws IOException {
        List<Usuario> lista = leerUsuarios();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Usuario u : lista) {
                if (u.getId() != id) {
                    bw.write(u.toString());
                    bw.newLine();
                }
            }
        }
    }

}


 

//hola
