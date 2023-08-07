package br.edu.scl.ifsp.ads.cadastro;


public class Formulario {
    private String nome;
    private String telefone;
    private String email;
    private boolean ingressarEmail;
    private String sexo;
    private String cidade;
    private String estado;

    public Formulario(String nome, String telefone, String email, boolean ingressarEmail, String sexo, String cidade, String estado) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.ingressarEmail = ingressarEmail;
        this.sexo = sexo;
        this.cidade = cidade;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
                "Telefone: " + telefone + "\n" +
                "Email: " + email + "\n" +
                "Ingressar na lista de emails? " + (ingressarEmail ? "Sim" : "Não") + "\n" +
                "Sexo: " + sexo + "\n" +
                "Cidade: " + cidade + "\n" +
                "Estado: " + estado;
    }
}
