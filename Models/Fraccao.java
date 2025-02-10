package Models;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Classe abstrata que representa uma fração (unidade) de um condomínio.
 * Contém informações básicas como área, localização, proprietário e percentagem da área em relação ao condomínio.
 */
public abstract class Fraccao {

    // Contador estático para gerar identificadores únicos para cada fração
    protected static int contador = 0;

    // Atributos da fração
    protected int identificador; // Identificador único da fração
    protected double area; // Área da fração
    protected double percentagemArea; // Percentagem da área da fração em relação à área total do condomínio
    protected String localizacao; // Localização da fração no condomínio
    protected Proprietario proprietario; // Proprietário da fração
    protected Condominio cond; // Referência ao condomínio ao qual a fração pertence

    /**
     * Construtor da classe Fraccao.
     *
     * @param area Área da fração.
     * @param localizacao Localização da fração no condomínio.
     * @param proprietario Proprietário da fração.
     * @param cond Condomínio ao qual a fração pertence.
     */
    public Fraccao(double area, String localizacao, Proprietario proprietario, Condominio cond) {
        this.identificador += ++contador; // Gera um identificador único para a fração
        this.area = area;
        this.localizacao = localizacao;
        this.proprietario = proprietario;
        this.cond = cond;

        // Calcula a percentagem da área da fração em relação à área total do condomínio
        double valor = (area * 100) / cond.getAreaTotal();
        this.percentagemArea = arredondarParaTresCasasDecimais(valor); // Arredonda o valor para 3 casas decimais
    }

    /**
     * Método para arredondar um número para três casas decimais.
     *
     * @param numero Número a ser arredondado.
     * @return Número arredondado para três casas decimais.
     */
    public static double arredondarParaTresCasasDecimais(double numero) {
        return Math.round(numero * 1000.0) / 1000.0;
    }

    // Métodos getters e setters

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    /**
     * Calcula a percentagem da área da fração em relação à área total do condomínio.
     *
     * @param areaTotalCondominio Área total do condomínio.
     * @return Percentagem da área da fração.
     */
    public double calcularPercentagemArea(double areaTotalCondominio) {
        double percentagem = (this.area * 100) / areaTotalCondominio;
        this.percentagemArea = percentagem; // Atualiza o valor da percentagem da área
        return percentagem;
    }

    /**
     * Mostra a percentagem da área da fração formatada com três casas decimais.
     *
     * @param cond Condomínio ao qual a fração pertence.
     */
    public void mostrarPercentagem(Condominio cond) {
        DecimalFormat df = new DecimalFormat("#.###"); // Formata o número para três casas decimais
        System.out.println("Percentagem: " + df.format(calcularPercentagemArea(cond.getAreaTotal())));
    }

    /**
     * Calcula a quota mensal da fração com base nas despesas gerais e do elevador.
     *
     * @param despesasGerais Despesas gerais do condomínio.
     * @param despesasElevadores Despesas do elevador do condomínio.
     * @return Quota mensal da fração.
     */
    public double calcularQuotaMensal(double despesasGerais, double despesasElevadores) {
        return calcularPercentagemArea(cond.getAreaTotal()) * (despesasGerais + despesasElevadores);
    }

    public double getPercentagemArea() {
        return percentagemArea;
    }

    public void setPercentagemArea(double percentagemArea) {
        this.percentagemArea = percentagemArea;
    }

    /**
     * Mostra as informações da fração, incluindo identificador, área, percentagem da área,
     * localização e informações do proprietário.
     */
    public void mostarInformacoes() {
        System.out.println("Id: " + this.getIdentificador());
        System.out.println("Área: " + this.getArea());
        System.out.println("Percentagem da Área: " + String.format("%.3f", this.percentagemArea) + "%");
        System.out.println("Localização: " + this.getLocalizacao());
        System.out.println("Id Proprietário: " + this.getProprietario().getIdentificador());
        System.out.println("Nome Proprietário: " + this.getProprietario().getNome());
        System.out.println("Email Proprietário: " + this.getProprietario().getEmail());
    }

    /**
     * Retorna uma representação em string da fração, útil para salvar em arquivos.
     *
     * @return String formatada com os dados da fração.
     */
    @Override
    public String toString() {
        String tipo = this.getClass().getSimpleName().toLowerCase(); // Obtém o tipo da fração (apartamento, garagem, etc.)
        return identificador + "," + area + "," + percentagemArea + "," + localizacao + "," + proprietario.getIdentificador() + "," + tipo;
    }
}