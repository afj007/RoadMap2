import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    private String apelido, senha;
    private Pessoa pessoa = new Pessoa();
    private Scanner ler = new Scanner(System.in);
    private ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();


    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getApelido() {
        return apelido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void cadastrarPessoa() {
        System.out.println("Digite o nome: ");
        pessoa.setNome(ler.next());

        System.out.println("Digite o telefone:");
        pessoa.setTelefone(ler.next());

        System.out.println("Digite o Email:");
        pessoa.setEmail(ler.next());

        listaPessoas.add(pessoa);
    }

    public void pesquisarUsuario() {
        System.out.println("\n1 - Nome:\n2 - Telefone:\n3 - Email:");
        String opcao = ler.next();
        String nome, telefone, email;
        boolean existePessoa = false;
        int numeroPessoasEncontrada = 0;
        for (int i = 0; i < listaPessoas.size(); i++) {
            switch (opcao) {

                case "1":
                    System.out.println("Digite o nome dele(a)");
                    nome = ler.next();
                    if (nome.equals(listaPessoas.get(i).getNome())) existePessoa = true;
                    break;
                case "2":
                    System.out.println("Digite o telefone dele(a):");
                    telefone = ler.next();
                    if (telefone.equals(listaPessoas.get(i).getNome())) existePessoa = true;
                    break;
                case "3":
                    System.out.println("Digite o email dele(a)");
                    email = ler.next();
                    if (email.equals(listaPessoas.get(i).getNome())) existePessoa = true;
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }

            if (existePessoa) {
                numeroPessoasEncontrada++;
                System.out.println("Achamos" + numeroPessoasEncontrada + " pessoa(s):");
                System.out.println("Nome: " + listaPessoas.get(i).getNome());
                System.out.println("Telefone: " + listaPessoas.get(i).getTelefone());
                System.out.println("Email: " + listaPessoas.get(i).getTelefone());
            }
            if (numeroPessoasEncontrada == 0) {
                System.out.println("Achamos nenhuma Pessoa");
            }

        }

    }
}
