
package Controllers;
import Models.Condominio;

public class GestorArquivo {
    private String caminho;
    
    
    //Constructor
    public GestorArquivo(String caminho) {
        this.caminho = caminho;
    }

    
    //get and set
    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
    
    //
    public Condominio carregarDados(){
        
        return null;
    }
    
    
}
