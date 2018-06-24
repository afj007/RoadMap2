package Ordenacao;

public class Ordenacao {
    private static SelecionSort selecionSort = new SelecionSort ( );

    public static void main(String[] args) {
        selecionSort.ordernarValores ();
        selecionSort.mostrarLista ();
    }
}
