package Main;

import Arquivo.GestorArquivo;
import Controllers.*;
import Models.*;
import Views.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PrincipalCondominio {

    private static final Scanner input = new Scanner(System.in);
    private static Condominio condominio;
    private static ArrayList<Proprietario> proprietarios;
    private static ArrayList<Usuario> usuarios;

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

        condominio = new Condominio();

        GestorArquivo.carregarDadosDoCondominio(condominio);
        proprietarios = GestorArquivo.carregarProprietarios();
        GestorArquivo.carregarFraccoes(condominio);
    }

    public static void sair() {
        GestorArquivo.guardarFracoes(condominio);
        GestorArquivo.guardarProprietarios(proprietarios);
        System.out.println("Saindo do programa...");
    }

    public static void verificarSomaDasFraccoes() {
        System.out.println("7 - Verificar as somas das frações");
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
                    sair();
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
                case 8:
                    listarProprietarios();
                    break;
                case 9:
                    cadastrarNovoProprietario();
                    break;
                case 10:
                    info();
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
            System.out.print("Altere a Despesa Geral: ");
            String despesasGeraisInput = input.next().replace(",", ".");
            double despesasGerais = Double.parseDouble(despesasGeraisInput);
            if (despesasGerais <= 0) {
                System.out.println("Não digite valores negativos para Despesa Geral.");
                return;
            }
            condominio.setTotalDispesasGerais(despesasGerais);

            System.out.print("Altere a Despesa do Elevador: ");
            String despesasElevadorInput = input.next().replace(",", ".");
            double despesasElevador = Double.parseDouble(despesasElevadorInput);
            if (despesasElevador <= 0) {
                System.out.println("Não digite valores negativos para Despesa do Elevador.");
                return;
            }
            condominio.setTotalDespesaElevador(despesasElevador);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Certifique-se de usar vírgula ou ponto como separador decimal.");
        }
    }

    private static void calcularQuotasMensais() {
        System.out.println("2 - Calcular a soma das Quotas Mensais");
        double quotaMensal = condominio.calcularQuotasMensais();
        System.out.println("Quota mensal: " + quotaMensal);
    }

    private static void listarFracoes() {
        System.out.println("3 - Listar as frações do condomínio");
        condominio.listarFraccao();
    }

    private static void alterarDadosCondominio() {
        System.out.println("4 - Alterar Dados do Condomínio");
        condominio.mostrarInformacao();

        double area;
        do {
            System.out.print("Digite a área Total: ");
            area = input.nextDouble();
            if (area <= 0) {
                System.out.println("Digite um valor positivo para área Total.");
            }
            condominio.setAreaTotal(area);
        } while (area <= 0);

        double despesasGerais;
        do {
            System.out.print("Digite a Despesa Geral: ");
            despesasGerais = input.nextDouble();
            condominio.setTotalDispesasGerais(despesasGerais);
        } while (despesasGerais <= 0);

        double despesasElevador;
        do {
            System.out.print("Digite a Despesa do Elevador: ");
            despesasElevador = input.nextDouble();
            condominio.setTotalDespesaElevador(despesasElevador);
        } while (despesasElevador <= 0);
    }

    private static void info() {
        condominio.mostrarInformacao();
    }

    private static void inserirFracao() {
        System.out.println("5 - Inserir Fração");
        double areaFraccao;
        do {
            System.out.print("Digite a área da Fração: ");
            areaFraccao = input.nextDouble();
            if (areaFraccao <= 0) {
                System.out.println("Digite um valor positivo para a área da Fração.");
            }
        } while (areaFraccao <= 0);

        System.out.print("Localização: ");
        String localizacao = input.next();
        input.nextLine();

        Proprietario proprietarioExistente = null;
        System.out.println("O proprietário já possui alguma fração do condomínio? 1-Sim / 0-Não");
        int temProprietario = input.nextInt();
        if (temProprietario == 1) {
            System.out.print("Digite o ID do Proprietário: ");
            int idProprietario = input.nextInt();
            proprietarioExistente = condominio.procurarProprietario(idProprietario);
        }
        if (proprietarioExistente == null) {
            proprietarioExistente = cadastrarNovoProprietario();
        }

        Menu.menuTipoFraccao();
        int opTipoFraccao = input.nextInt();
        switch (opTipoFraccao) {
            case 1:
                inserirApartamento(areaFraccao, localizacao, proprietarioExistente);
                break;
            case 2:
                inserirGaragem(areaFraccao, localizacao, proprietarioExistente);
                break;
            case 3:
                inserirArrecadacao(areaFraccao, localizacao, proprietarioExistente);
                break;
            case 4:
                inserirLoja(areaFraccao, localizacao, proprietarioExistente);
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    private static void inserirApartamento(double areaFraccao, String localizacao, Proprietario proprietario) {
        System.out.println("1 - Apartamento");
        System.out.println("Tipo de Apartamento:");
        System.out.println("T0");
        System.out.println("T1");
        System.out.println("T2");
        System.out.println("T3");
        System.out.println("T4");
        System.out.println("T5");
        System.out.print("Digite o Tipo de Apartamento: ");
        String tipoApartamento = input.next().toUpperCase();

        int numBanheiro, numVaranda;
        do {
            System.out.print("Número de Casas de Banho: ");
            numBanheiro = input.nextInt();
            if (numBanheiro < 0) {
                System.out.println("Digite um valor positivo para o número de Casas de Banho.");
            }
        } while (numBanheiro < 0);

        do {
            System.out.print("Número de Varandas: ");
            numVaranda = input.nextInt();
            if (numVaranda < 0) {
                System.out.println("Digite um valor positivo para o número de Varandas.");
            }
        } while (numVaranda < 0);

        System.out.print("Tem terraço? 1-Sim / 0-Não: ");
        boolean terraco = input.nextInt() == 1;

        Apartamento apartamento = new Apartamento(tipoApartamento, numBanheiro, numVaranda, terraco, areaFraccao, localizacao, proprietario, condominio);
        apartamento.setIdentificador(condominio.getFraccoes().size());
        if (condominio.adicionarFraccao(apartamento)) {
            System.out.println("Fração inserida com sucesso!");
            condominio.adicionarFraccao(apartamento);
            GestorArquivo.guardarFraccao(apartamento);
        } else {
            System.out.println("Fração não foi inserida. Verifique se há espaço disponível.");
        }
        
    }

    private static void inserirGaragem(double areaFraccao, String localizacao, Proprietario proprietario) {
        System.out.println("2 - Garagem");
        int numViaturas;
        do {
            System.out.print("Número de Viaturas: ");
            numViaturas = input.nextInt();
            if (numViaturas < 0) {
                System.out.println("Digite um valor positivo para o número de Viaturas.");
            }
        } while (numViaturas < 0);

        System.out.print("Possui Serviço de Lavagem? 1-Sim / 0-Não: ");
        boolean lavagem = input.nextInt() == 1;

        Garagem garagem = new Garagem(numViaturas, lavagem, areaFraccao, localizacao, proprietario, condominio);
        if (condominio.adicionarFraccao(garagem)) {
            System.out.println("Garagem inserida com sucesso!");
            condominio.adicionarFraccao(garagem);
            GestorArquivo.guardarFraccao(garagem);
        } else {
            System.out.println("Garagem não foi inserida. Verifique se há espaço disponível.");
        }
    }

    private static void inserirArrecadacao(double areaFraccao, String localizacao, Proprietario proprietario) {
        System.out.println("3 - Arrecadação");
        System.out.print("Possui porta blindada? 1-Sim / 0-Não: ");
        boolean portaBlindada = input.nextInt() == 1;

        Arrecadacao arrecadacao = new Arrecadacao(portaBlindada, areaFraccao, localizacao, proprietario, condominio);
        if (condominio.adicionarFraccao(arrecadacao)) {
            condominio.adicionarFraccao(arrecadacao);
            GestorArquivo.guardarFraccao(arrecadacao);
            System.out.println("Arrecadação inserida com sucesso!");
        } else {
            System.out.println("Arrecadação não foi inserida. Verifique se há espaço disponível.");
        }
    }

    private static void inserirLoja(double areaFraccao, String localizacao, Proprietario proprietario) {
        System.out.println("4 - Loja");
        Loja loja = new Loja(areaFraccao, localizacao, proprietario, condominio);
        if (condominio.adicionarFraccao(loja)) {
            System.out.println("Loja inserida com sucesso!");
            condominio.adicionarFraccao(loja);
            GestorArquivo.guardarFraccao(loja);
        } else {
            System.out.println("Loja não foi inserida. Verifique se há espaço disponível.");
        }
    }

    public static void removerFraccao() {
        System.out.println("Digite o ID da Fração: ");
        int idFraccao = input.nextInt();

        Optional<Fraccao> fraccaoParaRemover = condominio.getFraccoes().stream()
                .filter(frac -> frac.getIdentificador() == idFraccao)
                .findFirst();

        if (fraccaoParaRemover.isPresent()) {
            condominio.removerFraccao(fraccaoParaRemover.get());
            System.out.println("Fração removida com sucesso.");
        } else {
            System.out.println("Fração não encontrada. Verifique se o ID está correto.");
        }
    }

    public static void listarProprietarios() {
        for (Proprietario proprietario : proprietarios) {
            System.out.println("-----------------------------");
            proprietario.mostrarInformacao();
            System.out.println("-----------------------------");
        }
    }

    private static Proprietario cadastrarNovoProprietario() {
        System.out.println("Cadastre um novo proprietário...");
        System.out.print("Nome: ");
        String nome = input.next();
        System.out.print("Morada: ");
        String morada = input.next();

        String telefone;
        do {
            System.out.print("Telefone: ");
            telefone = input.next();
            if (!Login.validarTelefone(telefone)) {
                System.out.println("Digite um número de telefone com 9 dígitos e inicie com 9.");
            }
        } while (!Login.validarTelefone(telefone));

        System.out.print("Email: ");
        String emailProprietario = input.next();

        System.out.print("Data de nascimento do Proprietário (dd-MM-yyyy): ");
        String dataNascimento = input.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dataN = LocalDate.parse(dataNascimento, formatter);

        Proprietario proprietario = new Proprietario(nome, morada, telefone, emailProprietario, dataN);
        proprietario.setIdentificador(proprietarios.size());
        proprietarios.add(proprietario);
        GestorArquivo.guardarProprietario(proprietario);

        return proprietario;
    }
}