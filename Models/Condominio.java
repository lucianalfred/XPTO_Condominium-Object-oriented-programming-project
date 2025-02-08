package Models;

import java.util.*;
import java.time.LocalDate;
import Controllers.*;

public class Condominio {

    private static int identifcador = 0;
    private String morada;
    private double totalDispesasGerais;
    private double totalDespesaElevador;
    private LocalDate dataConstrucao;
    private ArrayList<Fraccao> fraccoes;
    private double areaTotal;
    private double areaOcupada;
    private double areaDisponivel;

    //Metodos gerais
    //Constructor
    public Condominio(double areaTotal, String morada, double totalDispesasGerais, double totalDespesaElevador, LocalDate dataConstrucao) {
        this.identifcador = this.identifcador + 1;
        this.morada = morada;
        this.areaDisponivel = areaTotal;
        this.totalDispesasGerais = totalDispesasGerais;
        this.dataConstrucao = dataConstrucao;
        this.fraccoes = new ArrayList<Fraccao>();
        this.areaTotal = areaTotal;
        this.totalDespesaElevador = totalDespesaElevador;
        this.areaOcupada = 0;
    }

    public Condominio() {

    }

    //get and set
    public int getIdentifcador() {
        return identifcador;
    }

    public void setAreaOcupada(double areaOcupada) {
        this.areaOcupada = areaOcupada;
    }

    public void setAreaDisponivel(double areaDisponivel) {
        this.areaDisponivel = areaDisponivel;
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
    //

    public void listarFraccao() {
        // this.fraccoes = new Arra
        if (fraccoes.size() == 0) {
            System.out.println(" Não Há Fraccoes No Condominio");
        } else {
            for (Fraccao aux : fraccoes) {
                aux.mostarInformacoes();
            }
        }
    }
    public boolean removerFraccao(Fraccao frac){
        return fraccoes.remove(frac);
    }
    public void verificarSomasDasPercentagens(){
        double soma = 0;
        if (fraccoes.size() != 0) {
            for (Fraccao aux : fraccoes) {
                soma += aux.percentagemArea;
            }
            System.out.println("Percentagem das Frações: "+soma+"%");
        }else{
            System.out.println("Não há frações!");
        }
        
    }
    public double calcularQuotasMensais() {
        double somaQuota = 0;
        if (fraccoes.size() != 0) {
            for (Fraccao aux : fraccoes) {
                somaQuota += aux.calcularQuotaMensal(totalDispesasGerais, totalDespesaElevador, areaTotal);
            }
        }
        return somaQuota;
    }

    @Override
    public String toString() {
        return identifcador + "," + morada + "," + totalDispesasGerais + "," + totalDespesaElevador + "," + dataConstrucao + "" + "," + areaTotal + "," + areaOcupada + "," + areaDisponivel;
    }

    public boolean adicionarFraccao(Fraccao fraccao) {
        if (fraccao.area <= this.areaDisponivel) {
            fraccoes.add(fraccao);
            this.areaDisponivel -= fraccao.area;
            this.areaOcupada += fraccao.area;
            return true;
        }
        return false;
    }

    public Proprietario procurarProprietario(int id) {
        for (Fraccao aux : fraccoes) {
            if (aux.proprietario.getIdentificador() == id) {
                return aux.getProprietario();
            }
        }
        return null;
    }

    public void mostrarInformacao() {
        System.out.println("_________________________________________________");
        System.out.println("Condominio: XPTO");
        System.out.println("Morada: " + morada);
        System.out.println("Total Despesas Gerais: " + totalDispesasGerais);
        System.out.println("Total Despesas Elevador: " + totalDespesaElevador);
        System.out.println("Data De Construcao: " + dataConstrucao.toString());
        System.out.println("Area Total: " + areaTotal);
        System.out.println("Area Ocupada: " + areaOcupada);
        System.out.println("Area Disponivel: " + areaDisponivel);
        System.out.println("Percentagem Disponivel: " + ((areaDisponivel * 100)/areaTotal)+"%");
        System.out.println("_________________________________________________");

    }
}
