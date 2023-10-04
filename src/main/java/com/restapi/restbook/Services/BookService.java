package com.restapi.restbook.Services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restapi.restbook.dao.BookRepository;
import com.restapi.restbook.entities.Book;

// import java.util.ArrayList;
@Component
public class BookService {
    
// private static List<Book> list=new ArrayList<>();
// static{
//     list.add(new Book(12,"Java","ABC"));
//     list.add(new Book(43,"Python","XYZ"));
//     list.add(new Book(332,"SQL","PQR"));
//     }

@Autowired
private BookRepository bookRepository;


public List<Book> getAllBooks(){
    
     List<Book>list=(List<Book>) this.bookRepository.findAll();
     System.out.println("line no 30");
     return list;
}
public Book getBookById(int id){
Book book=null;
try {
    // book=list.stream().filter(e->e.getId()==id).findFirst().get();
    book=this.bookRepository.findById(id);

} catch (Exception e) {
   
    e.printStackTrace();
     System.out.println("line no 42 ");
}
return book;
}


public Book addBook(Book b){
    Book result=bookRepository.save(b);
    System.out.println("line no 50");
    return result;
}
// public void deleteBook(int bid){
//     list=list.stream().filter(book->{
//         if(book.getId()!=bid){
//             return true;
//         }else{
//             return false;
//         }
//     }).collect(Collectors.toList());
// }
//option..
public void deleteBook(int bid){
    // list=list.stream().filter(book->book.getId()!=bid).
    // collect(Collectors.toList());
    bookRepository.deleteById(bid);
}
public void updateBook(Book book,int bookId){
    // list.stream().map(b->{
    //     if(b.getId()==bookId){
    //         b.setTitle(book.getTitle());
    //         b.setAuthor(book.getAuthor());
    //     }
    //     return b;
    // }).collect(Collectors.toList());
        book.setId(bookId);
        bookRepository.save(book);
}
}
