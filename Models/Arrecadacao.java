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
    @Override
    public double calcularQuotaMensal(double despesasGerais, double despesasElevadores) {
        return calcularPercentagemArea(cond.getAreaTotal()) * (despesasGerais + despesasElevadores);
    }
    @Override
    public void mostarInformacoes() {
       
        System.out.println("__________________________________________________________________________");
        System.out.println("ARRECADACAO");
        super.mostarInformacoes();
        System.out.println("Possui Porta Blindada :" + ((this.possuiPortaBlindada) ? "Possui": "Nao possui"));
        System.out.println("Quota Mensal da Arrecadação :"+this.calcularQuotaMensal(cond.getTotalDispesasGerais(), cond.getTotalDespesaElevador()));
        System.out.println("__________________________________________________________________________");
        
    }

    //outros metodos
}
