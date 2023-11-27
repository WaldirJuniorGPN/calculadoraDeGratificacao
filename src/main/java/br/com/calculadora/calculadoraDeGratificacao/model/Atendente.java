package br.com.calculadora.calculadoraDeGratificacao.model;

import br.com.calculadora.calculadoraDeGratificacao.dto.request.DadosCadastroAtendente;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Atendente")
@Table(name = "atendentes")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Atendente extends Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean ativo;

    public Atendente(DadosCadastroAtendente dados) {
        super(dados.nome(), dados.salario());
        this.ativo = true;
    }

    @Override
    public void desativar() {
        this.ativo = false;
    }
}
