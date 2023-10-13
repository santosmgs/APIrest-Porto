package br.com.fiap.domain.entity;

public class Bicicleta {

    private Long id;

    private String tipo;

    private Cliente dono;

    public Bicicleta() {
    }

    public Bicicleta(Long id, String tipo, Cliente dono) {
        this.setId(id);
        this.setTipo(tipo);
        this.setDono(dono);
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
                ", tipo='" + tipo + '\'' +
                ", dono=" + dono +
                '}';
    }
}