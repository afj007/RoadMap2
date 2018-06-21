package Agenda;

import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
    private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario> ( );
    private static ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa> ( );

    private static Scanner ler = new Scanner (System.in);

    public static void main(String[] args) {
        acessarAgenda ( );
    }

    private static void acessarAgenda() {

        String deseja;
        System.out.println ("Já é cadastrado ? S / N");
        deseja = ler.next ( );

        if (deseja.equalsIgnoreCase ("S")) {
            entrarNaAgenda ( );
        } else if (deseja.equalsIgnoreCase ("n")) {
            System.out.println ("Deseja cadastrar um usuário? S / N");
            deseja = ler.next ( );

            if (deseja.equalsIgnoreCase ("s")) {
                cadastrarUsuario ( );
                entrarNaAgenda ( );
            } else if (deseja.equalsIgnoreCase ("n")) {
                System.out.println ("Finalizar Sistema..........");
            } else {
                System.out.println ("Opção invalida.");
                acessarAgenda ( );
            }
        } else {
            System.out.println ("Opção invalida.");
            acessarAgenda ( );
        }
    }

    private static void cadastrarUsuario() {
        String repetir = "S";
        while (repetir.equalsIgnoreCase ("s")) {
            System.out.println ("Digite um apelido de usuário: ");
            Usuario usuario = new Usuario ( );
            usuario.setApelido (ler.next ( ));

            System.out.println ("Digite um senha");
            usuario.setSenha (ler.next ( ));

            listaUsuarios.add (usuario);
            System.out.println ("Deseja cadastrar mais um usuário? S / N");
            repetir = ler.next ( );
        }

    }

    private static void entrarNaAgenda() {
        Usuario usuario = new Usuario ( );
        String deseja;
        System.out.println ("Digite o apelido de usuario: ");
        String apelido = ler.next ( );
        String senha;
        int chance = 0;
        for (int i = 0; i < listaUsuarios.size ( ); i++) {
            if (apelido.equals (listaUsuarios.get (i).getApelido ( ))) {
                while (chance < 3) {

                    System.out.println ("Digite a senha: ");
                    senha = ler.next ( );

                    if (senha.equals (listaUsuarios.get (i).getSenha ( ))) {
                        menuAgenda ( );
                        break;
                    } else {
                        System.out.println ("Senha invalida");
                        chance++;
                    }
                    if (chance == 3) System.out.println ("Tentaivas excedidas!!!");
                }
            } else {
                System.out.println ("Acesso invalido");
            }
        }
        menuAgenda ( );


    }

    private static void menuAgenda() {
        System.out.println ("Escolha alguma das opções\n\n1 - Cadastrar Pessoa\n2 - Pesquisar Pessoa\n3 - Cadastrar um novo usuário\n4 - Sair do sistema");
        String opcao = ler.next ( );
        switch (opcao) {
            case "1":
                cadastrarPessoa ( );
            case "2":
                pesquisarPessoa ( );
            case "3":
                cadastrarUsuario ( );
            case "4":
                System.out.println ("Finalizando sistema...............");
            default:
                System.out.println ("Opção invalida");
                menuAgenda ( );
        }
    }

    private static void pesquisarPessoa() {
        Pessoa pessoa = new Pessoa ( );
        System.out.println ("\n1 - Nome:\n2 - Telefone:\n3 - Email:\n4 - Qualquer conteudo");
        String opcao = ler.next ( );
        String nome, telefone, email;

        boolean existePessoa = false;
        int numeroPessoasEncontrada = 0;
        switch (opcao) {

            case "1":
                System.out.println ("Digite o nome dele(a)");
                nome = ler.next ( );
                pessoa = pesquisarPorNome (nome);
                if (pessoa != null) existePessoa = true;
                break;
            case "2":
                System.out.println ("Digite o telefone dele(a):");
                telefone = ler.next ( );
                pessoa = pesquisarPorTelefone (telefone);
                if (pessoa != null) existePessoa = true;
                break;
            case "3":
                System.out.println ("Digite o email dele(a)");
                email = ler.next ( );
                pessoa = pesquisarPorEmail (email);
                if (pessoa != null) existePessoa = true;
                break;
            case "4":
                System.out.println ("Digite o que deseja encontrar");
                String conteudo = ler.next ( );
                pessoa = pesquisarPorTudo (conteudo );
                if (pessoa != null)existePessoa = true;
                break;
            default:
                System.out.println ("Opção invalida");
                break;
        }

        if (existePessoa) {
            numeroPessoasEncontrada++;
            System.out.println ("Achamos " + numeroPessoasEncontrada + " pessoa(s):");
            System.out.println ("Nome: " + pessoa.getNome ( ));
            System.out.println ("Telefone: " + pessoa.getTelefone ( ));
            System.out.println ("Email: " + pessoa.getEmail ( ));

        }

        if (numeroPessoasEncontrada == 0) {
            System.out.println ("Achamos nenhuma Pessoa na Agenda");
        }
        menuAgenda ( );

    }

    private static Pessoa pesquisarPorNome(String nome) {
        Pessoa pessoa;
        for (int i = 0; i < listaPessoas.size ( ); i++) {
            pessoa = listaPessoas.get (i);
            if (pessoa.getNome ( ).toLowerCase ().contains (nome.toLowerCase ())) {
                return pessoa;
            }
        }
        return null;
    }

    private static Pessoa pesquisarPorTelefone(String telefone) {
        Pessoa pessoa;
        for (int i = 0; i < listaPessoas.size ( ); i++) {
            pessoa = listaPessoas.get (i);
            if (telefone.equals (pessoa.getTelefone ( ))) {
                return pessoa;
            }
        }
        return null;
    }

    private static Pessoa pesquisarPorEmail(String email) {
        Pessoa pessoa;
        for (int i = 0; i < listaPessoas.size ( ); i++) {
            pessoa = listaPessoas.get (i);
            if (pessoa.getNome ().contains (email)) {
                return pessoa;
            }
        }
        return null;
    }

    private static Pessoa pesquisarPorTudo(String conteudo) {
        Pessoa pessoaPorNome = pesquisarPorNome (conteudo);
        if (pessoaPorNome == null) {
            Pessoa pessoaPorEmail = pesquisarPorEmail (conteudo);
            if (pessoaPorEmail == null){
                System.out.println ("Não achamos ninguém com essa informação" );
                pesquisarPessoa ();
            }else {
                return pessoaPorEmail;
            }
        }else {
            return pessoaPorNome;
        }
        return null;
    }

    private static void cadastrarPessoa() {
        Pessoa pessoa = new Pessoa ( );
        System.out.println ("Digite o nome: ");
        pessoa.setNome (ler.next ( ));

        System.out.println ("Digite o telefone:");
        pessoa.setTelefone (ler.next ( ));

        System.out.println ("Digite o Email:");
        pessoa.setEmail (ler.next ( ));

        listaPessoas.add (pessoa);
        boolean tentativa = true;
        while (tentativa) {
            System.out.println ("Deseja cadastrar mais uma pessoa? S / N");
            String deseja = ler.next ( );

            if (deseja.equalsIgnoreCase ("s")) {
                cadastrarPessoa ( );
            }
            if (deseja.equalsIgnoreCase ("n")) {
                menuAgenda ( );
                tentativa = false;
            } else {
                System.out.println ("Opção invalida");
                tentativa = true;
            }
        }

    }

}




