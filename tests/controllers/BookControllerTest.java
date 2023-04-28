package controllers;

import org.junit.Test;
import ro.mycode.controllers.BookController;
import ro.mycode.model.Book;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BookControllerTest
{


    @Test
    public void findById(){
        ArrayList<Book> books=new ArrayList();
        LocalDate date1 = LocalDate.of(2023, 11, 12);
        Book  b1=new Book(1,11,"titlu1","autor1",date1);
        books.add(b1);
        LocalDate date2 = LocalDate.of(2022, 11, 12);
        Book  b2=new Book(2,22,"titlu2","autor2",date2);
        books.add(b2);
        LocalDate date3 = LocalDate.of(2021, 11, 12);
        Book  b3=new Book(3,33,"titlu3","autor3",date3);
        books.add(b3);
        LocalDate date4 = LocalDate.of(2020, 11, 12);
        Book  b4=new Book(4,44,"titlu4","autor4",date4);
        books.add(b4);

        BookController bookController=new BookController(books);

        assertEquals("titlu1",bookController.findById(1).getTitle());
    }

    @Test
    public void testWithoutId(){
        ArrayList<Book> books=new ArrayList();
        LocalDate date1 = LocalDate.of(2023, 11, 12);
        Book  b1=new Book(1,11,"titlu1","autor1",date1);
        books.add(b1);
        LocalDate date2 = LocalDate.of(2022, 11, 12);
        Book  b2=new Book(2,22,"titlu2","autor2",date2);
        books.add(b2);
        LocalDate date3 = LocalDate.of(2021, 11, 12);
        Book  b3=new Book(3,33,"titlu3","autor3",date3);
        books.add(b3);
        LocalDate date4 = LocalDate.of(2020, 11, 12);
        Book  b4=new Book(4,44,"titlu4","autor4",date4);
        books.add(b4);

        BookController bookController=new BookController(books);
        assertNull(bookController.findById(8));

    }
    @Test
    public void testAdd(){
        ArrayList<Book> books=new ArrayList();
        LocalDate date1 = LocalDate.of(2023, 11, 12);
        Book  b1=new Book(1,11,"titlu1","autor1",date1);
        books.add(b1);
        LocalDate date2 = LocalDate.of(2022, 11, 12);
        Book  b2=new Book(2,22,"titlu2","autor2",date2);
        books.add(b2);
        LocalDate date3 = LocalDate.of(2021, 11, 12);
        Book  b3=new Book(3,33,"titlu3","autor3",date3);
        books.add(b3);
        LocalDate date4 = LocalDate.of(2020, 11, 12);
        Book  b4=new Book(4,44,"titlu4","autor4",date4);

        BookController bookController=new BookController(books);
        bookController.addBook(b4);
        assertNull(bookController.findById(5));

    }


    @Test
    public void testRemove(){
        ArrayList<Book> books=new ArrayList();
        LocalDate date1 = LocalDate.of(2023, 11, 12);
        Book  b1=new Book(1,11,"titlu1","autor1",date1);
        books.add(b1);
        LocalDate date2 = LocalDate.of(2022, 11, 12);
        Book  b2=new Book(2,22,"titlu2","autor2",date2);
        books.add(b2);
        LocalDate date3 = LocalDate.of(2021, 11, 12);
        Book  b3=new Book(3,33,"titlu3","autor3",date3);
        books.add(b3);
        LocalDate date4 = LocalDate.of(2020, 11, 12);
        Book  b4=new Book(4,44,"titlu4","autor4",date4);
        books.add(b4);

        BookController bookController=new BookController(books);
        bookController.removeBook(b4);
        assertEquals(null, bookController.findById(5));
    }





}
