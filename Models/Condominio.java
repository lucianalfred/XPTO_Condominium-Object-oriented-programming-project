package Models;

import java.util.*;
import java.time.LocalDate;
import Controllers.*;

/**
 * Classe que representa um condomínio.
 * Contém informações como morada, despesas, data de construção, área total, área ocupada, área disponível e uma lista de frações.
 */
public class Condominio {

    // Atributos da classe
    private static int identifcador = 0; // Identificador único do condomínio
    private String morada; // Morada do condomínio
    private double totalDispesasGerais; // Total das despesas gerais do condomínio
    private double totalDespesaElevador; // Total das despesas do elevador do condomínio
    private LocalDate dataConstrucao; // Data de construção do condomínio
    private ArrayList<Fraccao> fraccoes; // Lista de frações (unidades) do condomínio
    private double areaTotal; // Área total do condomínio
    private double areaOcupada; // Área ocupada pelas frações
    private double areaDisponivel; // Área disponível para novas frações

    /**
     * Construtor da classe Condominio.
     *
     * @param areaTotal Área total do condomínio.
     * @param morada Morada do condomínio.
     * @param totalDispesasGerais Total das despesas gerais do condomínio.
     * @param totalDespesaElevador Total das despesas do elevador do condomínio.
     * @param dataConstrucao Data de construção do condomínio.
     */
    public Condominio(double areaTotal, String morada, double totalDispesasGerais, double totalDespesaElevador, LocalDate dataConstrucao) {
        this.identifcador = this.identifcador + 1; // Incrementa o identificador único
        this.morada = morada;
        this.areaDisponivel = areaTotal; // Inicialmente, toda a área está disponível
        this.totalDispesasGerais = totalDispesasGerais;
        this.dataConstrucao = dataConstrucao;
        this.fraccoes = new ArrayList<Fraccao>(); // Inicializa a lista de frações
        this.areaTotal = areaTotal;
        this.totalDespesaElevador = totalDespesaElevador;
        this.areaOcupada = 0; // Inicialmente, nenhuma área está ocupada
    }

    /**
     * Construtor vazio da classe Condominio.
     * Inicializa a lista de frações.
     */
    public Condominio() {
        this.fraccoes = new ArrayList<>(); // Inicializa a lista de frações
    }

    // Métodos getters e setters

    public int getIdentifcador() {
        return identifcador;
    }

    public void setAreaOcupada(double areaOcupada) {
        this.areaOcupada = areaOcupada;
    }

    public void setAreaDisponivel(double areaDisponivel) {
        this.areaDisponivel = areaDisponivel;
    }

