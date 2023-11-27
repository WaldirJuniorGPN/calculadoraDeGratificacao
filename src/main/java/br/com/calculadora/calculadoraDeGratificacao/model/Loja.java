package br.com.calculadora.calculadoraDeGratificacao.model;

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
    private List<Funcionario> funcionarios = new ArrayList<>();
}
