package Ordenacao;

public class Ordenacao {
    private static SelecionSort selecionSort = new SelecionSort ( );
    private static  BubbleSort bubbleSort = new BubbleSort();
    private static int lista[] = {100, 40, 6, 25, 78, 18, 93, 110, 55, 23};;

    public static void main(String[] args) {
//        selecionSort.ordernarValores (lista,0);
//        selecionSort.mostrarLista ();

        bubbleSort.ordernarValores(lista);
//        bubbleSort.mostrarValores();


    }
}
