package view;

import java.util.Scanner;

public class MenuPrincipal {

    private Scanner scanner = new Scanner(System.in);
    PessoaView pessoaView = new PessoaView();
    PassagemView pv = new PassagemView();
    OnibusView ov = new OnibusView();
    ViagemView vv = new ViagemView();


        public void menuExibir() {
            System.out.println("Bem-vindo(a). O que deseja?");
            System.out.println("[1] Gerenciar pessoas");
            System.out.println("[2] Gerenciar ônibus");
            System.out.println("[3] Gerenciar viagens");
            System.out.println("[4] Gerenciar passagens");
            System.out.println("[0] Sair");
            int op = scanner.nextInt();

            switch (op) {
                case 1: pessoaView.menuPessoa();
                    break;
                case 2: ov.menuOnibus();
                    break;
                case 3: vv.menuViagem();
                    break;
                case 4: pv.menuPassagem();
                    break;
                case 0: System.out.println("Finalizando o programa...");
                    break;
                default:
                    break;
            }

        }

}
