package com.bytecodevelocity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String bookName;
    @JsonIgnore //for sending only one
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;
    public Book(){
    }

    public Book(Long id, String bookName) {
        this.id = id;
        this.bookName = bookName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
