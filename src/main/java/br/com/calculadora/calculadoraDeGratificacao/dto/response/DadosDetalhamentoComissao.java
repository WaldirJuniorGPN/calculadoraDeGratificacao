package br.com.calculadora.calculadoraDeGratificacao.dto.response;

import br.com.calculadora.calculadoraDeGratificacao.model.Comissao;

public record DadosDetalhamentoComissao(Long id, Double percentualPrimeiroColocado, Double percentualSegundoColocado,
                                        Double percentualTerceiroColocado, Double percentualDemaisColocados) {
    public DadosDetalhamentoComissao(Comissao comissao) {
        this(comissao.getId(), comissao.getPercentualPrimieroColocado(), comissao.getPercentualSegundoColocado(), comissao.getPercentualTerceiroColocado(), comissao.getPercentualDemaisColocados());
    }
}
