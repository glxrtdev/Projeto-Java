package model;

public class Cliente extends Pessoa {

    
    public Cliente(String nome, String cpf) {
        super(nome, cpf);
    }

    @Override
    public void exibirDados() {
        System.out.println("Cliente: " + nome + ", CPF: " + cpf);
    }

    public static Cliente fromString(String linha) {
        String[] partes = linha.split(";");
        String nome = partes[0];
        String cpf = partes[1];
        return new Cliente(nome, cpf);
    }
    
    @Override
    public String toString() {
        return nome + ";" + cpf;
    }

}
