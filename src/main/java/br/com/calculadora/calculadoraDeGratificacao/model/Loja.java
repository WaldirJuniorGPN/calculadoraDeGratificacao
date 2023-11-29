package br.com.calculadora.calculadoraDeGratificacao.model;

import br.com.calculadora.calculadoraDeGratificacao.dto.request.DadosCadastroLoja;
import br.com.calculadora.calculadoraDeGratificacao.dto.response.DadosAtualizacaoLoja;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Loja")
@Table(name = "lojas")
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private List<Double> vendasSemana = new ArrayList<>();
    private Double vendasMes;

    @OneToMany(mappedBy = "loja")
    private List<Atendente> atendentes = new ArrayList<>();

    private boolean ativo;

    public Loja(DadosCadastroLoja dados) {
        this.nome = dados.nome();
        this.ativo = true;
    }

    public void atualizarDados(DadosAtualizacaoLoja dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
    }

    public void desativar() {
        this.ativo = false;
    }
}
