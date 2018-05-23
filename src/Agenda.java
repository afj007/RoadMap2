import java.util.Scanner;

public class Agenda {
    String deseja;
    Usuario usuario = new Usuario();
    Scanner ler = new Scanner(System.in);

    public void main(String[] args) {
        CadastrarUsuario();
    }

    private void CadastrarUsuario() {
        while (deseja.equalsIgnoreCase("S")) {
            if () {
                for (Object o : ) {
                    if () {
                        if () {
                            for (Object o1 : ) {

                            }
                        }
                    }
                }
            }

            System.out.println("Digite o apelido do usuario: ");
            usuario.setApelido(ler.next());

            System.out.println("Digite uma senha: ");
            usuario.setSenha(ler.next());
        }


    }

    public void EntrarNaAgenda() {
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o apelido de usuario: ");
        String apelido = ler.next();

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
                usuario.CadatroPessoa(nome, telefone, email);

            } else {
                System.out.println("Deseja pesquisar por uma pessoa?");
                deseja = ler.next();
            }
        }

    }
}
