package com.lpu.library.service;
import com.lpu.library.repository.BookRepository;
public class BookService{
 private BookRepository bookRepository;
 public void setBookRepository(BookRepository bookRepository){this.bookRepository=bookRepository;}
 public void issueBook(){
  System.out.println("BookService: Processing request...");
  bookRepository.displayBook();
 }
}