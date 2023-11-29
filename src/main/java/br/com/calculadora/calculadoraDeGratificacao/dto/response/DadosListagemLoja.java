package br.com.calculadora.calculadoraDeGratificacao.dto.response;

import br.com.calculadora.calculadoraDeGratificacao.model.Loja;

public record DadosListagemLoja(Long id, String nome, Double valor) {
    public DadosListagemLoja(Loja loja) {
        this(loja.getId(), loja.getNome(), loja.getVendasMes());
    }
}
