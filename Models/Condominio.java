
package Models;

import java.util.*;
import java.time.LocalDate;

public class Condominio {
    
    private String identifcador;
    private String morada;
    private double totalDispesasGerais;
    private LocalDate dataConstrucaoa;
    private ArrayList<Fraccao> fraccoes;
    
    //Constructor

    public Condominio(String identifcador, String morada, double totalDispesasGerais, LocalDate dataConstrucaoa, ArrayList<Fraccao> fraccoes) {
        this.identifcador = identifcador;
        this.morada = morada;
        this.totalDispesasGerais = totalDispesasGerais;
        this.dataConstrucaoa = dataConstrucaoa;
        this.fraccoes = fraccoes;
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
    
}
