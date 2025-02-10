package Models;

import java.time.LocalDate;

public class Proprietario {

   
    private static int contador = 0;
    private int identificador;
    private String nome;
    private String morada;
    private String telefone;
    private String email;
    private LocalDate dataNascimento;

    //Constructor
    public Proprietario(String nome, String morada, String telefone, String email, LocalDate dataNascimento) {
        this.identificador = ++contador;
        this.nome = nome;
        this.morada = morada;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }
    
    public Proprietario(int identificador, String nome, String email) {
        this.identificador = identificador;
        this.nome = nome;
        this.email = email;
       
    }
    
    public Proprietario(String nome, String email) {
        this.identificador = ++contador;
        this.nome = nome;
        this.email = email;
       
    }
    
    @Override
    public String toString(){
        return identificador+","+nome+","+morada+","+telefone+","+email+","+dataNascimento;
    }

    //Setters and Getters
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // outros metodos 
}