    public void setIdentifcador(int identifcador) {
        this.identifcador = identifcador;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public double getTotalDispesasGerais() {
        return totalDispesasGerais;
    }

    public void setTotalDispesasGerais(double totalDispesasGerais) {
        this.totalDispesasGerais = totalDispesasGerais;
    }

    public LocalDate getDataConstrucao() {
        return dataConstrucao;
    }

    public void setDataConstrucao(LocalDate dataConstrucao) {
        this.dataConstrucao = dataConstrucao;
    }

    public ArrayList<Fraccao> getFraccoes() {
        return fraccoes;
    }

    public void setFraccoes(ArrayList<Fraccao> fraccoes) {
        this.fraccoes = fraccoes;
    }

    public double getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(double areaTotal) {
        this.areaTotal = areaTotal;
    }

    public double getAreaOcupada() {
        return areaOcupada;
    }

    public double getAreaDisponivel() {
        return areaDisponivel;
    }

    public double getTotalDespesaElevador() {
        return totalDespesaElevador;
    }

    public void setTotalDespesaElevador(double totalDespesaElevador) {
        this.totalDespesaElevador = totalDespesaElevador;
    }

    /**
     * Lista todas as frações do condomínio.
     * Se não houver frações, exibe uma mensagem informando isso.
     */
    public void listarFraccao() {
        if (fraccoes.size() == 0) {
            System.out.println("Não Há Frações No Condomínio");
        } else {
            for (Fraccao aux : fraccoes) {
                aux.mostarInformacoes(); // Exibe as informações de cada fração
            }
        }
    }

    /**
     * Verifica a soma das percentagens das áreas das frações em relação à área total do condomínio.
     * Se não houver frações, exibe uma mensagem informando isso.
     */
    public void verificarSomasDasPercentagens() {
        double soma = 0;
        if (fraccoes.size() != 0) {
            for (Fraccao aux : fraccoes) {
                soma += aux.percentagemArea; // Soma as percentagens das áreas das frações
            }
            System.out.println("Percentagem das Frações: " + soma + "%");
        } else {
            System.out.println("Não há frações!");
        }
    }

    /**
     * Calcula a soma das quotas mensais de todas as frações do condomínio.
     * Se a fração for uma loja, calcula a quota de forma diferente.
     *
     * @return Soma das quotas mensais.
     */
    public double calcularQuotasMensais() {
        double somaQuota = 0;
        if (fraccoes.size() != 0) {
            for (Fraccao aux : fraccoes) {
                if (aux instanceof Loja) {
                    somaQuota += ((Loja) aux).calcularQuotaMensal(totalDispesasGerais); // Calcula a quota para lojas
                } else {
                    somaQuota += aux.calcularQuotaMensal(totalDispesasGerais, totalDespesaElevador); // Calcula a quota para outras frações
                }
            }
        }
        return somaQuota;
    }

    /**
     * Retorna uma representação em string do condomínio, útil para salvar em arquivos.
     *
     * @return String formatada com os dados do condomínio.
     */
    @Override
    public String toString() {
        return identifcador + "," + morada + "," + totalDispesasGerais + "," + totalDespesaElevador + "," + dataConstrucao + "," + areaTotal + "," + areaOcupada;
    }

    /**
     * Adiciona uma fração ao condomínio, se houver área disponível.
     *
     * @param fraccao Fração a ser adicionada.
     * @return true se a fração foi adicionada com sucesso, false caso contrário.
     */
    public boolean adicionarFraccao(Fraccao fraccao) {
        if (fraccao.area <= this.areaDisponivel) {
            fraccoes.add(fraccao);
            this.areaDisponivel -= fraccao.area; // Atualiza a área disponível
            this.areaOcupada += fraccao.area; // Atualiza a área ocupada
            return true;
        }
        return false;
    }

    /**
     * Remove uma fração do condomínio.
     *
     * @param frac Fração a ser removida.
     * @return true se a fração foi removida com sucesso, false caso contrário.
     */
    public boolean removerFraccao(Fraccao frac) {
        this.areaDisponivel += frac.area; // Atualiza a área disponível
        this.areaOcupada -= frac.area; // Atualiza a área ocupada
        return fraccoes.remove(frac); // Remove a fração da lista
    }

    /**
     * Procura um proprietário pelo ID.
     *
     * @param id ID do proprietário a ser procurado.
     * @return Objeto Proprietario encontrado ou null se não existir.
     */
    public Proprietario procurarProprietario(int id) {
        for (Fraccao aux : fraccoes) {
            if (aux.proprietario.getIdentificador() == id) {
                return aux.getProprietario(); // Retorna o proprietário se encontrado
            }
        }
        return null;
    }

    /**
     * Exibe as informações do condomínio, incluindo morada, despesas, áreas e percentagem disponível.
     */
    public void mostrarInformacao() {
        System.out.println("_________________________________________________");
        System.out.println("Condomínio: XPTO");
        System.out.println("Morada: " + morada);
        System.out.println("Total Despesas Gerais: " + totalDispesasGerais);
        System.out.println("Total Despesas Elevador: " + totalDespesaElevador);
        System.out.println("Data De Construção: " + dataConstrucao.toString());
        System.out.println("Área Total: " + areaTotal);
        System.out.println("Área Ocupada: " + areaOcupada);
        System.out.println("Área Disponível: " + areaDisponivel);
        System.out.println("Percentagem Disponível: " + String.format("%.3f", ((areaDisponivel * 100) / areaTotal)) + "%");
        System.out.println("_________________________________________________");
    }
}