package br.com.calculadora.calculadoraDeGratificacao.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAtendente(
        @NotNull
        Long id,
        String nome,
        Double salario
) {
}
