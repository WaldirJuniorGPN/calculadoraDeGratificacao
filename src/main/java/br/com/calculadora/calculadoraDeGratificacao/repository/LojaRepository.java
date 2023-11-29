package br.com.calculadora.calculadoraDeGratificacao.repository;

import br.com.calculadora.calculadoraDeGratificacao.dto.response.DadosListagemLoja;
import br.com.calculadora.calculadoraDeGratificacao.model.Loja;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LojaRepository extends JpaRepository<Loja, Long> {
    Page<Loja> findAllByAtivoTrue(Pageable pageable);
}
