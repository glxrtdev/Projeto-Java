package model;

public class Passagem {
    private int idPassagem;
    private int numeroOnibus;
    private String dataViagem;
    private String nomePassageiro;

    public Passagem(int idPassagem, int numeroOnibus, String dataViagem, String nomePassageiro) {
        this.idPassagem = idPassagem;
        this.numeroOnibus = numeroOnibus;
        this.dataViagem = dataViagem;
        this.nomePassageiro = nomePassageiro;
    }

    // Getters e setters

    public int getIdPassagem() {
        return idPassagem;
    }
    public int getNumeroOnibus() {
        return numeroOnibus;
    }
    public String getDataViagem() {
        return dataViagem;
    }
    public String getNomePassageiro() {
        return nomePassageiro;
    }

    public void setIdPassagem(int idPassagem) {
        this.idPassagem = idPassagem;
    }
    public void setNumeroOnibus(int numeroOnibus) {
        this.numeroOnibus = numeroOnibus;
    }
    public void setDataViagem(String dataViagem) {
        this.dataViagem = dataViagem;
    }
    public void setNomePassageiro(String nomePassageiro) {
        this.nomePassageiro = nomePassageiro;
    }


    public static Passagem fromString(String linha) {
        String[] partes = linha.split(";");
        int idPassagem = Integer.parseInt(partes[0]);
        int numeroOnibus = Integer.parseInt(partes[1]);
        String dataViagem = partes[2];
        String nomePassageiro = partes[3];
        return new Passagem(idPassagem, numeroOnibus, dataViagem, nomePassageiro);
    }

    @Override
    public String toString() {
        return idPassagem + ";" + numeroOnibus + ";" + dataViagem + ";" + nomePassageiro;
    }
}