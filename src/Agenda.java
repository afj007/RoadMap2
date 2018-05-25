import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
    private static String deseja;
    private static Usuario usuario = new Usuario();
    private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

    Scanner ler = new Scanner(System.in);

    public void main(String[] args) {
        System.out.println("Já é cadastrado ? S / N");
        deseja = ler.next();

        if (deseja.equalsIgnoreCase("S")) {
            entrarNaAgenda();
        } else {
            System.out.println("Deseja cadastrar um usuário? S / N");
            deseja = ler.next();
            if (deseja.equalsIgnoreCase("s")) {
                cadastrarUsuario();
                entrarNaAgenda();
            } else {
                System.out.println("Finalizar Sistema..........");
            }

        }
    }

    private void cadastrarUsuario() {
        String repetir = "S";
        while (repetir.equalsIgnoreCase("s")) {
            System.out.println("Digite um apelido de usuário: ");
            usuario.setApelido(ler.next());

            System.out.println("Digite um senha");
            usuario.setSenha(ler.next());

            listaUsuarios.add(usuario);
            System.out.println("Deseja cadastrar mais um usuário? S / N");
            repetir = ler.next();
        }

    }

    private void entrarNaAgenda() {
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o apelido de usuario: ");
        String apelido = ler.next();
        for (int i = 0; i <= listaUsuarios.size(); i++) {

            if (apelido.equals(listaUsuarios.get(i).getSenha())) {
                System.out.println("Digite a senha: ");
                String senha = ler.next();
                if (senha.equals(listaUsuarios.get(i).getSenha())) {
                    usuario.cadastrarPessoa();
                } else {
                    System.out.println("Digite novamete: ");
                }

            }
        }

        if (apelido.equals(usuario.getApelido())) {
            System.out.println("Deseja cadastrar uma pessoa na agenda, S/N? ");
            String respota = ler.next();

            if (respota.equals("S") || respota.equals("s")) {
                String nome, telefone, email;
                System.out.println("Digite o nome da Pessoa: ");
                nome = ler.next();
                System.out.println("Digite o telefone: ");
                telefone = ler.next();
                System.out.println("Digite o email: ");
                email = ler.next();

            } else {
                System.out.println("Deseja pesquisar por uma pessoa?");
                deseja = ler.next();
            }
        }

    }
}
