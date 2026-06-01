package dev.cadudarmada.CadastroDePiratas.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.cadudarmada.CadastroDePiratas.Piratas.PirataModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Getter
@NoArgsConstructor
public class MissaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private DificuldadeMissao dificuldade;

    //Uma missao pode ter varios piratas então colocar varios nomes em missões eu criaria mais dados do que colocando
    // as missoes en cada ninja, por isso a table 1 vai para a tabela muitos.
    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List<PirataModel> pirata;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDificuldade(DificuldadeMissao dificuldade) {
        this.dificuldade = dificuldade;
    }

    public void setPirata(List<PirataModel> pirata) {
        this.pirata = pirata;
    }
}
