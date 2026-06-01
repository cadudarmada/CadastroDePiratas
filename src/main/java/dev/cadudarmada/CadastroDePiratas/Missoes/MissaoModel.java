package dev.cadudarmada.CadastroDePiratas.Missoes;

import dev.cadudarmada.CadastroDePiratas.Piratas.PirataModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
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
    private List<PirataModel> pirata;



}
