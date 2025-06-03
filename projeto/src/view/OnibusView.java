package view;

import java.util.Scanner;
import controller.OnibusController;
import model.Onibus;

public class OnibusView {

    private Scanner scanner = new Scanner(System.in);

    OnibusController oc = new OnibusController();

    public void menuOnibus() {
        int op;
        do {
            System.out.println("Escolha uma opção: ");
            System.out.println("[1] Adicionar ônibus");
            System.out.println("[2] Listar ônibus");
            System.out.println("[3] Buscar ônibus");
            System.out.println("[4] Editar ônibus");
            System.out.println("[5] Remover ônibus");
            System.out.println("[0] Voltar");
            op = scanner.nextInt();
            scanner.nextLine();

        switch (op) {
            case 1: adicionarOnibus();           
                break;
            case 2: oc.listarOnibus();
                break;
            case 3: buscarOnibus();
                break;
            case 4: editarOnibus();
                break;
            case 5: removerOnibus();
                break;
            case 0: System.out.println("Voltando...");
                break;
            default:
                    System.out.println("Opção inválida. Tente novamente");
                break;
        }
            
        } while (op != 0);
        

    }

    public void adicionarOnibus() {
        System.out.print("Dê um id para o ônibus: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Qual o modelo do ônibus?: ");
        String modelo = scanner.nextLine();

        System.out.print("Qual a capacidade do ônibus?: ");
        int capacidade = scanner.nextInt();
        scanner.nextLine();

        Onibus novoOnibus = new Onibus(id, modelo, capacidade);
        oc.adicionarOnibus(novoOnibus);
    }

    public void buscarOnibus() {
        System.out.print("Qual o id do ônibus?: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        oc.buscarPorIdentificador(id);
    }

    public void editarOnibus() {
        System.out.print("Qual o id do ônibus?: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Qual será o modelo do ônibus?: ");
        String modelo = scanner.nextLine();

        System.out.print("Qual a nova capacidade do ônibus?: ");
        int capacidade = scanner.nextInt();
        scanner.nextLine();

        oc.atualizarOnibus(id, modelo, capacidade);
    }

    public void removerOnibus() {
        System.out.print("Qual o id do ônibus?: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        oc.removerPorIdentificador(id);
    }
    
}
