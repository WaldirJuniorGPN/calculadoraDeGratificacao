package br.com.calculadora.calculadoraDeGratificacao.service;

import br.com.calculadora.calculadoraDeGratificacao.dto.request.DadosAtualizacaoComissao;
import br.com.calculadora.calculadoraDeGratificacao.dto.request.DadosCadastroComissao;
import br.com.calculadora.calculadoraDeGratificacao.dto.response.DadosDetalhamentoComissao;
import br.com.calculadora.calculadoraDeGratificacao.dto.response.DadosListagemComissao;
import br.com.calculadora.calculadoraDeGratificacao.model.Comissao;
import br.com.calculadora.calculadoraDeGratificacao.repository.ComissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ComissaoService {

    @Autowired
    private ComissaoRepository repository;

    public DadosDetalhamentoComissao cadastrar(DadosCadastroComissao dados) {
        var comissao = new Comissao(dados);
        this.repository.save(comissao);
        return new DadosDetalhamentoComissao(comissao);
    }

    public Page<DadosListagemComissao> listarTodos(Pageable paginacao) {
        var page = this.repository.findAll(paginacao).map(DadosListagemComissao::new);
        return page;
    }

    public DadosDetalhamentoComissao buscarPorid(Long id) {
        var comissao = this.repository.getReferenceById(id);
        return new DadosDetalhamentoComissao(comissao);
    }

    public DadosDetalhamentoComissao atualizar(DadosAtualizacaoComissao dados) {
        var comissao = this.repository.getReferenceById(dados.id());
        comissao.atualizarDados(dados);
        return new DadosDetalhamentoComissao(comissao);
    }

    public void deletar(Long id) {
        this.repository.deleteById(id);
    }
}
