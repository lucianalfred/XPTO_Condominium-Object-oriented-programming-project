package Main;

import Controllers.*;
import Models.*;
import Views.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class PrincipalCondominio {

    public static void main(String[] args) {
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        Usuario luciano = new Usuario("Luciano", "la@gmail.com", "1234");
        listaUsuarios.add(luciano);

        Scanner input = new Scanner(System.in);
        boolean flag = true;
        int op, opCondominio, opFraccao, opTipoFraccao;
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
                                        case 0:
                                            System.out.println(" 0 - Sair ");
                                            break;
                                        case 1:
                                            System.out.println(" 1 - Ver e Alterar a Despesa Geral e do Elevador  ");
                                            break;
                                        case 2:
                                            System.out.println(" 2 - Calcular a soma das Quotais Mensais ");
                                            break;
                                        case 3:
                                            System.out.println(" 3 - Listar as fraccoes que compoem o condominio ");
                                            break;
                                        case 4:
                                            System.out.println(" Inserir Dados Do Condominio ");
                                            System.out.print("Digite a morada do Condominio: ");
                                            String moradaCondominio = input.next();
                                            System.out.print("Digite a Despesa Geral ");
                                            double despesaGeralCondominio = input.nextDouble();
                                            System.out.print("Digite a Despesa do Elevador  ");
                                            double despesaElevadorCondominio = input.nextDouble();
                                            System.out.print("A area Total do Condominio :");
                                            double areaTotalCondominio = input.nextDouble();
                                            System.out.print("Digite a data de Construção yyyy-MM-dd :");
                                            String dataConstrucao = input.next();
                                            LocalDate data = LocalDate.parse(dataConstrucao);
                                            System.out.println("Data :" + data);
                                            // int identifcador, double areaTotal, String morada, double totalDispesasGerais,LocalDate dataConstrucao
                                            Condominio condominio = new Condominio (1,areaTotalCondominio,moradaCondominio,despesaGeralCondominio, despesaElevadorCondominio,data);
                                            System.out.println(condominio);
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
                                            do {
                                                Menu.menuTipoFraccao();
                                                opTipoFraccao = input.nextInt();
                                                switch (opTipoFraccao) {
                                                    case 0:
                                                        System.out.println(" Sair ");
                                                        break;
                                                    case 1:
                                                        System.out.println(" 1 - Apartamento ");
                                                        break;
                                                    case 2:
                                                        System.out.println(" 2 -  Garagens ");
                                                        break;
                                                    case 3:
                                                        System.out.println(" 3 - Arrecadação ");
                                                        break;
                                                    case 4:
                                                        System.out.println(" 4  - Loja ");
                                                        break;
                                                    default:
                                                        break;
                                                }
                                            } while (opTipoFraccao != 0);
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
