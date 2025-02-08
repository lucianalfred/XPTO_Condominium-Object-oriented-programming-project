package Controllers;

import Models.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.*;
import java.util.logging.Logger;

public class GestorArquivo {

    private static final String ARQUIVO_USUARIOS = "./Arquivos/usuarios.txt";
    private static final String ARQUIVO_APARTAMENTOS = "./Arquivos/apartamentos.txt";
    private static final String ARQUIVO_ARRECADACAO = "./Arquivos/arrecadacao.txt";
    private static final String ARQUIVO_GARAGEM = "./Arquivos/garagem.txt";
    private static final String ARQUIVO_LOJA = "./Arquivos/loja.txt";
    private static final String ARQUIVO_PROPRIETARIO = "./Arquivos/proprietario.txt";
    private static final String ARQUIVO_DADOS_D0_CONDOMINIO = "./Arquivos/xpto.txt";

    public static void guardarDadosDoCondomio(Condominio condominio) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARQUIVO_DADOS_D0_CONDOMINIO))) {
            escritor.write(condominio.toString());
            //guardarFracoes(condominio);
        } catch (IOException e) {
            System.err.print("Erro ao guardar dados do condominio: " + e.getMessage());
        }
    }

    public static void carregarDadosDoCondominio(Condominio condominio) {
        //Carregar dados basicos 
        try (BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO_DADOS_D0_CONDOMINIO))) {
            //le apenas a primera linha do arquivo do condominio
            String linha = leitor.readLine();
            String[] dados = linha.split(",");
            //manipulacao dos dados do arquivo
            int identificador = Integer.parseInt(dados[0]);
            String morada = dados[1];
            double totalDespesasGerais = Double.parseDouble(dados[2]);
            double totalDespesasElevador = Double.parseDouble(dados[3]);
            String data = dados[4];
            LocalDate dataConstrucao = LocalDate.parse(data);
            double areaTotal = Double.parseDouble(dados[5]);
            double areaOcupada = Double.parseDouble(dados[6]);
            double areaDisponivel = Double.parseDouble(dados[7]);

            condominio.setIdentifcador(identificador);
            condominio.setMorada(morada);
            condominio.setTotalDespesaElevador(totalDespesasElevador);
            condominio.setTotalDispesasGerais(totalDespesasGerais);
            condominio.setDataConstrucao(dataConstrucao);
            condominio.setAreaTotal(areaTotal);
            condominio.setAreaOcupada(areaTotal);
            condominio.setAreaDisponivel(areaTotal);

            //carregar fraccoes
            //loadFracoes(condominio);
            
        } catch (IOException e) {
            System.err.print("Erro ao ler arquivo de dados do condominio: " + e.getMessage());
        }
    }

    public static void guardarUsuario(Usuario usuario) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARQUIVO_USUARIOS, true))) {
            escritor.write(usuario.toString());
        } catch (IOException ex) {
            Logger.getLogger(GestorArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Usuario> listaDeUsuarios() {
        ArrayList<Usuario> listaDeUsuarios = new ArrayList<Usuario>();

        try (BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO_USUARIOS))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] results = linha.split(",");
                Usuario usuario = new Usuario(results[0], results[1], results[2]);
                listaDeUsuarios.add(usuario);
            }
        } catch (IOException e) {
            System.err.print("Erro ao ler o arquivo de usuarios: " + e.getMessage());
        }

        return listaDeUsuarios;
    }

    public static void guardarApartamento(Apartamento apartamento) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARQUIVO_APARTAMENTOS, true))) {
            escritor.write(apartamento.toString());
        } catch (IOException e) {
            System.err.print("Erro ao ler o arquivo de apartamentos: " + e.getMessage());
        }
    }

    public static void guardarArrecadacao(Arrecadacao arrecadacao) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARQUIVO_ARRECADACAO, true))) {
            escritor.write(arrecadacao.toString());
        } catch (IOException e) {
            System.err.print("Erro ao ler o arquivo de apartamentos: " + e.getMessage());
        }
    }

    public static void guardarGaragem(Garagem garagem) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARQUIVO_GARAGEM, true))) {
            escritor.write(garagem.toString());
        } catch (IOException e) {
            System.err.print("Erro ao ler o arquivo de garagem: " + e.getMessage());
        }
    }
    
    public static void guardarLoja(Loja loja) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARQUIVO_LOJA, true))) {
            escritor.write(loja.toString());
        } catch (IOException e) {
            System.err.print("Erro ao ler o arquivo de apartamentos: " + e.getMessage());
        }
    }

    public static void guardarProprietario(Proprietario prop) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARQUIVO_PROPRIETARIO, true))) {
            escritor.write(prop.toString());
        } catch (IOException e) {
            System.err.print("Erro ao ler o arquivo de apartamentos: " + e.getMessage());
        }
    }

    public void loadProprietarios(Condominio condominio) {
        try (BufferedReader leitorProprietarios = new BufferedReader(new FileReader(ARQUIVO_PROPRIETARIO))) {
            String linha;
            while ((linha = leitorProprietarios.readLine()) != null) {
                String[] dados = linha.split(",");
                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                String email = dados[2];

                Proprietario proprietario = new Proprietario(id, nome, email);
                //condominio.adicionarProprietario(proprietario);  
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar proprietários: " + e.getMessage());
        }
    }

    private static void guardarFracoes(Condominio condominio){
        
        try{
            //lista  de fracoes 
            
            ArrayList<Fraccao> fracoes = condominio.getFraccoes();
            
            for (Fraccao fraccao : fracoes) {
                
                if(fraccao instanceof Apartamento){
                    //Guardar Apartamento
                    Apartamento apartamento = (Apartamento)fraccao;
                    guardarApartamento(apartamento);
                }else if(fraccao instanceof Garagem){
                    //Guardar Garagem
                    Garagem garagem = (Garagem)fraccao;
                    guardarGaragem(garagem);
                }else if(fraccao instanceof Arrecadacao){
                    //Guardar Arrecadacao
                    Arrecadacao arrecadacao = (Arrecadacao)fraccao;
                    guardarArrecadacao(arrecadacao);
                }else if(fraccao instanceof Loja){
                    //Guardar Loja
                    Loja loja = (Loja)fraccao;
                    guardarLoja(loja);
                }
            }
            
        }catch(Exception e){
            System.err.print("Excepcao: "+e);
        }
    }
    
    public  static void loadFracoes(Condominio condominio) {
        try {
            // Carregar Apartamentos
            try (BufferedReader leitorApartamentos = new BufferedReader(new FileReader(ARQUIVO_APARTAMENTOS))) {
                String linha;
                while ((linha = leitorApartamentos.readLine()) != null) {
                    String[] dados = linha.split(",");
                    double area = Double.parseDouble(dados[1]);
                    String localizacao = dados[3];
                    int idProprietario = Integer.parseInt(dados[4]);
                    Proprietario proprietario = condominio.procurarProprietario(idProprietario);
                    if (proprietario != null) {
                        String tipoApartamento = dados[5];
                        int numCasasBanho = Integer.parseInt(dados[6]);
                        int numVarandas = Integer.parseInt(dados[7]);
                        boolean possuiTerraco = Boolean.parseBoolean(dados[8]);
                        Apartamento apartamento = new Apartamento(tipoApartamento, numCasasBanho, numVarandas, possuiTerraco, area, localizacao, proprietario,condominio);
                        condominio.adicionarFraccao(apartamento);
                    }
                }
            }

            // Carregar Arrecadacoes
            try (BufferedReader leitorArrecadacao = new BufferedReader(new FileReader(ARQUIVO_ARRECADACAO))) {
                String linha;
                while ((linha = leitorArrecadacao.readLine()) != null) {
                    String[] dados = linha.split(",");
                    double area = Double.parseDouble(dados[1]);
                    String localizacao = dados[3];
                    int idProprietario = Integer.parseInt(dados[4]);
                    Proprietario proprietario = condominio.procurarProprietario(idProprietario);
                    if (proprietario != null) {
                        boolean possuiPortaBlindada = Boolean.parseBoolean(dados[5]);
                      //  Arrecadacao arrecadacao = new Arrecadacao(possuiPortaBlindada, 0, area, localizacao, proprietario);
                       // condominio.adicionarFraccao(arrecadacao);
                    }
                }
            }
            
            //Carregar loja
            try (BufferedReader leitorLoja = new BufferedReader(new FileReader(ARQUIVO_LOJA))) {
                String linha;
                while ((linha = leitorLoja.readLine()) != null) {
                    String[] dados = linha.split(",");
                    double area = Double.parseDouble(dados[1]);
                    String localizacao = dados[3];
                    int idProprietario = Integer.parseInt(dados[4]);
                    Proprietario proprietario = condominio.procurarProprietario(idProprietario);
                    if (proprietario != null) {
                        Loja loja = new Loja(area, localizacao, proprietario,condominio);
                        condominio.adicionarFraccao(loja);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar frações: " + e.getMessage());
        }
    }

}
