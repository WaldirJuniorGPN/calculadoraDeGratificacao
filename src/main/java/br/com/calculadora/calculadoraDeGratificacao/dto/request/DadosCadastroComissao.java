package br.com.calculadora.calculadoraDeGratificacao.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosCadastroComissao(
        @NotNull
        @Positive
        Double percentualPrimeiroColocado,
        @NotNull
        @Positive
        Double percentualSegundoColocado,
        @NotNull
        @Positive
        Double percentualTerceiroColocado,
        @NotNull
        @Positive
        Double percentualDemaisColocados
) {
}
