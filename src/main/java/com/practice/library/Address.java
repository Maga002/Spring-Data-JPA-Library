package com.practice.library;


import jakarta.persistence.*;

@Table(name = "addresses")
@Entity(name = "Address")
public class Address {


    @Column(name = "street",nullable = false,length = 30)
    private String street;
    @Column(name = "city",nullable = false,length = 30)
    private String city;
    @Column(name = "state",nullable = false,length = 30)
    private String state;
    @Id
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    public Address(String street, String city, String state,User user) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.user = user;
    }

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUserId(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", user=" + user +
                '}';
    }
}
