package br.com.calculadora.calculadoraDeGratificacao.controller;

import br.com.calculadora.calculadoraDeGratificacao.dto.request.DadosAtualizacaoComissao;
import br.com.calculadora.calculadoraDeGratificacao.dto.request.DadosCadastroComissao;
import br.com.calculadora.calculadoraDeGratificacao.dto.response.DadosDetalhamentoComissao;
import br.com.calculadora.calculadoraDeGratificacao.dto.response.DadosListagemComissao;
import br.com.calculadora.calculadoraDeGratificacao.service.ComissaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("comissao")
public class ComissaoController {

    @Autowired
    private ComissaoService comissaoService;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoComissao> cadastrar(@RequestBody @Valid DadosCadastroComissao dados, UriComponentsBuilder uriComponentsBuilder) {
        var comissaoDto = this.comissaoService.cadastrar(dados);
        var uri = uriComponentsBuilder.path("/comissao/{id}").buildAndExpand(comissaoDto.id()).toUri();
        return ResponseEntity.created(uri).body(comissaoDto);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemComissao>> listarTodos(Pageable paginacao) {
        var page = this.comissaoService.listarTodos(paginacao);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoComissao> buscarPorId(@PathVariable Long id) {
        var comissaoDto = this.comissaoService.buscarPorid(id);
        return ResponseEntity.ok(comissaoDto);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoComissao> atualizar(@RequestBody @Valid DadosAtualizacaoComissao dados) {
        var comissaoDto = this.comissaoService.atualizar(dados);
        return ResponseEntity.ok(comissaoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        this.comissaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
