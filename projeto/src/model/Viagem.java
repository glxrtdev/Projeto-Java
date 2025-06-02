package model;

public class Viagem {

    private int id;
    private Motorista motorista;
    private Onibus onibus;
    private Linha linha;
    private String dataHora;

    public Viagem(int id, Motorista motorista, Onibus onibus, Linha linha, String dataHora) {
        this.id = id;
        this.motorista = motorista;
        this.onibus = onibus;
        this.linha = linha;
        this.dataHora = dataHora;
    }


    // Getters e Setters

    public int getId() {
        return id;
    }
    public Motorista geMotorista() {
        return motorista;
    }
    public Onibus getOnibus() {
        return onibus;
    }
    public Linha getLinha() {
        return linha;
    }
    public String getDataHora() {
        return dataHora;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }
    public void setOnibus(Onibus onibus) {
        this.onibus = onibus;
    }
    public void setLinha(Linha linha) {
        this.linha = linha;
    }
    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
}
