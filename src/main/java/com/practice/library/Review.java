package com.practice.library;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "reviews")
@Entity(name = "Review")
public class Review {

    @EmbeddedId
    private ReviewId id;

    @Column(name = "review_content", nullable = false)
    private String reviewContent;
    @Column(name = "published_date", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate publishedDate;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    @MapsId("bookId")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @MapsId("userId")
    private User user;

    public Review(Book book, User user, ReviewId id, String reviewContent, LocalDate publishedDate) {
        this.user = user;
        this.book = book;
        this.reviewContent = reviewContent;
        this.publishedDate = publishedDate;
        this.id = id;
    }

    public Review() {
    }



    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public ReviewId getReviewId() {
        return id;
    }

    public void setReviewId(ReviewId reviewId) {
        this.id = reviewId;
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

    @Override
    public String toString() {
        return "Review{" +
                ", reviewContent='" + reviewContent + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", reviewId=" + id +
                ", book=" + book +
                ", user=" + user +
                '}';
    }
}
