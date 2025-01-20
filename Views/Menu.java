package Views;

import Models.Condominio;

public class Menu {

    public static void menuPrincipal() {
        System.out.println("Menu Principal");
        System.out.println(" 1 - Condominio  ");
        System.out.println(" 2  - Fraccao ");
        System.out.println(" 0 - Sair ");
        System.out.println("Digite a opcção que deseja: ");
    }

    public static void menuLogin() {
        System.out.println("-----------------------------");
        System.out.println("--------Fazer  Login --------");
        System.out.println("-----------------------------");
    }

    public static void menuAdmin() {

    }

    public static void menuCondominio() {
        System.out.println(" Menu Condomínio ");
        System.out.println(" 1 - Ver e Alterar a Despesa Geral e do Elevador  ");
        System.out.println(" 2 - Calcular a soma das Quotais Mensais ");
        System.out.println(" 3 - Listar as fraccoes que compoem o condominio ");
        System.out.println(" 0 - Sair ");
        System.out.println("Digite a opcção que deseja: ");
    }
    public static void menuFraccao(){
        System.out.println(" Menu Fraccao ");
        System.out.println("1 - Inserir Fraccao ");
        System.out.println("2 - Remover Fraccao ");
        System.out.println("3 - Verificar as somas das fraccoes ");
        System.out.println(" 0 - Sair ");
        System.out.println("Digite a opcção que deseja: ");
    }
}
