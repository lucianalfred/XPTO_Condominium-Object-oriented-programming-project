package Models;


public class Apartamento extends Fraccao {
    private String tipoApartamento;
    private int numCasasBanho;
    private int numVarandas;
    private boolean possuiTerraco;
    
    //constructor
    public Apartamento(String tipoApartamento, int numCasasBanho, int numVarandas, boolean possuiTerraco, String identificador, double area, String localizacao, Proprietario proprietario) {
        super(identificador, area, localizacao, proprietario);
        this.tipoApartamento = tipoApartamento;
        this.numCasasBanho = numCasasBanho;
        this.numVarandas = numVarandas;
        this.possuiTerraco = possuiTerraco;
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
