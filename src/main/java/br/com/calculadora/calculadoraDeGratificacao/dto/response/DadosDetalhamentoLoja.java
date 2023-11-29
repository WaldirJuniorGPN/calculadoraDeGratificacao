package br.com.calculadora.calculadoraDeGratificacao.dto.response;

import br.com.calculadora.calculadoraDeGratificacao.model.Loja;

public record DadosDetalhamentoLoja(Long id, String nome, Double vendasMes) {
    public DadosDetalhamentoLoja(Loja loja) {
        this(loja.getId(), loja.getNome(), loja.getVendasMes());
    }
}
