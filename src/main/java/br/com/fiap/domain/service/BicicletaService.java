package br.com.fiap.domain.service;

import br.com.fiap.domain.entity.Bicicleta;
import br.com.fiap.domain.repository.BicicletaRepository;

import java.util.List;

public class BicicletaService implements Service<Bicicleta, Long> {

    private BicicletaRepository repo = BicicletaRepository.build();]
    @Override
    public List<Bicicleta> findAll() {
        return repo.findAll();
    }

    @Override
    public Bicicleta findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Bicicleta persiste(Bicicleta bicicleta) {
        return repo.persist(bicicleta);
    }
}
