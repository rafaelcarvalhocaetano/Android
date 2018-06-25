package com.br.cadastro.model;

/**
 * Created by rafael on 24/06/18.
 */

public class Contato {


    private Long id;
    private String nome;
    private String idade;

    public Contato(String nome, String idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Contato(Long id, String nome, String idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
}
