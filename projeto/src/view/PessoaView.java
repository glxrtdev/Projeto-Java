package view;

import java.util.Scanner;

public class PessoaView {

    private Scanner scanner = new Scanner(System.in);
    MotoristaView mv = new MotoristaView();
    ClienteView cv = new ClienteView();


    public void menuPessoa() {
        System.out.println("Escolha uma opção: ");
        System.out.println("[1] Gerenciar clientes");
        System.out.println("[2] Gerenciar motoristas");
        int op = scanner.nextInt();
        scanner.nextLine();

        switch (op) {
            case 1: cv.menuCliente();
                break;
            case 2: mv.menuMotorista();
                break;
            default:
                break;
        }

    }
    
}
