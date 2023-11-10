package br.com.fiap.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Cliente {

    private Long id;

    private String nome;

    private String endereco;

    private String cpf;

}


