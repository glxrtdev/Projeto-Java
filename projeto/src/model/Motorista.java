package model;

public class Motorista extends Funcionario{
    
    private String cnh;
    
    public Motorista(String nome, String cpf, double salario, String cnh) {
        super(nome, cpf, salario);
        this.cnh = cnh;
    }

    @Override
    public void exibirDados() {
        System.out.println("Motorista: " + nome + ", CNH: " + cnh);
    }

    // Getters e Setters

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
}
