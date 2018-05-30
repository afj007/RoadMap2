package Agenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenda {
    private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
    private static ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();

    private static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        String deseja;
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

    private static void cadastrarUsuario() {
        String repetir = "S";
        while (repetir.equalsIgnoreCase("s")) {
            System.out.println("Digite um apelido de usuário: ");
            Usuario usuario = new Usuario();
            usuario.setApelido(ler.next());

            System.out.println("Digite um senha");
            usuario.setSenha(ler.next());

            listaUsuarios.add(usuario);
            System.out.println("Deseja cadastrar mais um usuário? S / N");
            repetir = ler.next();
        }

    }

    private static void entrarNaAgenda() {
        Usuario usuario = new Usuario();
        String deseja;
        System.out.println("Digite o apelido de usuario: ");
        String apelido = ler.next();
        for (int i = 0; i < listaUsuarios.size(); i++) {
            String senha = "";
            while (senha.equals(listaUsuarios.get(i).getSenha())) {
                if (apelido.equals(listaUsuarios.get(i).getSenha())) {
                    System.out.println("Digite a senha: ");
                    senha = ler.next();
                    if (senha.equals(listaUsuarios.get(i).getSenha())) {
                        System.out.println("Cadastrar Pessoa? S / N");
                        deseja = ler.next();
                        if (deseja.equalsIgnoreCase("s")) cadastrarPessoa();
                        break;
                    } else {
                        System.out.println("Digite novamete: ");
                    }
                }
            }
        }

        /*if (apelido.equals(usuario.getApelido())) {
            System.out.println("Deseja cadastrar uma pessoa na agenda, S/N? ");
            String respota = ler.next();

            if (respota.equals("S") || respota.equals("s")) {
                String nome, telefone, email;
                System.out.println("Digite o nome da Agenda.Pessoa: ");
                nome = ler.next();
                System.out.println("Digite o telefone: ");
                telefone = ler.next();
                System.out.println("Digite o email: ");
                email = ler.next();
            }*/

        System.out.println("Deseja pesquisar por uma pessoa?");
        deseja = ler.next();
        if (deseja.equalsIgnoreCase("S")) {

            pesquisarUsuario();
        }

        System.out.println("Deseja finalizar sistema de agenda? S / N");
        deseja = ler.next();

        if (deseja.equalsIgnoreCase("s")) {
            System.out.println("FINALIZANDO SISTEMA......");
        }
        if (deseja.equalsIgnoreCase("n")) {
            System.out.println("O que deseja fazer?\n1 - Cadastrar Agenda.Pessoa?\n2 - Pesquisar Agenda.Pessoa?");
            String opcao = ler.next();
            switch (opcao) {
                case "1":
                    cadastrarPessoa();
                    break;
                case "2":
                    pesquisarUsuario();
            }
        }

    }


    private static void cadastrarPessoa() {
        Pessoa pessoa = new Pessoa();
        System.out.println("Digite o nome: ");
        pessoa.setNome(ler.next());

        System.out.println("Digite o telefone:");
        pessoa.setTelefone(ler.next());

        System.out.println("Digite o Email:");
        pessoa.setEmail(ler.next());

        listaPessoas.add(pessoa);
    }

    private static void pesquisarUsuario() {
        System.out.println("\n1 - Nome:\n2 - Telefone:\n3 - Email:");
        String opcao = ler.next();
        String nome, telefone, email;
        boolean existePessoa = false;
        int numeroPessoasEncontrada = 0;
        for (Pessoa listaPessoa : listaPessoas) {
            switch (opcao) {

                case "1":
                    System.out.println("Digite o nome dele(a)");
                    nome = ler.next();
                    if (nome.equals(listaPessoa.getNome())) existePessoa = true;
                    break;
                case "2":
                    System.out.println("Digite o telefone dele(a):");
                    telefone = ler.next();
                    if (telefone.equals(listaPessoa.getNome())) existePessoa = true;
                    break;
                case "3":
                    System.out.println("Digite o email dele(a)");
                    email = ler.next();
                    if (email.equals(listaPessoa.getEmail())) existePessoa = true;
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }

            if (existePessoa) {
                numeroPessoasEncontrada++;
                System.out.println("Achamos" + numeroPessoasEncontrada + " pessoa(s):");
                System.out.println("Nome: " + listaPessoa.getNome());
                System.out.println("Telefone: " + listaPessoa.getTelefone());
                System.out.println("Email: " + listaPessoa.getTelefone());
            }
            if (numeroPessoasEncontrada == 0) {
                System.out.println("Achamos nenhuma Agenda.Pessoa");
            }

        }

    }

}
