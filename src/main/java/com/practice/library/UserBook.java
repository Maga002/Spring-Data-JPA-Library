package com.practice.library;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "users_books")
@Entity(name = "UserBook")
public class UserBook {
    @EmbeddedId
    private UserBookId id;
    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
    @Column(name = "checkout_date",nullable = false,columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate checkOutDate;
    @Column(name = "return_date",nullable = false,columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate returnDate;

    public UserBook() {
    }

    public UserBook(UserBookId id, Book book, User user, LocalDate checkOutDate, LocalDate returnDate) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.checkOutDate = checkOutDate;
        this.returnDate = returnDate;
    }

    public UserBookId getId() {
        return id;
    }

    public void setId(UserBookId id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "UserBook{" +
                "id=" + id +
                ", book=" + book +
                ", user=" + user +
                ", checkOutDate=" + checkOutDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
