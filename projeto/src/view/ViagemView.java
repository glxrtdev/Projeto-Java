package view;

import java.util.List;
import java.util.Scanner;
import controller.ViagemController;
import model.Viagem;

public class ViagemView {
    
    private Scanner scanner = new Scanner(System.in);
    ViagemController vc = new ViagemController();

    public void menuViagem() {

        int op;
        do {
            System.out.println("Escolha uma opção: ");
            System.out.println("[1] Adicionar viagem");
            System.out.println("[2] Listar viagens");
            System.out.println("[3] Buscar viagem");
            System.out.println("[4] Editar viagem");
            System.out.println("[5] Remover viagem");
            System.out.println("[0] Voltar");
            op = scanner.nextInt();
            scanner.nextLine();

        switch (op) {
            case 1: adicionarViagem();                
                break;
            case 2: List<Viagem> viagem = vc.listarViagens();
                    for (Viagem v : viagem) {
                        imprimirViagens(v);
                    }
                break;
            case 3: buscarViagem();
                break;
            case 4: editarViagem();
                break;
            case 5: removerViagem();
                break;
            case 0: System.out.println("Voltando...");
                break;
            default:
                    System.out.println("Opção inválida. Tente novamente");
                break;
        }
            
        } while (op != 0);
        
    }


    public void adicionarViagem() {
        System.out.print("Dê um id para a viagem: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Destino:");
        String destino = scanner.nextLine();

        System.out.print("Data (ex: 03/06/2025): ");
        String data = scanner.nextLine();

        System.out.print("Qual o id do ônibus que será utilizado?: ");
        int idOnibus = scanner.nextInt();
        scanner.nextLine();

        Viagem novaViagem = new Viagem(id, destino, data, idOnibus);
        vc.adicionarViagem(novaViagem);

        System.out.print("Viagem adicionada com sucesso!");
    }

    private void imprimirViagens(Viagem v) {
        System.out.println("ID: " + v.getId() + ", Destino: " + v.getDestino() + ", Data: " + v.getData() +
                   ", Ônibus ID: " + v.getOnibusId());

    }

    public void buscarViagem() {
        System.out.print("Informe o id da viagem: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        vc.buscarPorIdentificador(id);
    }

    public void editarViagem() {
        System.out.print("Qual o ID da viagem?: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo destino: ");
        String destino = scanner.nextLine();

        System.out.print("Nova data: ");
        String data = scanner.nextLine();

        System.out.print("ID do ônibus: ");
        int idOnibus = scanner.nextInt();
        scanner.nextLine();

        vc.atualizarViagem(id, destino, data, idOnibus);
    }

    public void removerViagem() {
        System.out.print("Qual o ID da viagem?: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        vc.removerPorIdentificador(id);
    }

    
}
