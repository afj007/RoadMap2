package Ordenacao;

import java.util.Scanner;

public class BubbleSort {

//    private static int lista[] = {100, 40, 6, 25, 78, 18, 93, 110, 55, 23};

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
                i = 0;
            }
        }
        mostrarValores(lista);
    }

    private static void mostrarValores(int lista[]) {
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i]);
        }
    }
}
