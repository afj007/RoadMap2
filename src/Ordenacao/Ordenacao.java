package Ordenacao;

import java.util.*;

public class Ordenacao {
    private static SelecionSort selecionSort = new SelecionSort ( );
    private static  BubbleSort bubbleSort = new BubbleSort();
    private static int lista[] = {100, 40, 6, 25, 78, 18, 93, 110, 55, 23};;

    public static void main(String[] args) {
        gerarListaRandom();
//        selecionSort.ordernarValores(lista,0);

    }

    private static void gerarListaRandom(){
        int lista[] = new int[100];
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            lista[i] = r.nextInt(101);
        }

        BubbleSort.ordernarValores(lista);
    }
}
