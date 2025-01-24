package Main;

import Controllers.*;
import Models.*;
import Views.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class PrincipalCondominio {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        int op, opCondominio, opFraccao, opTipoFraccao;
        Condominio condominio = new Condominio(25000, "Luanda", 12000, 1200, LocalDate.parse("2025-11-11"));

        try {

            do {
                Menu.menuLogin();
                System.out.print("Email: ");
                String email = input.next();
                System.out.print("Password: ");
                String password = input.next();

                if (Login.logar(email, password)) {
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
                                            System.out.print("Digite a Despesa Geral do Condominio :");
                                            double despesaGeral = input.nextDouble();
                                            System.out.print("Digite a Despesa Do Elevador :");
                                            double desepesaElevador = input.nextDouble();
                                            condominio.setTotalDispesasGerais(despesaGeral);
                                            condominio.setTotalDespesaElevador(desepesaElevador);
                                            System.out.println(condominio.toString());
                                            break;
                                        case 2:
                                            System.out.println(" 2 - Calcular a soma das Quotais Mensais ");
                                            System.out.println("A Soma das Quotas Mensais :" + condominio.calcularQuotasMensais());
                                            break;
                                        case 3:
                                            System.out.println(" 3 - Listar as fraccoes que compoem o condominio ");
                                            condominio.listarFraccao();
                                            break;
                                        case 4:

                                            System.out.println(" Alterar Dados Do Condominio ");
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
                                            condominio.setMorada(moradaCondominio);
                                            condominio.setTotalDispesasGerais(despesaGeralCondominio);
                                            condominio.setTotalDespesaElevador(despesaElevadorCondominio);
                                            condominio.setDataConstrucao(data);
                                            condominio.setAreaTotal(areaTotalCondominio);

                                            System.out.println(condominio.toString());
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
                                    Proprietario proprietarioExistente = null;
                                    Menu.menuFraccao();
                                    opFraccao = input.nextInt();
                                    switch (opFraccao) {
                                        case 1:
                                            System.out.println("1 - Inserir Fraccao ");
                                            do {
                                                System.out.println(" O proprietario Já possui alguma fracção do Condominio?! 1-Sim /0-Não ");
                                                int temProprietario = input.nextInt();
                                                if (temProprietario == 1) {
                                                    System.out.println("Digite o Id do Proprietario :");
                                                    int id = input.nextInt();
                                                    proprietarioExistente = condominio.procurarProprietario(id);

                                                    if (proprietarioExistente == null) {
                                                        System.out.println("Proprietário Não Existe! Cadastra proprietario ");
                                                        //String nome, String morada, String telefone, String email, LocalDate dataNascimento
                                                        System.out.println(" Nome :");
                                                        String nome = input.next();
                                                        System.out.println("Morada :");
                                                        String morada = input.next();
                                                        System.out.println("Telefone :");
                                                        String telefone = input.next();
                                                        System.out.println(" Email :");
                                                        String emailProprietario = input.next();
                                                        System.out.println(" Digite a Date de Nascimento :");
                                                        String dataNascimento = input.next();
                                                        LocalDate data = LocalDate.parse(dataNascimento);
                                                        proprietarioExistente = new Proprietario(nome, morada, telefone, emailProprietario, data);

                                                    }

                                                } else {
                                                    System.out.println("Proprietário Não Existe! Cadastra proprietario ");
                                                    //String nome, String morada, String telefone, String email, LocalDate dataNascimento
                                                    System.out.println(" Nome :");
                                                    String nome = input.next();
                                                    System.out.println("Morada :");
                                                    String morada = input.next();
                                                    System.out.println("Telefone :");
                                                    String telefone = input.next();
                                                    System.out.println(" Email :");
                                                    String emailProprietario = input.next();
                                                    System.out.println(" Digite a Date de Nascimento :");
                                                    String dataNascimento = input.next();
                                                    LocalDate data = LocalDate.parse(dataNascimento);
                                                    proprietarioExistente = new Proprietario(nome, morada, telefone, emailProprietario, data);

                                                }
                                                System.out.println(" Digite os Dados da Fraccao ");
                                                System.out.print("Digite a area da Fracção :");
                                                double areafraccao = input.nextDouble();
                                                System.out.println("Digite a Localização :");
                                                String localizacao = input.next();

                                                Menu.menuTipoFraccao();
                                                opTipoFraccao = input.nextInt();
                                                switch (opTipoFraccao) {
                                                    case 0:
                                                        System.out.println(" Sair ");
                                                        break;
                                                    case 1:
                                                        System.out.println(" 1 - Apartamento ");
                                                        System.out.println(" Tipo apartamento :");
                                                        String tipoApartamento = input.next();
                                                        System.out.println("Numero de Casas De Banho :");
                                                        int numBanheiro = input.nextInt();
                                                        System.out.println("Numero Varandas :");
                                                        int numVaranda = input.nextInt();
                                                        System.out.println("Tem terraço ? sim-1/ não - 0");
                                                        int temTerraco = input.nextInt();
                                                        boolean terraco = true;
                                                        if (temTerraco == 0) {
                                                            terraco = false;
                                                        }

                                                        Apartamento apartamento = new Apartamento(tipoApartamento, numBanheiro, numVaranda, terraco, areafraccao, localizacao, proprietarioExistente);

                                                        condominio.adicionarFraccao(apartamento);

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
