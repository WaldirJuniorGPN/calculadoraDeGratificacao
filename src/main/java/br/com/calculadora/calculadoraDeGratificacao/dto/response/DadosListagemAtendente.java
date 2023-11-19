package br.com.calculadora.calculadoraDeGratificacao.dto.response;

import br.com.calculadora.calculadoraDeGratificacao.model.Atendente;

public record DadosListagemAtendente(Long id, String nome) {
    public DadosListagemAtendente(Atendente atendente) {
        this(atendente.getId(), atendente.getNome());
    }
}
