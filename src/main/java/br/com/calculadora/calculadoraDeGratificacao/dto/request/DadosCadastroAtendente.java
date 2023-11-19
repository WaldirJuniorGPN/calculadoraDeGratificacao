package br.com.calculadora.calculadoraDeGratificacao.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAtendente(
        @NotBlank
        String nome,
        @NotNull
        double salario
) {
}
