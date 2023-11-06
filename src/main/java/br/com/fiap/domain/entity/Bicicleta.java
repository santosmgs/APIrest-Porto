package br.com.fiap.domain.entity;

public class Bicicleta {

    private Long id;

    private String nome;

    private Cliente dono;

    public Bicicleta() {
    }

    public Bicicleta(Long id, String nome, Cliente dono) {
        this.setId(id);
        this.setNome(nome);
        this.setDono(dono);
    }


    public Long getId() {
        return id;
    }

    public Bicicleta setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Bicicleta setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Cliente getDono() {
        return dono;
    }

    public Bicicleta setDono(Cliente dono) {
        this.dono = dono;
        return this;
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dono=" + dono +
                '}';
    }
}