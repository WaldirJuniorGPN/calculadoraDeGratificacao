package br.com.calculadora.calculadoraDeGratificacao.dto.request;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroLoja(
        @NotBlank
        String nome
) {
}
