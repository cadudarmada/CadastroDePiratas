package dev.cadudarmada.CadastroDePiratas.Piratas;

import dev.cadudarmada.CadastroDePiratas.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

// Transforma uma classe em uma entidade do BD
//JPA = Java Persistence API

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PirataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

    //Colocando uma coluna de missão na tabela pirata pois é uma relação muitos para um então o um vai para o muitos
    @ManyToOne
    @JoinColumn(name = "missoes_id") //ForeignerKey
    private MissaoModel missoes;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setMissoes(MissaoModel missoes) {
        this.missoes = missoes;
    }
}
