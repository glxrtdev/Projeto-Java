package model;

public class Motorista extends Pessoa{
    
    private String cnh;
    private double salario;
    
    public Motorista(String nome, String cpf, double salario, String cnh) {
        super(nome, cpf);
        this.salario = salario;
        this.cnh = cnh;
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

    public static Motorista fromString(String linha) {
        String[] partes = linha.split(";");
        String nome = partes[0];
        String cpf = partes[1];
        double salario = Double.parseDouble(partes[2]);
        String cnh = partes[3];
        
        return new Motorista(nome, cpf, salario, cnh);
    }

    @Override
    public String toString() {
        return nome + ";" + cpf + ";" + salario + ";" + cnh;
    }


}
