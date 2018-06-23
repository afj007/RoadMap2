package Agenda;

class Pessoa extends Usuario {
    String nome, telefone,email;

    Pessoa() {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    String getNome() {
        return nome;
    }

    void setNome(String nome) {
        this.nome = nome;
    }

    String getTelefone() {
        return telefone;
    }

    void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

}
