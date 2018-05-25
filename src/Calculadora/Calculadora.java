package Calculadora;

import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        double n1,n2,resultado;
        String operacao, deseja = "S";

        while (deseja.equals("S") || deseja.equals("s")) {

            Scanner ler = new Scanner(System.in);
            System.out.println("Digite o primeiro valor: ");
            n1 = ler.nextInt();

            System.out.println("Digite o segundo Número: ");
            n2 = ler.nextInt();

            System.out.println("Digite a operação desejada: ");
            operacao = ler.next();



            switch (operacao) {
                case "+":
                    resultado = n1 + n2;
                    System.out.println(resultado);
                    break;
                case "-":
                    resultado = n1 - n2;
                    System.out.println(resultado);
                    break;
                case "*":
                    resultado = n1 * n2;
                    System.out.println(n1+ " "+ operacao+ " "+n2+"= "+resultado);
                    break;
                case "/":
                    if (n2 == 0) {
                        System.out.println("Não é possível dividir por 0");
                        break;
                    } else {
                        resultado = n1 / n2;
                        System.out.println(n1+ " "+ operacao+" "+n2 +"= "+resultado);
                    }
                    break;
                default:
                    System.out.println("Operação ínvalida");

            }
            System.out.println("Deseja fazer outra operação? ");
            deseja = ler.next();

        }
        System.out.println("Obrigado!");

    }
}
