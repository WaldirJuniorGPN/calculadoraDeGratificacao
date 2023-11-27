package br.com.calculadora.calculadoraDeGratificacao.repository;

import br.com.calculadora.calculadoraDeGratificacao.model.Loja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LojaRepository extends JpaRepository<Loja, Long> {
}
