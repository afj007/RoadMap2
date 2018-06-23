package Agenda;

public class PesquisarPessoa extends Agenda {

    static void pesquisarPessoa() {
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
                pessoa = pesquisarPorTudo (conteudo);
                if (pessoa != null) existePessoa = true;
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
            if (pessoa.getNome ( ).toLowerCase ( ).contains (nome.toLowerCase ( ))) {
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
            if (pessoa.getNome ( ).contains (email)) {
                return pessoa;
            }
        }
        return null;
    }

    private static Pessoa pesquisarPorTudo(String conteudo) {
        Pessoa pessoaPorNome = pesquisarPorNome (conteudo);
        if (pessoaPorNome == null) {
            Pessoa pessoaPorEmail = pesquisarPorEmail (conteudo);
            if (pessoaPorEmail == null) {
                System.out.println ("Não achamos ninguém com essa informação");
                pesquisarPessoa ( );
            } else {
                return pessoaPorEmail;
            }
        } else {
            return pessoaPorNome;
        }
        return null;
    }

}
