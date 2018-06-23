package Agenda;

import java.util.List;

class Usuario {
    private String apelido;
    private String senha;
    private List<Pessoa> contatos;

    void setApelido(String apelido) {
        this.apelido = apelido;
    }

    String getApelido() {
        return apelido;
    }

    String getSenha() {
        return senha;
    }

    void setSenha(String senha) {
        this.senha = senha;
    }


    public List<Pessoa> getContatos() {
        return contatos;
    }

    public void setContatos(List<Pessoa> contatos) {
        this.contatos = contatos;
    }
}
