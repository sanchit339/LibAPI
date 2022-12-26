package com.bytecodevelocity.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "student_name")
    private String studentName;
    private int age;
     @OneToMany(mappedBy = "student")
     List<Book> allBooks;

    public Student() {
    }

    public Student(String studentName, int age) {
        this.studentName = studentName;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

     public List<Book> getAllBooks() {
         return allBooks;
     }

     public void setAllBooks(List<Book> allBooks) {
         this.allBooks = allBooks;
     }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", age=" + age +
                '}';
    }
}
