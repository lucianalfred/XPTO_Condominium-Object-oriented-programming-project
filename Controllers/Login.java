
package Controllers;
import Models.Usuario;
import java.util.*;


public class Login {
    
    public static boolean logar(String email, String pass){
        ArrayList<Usuario> usuarios =  GestorArquivo.listaDeUsuarios();
        for (Usuario usuario : usuarios) {
            if(usuario.getEmail().equals(email) && usuario.getPassword().equals(pass)){
                return true;
            }
        }
        
        return false;
    }    
    
}
