package com.jbk.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private long isbn;
    private double price;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Book_Borrower",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "borrower_id")
    )
    private List<Borrower> borrowers = new ArrayList<> ( );

    public Book (){
    }

    public Book (int id, String title, long isbn, double price, Author author, List<Borrower> borrowers) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.price = price;
        this.author = author;
        this.borrowers = borrowers;
    }

    public Book (String title, long isbn, double price, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.price = price;
        this.author = author;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public long getIsbn () {
        return isbn;
    }

    public void setIsbn (long isbn) {
        this.isbn = isbn;
    }

    public double getPrice () {
        return price;
    }

    public void setPrice (double price) {
        this.price = price;
    }

    public Author getAuthor () {
        return author;
    }

    public void setAuthor (Author author) {
        this.author = author;
    }

    public List<Borrower> getBorrowers () {
        return borrowers;
    }

    public void setBorrowers (List<Borrower> borrowers) {
        this.borrowers = borrowers;
    }

    @Override
    public String toString () {
        return "Books [" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", author=" + author +
                ", borrowers=" + borrowers +
                ']';
    }
}
