package com.bytecodevelocity.controller;

import com.bytecodevelocity.model.Book;
import com.bytecodevelocity.model.Student;
import com.bytecodevelocity.service.StudentDao;
import com.bytecodevelocity.service.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.OneToMany;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentDao dao;
    @Autowired
    StudentRepository repo;
    @PostMapping("/saveStudent")
    public void saveStudent(@RequestBody Student student){
        dao.insertStudent(student);
    }
    @PostMapping("/persistStudent")
    public void persistStudent(@RequestBody Student student){
        repo.save(student);
    }
// one student my have many books
    @OneToMany(mappedBy = "student")
    List<Book> allBooks;
    @GetMapping("allStudent")
    public List<Student>getAllStudent(){
        return repo.findAll();
    }
    @GetMapping("allStudentById/{Id}")
    public Student getAllStudent(@PathVariable long Id) {
        Optional<Student> byId = repo.findById(Id);
        return byId.get();
    }

    public List<Book> getAllBooks() {
        return allBooks;
    }

    public void setAllBooks(List<Book> allBooks) {
        this.allBooks = allBooks;
    }
    @GetMapping("getBookById/{Id}")
    public List<Book> getBookById(@PathVariable long Id) {
        Student byId = repo.getById(Id);
        return byId.getAllBooks();
    }
    @GetMapping("getAllBook")
    public List<Student> getAllBook() {
        return repo.findAll();
    }
}
