package Model;

import java.util.Scanner;
import View.MenuView;

public class Main {
    private static double saldo = 0.0;
    private static Scanner scanner = new Scanner(System.in);
    private static MenuView view = new MenuView();

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n--- Sistema de Transporte ---");
            System.out.println("1. Ver saldo");
            System.out.println("2. Recarregar saldo");
            System.out.println("3. Retirar saldo");
            System.out.println("4. Ver horários");
            System.out.println("5. Ver assentos disponíveis");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1: view.verSaldo(saldo); break;
                case 2: recarregarSaldo(); break;
                case 3: retirarSaldo(); break;
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private static void recarregarSaldo() {
        System.out.print("Digite o valor da recarga: ");
        double valor = scanner.nextDouble();
        saldo += valor;
        System.out.println("Recarga realizada com sucesso!");
    }

    private static void retirarSaldo() {
        System.out.print("Digite o valor a retirar: ");
        double valor = scanner.nextDouble();
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Valor retirado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
}
