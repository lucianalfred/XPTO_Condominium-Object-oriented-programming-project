
package Models;

import java.util.*;
import java.time.LocalDate;

public class Condominio {
    
    private String identifcador;
    private String morada;
    private double totalDispesasGerais;
    private LocalDate dataConstrucaoa;
    private ArrayList<Fraccao> fraccoes;
    private double areaTotal;
    private double areaOcupada;
    private double areaDisponivel;
    
    //Metodos gerais
    private double calcularPercentagem(double area){
        return ((100 * area)/areaTotal);
    }
    
    public boolean adicionarFraccao(Fraccao fraccao){
        if(fraccao.getPercentagemArea() > calcularPercentagem(areaDisponivel)){
            return false;
        }
        
        return true;
    }
    //Constructor

    public Condominio(String identifcador,double areaTotal, String morada, double totalDispesasGerais, LocalDate dataConstrucaoa, ArrayList<Fraccao> fraccoes) {
        this.identifcador = identifcador;
        this.morada = morada;
        this.totalDispesasGerais = totalDispesasGerais;
        this.dataConstrucaoa = dataConstrucaoa;
        this.fraccoes = fraccoes;
        this.areaTotal = areaTotal;
    }
    
    
    
    //get and setters

    
    public String getIdentifcador() {
        return identifcador;
    }

    public void setIdentifcador(String identifcador) {
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

    public LocalDate getDataConstrucaoa() {
        return dataConstrucaoa;
    }

    public void setDataConstrucaoa(LocalDate dataConstrucaoa) {
        this.dataConstrucaoa = dataConstrucaoa;
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
    
}
