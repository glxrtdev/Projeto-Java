package view;

import java.util.Scanner;

public class SistemaView {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- Sistema de Transporte ---");
        System.out.println("1. Ver saldo");
        System.out.println("2. Recarregar saldo");
        System.out.println("3. Retirar saldo");
        System.out.println("4. Ver horários");
        System.out.println("5. Ver assentos disponíveis");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public double solicitarValor(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextDouble();
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void mostrarSaldo(double saldo) {
        System.out.printf("Seu saldo é: R$ %.2f%n", saldo);
    }

    public void mostrarHorarios(String[] horarios) {
        System.out.println("Horários disponíveis:");
        for (String h : horarios) {
            System.out.println(h);
        }
    }

    public void mostrarAssentos(int disponiveis, int total) {
        System.out.println("Assentos disponíveis: " + disponiveis + " de " + total);
    }
}
