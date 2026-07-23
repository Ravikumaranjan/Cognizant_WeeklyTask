
package com.lpu.library.service;
import com.lpu.library.repository.BookRepository;

public class BookService{
    private String libraryName;
    private BookRepository bookRepository;

    public BookService(String libraryName){
        this.libraryName=libraryName;
        System.out.println("Constructor Injection Successful");
    }

    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository=bookRepository;
        System.out.println("Setter Injection Successful");
    }

    public void display(){
        System.out.println("Library: "+libraryName);
        bookRepository.getBook();
    }
}
