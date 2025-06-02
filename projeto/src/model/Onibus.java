package model;

public class Onibus {
    
    private int numeroIdentificacao;
    private String modelo;

    public Onibus(int numeroIdentificacao, String modelo) {
        this.numeroIdentificacao = numeroIdentificacao;
        this.modelo = modelo;
    }

    // Getters e Setters

    public int getNumeroIdentificacao() {
        return numeroIdentificacao;
    }
    public String getModelo() {
        return modelo;
    }

    public void setNumeroIdentificacao(int numeroIdentificacao) {
        this.numeroIdentificacao = numeroIdentificacao;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
