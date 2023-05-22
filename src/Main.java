import com.usuer.Usuario;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        Usuario listaUsuario = new Usuario();
//        listaUsuario.createUsuario();
        listaUsuario.readUsuarios();
        listaUsuario.updateUsuario();
//        listaUsuario.deleteUsuario();

    }
}
