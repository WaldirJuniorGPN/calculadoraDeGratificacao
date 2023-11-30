package br.com.calculadora.calculadoraDeGratificacao.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosAtualizacaoComissao(
        @NotNull
        Long id,
        @Positive
        Double percentualPrimeiroColocado,
        @Positive
        Double percentualSegundoColocado,
        @Positive
        Double percentualTerceiroColocado,
        @Positive
        Double percentualDemaisColocados
) {
}
