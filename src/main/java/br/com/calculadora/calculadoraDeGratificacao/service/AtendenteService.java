package br.com.calculadora.calculadoraDeGratificacao.service;

import br.com.calculadora.calculadoraDeGratificacao.dto.request.DadosAtualizacaoAtendente;
import br.com.calculadora.calculadoraDeGratificacao.dto.request.DadosCadastroAtendente;
import br.com.calculadora.calculadoraDeGratificacao.dto.response.DadosDetalhamentoAtendente;
import br.com.calculadora.calculadoraDeGratificacao.dto.response.DadosListagemAtendente;
import br.com.calculadora.calculadoraDeGratificacao.model.Atendente;
import br.com.calculadora.calculadoraDeGratificacao.repository.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AtendenteService {

    @Autowired
    private AtendenteRepository repository;

    public DadosDetalhamentoAtendente cadastrar(DadosCadastroAtendente dados) {
        var atendente = new Atendente(dados);
        this.repository.save(atendente);
        return new DadosDetalhamentoAtendente(atendente);
    }

    public Page<DadosListagemAtendente> listarTodos(Pageable pageable) {
        var page = this.repository.findAllByAtivoTrue(pageable).map(DadosListagemAtendente::new);
        return page;
    }

    public DadosDetalhamentoAtendente buscarPorId(Long id) {
        var atendente = this.repository.getReferenceById(id);
        return new DadosDetalhamentoAtendente(atendente);
    }

    public DadosDetalhamentoAtendente atualizar(DadosAtualizacaoAtendente dados) {
        var atendente = this.repository.getReferenceById(dados.id());
        atendente.atualizarDados(dados);
        return new DadosDetalhamentoAtendente(atendente);
    }

    public void deletar(Long id) {
        var atendente = this.repository.getReferenceById(id);
        atendente.desativar();
    }
}
