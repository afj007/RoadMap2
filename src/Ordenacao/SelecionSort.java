package Ordenacao;

import java.util.Scanner;

public class SelecionSort {
    private static Scanner ler = new Scanner (System.in);
    private static int lista[] = {100, 4, 6, 2, 7, 8, 9, 10, 55, 23};
    private static int listaReserva[] = new int[lista.length];

    static void armazenandoNumero() {

        for (int i = 0; i < lista.length; i++) {

            System.out.print ("Digite o " + (i + 1) + "º número: ");
            lista[i] = ler.nextInt ( );
        }
    }

    static void ordernarValores() {
        int menor = 0;
        int maior;
        int reserva = 0;
        int i;
        for (int j = 0; j < listaReserva.length; j++) {

            for (i = 0; i < lista.length; i++) {
                if (i == 0 && j == 0) {
                    menor = lista[i];

                }
                if (lista[i] < menor) {
                    menor = lista[i];

                }
            }
            if (i == lista.length) {
                listaReserva[j] = menor;
            }
        }
    }

    static void mostrarLista() {
        for (int i = 0; i<listaReserva.length; i++){
            System.out.println (listaReserva[i] );
        }

    }

}


