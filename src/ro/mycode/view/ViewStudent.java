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
        System.out.println("4- editeaza o carte ");


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
                case 4: editareCarte();
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

        System.out.println("Intr id-ul");
        int id=Integer.parseInt(scanner.nextLine());

        Book book=bookController.findById(id);

        if(book==null){
            System.out.println("Nu este in lista cartea");
        }else{
            bookController.removeBook(book);
            System.out.println("Cartea a fost stearsa");
        }

    }

    private void afisareBooks() {

        ArrayList<Book> studentBooks = bookController.findAllStudentBooks(this.student.getId());


        for (Book book : studentBooks) {

            System.out.println(book.descriereBook());

        }


    }


    private void editareCarte(){
        System.out.println("Intr id-ul:");
        int id=Integer.parseInt(scanner.nextLine());

        Book book=bookController.findById(id);
        if(book==null){
            System.out.println("Nu exista o carte cu id-ul introdus");
        }else{
            System.out.println("Introduceti cu virgula ce doresti sa modifici(titlu, autor,data): ");

            String [] upd= scanner.nextLine().split(",");
            Book nou=new Book();

            nou.setId(book.getId());

            for(int i=0; i< upd.length; i++){
                switch (upd[i]){
                    case "titlu":
                        System.out.println("Intr titlul:");
                        String title= scanner.nextLine();

                        nou.setTitle(title);

                        break;
                    case "autor":
                        System.out.println("Intr autorul:");
                        String autor= scanner.nextLine();
                        nou.setAutor(autor);
                        break;
                    case "data":
                        System.out.println("Intr data:");
                        LocalDate data=LocalDate.parse(scanner.nextLine());
                        nou.setCreateAt(data);

                        break;
                    default:
                        System.out.println("Eroare");

                }
            }
            bookController.editareBook(nou);
        }
    }



}
