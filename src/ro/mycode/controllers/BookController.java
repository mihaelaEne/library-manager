package ro.mycode.controllers;

import ro.mycode.model.Book;
import ro.mycode.model.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BookController {
    private ArrayList<Book> books;

    public BookController(ArrayList<Book> books) {
        this.books = books;
    }

    public BookController() {
        this.books = new ArrayList();
        this.load();
    }


    public void load() {
        try {
            File file = new File("C:\\mycode\\OOP\\incapsularea\\library-manager\\src\\ro\\mycode\\data\\book.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Book book = new Book(scanner.nextLine());
                this.books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afisareBook() {
        for (int i = 0; i < books.size(); i++) {
            System.out.println(this.books.get(i).descriereBook());
            System.out.println("\n");
        }
    }

    //todo:functie ce primeste id studentului si returneaza o lista de carti


    public ArrayList<Book> findAllStudentBooks(int studentId) {
        ArrayList<Book> studentBooks = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getStudentId() == studentId) {
                studentBooks.add(books.get(i));
            }
        }
        return studentBooks;
    }

    public void addBook(Book book) {
     if(this.studentulAreCartea(book.getStudentId(), book.getTitle(), book.getAutor())){
         System.out.println("Cartea "+book.getTitle()+ "exista deja ");

     }else {this.books.add(book);}
    }

    public void removeBook(Book book) {
        if(this.studentulAreCartea(book.getStudentId(), book.getTitle(), book.getAutor())){
            System.out.println("cartea este in lista ");

        }else {this.books.remove(book);}
    }

    public Book findById(int id) {
        for (int i = 0; i < this.books.size(); i++) {
            if (books.get(i).getId() == id) {
                return books.get(i);
            }
        }
        return null;
    }

    //todo:metoda ce verifica daca un anume student are deja cartea cu titlul si autorul respectiv

    public boolean studentulAreCartea(int idStudent, String title, String autor){


        for(int i=0;i<this.books.size();i++){

            if(books.get(i).getStudentId()==idStudent&& books.get(i).getTitle().equals(title)&&books.get(i).getAutor().equals(autor)){

                return true;
            }

        }
        return false;
    }


    public  int generareId(){
        int id=(int)Math.round(Math.random()*1000+10000);
        while (this.findById(id)!=null){
            id=(int)Math.round(Math.random()*1000+10000);

        }
        return id;
    }


}
