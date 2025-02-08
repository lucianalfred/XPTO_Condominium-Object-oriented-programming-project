package Models;

public class Arrecadacao extends Fraccao {

    protected boolean possuiPortaBlindada;

    //constructor
    public Arrecadacao(boolean possuiPortaBlindada,double area, String localizacao, Proprietario proprietario,Condominio cond) {
        super(area, localizacao, proprietario, cond);
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
