package br.com.calculadora.calculadoraDeGratificacao.controller;

import br.com.calculadora.calculadoraDeGratificacao.dto.request.DadosAtualizacaoAtendente;
import br.com.calculadora.calculadoraDeGratificacao.dto.request.DadosCadastroAtendente;
import br.com.calculadora.calculadoraDeGratificacao.dto.response.DadosListagemAtendente;
import br.com.calculadora.calculadoraDeGratificacao.service.AtendenteService;
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
    private AtendenteService atendenteService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAtendente dados, UriComponentsBuilder uriComponentsBuilder) {
        var atendenteDto = this.atendenteService.cadastrar(dados);
        var uri = uriComponentsBuilder.path("atendente/{id}").buildAndExpand(atendenteDto.id()).toUri();
        return ResponseEntity.ok(atendenteDto);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAtendente>> listar(Pageable paginacao) {
        var page = this.atendenteService.listarTodos(paginacao);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        var atendenteDto = this.atendenteService.buscarPorId(id);
        return ResponseEntity.ok(atendenteDto);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoAtendente dados) {
        var atendenteDto = this.atendenteService.atualizar(dados);
        return ResponseEntity.ok(atendenteDto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        this.atendenteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
