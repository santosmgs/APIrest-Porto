package br.com.fiap.domain.entity;

public class Cliente {

    private Long id;

    private String nome;

    private String cpf;

    private String cnpj;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String cpf, String cnpj) {
        this.setId(id);
        this.setNome(nome);
        this.setCpf(cpf);
        this.setCnpj(cnpj);
    }


    public Long getId() {
        return id;
    }

    public Cliente setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Cliente setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Cliente setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Cliente setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}


