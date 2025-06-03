package view;

import java.util.Scanner;

public class PessoaView {

    private Scanner scanner = new Scanner(System.in);
    MotoristaView mv = new MotoristaView();
    ClienteView cv = new ClienteView();


    public void menuPessoa() {
        int op;
        do {
            System.out.println("Escolha uma opção: ");
            System.out.println("[1] Gerenciar clientes");
            System.out.println("[2] Gerenciar motoristas");
            System.out.println("[0] Voltar");
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1: cv.menuCliente();
                    break;
                case 2: mv.menuMotorista();
                    break;
                case 0: System.out.println("Voltando...");
                    break;
                default:
                        System.out.println("Opção inválida. Tente novamente");
                    break;
        }
            
        } while (op != 0);
        

    }
    
}
