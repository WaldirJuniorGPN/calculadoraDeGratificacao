package br.com.calculadora.calculadoraDeGratificacao.model;

import br.com.calculadora.calculadoraDeGratificacao.dto.request.DadosAtualizacaoComissao;
import br.com.calculadora.calculadoraDeGratificacao.dto.request.DadosCadastroComissao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Comissao")
@Table(name = "comissoes")
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Comissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double percentualPrimieroColocado;
    private Double percentualSegundoColocado;
    private Double percentualTerceiroColocado;
    private Double percentualDemaisColocados;

    @OneToMany(mappedBy = "comissao")
    private List<Loja> lojas = new ArrayList<>();

    public Comissao(DadosCadastroComissao dados) {
        this.percentualPrimieroColocado = dados.percentualPrimeiroColocado();
        this.percentualSegundoColocado = dados.percentualSegundoColocado();
        this.percentualTerceiroColocado = dados.percentualTerceiroColocado();
        this.percentualDemaisColocados = dados.percentualDemaisColocados();
    }

    public void atualizarDados(DadosAtualizacaoComissao dados) {
        if (dados.percentualPrimeiroColocado() != null) {
            this.percentualPrimieroColocado = dados.percentualPrimeiroColocado();
        }
        if (dados.percentualSegundoColocado() != null) {
            this.percentualSegundoColocado = dados.percentualSegundoColocado();
        }
        if (dados.percentualTerceiroColocado() != null) {
            this.percentualTerceiroColocado = dados.percentualTerceiroColocado();
        }
        if (dados.percentualDemaisColocados() != null) {
            this.percentualDemaisColocados = dados.percentualDemaisColocados();
        }
    }
}
