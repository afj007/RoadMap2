package Ordenacao;

import java.util.Scanner;

public class BubbleSort {

    private static Scanner ler = new Scanner(System.in);
    private static int lista[] = {100, 40, 6, 25, 78, 18, 93, 110, 55, 23};
    private static int listaReserva[] = new int[lista.length];

    static void ordernarValores(int lista[], int totalDeLoops) {
        int anterior;
        for (int i = 0; i < lista.length; i++) {
            if (i == 0) {
                continue;
            }

            if (lista[i - 1] > lista[i]) {
                anterior = lista[i - 1];
                lista[i - 1] = lista[i];
                lista[i] = anterior;
            }
        }

        if (totalDeLoops < (lista.length ^ 2)) {
            ordernarValores(lista, totalDeLoops + 1);
        } else {
            mostrarValores(lista);
        }

    }

    static void mostrarValores(int lista[]) {
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i]);
        }
    }
}
