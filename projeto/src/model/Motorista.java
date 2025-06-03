package model;

public class Motorista extends Pessoa{
    
    private String cnh;
    private double salario;
    
    public Motorista(String nome, String cpf, double salario, String cnh) {
        super(nome, cpf);
        this.salario = salario;
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
    public double getSalario() {
        return salario;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
}
