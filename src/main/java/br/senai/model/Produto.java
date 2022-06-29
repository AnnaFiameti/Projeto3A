package br.senai.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @ManyToMany(mappedBy = "produtos")
    private List<ControleRenda> controleRenda;

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

    public List<ControleRenda> getControleRenda() {
        return controleRenda;
    }

    public void setControleRenda(List<ControleRenda> controleRenda) {
        this.controleRenda = controleRenda;
    }
}
