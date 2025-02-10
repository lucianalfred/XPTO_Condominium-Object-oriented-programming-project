package Views;

import Models.Condominio;

public class Menu {

    public static void menuPrincipal() {
        System.out.println("Menu Principal");
        System.out.println(" 1 - Condominio  ");
        System.out.println(" 0 - Sair ");
        System.out.println("Digite a opcção que deseja: ");
    }

    public static void menuLogin() {
        System.out.println("-----------------------------");
        System.out.println("-------- Login --------");
        System.out.println("-----------------------------");
    }

    public static void menuAdmin() {
        System.out.println("Menu Admin");
    }

    public static void menuCondominio() {
        System.out.println("______________________________________________________________________________________");
        System.out.println("                          Serviços Disponíveis                                        ");
        System.out.println(" 1 - Ver e Alterar a Despesa Geral e do Elevador  ");
        System.out.println(" 2 - Calcular a soma das Quotais Mensais ");
        System.out.println(" 3 - Listar as fraccoes que compoem o condominio ");
        System.out.println(" 4 - Alterar Dados do Condominio ");
        System.out.println(" 5 - Inserir Fraccao ");
        System.out.println(" 6 - Remover Fraccao ");
        System.out.println(" 7 - Verificar as somas das fraccoes ");
        System.out.println(" 8 - Listar Proprietarios");
        System.out.println(" 9 - Adicionar Proprietario");
        System.out.println(" 10- Info");
        System.out.println(" 0 - Sair ");
        System.out.println("Digite a opcção que deseja :");
        System.out.println("______________________________________________________________________________________");
    }

    public static void menuTipoFraccao() {
        System.out.println("______________________________________________________________________________________");
        System.out.println("                            Tipos de Fracçoes   ");
        System.out.println(" 1 - Apartamento ");
        System.out.println(" 2 -  Garagens ");
        System.out.println(" 3 - Arrecadação ");
        System.out.println(" 4  - Loja ");
        System.out.println("Digite a opção que deseja :");
        System.out.println("______________________________________________________________________________________"); 
    }
}
