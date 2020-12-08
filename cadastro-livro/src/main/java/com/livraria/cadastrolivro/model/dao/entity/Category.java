package com.livraria.cadastrolivro.model.dao.entity;

import javax.persistence.*;

@Entity
@Table(name="categoria")
public class Category {
    @Id
    private Long id;

    @Column(name = "descricao")
    private String description;

    public Category() {}

    public Category(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
