package com.practice.library;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {



        return args -> {

            List<Book> books = generateRandomBook();
            List<User> users = generateRandomUser();

            for (int i = 0; i < 10; i++) {
                User user = users.get(i);
                Book book = books.get(i);
                Address address1 = new Address("Vamhaz krt 11","Budapest","Budapest",user);
                user.setAddress(address1);
                user.addReview(new Review(book, user, new ReviewId(i,i), "It is so cool book", LocalDate.now()));
                user.addUserBook(new UserBook(new UserBookId(i,i),book,user,LocalDate.now(),LocalDate.now()));
            }



            userRepository.saveAll(users);



        };
    }

    private static List<User> generateRandomUser() {
        Faker fakerUser = new Faker();
        List<User> users= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String username = fakerUser.name().firstName();
            boolean enabled = true;
            User user = new User(username,enabled);
            users.add(user);
        }
        return users;
    }

    private static List<Book> generateRandomBook() {
        Faker fakerBook = new Faker();
        List<Book> books = new ArrayList<>();
        for(int i = 0;i<10;i++){
            String title = fakerBook.funnyName().name();
            String author = fakerBook.name().lastName();
            LocalDate publishedDate = LocalDate.now();
            Integer isbn = Math.toIntExact(fakerBook.number().randomNumber(
                    5, true));
            Book book = new Book(title, author, publishedDate, isbn);
            books.add(book);
        }
        return books;
    }


}
