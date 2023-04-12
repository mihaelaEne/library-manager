package ro.mycode.view;

import ro.mycode.controllers.BookController;
import ro.mycode.controllers.StudentController;
import ro.mycode.model.Book;
import ro.mycode.model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewStudent {

    private Student student;

    private BookController bookController;
    private Scanner scanner;

    public ViewStudent(){

        this.student= new Student(1,"test","test2","test3",12);
        bookController=new BookController();
        scanner=new Scanner(System.in);
        play();
    }

    public void meniu(){
        System.out.println("Buna "+this.student.getFirstName()+" !");
        System.out.println("1-pt a afisa toate cartile dvs");

    }


    public void play(){

        int alegere=0;
        boolean running=true;
        while(running){
            meniu();
            alegere=Integer.parseInt(scanner.nextLine());
            switch(alegere){
                case 1: afisareBooks();
                break;
                default:
                    System.out.println("Alegere gresita");
                    break;
            }
        }
    }

    void afisareBooks(){

        ArrayList<Book> studentBooks = bookController.findAllStudentBooks(this.student.getId());


        for(Book book:studentBooks){


            System.out.println(book.descriereBook());

        }


    }
}
