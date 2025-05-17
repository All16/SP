package com.example.ciuleSP.Book;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

 /*   public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
*/
    public void print() {
        System.out.println(name + " " + surname);
    }
}
