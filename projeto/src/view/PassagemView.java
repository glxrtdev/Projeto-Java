package view;

import java.util.Scanner;

import controller.PassagemController;
import model.Passagem;

public class PassagemView {

    private Scanner scanner = new Scanner(System.in);
    PassagemController pc = new PassagemController();

    public void menuPassagem() {
        int op;
        do {
            System.out.println("Escolha uma opção: ");
            System.out.println("Escolha uma opção: ");
            System.out.println("[1] Adicionar passagem");
            System.out.println("[2] Listar passagens");
            System.out.println("[3] Buscar passagem");
            System.out.println("[4] Editar passagem");
            System.out.println("[5] Remover passagem");
            System.out.println("[0] Voltar");
            op = scanner.nextInt();
            scanner.nextLine();

        switch (op) {
            case 1: adicionarPassagem();          
                break;
            case 2: pc.listarPassagens();
                break;
            case 3: buscarPassagem();
                break;
            case 4: editarPassagem();
                break;
            case 5: removerPassagem();
                break;
            case 0: System.out.println("Voltando...");
                break;
            default:
                    System.out.println("Opção inválida. Tente novamente");
                break;
        }
            
        } while (op != 0);
        
    }

    public void adicionarPassagem() {
        System.out.print("Dê um id para a passagem: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Qual id do ônibus a ser atribuido?: ");
        int idOnibus = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Qual a data da viagem? (ex: 03/06/2025): ");
        String dataPassagem = scanner.nextLine();

        System.out.print("Qual o nome do passageiro?: ");
        String nomePassageiro = scanner.nextLine();

        System.out.print("Qual o valor?: ");
        double valor = scanner.nextDouble();

        Passagem novaPassagem = new Passagem(id, idOnibus, dataPassagem, nomePassageiro, valor);
        pc.adicionarPassagem(novaPassagem);
    }

    public void buscarPassagem() {
        System.out.print("Qual o id da passagem?: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        pc.buscarPorId(id);
    }

    public void editarPassagem() {
        System.out.print("Qual o id da passagem?: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Qual ônibus será atribuido?: ");
        int idOnibus = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nova data: ");
        String dataPassagem = scanner.nextLine();

        System.out.print("Nome do passageiro: ");
        String nomePassageiro = scanner.nextLine();

        System.out.print("Qual o valor?: ");
        double valor = scanner.nextDouble();

        pc.atualizarPassagem(id, idOnibus, dataPassagem, nomePassageiro, valor);
    }

    public void removerPassagem() {
        System.out.print("Qual o id da passagem?: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        pc.removerPorId(id);

    }
    
}