package view;

import java.util.List;
import java.util.Scanner;
import controller.ClienteController;
import model.Cliente;

public class ClienteView {

    private Scanner scanner = new Scanner(System.in);
    ClienteController cc = new ClienteController();

    public void menuCliente() {
        int op;
        do {
            System.out.println("Escolha uma opção: ");
            System.out.println("[1] Adicionar cliente");
            System.out.println("[2] Listar clientes");
            System.out.println("[3] Buscar cliente");
            System.out.println("[4] Remover cliente");
            System.out.println("[0] Voltar");
            op = scanner.nextInt();
            scanner.nextLine();

        switch (op) {
            case 1: adicionarCliente();           
                break;
            case 2: List<Cliente> clientes = cc.listarClientes();
                    for (Cliente c : clientes) {
                        imprimirClientes(c);
                    }
                break;
            case 3: buscarCliente();
                break;
            case 4: removerCliente();
                break;
            case 0: System.out.println("Voltando...");
                break;
            default:
                    System.out.println("Opção inválida. Tente novamente");
                break;
        }
            
        } while (op != 0);
        

    }

    public void adicionarCliente() {
        System.out.print("Qual o nome do cliente?: ");
        String nome = scanner.nextLine();

        System.out.print("Qual o CPF do cliente?: ");
        String cpf = scanner.nextLine();

        Cliente novoCliente = new Cliente(nome, cpf);
        cc.adicionarCliente(novoCliente);
    }

    private void imprimirClientes(Cliente c) {
        System.out.println("Nome: " + c.getNome() + ", CPF: " + c.getCpf());
    }

    public void buscarCliente() {
        System.out.print("Qual o nome do cliente?: ");
        String nome = scanner.nextLine();

        cc.buscarPorNome(nome);
    }

    public void removerCliente() {
        System.out.print("Qual o nome do cliente?: ");
        String nome = scanner.nextLine();

        cc.removerPorNome(nome);
    }

    
}
