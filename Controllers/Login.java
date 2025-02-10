package Controllers;

import Models.Usuario;
import java.util.*;
import java.util.regex.Pattern;

public class Login {

//login     
    public static boolean logar(String email, String pass) {
        ArrayList<Usuario> usuarios = GestorArquivo.listaDeUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getPassword().equals(pass)) {
                return true;
            }
        }

        return false;
    }
    // validar numero de telefone 

    public static boolean validarTelefone(String telefone) {

        String regular = "^[9][0-9]{8}$";
        return Pattern.matches(regular, telefone);
    }
     /*public static boolean validarEmail (String email ){
        String regular = "^[A-Za-z0-9+]+[A-Za-z0-9.-]+$";
        return Pattern.matches(regular, email);
    }
*/
}
