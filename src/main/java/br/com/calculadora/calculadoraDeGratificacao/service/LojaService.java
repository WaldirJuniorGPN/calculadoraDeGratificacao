package br.com.calculadora.calculadoraDeGratificacao.service;

import br.com.calculadora.calculadoraDeGratificacao.dto.request.DadosCadastroLoja;
import br.com.calculadora.calculadoraDeGratificacao.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LojaService {

    @Autowired
    private LojaRepository repository;

    public DadosDetalhamentoLoja cadastrar(DadosCadastroLoja dados) {

    }
}
