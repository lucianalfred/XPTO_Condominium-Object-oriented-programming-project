package Main;

import Controllers.*;
import Models.*;
import Views.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PrincipalCondominio {

    private static Scanner input = new Scanner(System.in);
    private static Condominio condominio;

    public static void main(String[] args) {
        try {
            inicializarCondominio();
            executarPrograma();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            input.close();
        }
    }

    private static void inicializarCondominio() {
        String dataConstrucao = "11-11-2001";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate data = LocalDate.parse(dataConstrucao, formatter);
        condominio = new Condominio(25000, "Luanda, Talatona", 1500, 500, data);

        Proprietario luciano = new Proprietario("Luciano", "luciano@gmail.com");
        TipoApartamento escolher = TipoApartamento.T3;
        TipoApartamento escolher1 = TipoApartamento.T4;
        Apartamento ap = new Apartamento(escolher, 2, 2, false, 45, "Luanda", luciano, condominio);
        Apartamento ap2 = new Apartamento(escolher1, 2, 2, false, 45, "Luanda", luciano, condominio);
        condominio.adicionarFraccao(ap);
        condominio.adicionarFraccao(ap2);
    }

    public static void verificarSomaDasFraccoes() {
        System.out.println(" 7 - Verificar as somas das fraccoes ");
        condominio.verificarSomasDasPercentagens();
    }

    private static void executarPrograma() {
        boolean flag = true;
        do {
            Menu.menuLogin();
            System.out.print("Email: ");
            String email = input.next();
            System.out.print("Password: ");
            String password = input.next();
            if (Login.logar(email, password)) {
                gerenciarMenuPrincipal();
            } else {
                System.out.println("Login falhou. Tente novamente.");
            }
        } while (flag);
    }

    private static void gerenciarMenuPrincipal() {
        boolean flagMenuPrincipal = true;
        do {
            Menu.menuPrincipal();
            int op = input.nextInt();
            switch (op) {
                case 1:
                    gerenciarMenuCondominio();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    flagMenuPrincipal = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (flagMenuPrincipal);
    }

    private static void gerenciarMenuCondominio() {
        boolean flagCondominio = true;
        do {
            Menu.menuCondominio();
            int opcaoCondominio = input.nextInt();
            switch (opcaoCondominio) {
                case 1:
                    alterarDespesas();

                    break;
                case 2:
                    calcularQuotasMensais();
                    break;
                case 3:
                    listarFracoes();
                    break;
                case 4:

                    alterarDadosCondominio();
                    break;
                case 5:
                    inserirFracao();
                    break;
                case 6:
                    removerFraccao();
                    break;
                case 7:
                    verificarSomaDasFraccoes();
                    break;
                case 0:
                    System.out.println("Saindo do menu do condomínio...");
                    flagCondominio = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (flagCondominio);
    }

    private static void alterarDespesas() {
        System.out.println("1 - Ver e Alterar a Despesa Geral e do Elevador");
        condominio.mostrarInformacao();

        try {
            System.out.print("Altere a  Despesa Geral :");
            String despesasGeraisInput = input.next();
            despesasGeraisInput = despesasGeraisInput.replace(",", ".");

            double despesasGerais = Double.parseDouble(despesasGeraisInput);
            if (despesasGerais <= 0) {
                System.out.println(" Não Digite valores negativos para Despesa Geral  ");
                return;
            }
            condominio.setTotalDispesasGerais(despesasGerais);

            System.out.print("Altere a Despesas Elevador :");
            String despesasElevadorInput = input.next();
            despesasElevadorInput = despesasElevadorInput.replace(",", ".");
            double despesasElevador = Double.parseDouble(despesasElevadorInput);
            if (despesasElevador <= 0) {
                System.out.println(" Não Digite valores negativos para Despesa do Elevador  ");
                return;
            }
            condominio.setTotalDespesaElevador(despesasElevador);
        } catch (NumberFormatException e) {
            System.out.println(" Entrada Inválida. Certifique-se de usar vírgula ou ponto como separador decimal.");
        }
    }

    private static void calcularQuotasMensais() {
        System.out.println("2 - Calcular a soma das Quotas Mensais");
        double quotaMensal = condominio.calcularQuotasMensais();
        System.out.println("Quota mensal: " + quotaMensal);
    }

    private static void listarFracoes() {
        System.out.println("3 - Listar as fracções do condomínio");
        condominio.listarFraccao();
    }

    private static void alterarDadosCondominio() {
        System.out.println("4 - Alterar Dados do Condomínio");
        condominio.mostrarInformacao();

        double area;
        do {
            System.out.print("Digite a  área Total: ");
            area = input.nextDouble();
            if (area <= 0) {
                System.out.println("Digite um Valor Positivo para área Total ou Numero Diferente que Zero  ");
            }
            condominio.setAreaTotal(area);
        } while (area <= 0);
        double despesasGerais;
        do {
            System.out.print("Digite a Despesas Geral: ");
            despesasGerais = input.nextDouble();
            condominio.setTotalDispesasGerais(despesasGerais);
        } while (despesasGerais <= 0);

        double despesasElevador;
        do {
            System.out.print("Digite  a Despesas Elevador: ");
            despesasElevador = input.nextDouble();
            condominio.setTotalDespesaElevador(despesasElevador);
        } while (despesasElevador <= 0);
    }

    private static void inserirFracao() {
        System.out.println("5 - Inserir Fracção");
        double areaFraccao;
        do {
            System.out.print("Digite a área da Fracção: ");
            areaFraccao = input.nextDouble();
            if (areaFraccao <= 0) {
                System.out.println(" Digite Um Valor Positivo para Área da Fracção ou  Numero Diferente que Zero ");
            }
        } while (areaFraccao <= 0);

        System.out.print("Localização: ");
        String localizacao = input.next();
        input.nextLine();
        Proprietario proprietarioExistente = null;
        System.out.println("O proprietário já possui alguma fracção do condomínio?! 1-Sim / 0-Não");
        int temProprietario = input.nextInt();
        if (temProprietario == 1) {
            System.out.print("Digite o Id do Proprietário: ");
            int idProprietario = input.nextInt();
            proprietarioExistente = condominio.procurarProprietario(idProprietario);
        }
        if (proprietarioExistente == null) {
            proprietarioExistente = cadastrarNovoProprietario();
        }
        //Escolher diferente tipo de fraccoes
        Menu.menuTipoFraccao();
        int opTipoFraccao = input.nextInt();
        switch (opTipoFraccao) {
            case 0:
                System.out.println(" Sair ");

                break;
            case 1:
                System.out.println(" 1 - Apartamento ");
                int tipoApartamento;

                System.out.println(" Tipo de Apartamento :");
                System.out.println("0 - T0");
                System.out.println("1 - T1");
                System.out.println("2 - T2");
                System.out.println("3 - T3");
                System.out.println("4 - T4");
                System.out.println("5 - T5");
                System.out.print(" Digite o Tipo apartamento :");
                tipoApartamento = input.nextInt();
                TipoApartamento escolhidoApartamento = null;
                switch (tipoApartamento) {
                    case 0:
                        escolhidoApartamento = TipoApartamento.T0;
                        break;
                    case 1:
                        escolhidoApartamento = TipoApartamento.T1;
                        break;
                    case 2:
                        escolhidoApartamento = TipoApartamento.T2;
                        break;
                    case 3:
                        escolhidoApartamento = TipoApartamento.T3;
                        break;
                    case 4:
                        escolhidoApartamento = TipoApartamento.T4;
                        break;
                    case 5:
                        escolhidoApartamento = TipoApartamento.T5;
                        break;

                }
                int numBanheiro,
                 numVaranda;
                do {
                    System.out.print("Numero de Casas De Banho :");
                    numBanheiro = input.nextInt();
                    if (numBanheiro < 0) {
                        System.out.println(" Digite Um Valor Positivo para o  Numero de Casas De Banho ");
                    }
                } while (numBanheiro < 0);
                do {
                    System.out.print("Numero Varandas :");
                    numVaranda = input.nextInt();
                    if (numVaranda < 0) {
                        System.out.println(" Digite Um Valor Positivo para o Numero Varandas  ");
                    }
                } while (numVaranda < 0);

                System.out.print("Tem terraço ? sim-1/ não - 0");
                int temTerraco = input.nextInt();
                boolean terraco = true;
                if (temTerraco == 0) {
                    terraco = false;
                }
                Apartamento apartamento = new Apartamento(escolhidoApartamento, numBanheiro, numVaranda, terraco, areaFraccao, localizacao, proprietarioExistente, condominio);
                if (condominio.adicionarFraccao(apartamento)) {
                    System.out.println("Fraçãoa foi inserida com sucesso!");
                } else {
                    System.out.println("Fraçãoa não foi inserida, verifica se tem espaaço disponivel!");
                }

                break;
            case 2:
                System.out.println(" 2 - Garagens ");
                int numViaturas;
                do {
                    System.out.println("Digite o Numero de Viatuaras :");
                    numViaturas = input.nextInt();
                    if (numViaturas < 0) {
                        System.out.println(" Digite Um Valor Positivo para o  Numero de Viatuaras   ");
                    }
                } while (numViaturas < 0);

                System.out.println("Possui Serviço de Lavegem ?! 1-Sim / 0-Não ");
                int possuiLavagem = input.nextInt();
                boolean lavagem = true;
                if (possuiLavagem == 0) {
                    lavagem = false;
                }
                Garagem garagem = new Garagem(numViaturas, lavagem, areaFraccao, localizacao, proprietarioExistente, condominio);
                if (condominio.adicionarFraccao(garagem)) {
                    System.out.println("Garagem  foi inserida com sucesso!");
                } else {
                    System.out.println("Garagem  não foi inserida, verifica se tem espaaço disponivel!");
                }
                break;
            case 3:
                System.out.println(" 3 - Arrecadação ");
                System.out.println("Possui porta blindada? Sim -1, não - 0");
                int blindada = input.nextInt();
                boolean portaBlindada = true;
                if (blindada == 0) {
                    portaBlindada = false;
                }
                Arrecadacao arrecadacao = new Arrecadacao(portaBlindada, areaFraccao, localizacao, proprietarioExistente, condominio);
                if (condominio.adicionarFraccao(arrecadacao)) {
                    System.out.println("Arrecadação foi inserida com sucesso!");
                } else {
                    System.out.println("Arrecadação não foi inserida, verifica se tem espaaço disponivel!");
                }
                break;
            case 4:
                System.out.println(" 4 - Loja ");
                Loja loja = new Loja(areaFraccao, localizacao, proprietarioExistente, condominio);
                if (condominio.adicionarFraccao(loja)) {
                    System.out.println("Loja foi inserida com sucesso!");
                } else {
                    System.out.println("Loja não foi inserida, verifica se tem espaaço disponivel!");
                }
                break;
            default:
                break;
        }

    }

    public static void removerFraccao() {
        System.out.println("Digite o id da Fração: ");
        int idFraccao = input.nextInt();
        boolean removeu = false;
        for (Fraccao frac : condominio.getFraccoes()) {
            if (frac.getIdentificador() == idFraccao) {
                if (condominio.removerFraccao(frac)) {
                    removeu = true;
                }
            }
        }
        if (removeu) {
            System.out.println("Fraçao removida com sucesso");
        } else {
            System.out.println("Fraçao não foi removida, verifica se foi inserida!");
        }
    }

    private static Proprietario cadastrarNovoProprietario() {
        System.out.println(" Cadastre um novo proprietário...");
        System.out.print("Nome: ");
        String nome = input.next();
        System.out.print("Morada: ");
        String morada = input.next();
        String telefone, emailProprietario;
        do {
            System.out.print("Telefone: ");
            telefone = input.next();
            if (Login.validarTelefone(telefone) == false) {
                System.out.println(" Digite um numero de telefone com 9 Digitos e Inicie com 9  ");
            }
        } while (Login.validarTelefone(telefone) == false);
        /* do {
            System.out.print("Email: ");
            emailProprietario = input.next();
            if ((Login.validarEmail(emailProprietario) == false)) {
                System.out.println(" Digite um email Válido ");
            }
        } while (Login.validarEmail(emailProprietario) == false);
         */
        System.out.print("Email: ");
        emailProprietario = input.next();
        System.out.print("Data de nascimento do Proprietário (dd-MM-yyyy): ");
        String dataNascimento = input.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dataN = LocalDate.parse(dataNascimento, formatter);
        return new Proprietario(nome, morada, telefone, emailProprietario, dataN);
    }
}
