package Models;


public class Arrecadacao extends Fraccao {
    private boolean possuiPortaBlindada;
    
    
    //constructor
    public Arrecadacao(boolean possuiPortaBlindada, int identificador, double area, String localizacao, Proprietario proprietario) {
        super(identificador, area, localizacao, proprietario);
        this.possuiPortaBlindada = possuiPortaBlindada;
    }

    //getters and setters
    public boolean isPossuiPortaBlindada() {
        return possuiPortaBlindada;
    }

    public void setPossuiPortaBlindada(boolean possuiPortaBlindada) {
        this.possuiPortaBlindada = possuiPortaBlindada;
    }
    
    //outros metodos
}
