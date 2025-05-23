package model;

public class AssentoService {
    private final int totalAssentos = 40;

    public int getAssentosDisponiveis() {
        int ocupados = (int) (Math.random() * totalAssentos);
        return totalAssentos - ocupados;
    }

    public int getTotalAssentos() {
        return totalAssentos;
    }
}
