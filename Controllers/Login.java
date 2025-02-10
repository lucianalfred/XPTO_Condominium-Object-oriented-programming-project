package Controllers;

import Arquivo.GestorArquivo;
import Models.Usuario;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Classe responsável por gerenciar o login e a validação de dados, como telefone e e-mail.
 */
public class Login {

    /**
     * Método para realizar o login de um usuário.
     *
     * @param email E-mail do usuário.
     * @param pass Senha do usuário.
     * @return true se o login for bem-sucedido, false caso contrário.
     */
    public static boolean logar(String email, String pass) {
        // Obtém a lista de usuários do arquivo
        ArrayList<Usuario> usuarios = GestorArquivo.listaDeUsuarios();

        // Verifica se o e-mail e a senha correspondem a algum usuário na lista
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getPassword().equals(pass)) {
                return true; // Login bem-sucedido
            }
        }

        return false; // Login falhou
    }

    /**
     * Método para validar um número de telefone.
     * O telefone deve começar com o número 9 e ter exatamente 9 dígitos.
     *
     * @param telefone Número de telefone a ser validado.
     * @return true se o telefone for válido, false caso contrário.
     */
    public static boolean validarTelefone(String telefone) {
        // Expressão regular para validar o telefone
        String regular = "^[9][0-9]{8}$"; // O telefone deve começar com 9 e ter 9 dígitos no total
        return Pattern.matches(regular, telefone); // Verifica se o telefone corresponde à expressão regular
    }

    /*
     * Método para validar um e-mail (comentado).
     * Este método pode ser implementado para validar e-mails no futuro.
     *
     * @param email E-mail a ser validado.
     * @return true se o e-mail for válido, false caso contrário.
     */
    /*
    public static boolean validarEmail(String email) {
        // Expressão regular para validar o e-mail
        String regular = "^[A-Za-z0-9+]+[A-Za-z0-9.-]+$";
        return Pattern.matches(regular, email); // Verifica se o e-mail corresponde à expressão regular
    }
    */
}