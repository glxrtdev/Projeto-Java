package view;

import java.util.List;
import java.util.Scanner;
import controller.MotoristaController;
import model.Motorista;

public class MotoristaView {

    private Scanner scanner = new Scanner(System.in);
    MotoristaController mc = new MotoristaController();

    public void menuMotorista() {
        int op;
        do {
            System.out.println("Escolha uma opção: ");
            System.out.println("[1] Adicionar motorista");
            System.out.println("[2] Listar motoristas");
            System.out.println("[3] Buscar motorista");
            System.out.println("[4] Editar motorista");
            System.out.println("[5] Remover motorista");
            System.out.println("[0] Voltar");
            op = scanner.nextInt();
            scanner.nextLine();

        switch (op) {
            case 1: adicionarMotorista();           
                break;
            case 2: List<Motorista> motoristas = mc.listarMotoristas();
                    for (Motorista m : motoristas) {
                        imprimirMotoristas(m);
                    }  
                break;
            case 3: buscarMotorista();
                break;
            case 4: editarMotorista();
                break;
            case 5: removerMotorista();
                break;
            case 0: System.out.println("Voltando...");
                break;
            default:
                    System.out.println("Opção inválida. Tente novamente");
                break;
        }
        } while (op != 0);
        

    }

    public void adicionarMotorista() {
        System.out.print("Qual é o nome do novo motorista?: ");
        String nome = scanner.nextLine();

        System.out.print("Qual o CPF do motorista?: ");
        String cpf = scanner.nextLine();

        System.out.print("Qual o salário do motorista?: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Qual a CNH do motorista?: ");
        String cnh = scanner.nextLine();

        Motorista novMotorista = new Motorista(nome, cpf, salario, cnh);
        mc.adicionarMotorista(novMotorista);
    }

    private void imprimirMotoristas(Motorista m) {
        System.out.println("Nome: " + m.getNome() + ", CPF: " + m.getCpf() + ", Salário: R$ " + m.getSalario() + ", CNH: " + m.getCnh());
    }

    public void buscarMotorista() {
        System.out.print("Qual o nome do motorista?: ");
        String nome = scanner.nextLine();

        mc.buscarPorNome(nome);
    }

    public void editarMotorista() {
        System.out.print("Qual o nome do motorista?: ");
        String nome = scanner.nextLine();

        System.out.print("Qual o novo salário?: ");
        double salario = scanner.nextDouble();

        mc.atualizarMotorista(nome, salario);
    }

    public void removerMotorista() {
        System.out.print("Qual o nome do motorista?: ");
        String nome = scanner.nextLine();

        mc.removerPorNome(nome);
    }
    
}
