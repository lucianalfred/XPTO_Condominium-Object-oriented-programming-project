package Arquivo;

import Models.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe responsável por gerenciar a leitura e escrita de dados em arquivos.
 * Esta classe lida com operações de persistência de dados relacionados a
 * usuários, proprietários, frações e informações do condomínio.
 */
public class GestorArquivo {

    // Constantes que definem os caminhos dos arquivos de armazenamento
    private static final String ARQUIVO_USUARIOS = "./Arquivos/usuarios.txt";
    private static final String ARQUIVO_FRACCOES = "./Arquivos/fracoes.txt";
    private static final String ARQUIVO_PROPRIETARIO = "./Arquivos/proprietario.txt";
    private static final String ARQUIVO_DADOS_CONDOMINIO = "./Arquivos/xpto.txt";

    // Cache para proprietários, evitando múltiplas leituras do arquivo
    private static ArrayList<Proprietario> cacheProprietarios = null;

    // Logger para registrar eventos e erros
    private static final Logger LOGGER = Logger.getLogger(GestorArquivo.class.getName());

    /**
     * Carrega todos os dados do condomínio, incluindo proprietários e frações.
     *
     * @param condominio Objeto Condominio que receberá os dados.
     */
    public static void carregarTodosDados(Condominio condominio) {
        carregarDadosDoCondominio(condominio);
        carregarFraccoes(condominio);
        carregarProprietarios(); // Carrega proprietários e os adiciona ao cache
    }

    /**
     * Salva todos os dados do condomínio, incluindo proprietários e frações.
     *
     * @param condominio Objeto Condominio que será salvo.
     */
    public static void guardarTodosOsDados(Condominio condominio) {
        guardarDadosDoCondominio(condominio);
        guardarFracoes(condominio);
        guardarProprietarios(cacheProprietarios); // Salva proprietários do cache
    }

    /**
     * Limpa o conteúdo de um arquivo.
     *
     * @param caminhoArquivo Caminho do arquivo a ser limpo.
     */
    private static void limparArquivo(String caminhoArquivo) {
        try (FileWriter writer = new FileWriter(caminhoArquivo, false)) {
            writer.write("");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erro ao limpar o arquivo: " + caminhoArquivo, e);
        }
    }

