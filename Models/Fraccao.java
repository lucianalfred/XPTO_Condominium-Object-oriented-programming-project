package Models;

public abstract class Fraccao {

    protected int identificador;
    protected double area;
    protected double percentagemArea;
    protected String localizacao;
    protected Proprietario proprietario;
    protected Condominio condominio;

    //constructor
    public Fraccao(int identificador, double area, String localizacao, Proprietario proprietario) {
        this.identificador = identificador;
        this.area = area;
        this.localizacao = localizacao;
        this.proprietario = proprietario;
    }
    // analisar 
    public  static boolean areaDisponivel(double area, Condominio condominio) {
        if (condominio.getAreaDisponivel() <= area) {
            return true;
        }
        return false;
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

    //Outros metodos
    public double calcularQuotaMensal(double despesasGerais, double despesasElevadores) {
        return 0.00;
    }

    public double getPercentagemArea() {
        return percentagemArea;
    }

    public void setPercentagemArea(double percentagemArea) {
        this.percentagemArea = percentagemArea;
    }

}
