package dev.cadudarmada.CadastroDePiratas.Piratas;

import dev.cadudarmada.CadastroDePiratas.Missoes.MissaoModel;
import jakarta.persistence.*;

import java.util.List;

// Transforma uma classe em uma entidade do BD
//JPA = Java Persistence API

@Entity
@Table(name = "tb_cadastro")
public class PirataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

    //Colocando uma coluna de missão na tabela pirata pois é uma relação muitos para um então o um vai para o muitos
    @ManyToOne
    @JoinColumn(name = "missoes_id") //FK
    private MissaoModel missoes;

    public PirataModel(){

    }
    public PirataModel(String nome, String email, int idade){
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }
}
