package br.com.calculadora.calculadoraDeGratificacao.controller;

import br.com.calculadora.calculadoraDeGratificacao.dto.request.DadosAtualizacaoAtendente;
import br.com.calculadora.calculadoraDeGratificacao.dto.request.DadosCadastroAtendente;
import br.com.calculadora.calculadoraDeGratificacao.dto.response.DadosDetalhamentoAtendente;
import br.com.calculadora.calculadoraDeGratificacao.dto.response.DadosListagemAtendente;
import br.com.calculadora.calculadoraDeGratificacao.model.Atendente;
import br.com.calculadora.calculadoraDeGratificacao.repository.AtendenteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("atendente")
public class AtendenteController {

    @Autowired
    private AtendenteRepository atendenteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAtendente dados, UriComponentsBuilder uriComponentsBuilder) {
        var atendente = new Atendente(dados);
        var uri = uriComponentsBuilder.path("atendente/{id}").buildAndExpand(atendente.getId()).toUri();
        this.atendenteRepository.save(atendente);
        return ResponseEntity.ok(new DadosDetalhamentoAtendente(atendente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAtendente>> listar(Pageable paginacao) {
        var page = this.atendenteRepository.findAllByAtivoTrue(paginacao).map(DadosListagemAtendente::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoAtendente dados) {
        var atendente = this.atendenteRepository.getReferenceById(dados.id());
        atendente.atualizarDados(dados);
        return ResponseEntity.ok(new DadosDetalhamentoAtendente(atendente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        var atendente = this.atendenteRepository.getReferenceById(id);
        atendente.desativar();
        return ResponseEntity.noContent().build();
    }
}
