/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author lucian
 */
public class Loja extends Fraccao {

    // Constructor 
    public Loja(double area, String localizacao, Proprietario proprietario, Condominio cond) {
        super(area, localizacao, proprietario, cond);
    }

    public double calcularQuotaMensal(double despesasGerais) {
        return calcularPercentagemArea(cond.getAreaDisponivel()) * (despesasGerais);
    }
     @Override
    public void mostarInformacoes() {
        super.mostarInformacoes();
        System.out.println(" Quota Mensal da Loja :"+this.calcularQuotaMensal(cond.getTotalDispesasGerais()));
        
    }
    

}
