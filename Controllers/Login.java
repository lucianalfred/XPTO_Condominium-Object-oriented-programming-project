
package Controllers;
import Models.Usuario;
import java.util.*;

public class Login {
    
    public static boolean logar(ArrayList<Usuario> usuarios, String email, String pass){
        
        for (Usuario usuario : usuarios) {
            if(usuario.getEmail().equals(email) && usuario.getPassword().equals(pass)){
                return true;
            }
        }
        
        return false;
    }    
    
}
