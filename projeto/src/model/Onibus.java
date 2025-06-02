package model;

public class Onibus {
    
    private int numeroIdentificacao;
    private String modelo;
    private int capacidade;

    public Onibus(int numeroIdentificacao, String modelo, int capacidade) {
        this.numeroIdentificacao = numeroIdentificacao;
        this.modelo = modelo;
        this.capacidade = capacidade;
    }

    // Getters e Setters

    public int getNumeroIdentificacao() {
        return numeroIdentificacao;
    }
    public String getModelo() {
        return modelo;
    }
    public int getCapacidade() {
        return capacidade;
    }

    public void setNumeroIdentificacao(int numeroIdentificacao) {
        this.numeroIdentificacao = numeroIdentificacao;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public static Onibus fromString(String linha) {
    String[] partes = linha.split(";");
    int numeroIdentificacao = Integer.parseInt(partes[0]);
    String modelo = partes[1];
    int capacidade = Integer.parseInt(partes[2]);
    return new Onibus(numeroIdentificacao, modelo, capacidade);
    }

    @Override
    public String toString() {
        return numeroIdentificacao + ";" + modelo + ";" + capacidade;
    }

}
