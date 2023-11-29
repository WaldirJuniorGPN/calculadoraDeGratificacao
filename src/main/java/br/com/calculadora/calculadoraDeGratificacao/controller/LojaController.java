package br.com.calculadora.calculadoraDeGratificacao.controller;

import br.com.calculadora.calculadoraDeGratificacao.dto.request.DadosCadastroAtendente;
import br.com.calculadora.calculadoraDeGratificacao.dto.request.DadosCadastroLoja;
import br.com.calculadora.calculadoraDeGratificacao.dto.response.DadosAtualizacaoLoja;
import br.com.calculadora.calculadoraDeGratificacao.dto.response.DadosDetalhamentoLoja;
import br.com.calculadora.calculadoraDeGratificacao.dto.response.DadosListagemLoja;
import br.com.calculadora.calculadoraDeGratificacao.service.LojaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("loja")
public class LojaController {

    @Autowired
    private LojaService lojaService;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoLoja> cadastrar(@RequestBody @Valid DadosCadastroLoja dados, UriComponentsBuilder uriComponentsBuilder) {
        var lojaDto = this.lojaService.cadastrar(dados);
        var uri = uriComponentsBuilder.path("/loja/{id}").buildAndExpand(lojaDto.id()).toUri();
        return ResponseEntity.created(uri).body(lojaDto);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemLoja>> listarTodas(Pageable paginacao) {
        var page = this.lojaService.listarTodas(paginacao);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoLoja> buscarPorId(@PathVariable Long id) {
        var lojaDto = this.lojaService.buscarPorId(id);
        return ResponseEntity.ok(lojaDto);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoLoja> atualizar(@RequestBody @Valid DadosAtualizacaoLoja dados) {
        var lojaDto = this.lojaService.atualizar(dados);
        return ResponseEntity.ok(lojaDto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        this.lojaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
