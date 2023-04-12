package ro.mycode.controllers;

import ro.mycode.model.Book;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class BookController {
    private ArrayList<Book> books=new ArrayList();
    public BookController(ArrayList<Book>books){
        this.books=books;
    }

    public BookController(){
        this.books=new ArrayList();
        this.load();
    }


    public void load(){
        try {
            File file = new File("C:\\mycode\\OOP\\incapsularea\\lottery manager\\src\\ro\\mycode\\data\\book.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
               Book book=new Book(scanner.nextLine());
                this.books.add(book);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void afisareBook(){
        for(int i=0; i<books.size(); i++){
            System.out.println(this.books.get(i).descriereBook());
            System.out.println("\n");
        }
    }

    //todo:functie ce primeste id studentului si returneaza o lista de carti


    public  ArrayList<Book>  findAllStudentBooks(int studentId){
        ArrayList<Book> studentBooks=new ArrayList<>();
        for(int i=0; i<books.size(); i++){
            if(books.get(i).getStudentId()==studentId){
                studentBooks.add(books.get(i));
            }
        }
        return studentBooks;
    }






}
