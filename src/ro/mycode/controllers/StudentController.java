package ro.mycode.controllers;

import ro.mycode.model.Book;
import ro.mycode.model.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
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
            File file = new File("C:\\mycode\\OOP\\incapsularea\\library-manager\\src\\ro\\mycode\\data\\student.txt");
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

    public String toSave(){

        String text="";
        int i=0;
        for(i=0;i<students.size()-1; i++){

            text+=students.get(i).toSave()+"\n";
        }

        text+=students.get(i).toSave();
        return text;
    }


    public void save(){
        try {
            File file = new File("C:\\mycode\\OOP\\incapsularea\\library-manager\\src\\ro\\mycode\\data\\student.txt");

            FileWriter fileWriter= new FileWriter(file);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print(toSave());

            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //todo:metoda care primeste ca paraametru user si parola si returneaza studentul cu datele

    public Student findStudentConectare(String email, String password){
        for(int i=0; i<students.size();i++){
            Student student=students.get(i);
            if(student.getEmail().equals(email)&&student.getPassword().equals(password)){
                return student;
            }
        }
        return null;
    }



}












