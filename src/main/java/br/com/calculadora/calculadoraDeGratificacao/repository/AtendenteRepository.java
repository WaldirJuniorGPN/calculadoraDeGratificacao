package br.com.calculadora.calculadoraDeGratificacao.repository;

import br.com.calculadora.calculadoraDeGratificacao.model.Atendente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendenteRepository extends JpaRepository<Atendente, Long> {
     Page<Atendente> findAllByAtivoTrue(Pageable paginacao);
}
