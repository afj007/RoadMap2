package Agenda;

import java.util.List;

public class Usuario {
    private String apelido;
    private String senha;
    private List<Pessoa> contatos;

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


    public List<Pessoa> getContatos() {
        return contatos;
    }

    public void setContatos(List<Pessoa> contatos) {
        this.contatos = contatos;
    }
}
