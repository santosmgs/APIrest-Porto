package br.com.fiap.domain.entity;

public class Bicicleta {

    private Long id;

    private String tipo;

    public Bicicleta() {
    }

    public Bicicleta(Long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public Bicicleta setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public Bicicleta setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
