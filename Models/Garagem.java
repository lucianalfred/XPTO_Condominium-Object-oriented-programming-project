/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author lucian
 */
public class Garagem extends Fraccao {
    protected int capacidadeViaturas;
    protected boolean possuiServicoLavagem;

    // constructor
    public Garagem(int capacidadeViaturas, boolean possuiServicoLavagem,double area, String localizacao, Proprietario proprietario, Condominio cond) {    
        super(area, localizacao, proprietario, cond);
        this.capacidadeViaturas = capacidadeViaturas;
        this.possuiServicoLavagem = possuiServicoLavagem;
    }

    //Getter and setters
    public int getCapacidadeViaturas() {
        return capacidadeViaturas;
    }

    public void setCapacidadeViaturas(int capacidadeViaturas) {
        this.capacidadeViaturas = capacidadeViaturas;
    }

    public boolean isPossuiServicoLavagem() {
        return possuiServicoLavagem;
    }

    public void setPossuiServicoLavagem(boolean possuiServicoLavagem) {
        this.possuiServicoLavagem = possuiServicoLavagem;
    }
    @Override
    public double calcularQuotaMensal(double despesasGerais, double despesasElevadores) {
        return calcularPercentagemArea(cond.getAreaTotal()) * (despesasGerais + despesasElevadores);
    }

     @Override
    public void mostarInformacoes() {
        super.mostarInformacoes();
        System.out.println("Capacidade de Viaturas :" + this.capacidadeViaturas);
        System.out.println("Possui Serviço de Lavgem  :" + this.possuiServicoLavagem);
        System.out.println(" Quota Mensal da Gragem :"+this.calcularQuotaMensal(cond.getTotalDispesasGerais(), cond.getTotalDespesaElevador()));
        
    }
    
    //outros metodos
    
}
