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
    private double calcularPercentagem(double area) {
        return ((100 * area) / areaTotal);
    }

    public boolean adicionarFraccao(Fraccao fraccao) {
        if (fraccao.getPercentagemArea() > calcularPercentagem(areaDisponivel)) {
            return false;
        }
        return true;
    }

    //Constructor
    public Condominio(int identifcador, double areaTotal, String morada, double totalDispesasGerais,double totalDespesaElevador ,LocalDate dataConstrucao) {
        this.identifcador = identifcador;
        this.morada = morada;
        this.areaDisponivel = areaTotal;
        this.totalDispesasGerais = totalDispesasGerais;
        this.dataConstrucao = dataConstrucao;
        this.fraccoes = new ArrayList();
        this.areaTotal = areaTotal;
        this.totalDespesaElevador = totalDespesaElevador;
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
    

}
