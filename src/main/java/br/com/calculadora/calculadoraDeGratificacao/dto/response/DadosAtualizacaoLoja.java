package br.com.calculadora.calculadoraDeGratificacao.dto.response;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoLoja(
        @NotNull
        Long id,
        String nome
) {
}
