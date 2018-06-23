package Agenda;

import java.util.ArrayList;
import java.util.Scanner;

import static Agenda.PesquisarPessoa.pesquisarPessoa;

public class Agenda {
    private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario> ( );
    static ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa> ( );
    static Scanner ler = new Scanner (System.in);

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
                //entrarNaAgenda ( );
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
            Usuario usuario = new Usuario ( );
            System.out.println ("Digite um apelido de usuário: ");
            usuario.setApelido (ler.next ( ));

            System.out.println ("Digite um senha");
            usuario.setSenha (ler.next ( ));

            listaUsuarios.add (usuario);
            System.out.println ("Deseja cadastrar mais um usuário? S / N");
            repetir = ler.next ( );
        }
        entrarNaAgenda ( );
    }

    private static void entrarNaAgenda() {
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
            }
            if (i == listaUsuarios.size ( )) {
                System.out.println ("Usuário invalido");
                entrarNaAgenda ( );
            }
        }

    }

    static void menuAgenda() {
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




