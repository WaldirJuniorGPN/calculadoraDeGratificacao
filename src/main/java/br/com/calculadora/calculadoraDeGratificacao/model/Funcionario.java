package br.com.calculadora.calculadoraDeGratificacao.model;

import br.com.calculadora.calculadoraDeGratificacao.dto.request.DadosAtualizacaoAtendente;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class Funcionario {

    private String nome;
    private Double salario;
    private Double gratificacao;

    public Funcionario(String nome, Double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public void atualizarDados(DadosAtualizacaoAtendente dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.salario() != null) {
            this.salario = dados.salario();
        }
    }

    public abstract void desativar();
}
