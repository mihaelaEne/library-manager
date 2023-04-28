package ro.mycode.controllers;

import ro.mycode.model.Book;
import ro.mycode.model.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {


    private ArrayList<Student> students = new ArrayList();


    public StudentController(ArrayList<Student> students) {
        this.students = students;
    }

    public StudentController() {
        this.students = new ArrayList();
        this.load();
    }


    public void load() {
        try {
            File file = new File("C:\\mycode\\OOP\\incapsularea\\lottery manager\\src\\ro\\mycode\\data\\student.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Student student = new Student(scanner.nextLine());
                this.students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afisareStudent() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(this.students.get(i).descriereStudent());
            System.out.println("\n");
        }
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }


    public Student findByName(String firstName) {
        for (int i = 0; i < this.students.size(); i++) {
            if (students.get(i).getFirstName().equals(firstName)) {
                if (students.get(i).getFirstName().equals(firstName)) {
                    return students.get(i);
                }
            }
        }
        return null;
    }


}












