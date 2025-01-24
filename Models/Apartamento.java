package Models;

public class Apartamento extends Fraccao {

    protected String tipoApartamento;
    protected int numCasasBanho;
    protected int numVarandas;
    protected boolean possuiTerraco;

    //constructor
    public Apartamento(String tipoApartamento, int numCasasBanho, int numVarandas, boolean possuiTerraco,double area, String localizacao, Proprietario proprietario) {
        super(area, localizacao, proprietario);
        this.tipoApartamento = tipoApartamento;
        this.numCasasBanho = numCasasBanho;
        this.numVarandas = numVarandas;
        this.possuiTerraco = possuiTerraco;
    }

    @Override 
    public String toString(){
        return super.toString()+","+tipoApartamento+","+numCasasBanho+","+numVarandas+","+possuiTerraco;
    }
    
    //getters and setters
    public String getTipoApartamento() {
        return tipoApartamento;
    }

    public void setTipoApartamento(String tipoApartamento) {
        this.tipoApartamento = tipoApartamento;
    }

    public int getNumCasasBanho() {
        return numCasasBanho;
    }

    public void setNumCasasBanho(int numCasasBanho) {
        this.numCasasBanho = numCasasBanho;
    }

    public int getNumVarandas() {
        return numVarandas;
    }

    public void setNumVarandas(int numVarandas) {
        this.numVarandas = numVarandas;
    }

    public boolean isPossuiTerraco() {
        return possuiTerraco;
    }

    public void setPossuiTerraco(boolean possuiTerraco) {
        this.possuiTerraco = possuiTerraco;
    }

    //outros metodos
}
