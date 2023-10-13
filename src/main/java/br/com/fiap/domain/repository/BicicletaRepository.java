package br.com.fiap.domain.repository;

import br.com.fiap.domain.entity.Bicicleta;

import java.util.List;

public class BicicletaRepository implements Repository<Bicicleta, Long> {
    @Override
    public Bicicleta persist(Bicicleta bicicleta) {
        return null;
    }

    @Override
    public List<Bicicleta> findAll() {
        return null;
    }

    @Override
    public Bicicleta findById(Long aLong) {
        return null;
    }

    @Override
    public Bicicleta update(Bicicleta bicicleta) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
