public class Usuario {
    String apelido, senha;


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


    public void CadatroPessoa(String nome, String telefone,String email) {

        new Pessoa(nome,telefone,email);
    }
}
