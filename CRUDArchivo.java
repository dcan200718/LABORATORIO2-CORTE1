public class CRUDArchivo {
   //CREAR USUARIO
    public static void crearUsuario(Usuario usuario) throws IOException {
    FileWriter fw = new FileWriter("usuarios.txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write(usuario.toString());
    bw.newLine();
    bw.close();
    System.out.println("usuario agregado correctamente");
   }
}
//LEER USUARIO
public static List<usuario> leerUsuarios() 
throws IOException {
    List<usuario> lista = new ArrayList<>();
    Scanner sc = new Scanner(new File("usuarios.txt"));

    while (sc.hasNextLine()) {
        String[] datos = sc.nextLine().split(",");
        lista.add(new Usuario(
            Integer.parseInt(datos[0]),
            datos[1],
            datos[2]));
    }
    sc.close();
    return lista;
}
      </usuario></usuario>


      //ACTUALIZAR
public static void actualizarUsuario(int id, 
String nuevoNombre, String nuevoEmail) 
throws IOException {

    List<usuario> lista = leerUsuarios();
    BufferedWriter bw = 
        new BufferedWriter(new FileWriter("usuarios.txt"));

    for (Usuario u : lista) {
        if (u.getId() == id) {
            u.setNombre(nuevoNombre);
            u.setEmail(nuevoEmail);
        }
        bw.write(u.toString());
        bw.newLine();
    }
    bw.close();
}
      </usuario>

//ELIMINAR
public static void eliminarUsuario(int id) 
throws IOException {

    List<usuario> lista = leerUsuarios();
    BufferedWriter bw = 
        new BufferedWriter(new FileWriter("usuarios.txt"));

    for (Usuario u : lista) {
        if (u.getId() != id) {
            bw.write(u.toString());
            bw.newLine();
        }
    }
    bw.close();
}
      </usuario>
//hola


