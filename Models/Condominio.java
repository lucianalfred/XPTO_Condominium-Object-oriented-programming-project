package Models;

import java.util.*;
import java.time.LocalDate;

public class Condominio {

    private int identifcador;
    private String morada;
    private double totalDispesasGerais;
    private double totalDespesaElevador;
    private LocalDate dataConstrucao;
    private ArrayList<Fraccao> fraccoes;
    private double areaTotal;
    private double areaOcupada;
    private double areaDisponivel;

    //Metodos gerais

    public void listarFraccao(){
        for (Fraccao aux : fraccoes ){
            System.out.println(aux.toString());
        }
    }
    public double calcularQuotasMensais() {
        double somaQuota= 0 ;
        for (Fraccao aux : fraccoes) {
            somaQuota +=aux.calcularQuotaMensal(totalDispesasGerais, totalDespesaElevador, areaTotal);
        }
        return somaQuota;
    }

    @Override
    public String toString() {
        return "Condominio{" + "identifcador=" + identifcador + ", morada=" + morada + ", totalDispesasGerais=" + totalDispesasGerais + ", totalDespesaElevador=" + totalDespesaElevador + ", dataConstrucao=" + dataConstrucao + ", fraccoes=" + fraccoes + ", areaTotal=" + areaTotal + ", areaOcupada=" + areaOcupada + ", areaDisponivel=" + areaDisponivel + '}';
    }
    public boolean adicionarFraccao(Fraccao fraccao){
        if ( fraccao.area <= this.areaDisponivel){
            fraccoes.add(fraccao);
            this.areaDisponivel -=fraccao.area;
             this.areaOcupada +=fraccao.area;          
            return true;
        }
        return  false ;
    }
    public Proprietario procurarProprietario(int id){
         for (Fraccao aux : fraccoes){
             if (aux.proprietario.getIdentificador() == id){
                 return aux.getProprietario();
             }
         }
        return null;     
    }

    //Constructor
    public Condominio(int identifcador, double areaTotal, String morada, double totalDispesasGerais, double totalDespesaElevador, LocalDate dataConstrucao) {
        this.identifcador = identifcador;
        this.morada = morada;
        this.areaDisponivel = areaTotal;
        this.totalDispesasGerais = totalDispesasGerais;
        this.dataConstrucao = dataConstrucao;
        this.fraccoes = new ArrayList();
        this.areaTotal = areaTotal;
        this.totalDespesaElevador = totalDespesaElevador;
        this.areaOcupada = 0;
    }

    //get and set
    public int getIdentifcador() {
        return identifcador;
    }

    public void setIdentifcador(int identifcador) {
        this.identifcador = identifcador;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public double getTotalDispesasGerais() {
        return totalDispesasGerais;
    }

    public void setTotalDispesasGerais(double totalDispesasGerais) {
        this.totalDispesasGerais = totalDispesasGerais;
    }

    public LocalDate getDataConstrucao() {
        return dataConstrucao;
    }

    public void setDataConstrucao(LocalDate dataConstrucao) {
        this.dataConstrucao = dataConstrucao;
    }

    public ArrayList<Fraccao> getFraccoes() {
        return fraccoes;
    }

    public void setFraccoes(ArrayList<Fraccao> fraccoes) {
        this.fraccoes = fraccoes;
    }

    public double getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(double areaTotal) {
        this.areaTotal = areaTotal;
    }

    public double getAreaOcupada() {
        return areaOcupada;
    }

    public double getAreaDisponivel() {
        return areaDisponivel;
    }

    public double getTotalDespesaElevador() {
        return totalDespesaElevador;
    }

    public void setTotalDespesaElevador(double totalDespesaElevador) {
        this.totalDespesaElevador = totalDespesaElevador;
    }

}
