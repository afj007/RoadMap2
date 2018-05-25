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

    public void pesquisarUsuario(String opcao){
        for (int i = 0; i < listaPessoas.size();i++){
            switch (opcao){

                case "1":
                    System.out.println("Digite o nome dele");

            }
        }
    }


}
