package model;

public class Linha {
    
    private String saida;
    private String destino;

    public Linha(String saida, String destino) {
        this.saida = saida;
        this.destino = destino;
    }

    // Getters e Setters

    public String getSaida() {
        return saida;
    }
    public String getDestino() {
        return destino;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
}
