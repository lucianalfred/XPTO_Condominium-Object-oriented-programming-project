package Main;

import Controllers.*;
import Models.*;
import Views.*;
import java.util.*;

public class PrincipalCondominio {

    public static void main(String[] args) {
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        Usuario luciano = new Usuario("Luciano", "la@gmail.com", "1234");
        listaUsuarios.add(luciano);

        Scanner input = new Scanner(System.in);
        boolean flag = true;
        int op, opCondominio, opFraccao;
        try {

            do {
                Menu.menuLogin();
                System.out.print("Email: ");
                String email = input.next();
                System.out.print("Password: ");
                String password = input.next();

                if (Login.logar(listaUsuarios, email, password)) {
                    do {
                        Menu.menuPrincipal();
                        op = input.nextInt();
                        switch (op) {
                            case 1:
                                System.out.println(" 1 - Condominio  ");
                                do {
                                    Menu.menuCondominio();
                                    opCondominio = input.nextInt();
                                    switch (opCondominio) {
                                        case 1:
                                            System.out.println(" 1 - Ver e Alterar a Despesa Geral e do Elevador  ");
                                            break;
                                        case 2:
                                            System.out.println(" 2 - Calcular a soma das Quotais Mensais ");
                                            break;
                                        case 3:
                                            System.out.println(" 3 - Listar as fraccoes que compoem o condominio ");
                                            break;
                                        case 0:
                                            System.out.println(" 0 - Sair ");
                                            break;
                                        default:
                                            System.out.println(" Opção Inválida ");
                                            break;
                                    }
                                } while (opCondominio != 0);
                                break;
                            case 2:
                                System.out.println(" 2  - Fraccao ");
                                do {
                                    Menu.menuFraccao();
                                    opFraccao = input.nextInt();
                                    switch (opFraccao) {
                                        case 1:
                                            System.out.println("1 - Inserir Fraccao ");
                                            break;
                                        case 2:
                                            System.out.println("2 - Remover Fraccao ");
                                            break;
                                        case 3:
                                            System.out.println("3 - Verificar as somas das fraccoes ");
                                            break;
                                        case 0:
                                            System.out.println(" 0 - Sair ");
                                            break;
                                        default:
                                            break;
                                    }
                                } while (opFraccao != 0);
                                break;
                            case 0:
                                flag = false;
                                System.out.println(" 0 - Sair ");
                                break;
                            default:
                                break;
                        }
                    } while (op != 0);

                }

            } while (flag);

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }

}
