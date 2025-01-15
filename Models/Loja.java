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
    
    private boolean possuiAcessoExterno;

    //contstructor
    public Loja(boolean possuiAcessoExterno, String identificador, double area, String localizacao, Proprietario proprietario) {
        super(identificador, area, localizacao, proprietario);
        this.possuiAcessoExterno = possuiAcessoExterno;
    }
    
    //get and setters

    public boolean isPossuiAcessoExterno() {
        return possuiAcessoExterno;
    }

    //metodos
    public double calcularQuotaMensal(double despesasGerais){
        return 0.00;
    }
    
    

    
    
}
