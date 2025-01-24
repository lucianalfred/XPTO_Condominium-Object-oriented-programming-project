package Models;

public abstract class Fraccao {

    protected static int identificador = 0;
    protected double area;
    protected double percentagemArea;
    protected String localizacao;
    protected Proprietario proprietario;
    
    //constructor
    public Fraccao(double area, String localizacao, Proprietario proprietario) {
        this.identificador = identificador++;
        this.area = area;
        this.localizacao = localizacao;
        this.proprietario = proprietario;
       
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
        return  percentagem;
        
    }
    public double calcularQuotaMensal(double despesasGerais, double despesasElevadores,double areaTotalCondominio) {
        double quotaMensal = calcularPercentagemArea(areaTotalCondominio)*(despesasGerais + despesasElevadores);
        return quotaMensal;
    }

    public double getPercentagemArea() {
        return percentagemArea;
    }

    public void setPercentagemArea(double percentagemArea) {
        this.percentagemArea = percentagemArea;
    }

}
