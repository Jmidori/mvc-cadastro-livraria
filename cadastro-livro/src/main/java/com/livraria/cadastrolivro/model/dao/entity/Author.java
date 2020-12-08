package com.livraria.cadastrolivro.model.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "autor")
public class Author {

    @Id
    private Long id;
    @Column(name = "nome")
    private String name;
    @Column(name = "nacionalidade")
    private String nationality;

    public Author() {}
    public Author(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
