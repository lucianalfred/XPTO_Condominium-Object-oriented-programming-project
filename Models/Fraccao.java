
package Models;


public  abstract class Fraccao {
   
    private String identificador;
    private double area;
    private double percentagemArea;
    private String localizacao;
    private Proprietario proprietario;
  
    //constructor
    public Fraccao(String identificador, double area, String localizacao, Proprietario proprietario) {
        this.identificador = identificador;
        this.area = area;
        this.localizacao = localizacao;
        this.proprietario = proprietario;
    }
    
    //get and setters
    public String getIdentificador() {
        return identificador;
    }
    
    public void setIdentificador(String identificador) {
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
    
    
    //Outros metodos
    public double calcularQuotaMensal(double despesasGerais, double despesasElevadores){
        return 0.00;
    }

    public double getPercentagemArea() {
        return percentagemArea;
    }

    public void setPercentagemArea(double percentagemArea) {
        this.percentagemArea = percentagemArea;
    }
    
}
