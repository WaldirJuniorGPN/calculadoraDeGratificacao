package br.com.calculadora.calculadoraDeGratificacao.dto.response;

import br.com.calculadora.calculadoraDeGratificacao.model.Atendente;

public record DadosDetalhamentoAtendente(Long id, String nome, double salario) {
    public DadosDetalhamentoAtendente(Atendente atendente) {
        this(atendente.getId(), atendente.getNome(), atendente.getSalario());
    }
}
