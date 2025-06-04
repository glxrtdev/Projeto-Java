package model;

public class Onibus {
    
    private int id;
    private String modelo;
    private int capacidade;

    public Onibus(int id, String modelo, int capacidade) {
        this.id = id;
        this.modelo = modelo;
        this.capacidade = capacidade;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }
    public String getModelo() {
        return modelo;
    }
    public int getCapacidade() {
        return capacidade;
    }

    public void setId(int id) {
        this.id = id;
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
        return id + ";" + modelo + ";" + capacidade;
    }

}
