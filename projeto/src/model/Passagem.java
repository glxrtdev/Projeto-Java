package model;

public class Passagem {
    private int idPassagem;
    private int idOnibus;
    private String dataPassagem;
    private String nomePassageiro;
    private double valor;

    public Passagem(int idPassagem, int idOnibus, String dataPassagem, String nomePassageiro, double valor) {
        this.idPassagem = idPassagem;
        this.idOnibus = idOnibus;
        this.dataPassagem = dataPassagem;
        this.nomePassageiro = nomePassageiro;
        this.valor = valor;
    }

    // Getters e setters

    public int getIdPassagem() {
        return idPassagem;
    }
    public int getNumeroOnibus() {
        return idOnibus;
    }
    public String getDataPassagem() {
        return dataPassagem;
    }
    public String getNomePassageiro() {
        return nomePassageiro;
    }
    public double getValor() {
        return valor;
    }

    public void setIdPassagem(int idPassagem) {
        this.idPassagem = idPassagem;
    }
    public void setNumeroOnibus(int idOnibus) {
        this.idOnibus = idOnibus;
    }
    public void setDataViagem(String dataPassagem) {
        this.dataPassagem = dataPassagem;
    }
    public void setNomePassageiro(String nomePassageiro) {
        this.nomePassageiro = nomePassageiro;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }


    public static Passagem fromString(String linha) {
        String[] partes = linha.split(";");
        int idPassagem = Integer.parseInt(partes[0]);
        int idOnibus = Integer.parseInt(partes[1]);
        String dataPassagem = partes[2];
        String nomePassageiro = partes[3];
        double valor = Double.parseDouble(partes[4]);

        return new Passagem(idPassagem, idOnibus, dataPassagem, nomePassageiro, valor);
    }

    @Override
    public String toString() {
        return idPassagem + ";" + idOnibus + ";" + dataPassagem + ";" + nomePassageiro + ";" + valor;
    }

}