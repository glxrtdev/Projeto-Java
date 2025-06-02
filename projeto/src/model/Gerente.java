package model;

public class Gerente extends Funcionario{
    
    private int id;

    public Gerente(String nome, String cpf, double salario, int id) {
        super(nome, cpf, salario);
        this.id = id;
    }

    @Override
    public void exibirDados() {
        System.out.println("Gerente: " + nome + ", ID: " + id);
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
