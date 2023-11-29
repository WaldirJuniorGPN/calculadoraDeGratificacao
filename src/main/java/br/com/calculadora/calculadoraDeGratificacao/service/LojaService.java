package br.com.calculadora.calculadoraDeGratificacao.service;

import br.com.calculadora.calculadoraDeGratificacao.dto.request.DadosCadastroLoja;
import br.com.calculadora.calculadoraDeGratificacao.dto.response.DadosAtualizacaoLoja;
import br.com.calculadora.calculadoraDeGratificacao.dto.response.DadosDetalhamentoLoja;
import br.com.calculadora.calculadoraDeGratificacao.dto.response.DadosListagemLoja;
import br.com.calculadora.calculadoraDeGratificacao.model.Loja;
import br.com.calculadora.calculadoraDeGratificacao.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LojaService {

    @Autowired
    private LojaRepository repository;

    public DadosDetalhamentoLoja cadastrar(DadosCadastroLoja dados) {
        var loja = new Loja(dados);
        this.repository.save(loja);
        return new DadosDetalhamentoLoja(loja);
    }

    public Page<DadosListagemLoja> listarTodas(Pageable pageable) {
        var page = this.repository.findAllByAtivoTrue(pageable).map(DadosListagemLoja::new);
        return page;
    }

    public DadosDetalhamentoLoja buscarPorId(Long id) {
        var loja = this.repository.getReferenceById(id);
        return new DadosDetalhamentoLoja(loja);
    }

    public DadosDetalhamentoLoja atualizar(DadosAtualizacaoLoja dados) {
        var loja = this.repository.getReferenceById(dados.id());
        loja.atualizarDados(dados);
        return new DadosDetalhamentoLoja(loja);
    }

    public void deletar(Long id) {
        var loja = this.repository.getReferenceById(id);
        loja.desativar();
    }
}
