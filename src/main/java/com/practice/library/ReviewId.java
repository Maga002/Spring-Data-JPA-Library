package com.practice.library;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReviewId implements Serializable {
    @Column(name = "book_id",updatable = false)
    private Integer bookId;
    @Column(name = "user_id",updatable = false)
    private Integer userId;

    public ReviewId(Integer bookId, Integer userId) {
        this.bookId = bookId;
        this.userId = userId;
    }

    public ReviewId() {
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewId reviewId = (ReviewId) o;
        return Objects.equals(bookId, reviewId.bookId) && Objects.equals(userId, reviewId.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, userId);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
