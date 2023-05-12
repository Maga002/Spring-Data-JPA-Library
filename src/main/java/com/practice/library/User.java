package com.practice.library;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "users",uniqueConstraints = @UniqueConstraint(name = "username_unique",columnNames = "username"))
@Entity(name = "User")
public class User {
    @Id
    @SequenceGenerator(name = "user_id_seq",sequenceName = "user_id_seq",allocationSize = 1)
    @GeneratedValue(generator = "user_id_seq",strategy = GenerationType.SEQUENCE)
    @Column(name = "id",updatable = false)
    private Integer id;
    @Column(name = "username",length = 25,nullable = false)
    private String userName;
    @Column(name = "enabled")
    private boolean enabled;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "user")
    private List<UserBook> userBooks = new ArrayList<>();


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User(String userName, boolean enabled) {
        this.userName = userName;
        this.enabled = enabled;
    }

    public User() {
    }


    public void addReview(Review review){
        reviews.add(review);
        review.setUser(this);
    }
    public void removeReview(Review review){
        if(reviews.contains(review)){
            reviews.remove(review);
        }
    }

    public void removeUserBook(UserBook userBook){
        if(userBooks.contains(userBook)){
            userBooks.remove(userBook);
        }
    }

    public void addUserBook(UserBook userBook){
        userBooks.add(userBook);
        userBook.setUser(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
