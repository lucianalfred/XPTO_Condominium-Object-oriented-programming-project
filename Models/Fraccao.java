package Models;

import java.text.DecimalFormat;
import java.util.*;
public abstract class Fraccao {

    protected static int contador = 0;
    protected int identificador;
    protected double area;
    protected double percentagemArea;
    protected String localizacao;
    protected Proprietario proprietario;
    protected Condominio cond;
    //constructor
    public Fraccao(double area, String localizacao, Proprietario proprietario,Condominio cond) {
        this.identificador =  ++contador;
        this.area = area;
        this.localizacao = localizacao;
        this.proprietario = proprietario;
        this.cond = cond;
        double valor = (area*100)/cond.getAreaTotal();
        this.percentagemArea = arredondarParaTresCasasDecimais(valor);
    }

    public static double arredondarParaTresCasasDecimais(double numero) {
        return Math.round(numero * 1000.0) / 1000.0;
    }
    //get and setters
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }
    
    
    @Override 
    public String toString(){
        return identificador+","+area+","+percentagemArea+","+localizacao+","+proprietario.getIdentificador();
    }
  
    //metodo que calcula a percentagem da area da fraccao em relacao a areaa total do condominio 
    public double calcularPercentagemArea(double areaTotalCondominio){
        double percentagem = (this.area *100)/areaTotalCondominio;
        //DecimalFormat df = new DecimalFormat("#.###");
          this.percentagemArea = (this.area *100)/areaTotalCondominio;;
        return  percentagem;
        
    }
    
    public void mostrarPercentagem(Condominio cond){
         DecimalFormat df = new DecimalFormat("#.###");
         System.out.println("Percentagem: "+df.format(calcularPercentagemArea(cond.getAreaTotal())));
    }
    public double calcularQuotaMensal(double despesasGerais, double despesasElevadores,double areaTotalCondominio) {
        return  calcularPercentagemArea(areaTotalCondominio)*(despesasGerais + despesasElevadores);
    }

    public double getPercentagemArea() {
        return percentagemArea;
    }

    public void setPercentagemArea(double percentagemArea) {
        this.percentagemArea = percentagemArea;
    }

    public void mostarInformacoes(){
        System.out.println("Id :"+this.getIdentificador());
        System.out.println("Area:"+this.getArea());
        System.out.println("Percentagem da Area :"+this.percentagemArea+"%");
        System.out.println("Localização :"+this.getLocalizacao());
        System.out.println("Id Proprietario :"+this.getProprietario().getIdentificador());
        System.out.println("Nome Proprietario :"+this.getProprietario().getNome());
        System.out.println("Email Proprietario :"+this.getProprietario().getEmail());
        
    }
}
