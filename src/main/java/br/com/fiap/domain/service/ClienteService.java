package br.com.fiap.domain.service;

import br.com.fiap.domain.entity.Cliente;
import br.com.fiap.domain.repository.ClienteRepository;

import java.util.List;

public class ClienteService implements Service<Cliente, Long> {

    private ClienteRepository repo  = ClienteRepository.build();
    @Override
    public List<Cliente> findAll() {
        return repo.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Cliente persiste(Cliente cliente) {
        return repo.persist(cliente);
    }
}
