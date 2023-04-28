package ro.mycode.view;

import ro.mycode.controllers.BookController;
import ro.mycode.controllers.StudentController;
import ro.mycode.model.Book;
import ro.mycode.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewStudent {

    private Student student;

    private BookController bookController;
    private Scanner scanner;

    public ViewStudent() {

        this.student = new Student(1, "test", "test2", "test3", 12);
        bookController = new BookController();
        scanner = new Scanner(System.in);
        play();
    }

    public void meniu() {
        System.out.println("Buna " + this.student.getFirstName() + " !");
        System.out.println("1-pt a afisa toate cartile dvs");
        System.out.println("2-adaugare carte");
        System.out.println("3-pt a sterge o carte");


    }


    public void play() {

        int alegere = 0;
        boolean running = true;
        while (running) {
            meniu();
            alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    afisareBooks();
                    break;
                case 2:
                    adaugareCarte();
                    break;
                case 3: stergereCarte();
                break;
                default:
                    System.out.println("Alegere gresita");
                    break;
            }
        }
    }

    private void adaugareCarte(){

        System.out.println("Titlu: ");
        String titlu=scanner.nextLine();
        System.out.println("Autor:");
        String autor=scanner.nextLine();
        System.out.println("created at: ");
        LocalDate createdAt=LocalDate.parse(scanner.nextLine());


        boolean isBook = this.bookController.studentulAreCartea(this.student.getId(), titlu, autor);


        if(!isBook){
            this.bookController.addBook(new Book(bookController.generareId(),this.student.getId(),titlu,autor,createdAt));
            System.out.println("Adaugat cu succes");
        }else{
            System.out.println("eroare");
        }


    }

    private void stergereCarte(){



    }

    private void afisareBooks() {

        ArrayList<Book> studentBooks = bookController.findAllStudentBooks(this.student.getId());


        for (Book book : studentBooks) {

            System.out.println(book.descriereBook());

        }


    }


}
