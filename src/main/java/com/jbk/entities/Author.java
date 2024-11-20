package com.jbk.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<> ( );

    public Author () {
    }

    public Author (int id, String name, String email, List<Book> books) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.books = books;
    }

    public Author (String name, String email) {
        this.name = name;
        this.email = email;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public List<Book> getBooks () {
        return books;
    }

    public void setBooks (List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString () {
        return "Authors [" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", books=" + books +
                ']';
    }
}
