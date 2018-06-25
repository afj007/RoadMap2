package Ordenacao;

import java.util.Scanner;

public class SelecionSort {
    private static Scanner ler = new Scanner(System.in);
    private static int lista[] = {100, 4, 6, 2, 7, 8, 9, 10, 55, 23};
    private static int listaReserva[] = new int[lista.length];

    static void ordernarValores(int lista[], int _posicao) {
        int menor = -1;
        int posicao = _posicao;

        for(int i = 0; i < lista.length;i++){
            if (i == 0){
                menor = lista[i];
                posicao = i;
                continue;
            }

            if(menor > lista[i]){
                int reserva = lista[posicao];
                lista[posicao] = lista[i];
                lista[i] = reserva;
            }
        }

        if(posicao <= lista.length){
            ordernarValores(lista,posicao);
        }else{
            mostrarLista(lista);
        }


    }

    static void mostrarLista(int lista[]) {
        for (int i = 0; i < listaReserva.length; i++) {
            System.out.println(listaReserva[i]);
        }

    }

}


