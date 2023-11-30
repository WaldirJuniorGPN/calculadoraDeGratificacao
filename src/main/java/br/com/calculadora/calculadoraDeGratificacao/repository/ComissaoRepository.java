package br.com.calculadora.calculadoraDeGratificacao.repository;

import br.com.calculadora.calculadoraDeGratificacao.model.Comissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComissaoRepository extends JpaRepository<Comissao, Long> {
}
