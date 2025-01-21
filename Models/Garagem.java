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
    public Garagem(int capacidadeViaturas, boolean possuiServicoLavagem,int identificador, double area, String localizacao, Proprietario proprietario) {    
        super(identificador, area, localizacao, proprietario);
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
    
    //outros metodos
    
}
