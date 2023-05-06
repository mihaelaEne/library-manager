package ro.mycode.controllers;

import ro.mycode.model.Book;
import ro.mycode.model.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
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

    //add, remove

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
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

    public boolean studentulAreCartea(int idStudent, String title, String autor) {
        for (int i = 0; i < this.books.size(); i++) {
            if (books.get(i).getStudentId() == idStudent && books.get(i).getTitle().equals(title) && books.get(i).getAutor().equals(autor)) {
                return true;
            }
        }
        return false;
    }


    public int generareId() {
        int id = (int) Math.round(Math.random() * 1000 + 10000);
        while (this.findById(id) != null) {
            id = (int) Math.round(Math.random() * 1000 + 10000);

        }
        return id;
    }


    public void editareBook(Book book) {
        Book deEditat = findById(book.getId());

        if (book.getTitle() != null) {
            deEditat.setTitle(book.getTitle());
        }
        if (book.getAutor() != null) {
            deEditat.setAutor(book.getAutor());
        }
        if (book.getCreateAt() != null) {
            deEditat.setCreateAt(book.getCreateAt());
        }
    }

    public String toSave() {
        String text = "";
        int i = 0;
        for (i = 0; i < books.size() - 1; i++) {
            text += books.get(i).toSave() + "\n";
        }
        text += books.get(i).toSave();
        return text;
    }

    public void save() {
        try {
            File file = new File("C:\\mycode\\OOP\\incapsularea\\library-manager\\src\\ro\\mycode\\data\\book.txt");

            FileWriter fileWriter = new FileWriter(file);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print(toSave());

            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
