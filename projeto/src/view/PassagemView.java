package view;

import java.util.Scanner;

import controller.PassagemController;
import model.Passagem;

public class PassagemView {

    private Scanner scanner = new Scanner(System.in);
    PassagemController pc = new PassagemController();

    public void menuPassagem() {
        System.out.println("Escolha uma opção: ");
        System.out.println("Escolha uma opção: ");
        System.out.println("[1] Adicionar passagem");
        System.out.println("[2] Listar passagem");
        System.out.println("[3] Buscar passagem");
        System.out.println("[4] Editar passagem");
        System.out.println("[5] Remover passagem");
        int op = scanner.nextInt();
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
            default:
                break;
        }
    }

    public void adicionarPassagem() {
        System.out.println("Dê um id para a passagem: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Qual id do ônibus a ser atribuido?: ");
        int idOnibus = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Qual a data da viagem? (ex: 03/06/2025): ");
        String dataPassagem = scanner.nextLine();

        System.out.println("Qual o nome do passageiro?: ");
        String nomePassageiro = scanner.nextLine();

        Passagem novaPassagem = new Passagem(id, idOnibus, dataPassagem, nomePassageiro);
        pc.adicionarPassagem(novaPassagem);
    }

    public void buscarPassagem() {
        System.out.println("Qual o id da passagem?: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        pc.buscarPorId(id);
    }

    public void editarPassagem() {
        System.out.println("Qual o id da passagem?: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Qual ônibus será atribuido?: ");
        int idOnibus = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nova data: ");
        String dataPassagem = scanner.nextLine();

        System.out.println("Nome do passageiro: ");
        String nomePassageiro = scanner.nextLine();

        pc.atualizarPassagem(id, idOnibus, dataPassagem, nomePassageiro);
    }

    public void removerPassagem() {
        System.out.println("Qual o id da passagem?: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        pc.removerPorId(id);

    }
    
}