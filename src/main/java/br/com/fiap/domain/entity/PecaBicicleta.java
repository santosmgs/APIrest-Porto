package br.com.fiap.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class PecaBicicleta extends Bicicleta{

    private String guidao;

    private String selim;

    private String quadro;

    private String rodas;

}
