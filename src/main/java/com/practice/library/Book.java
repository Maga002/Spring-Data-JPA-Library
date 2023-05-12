package com.practice.library;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "books",uniqueConstraints = @UniqueConstraint(name = "book_isbn_unique",columnNames = "isbn"))
@Entity(name = "Book")
public class Book {
    @Id
    @SequenceGenerator(name = "book_id_seq",sequenceName = "book_id_seq")
    @GeneratedValue(generator = "book_id_seq",strategy = GenerationType.SEQUENCE)
    @Column(name = "id",updatable = false)
    private Integer id;
    @Column(name = "title",nullable = false,length = 100)
    private String title;
    @Column(name = "author",nullable = false,length = 100)
    private String author;
    @Column(name="published_date",columnDefinition = "TIMESTAMP WITHOUT TIME ZONE",nullable = false)
    private LocalDate publishedDate;
    @Column(name = "isbn",nullable = false)
    private Integer isbn;

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "book")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "book")
    private List<UserBook> userBooks = new ArrayList<>();


    public Book(String title, String author, LocalDate publishedDate, Integer isbn) {
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
        this.isbn = isbn;
    }

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }
    public void addReview(Review review){
        reviews.add(review);
        review.setBook(this);
    }

    public void removeReview(Review review){
        if(reviews.contains(review)){
            reviews.remove(review);
        }
    }

    public void removeUserBook(UserBook userBook){
        if(reviews.contains(userBook)){
            reviews.remove(userBook);
        }
    }

    public void addUserBook(UserBook userBook){
        userBooks.add(userBook);
        userBook.setBook(this);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishedDate=" + publishedDate +
                ", isbn=" + isbn +
                '}';
    }
}