    /**
     * Escreve conteúdo em um arquivo.
     *
     * @param caminho Caminho do arquivo.
     * @param conteudo Conteúdo a ser escrito.
     * @param append Se true, o conteúdo será adicionado ao final do arquivo.
     */
    private static void escreverNoArquivo(String caminho, String conteudo, boolean append) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminho, append))) {
            escritor.write(conteudo);
            escritor.newLine();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erro ao escrever no arquivo: " + caminho, e);
        }
    }

    /**
     * Lê todas as linhas de um arquivo.
     *
     * @param caminho Caminho do arquivo.
     * @return Lista de strings, onde cada string é uma linha do arquivo.
     */
    private static ArrayList<String> lerArquivo(String caminho) {
        ArrayList<String> linhas = new ArrayList<>();
        File arquivo = new File(caminho);

        if (!arquivo.exists()) {
            LOGGER.warning("Arquivo não encontrado: " + caminho);
            return linhas;
        }

        try (BufferedReader leitor = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erro ao ler o arquivo: " + caminho, e);
        }

        return linhas;
    }

    /**
     * Salva os dados do condomínio em um arquivo.
     *
     * @param condominio Objeto Condominio a ser salvo.
     */
    public static void guardarDadosDoCondominio(Condominio condominio) {
        escreverNoArquivo(ARQUIVO_DADOS_CONDOMINIO, condominio.toString(), false);
    }

    /**
     * Carrega os dados do condomínio a partir de um arquivo.
     *
     * @param condominio Objeto Condominio que receberá os dados.
     */
    public static void carregarDadosDoCondominio(Condominio condominio) {
        ArrayList<String> linhas = lerArquivo(ARQUIVO_DADOS_CONDOMINIO);
        if (!linhas.isEmpty()) {
            try {
                String[] dados = linhas.get(0).split(",");
                if (dados.length < 8) {
                    return;
                }

                // Extrai e define os dados do condomínio
                int identificador = Integer.parseInt(dados[0]);
                String morada = dados[1];
                double totalDespesasGerais = Double.parseDouble(dados[2]);
                double totalDespesasElevador = Double.parseDouble(dados[3]);
                LocalDate dataConstrucao = LocalDate.parse(dados[4]);
                double areaTotal = Double.parseDouble(dados[5]);
                double areaOcupada = Double.parseDouble(dados[6]);
                double areaDisponivel = Double.parseDouble(dados[7]);

                condominio.setIdentifcador(identificador);
                condominio.setMorada(morada);
                condominio.setTotalDespesaElevador(totalDespesasElevador);
                condominio.setTotalDispesasGerais(totalDespesasGerais);
                condominio.setDataConstrucao(dataConstrucao);
                condominio.setAreaTotal(areaTotal);
                condominio.setAreaOcupada(areaOcupada);
                condominio.setAreaDisponivel(areaDisponivel);

            } catch (NumberFormatException e) {
                LOGGER.log(Level.SEVERE, "Erro ao converter valores do arquivo de dados do condomínio", e);
            }
        }
    }

    /**
     * Salva um usuário no arquivo de usuários.
     *
     * @param usuario Objeto Usuario a ser salvo.
     */
    public static void guardarUsuario(Usuario usuario) {
        escreverNoArquivo(ARQUIVO_USUARIOS, usuario.toString(), true);
    }

    /**
     * Carrega a lista de usuários a partir do arquivo.
     *
     * @return Lista de objetos Usuario.
     */
    public static ArrayList<Usuario> listaDeUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<String> linhas = lerArquivo(ARQUIVO_USUARIOS);

        for (String linha : linhas) {
            String[] dados = linha.split(",");
            if (dados.length == 3) {
                usuarios.add(new Usuario(dados[0], dados[1], dados[2]));
            }
        }

        return usuarios;
    }

    /**
     * Salva um proprietário no arquivo de proprietários.
     *
     * @param prop Objeto Proprietario a ser salvo.
     */
    public static void guardarProprietario(Proprietario prop) {
        escreverNoArquivo(ARQUIVO_PROPRIETARIO, prop.toString(), true);
    }

    /**
     * Salva todos os proprietários no arquivo de proprietários.
     *
     * @param proprietarios Lista de proprietários a serem salvos.
     */
    public static void guardarProprietarios(ArrayList<Proprietario> proprietarios) {
        limparArquivo(ARQUIVO_PROPRIETARIO);
        for (Proprietario proprietario : proprietarios) {
            guardarProprietario(proprietario);
        }
    }

    /**
     * Carrega a lista de proprietários a partir do arquivo.
     *
     * @return Lista de objetos Proprietario.
     */
    public static ArrayList<Proprietario> carregarProprietarios() {
        if (cacheProprietarios != null) {
            return cacheProprietarios;
        }

        ArrayList<Proprietario> proprietarios = new ArrayList<>();
        File arquivo = new File(ARQUIVO_PROPRIETARIO);
        if (!arquivo.exists()) {
            LOGGER.warning("Arquivo não encontrado: " + ARQUIVO_PROPRIETARIO);
            return proprietarios;
        }

        try (BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO_PROPRIETARIO))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(",");

                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                String email = dados[2];
                String endereco = dados[3];
                String telefone = dados[4];

                Proprietario prop = new Proprietario(id, nome, email);
                proprietarios.add(prop);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erro ao ler o arquivo: " + ARQUIVO_PROPRIETARIO, e);
        }

        cacheProprietarios = proprietarios;
        return proprietarios;
    }

    /**
     * Procura um proprietário pelo ID.
     *
     * @param idProprietario ID do proprietário a ser procurado.
     * @return Objeto Proprietario encontrado ou null se não existir.
     */
    public static Proprietario procurarProprietario(int idProprietario) {
        ArrayList<Proprietario> proprietarios = carregarProprietarios();

        for (Proprietario prop : proprietarios) {
            if (prop.getIdentificador() == idProprietario) {
                return prop;
            }
        }

        return null;
    }

    /**
     * Salva uma fração no arquivo de frações.
     *
     * @param fraccao Objeto Fraccao a ser salvo.
     */
    public static void guardarFraccao(Fraccao fraccao) {
        escreverNoArquivo(ARQUIVO_FRACCOES, fraccao.toString(), true);
    }

    /**
     * Salva todas as frações de um condomínio no arquivo de frações.
     *
     * @param condominio Objeto Condominio contendo as frações a serem salvas.
     */
    public static void guardarFracoes(Condominio condominio) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARQUIVO_FRACCOES, false))) {
            for (Fraccao fraccao : condominio.getFraccoes()) {
                escritor.write(fraccao.toString());
                escritor.newLine();
            }
            System.out.println("Frações salvas com sucesso!");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar frações: " + e.getMessage(), e);
        }
    }

    /**
     * Carrega as frações a partir do arquivo e as adiciona ao condomínio.
     *
     * @param condominio Objeto Condominio que receberá as frações.
     */
    public static void carregarFraccoes(Condominio condominio) {
        ArrayList<String> linhas = lerArquivo(ARQUIVO_FRACCOES);
        ArrayList<Fraccao> fraccoes = new ArrayList<>();

        for (String linha : linhas) {
            String[] dados = linha.split(",");
            int identificador = Integer.parseInt(dados[0]);
            double area = Double.parseDouble(dados[1]);
            double percentagemArea = Double.parseDouble(dados[2]);
            String localizacao = dados[3];
            int idProprietario = Integer.parseInt(dados[4]);
            String tipoFraccao = dados[5];

            Proprietario proprietario = procurarProprietario(idProprietario);
            if (proprietario == null) {
                proprietario = new Proprietario("Não Definido", "indefinido@gmail.com");
            }

            Fraccao novaFraccao = null;
            switch (tipoFraccao.toLowerCase()) {
                case "apartamento":
                    if (dados.length == 10) {
                        String tipoApartamento = dados[6];
                        int numCasasBanho = Integer.parseInt(dados[7]);
                        int numVarandas = Integer.parseInt(dados[8]);
                        boolean possuiTerraco = Boolean.parseBoolean(dados[9]);

                        novaFraccao = new Apartamento(tipoApartamento, numCasasBanho, numVarandas, possuiTerraco, area, localizacao, proprietario, condominio);
                    }
                    break;
                case "arrecadacao":
                    if (dados.length == 7) {
                        boolean possuiPortaBlindada = Boolean.parseBoolean(dados[6]);
                        novaFraccao = new Arrecadacao(possuiPortaBlindada, area, localizacao, proprietario, condominio);
                    }
                    break;
                case "loja":
                    if (dados.length == 6) {
                        novaFraccao = new Loja(area, localizacao, proprietario, condominio);
                    }
                    break;
                case "garagem":
                    if (dados.length == 6) {
                        int capacidade = Integer.parseInt(dados[6]);
                        boolean lavagem = Boolean.parseBoolean(dados[7]);
                        novaFraccao = new Garagem(capacidade, lavagem, area, localizacao, proprietario, condominio);
                    }
                    break;
                default:
                    LOGGER.warning("Tipo de fração desconhecido: " + tipoFraccao);
            }

            if (novaFraccao != null) {
                novaFraccao.setPercentagemArea(percentagemArea);
                fraccoes.add(novaFraccao);
            }
        }

        condominio.setFraccoes(fraccoes);
    }
}