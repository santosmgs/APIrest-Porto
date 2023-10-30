package br.com.fiap.domain.repository;

import br.com.fiap.domain.entity.Bicicleta;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class BicicletaRepository implements Repository<Bicicleta, Long> {

    private static final AtomicReference<BicicletaRepository> instance = new AtomicReference<>();

    private BicicletaRepository() {
    }

    public static BicicletaRepository build() {
        BicicletaRepository result = instance.get();
        if (Objects.isNull( result )) {
            BicicletaRepository repo = new BicicletaRepository();
            if (instance.compareAndSet( null, repo )) {
                result = repo;
            } else {
                result = instance.get();
            }
        }
        return result;
    }
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
