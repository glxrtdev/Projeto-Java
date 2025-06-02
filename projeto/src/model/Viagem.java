package model;

public class Viagem {
    private int id;
    private String destino;
    private String data; 
    private int onibusId; 

    public Viagem(int id, String destino, String data, int onibusId) {
        this.id = id;
        this.destino = destino;
        this.data = data;
        this.onibusId = onibusId;
    }

    public int getId() {
        return id;
    }
    public String getDestino() {
        return destino;
    }
    public String getData() {
        return data;
    }
    public int getOnibusId() {
        return onibusId;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setOnibusId(int onibusId) {
        this.onibusId = onibusId;
    }

    public static Viagem fromString(String linha) {
        String[] partes = linha.split(";");
        int id = Integer.parseInt(partes[0]);
        String destino = partes[1];
        String data = partes[2];
        int onibusId = Integer.parseInt(partes[3]);
        return new Viagem(id, destino, data, onibusId);
    }

    @Override
    public String toString() {
        return id + ";" + destino + ";" + data + ";" + onibusId;
    }
}