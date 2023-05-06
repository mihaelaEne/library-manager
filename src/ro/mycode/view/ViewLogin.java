package ro.mycode.view;

import ro.mycode.controllers.AdminController;
import ro.mycode.controllers.BookController;
import ro.mycode.controllers.StudentController;
import ro.mycode.model.Admin;
import ro.mycode.model.Student;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class ViewLogin {
    private AdminController adminController;
    private StudentController studentController;
    private Scanner scanner;


    public ViewLogin() {
        studentController = new StudentController();
        adminController = new AdminController();
        scanner = new Scanner(System.in);
        play();
    }

    public void meniu() {
        System.out.println("Apasa tasta 1 pentru a va loga");
        System.out.println("Apasa tasta 2 pentru a va inregistra");

    }

    public void meniu2() {
        System.out.println("Apasa 1 daca esti  student");
        System.out.println("Apasa 2 daca esti ADMIN");
    }

    public void play() {
        int alegere = 0;
        boolean running = true;
        while (running) {
            meniu();
            alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {

                case 1:
                    conectare();
                    break;
                case 2:
                    inregistrare();
                    studentController.save();
                    break;
                default:
                    System.out.println("Eroare");
                    break;
            }
        }
    }

    public void conectare() {

        int alegere = 0;
        boolean running = true;
        while (running) {
            meniu2();
            alegere = Integer.parseInt(scanner.nextLine());

            System.out.println("Introduceti adersa de email: ");
            String mail = scanner.nextLine();
            System.out.println("Introduceti parola:");
            String password = scanner.nextLine();
            switch (alegere) {
                case 1:

                    Student student = studentController.findStudentConectare(mail, password);
                    if (student != null) {
                        ViewStudent viewStudent = new ViewStudent(student);
                    } else {
                        System.out.println("eroare la student");
                    }
                    break;
                case 2:

                    Admin admin = adminController.findAdminConectare(mail, password);
                    if (admin != null) {
                        ViewAdmin viewAdmin = new ViewAdmin(admin);
                    } else {
                        System.out.println("eroare la admin");
                    }
                    break;
                default:
                    System.out.println("eroare la switch");
                    break;
            }
        }
    }


    public void inregistrare() {
        int alegere = 0;
        boolean running = true;
        while (running) {
            meniu2();
            alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:

                    System.out.println("Introduceti id-ul,numele, prenumele, varsta, mailul, ul si parola");
                    System.out.println("id:");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("nume:");
                    String nume = scanner.nextLine();
                    System.out.println("prenume:");
                    String prenume = scanner.nextLine();
                    System.out.println("varsta:");
                    int varsta = Integer.parseInt(scanner.nextLine());
                    System.out.println("mail:");
                    String mail = scanner.nextLine();
                    System.out.println("parola:");
                    String parola = scanner.nextLine();

                    Student student = studentController.findByName(nume);
                    if (student == null) {
                        Student sNou = new Student(id, nume, prenume, mail, varsta, parola);
                        studentController.addStudent(sNou);
                        System.out.println("Studentul a fost adaugat!");

                    } else {
                        System.out.println("Studentul este inregistrat deja");
                    }
                    break;
                case 2:
                    System.out.println("Introduceti id-ul,numele, prenumele, mailul, ul si parola");
                    System.out.println("id:");
                    int idAdmin = Integer.parseInt(scanner.nextLine());
                    System.out.println("nume:");
                    String numeAdmin = scanner.nextLine();
                    System.out.println("prenume:");
                    String prenumeAdmin = scanner.nextLine();
                    System.out.println("mail:");
                    String mailAdmin = scanner.nextLine();
                    System.out.println("parola:");
                    String parolaAdmin = scanner.nextLine();


                    Admin admin = adminController.findAdminById(idAdmin);
                    if (admin == null) {
                        Admin aNou = new Admin(idAdmin, numeAdmin, prenumeAdmin, mailAdmin, parolaAdmin);
                        adminController.addAdmin(aNou);
                        System.out.println("Adminul a fost adaugat cu succes");
                    } else {
                        System.out.println("Adminul este deja in baza de date");
                    }
                    break;
                default:
                    System.out.println("Eroare");
                    break;

            }
        }
    }


}
