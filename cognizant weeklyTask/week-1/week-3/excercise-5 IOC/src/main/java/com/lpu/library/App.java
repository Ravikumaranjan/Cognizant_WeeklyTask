package com.lpu.library;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.lpu.library.service.BookService;
public class App{
 public static void main(String[] args){
  ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
  BookService service=context.getBean("bookService",BookService.class);
  service.issueBook();
 }
}