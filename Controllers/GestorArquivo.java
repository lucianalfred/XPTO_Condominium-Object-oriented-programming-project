
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
    private static final String ARQUIVO_DADOS_D0_CONDOMINIO = "./Arquivos/xpto.txt";
    
    public static void guardarDadosDoCondomio(Condominio condominio){
        try(BufferedWriter escritor  = new BufferedWriter(new FileWriter(ARQUIVO_DADOS_D0_CONDOMINIO))){
            escritor.write(condominio.toString());
        }catch(IOException e){
            System.err.print("Erro ao guardar dados do condominio: "+e.getMessage());
        }
    }
    public static void carregarDadosDoCondominio(Condominio condominio){
        //Carregar dados basicos 
        try(BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO_DADOS_D0_CONDOMINIO))){
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
            
            
            
        }catch(IOException e){
            System.err.print("Erro ao ler arquivo de dados do condominio: "+e.getMessage());
        }
    }
    
    public static void  guardarUsuario(Usuario usuario){
        try(BufferedWriter escritor = new BufferedWriter(new FileWriter(ARQUIVO_USUARIOS, true))){
                escritor.write(usuario.toString());
        } catch (IOException ex) {
            Logger.getLogger(GestorArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static ArrayList<Usuario> listaDeUsuarios(){
        ArrayList<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
        
        try(BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO_USUARIOS))){
            String linha;
            while((linha = leitor.readLine()) != null){
                String[] results = linha.split(",");
                Usuario usuario = new Usuario(results[0], results[1],results[2]);
                listaDeUsuarios.add(usuario);
            }
        }catch(IOException e){
            System.err.print("Erro ao ler o arquivo de usuarios: "+e.getMessage());
        }
        
        return listaDeUsuarios;
    }
    
    public static void guardarApartamento(Apartamento apartamento){
        try(BufferedWriter escritor = new BufferedWriter(new FileWriter(ARQUIVO_APARTAMENTOS, true))){
            escritor.write(apartamento.toString());
        }catch(IOException e){
            System.err.print("Erro ao ler o arquivo de apartamentos: "+e.getMessage());
        }
    }
    
    
    public void loadFracoes(Condominio condominio)
    {
        
    }
    
}
