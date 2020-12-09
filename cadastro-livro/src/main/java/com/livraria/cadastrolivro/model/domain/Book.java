package com.livraria.cadastrolivro.model.domain;

import java.time.LocalDate;

public class Book implements DomainEntity{
    private Long id;
    private String isbn;
    private String title;
    private Long authorId;
    private Long publisherId;
    private Integer edition;
    private LocalDate publicationDate;
    private Integer categoryId;
    private Boolean bestSeller;

    public Book() {}
    public Book(Long id, String isbn, String title, Long authorId, Long publisherId, Integer edition, LocalDate publicationDate, Integer categoryId, Boolean bestSeller) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.authorId = authorId;
        this.publisherId = publisherId;
        this.edition = edition;
        this.publicationDate = publicationDate;
        this.categoryId = categoryId;
        this.bestSeller = bestSeller;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Boolean getBestSeller() {
        return bestSeller;
    }

    public void setBestSeller(Boolean bestSeller) {
        this.bestSeller = bestSeller;
    }
}
