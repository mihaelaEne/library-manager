package ro.mycode.view;

import ro.mycode.controllers.*;
import ro.mycode.model.Enrolment;
import ro.mycode.model.Student;

import java.util.Scanner;

public class ViewEnrolment {
    private Scanner scanner;
    private Enrolment enrolment;
    private EnrolmentController enrolmentController;
    private CourseController courseController;
    private StudentController studentController;
    private AdminController adminController;
    private BookController bookController;



    public ViewEnrolment(Enrolment enrolment) {

        this.enrolment = enrolment;
        bookController = new BookController();
        courseController = new CourseController();
        enrolmentController=new EnrolmentController();
        scanner = new Scanner(System.in);
        play();
    }

    public void meniu() {
        System.out.println("1-pt a afisa toate enrolmenturile dvs");
        System.out.println("2- pt a adauga un enrolment ");
        System.out.println("3-pt a sterge un enrolment");
    }

    public void play() {

        int alegere = 0;
        boolean running = true;
        while (running) {
            meniu();
            alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    enrolmentController.afisareEnrolment();
                    break;
                case 2: adaugareEnrolment();
                break;
                case 3: stergereEnrolment();
                break;
                default:
                    System.out.println("Alegere gresita");
                    break;
            }
        }
    }

    private void adaugareEnrolment(){
        System.out.println("Id:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("IdStud:");
        int idStud = Integer.parseInt(scanner.nextLine());
        System.out.println("IdCurs:");
        int idCurs = Integer.parseInt(scanner.nextLine());
        Enrolment enrolment1=enrolmentController.findAdminByIdd(id);
        if(enrolment1==null){
            Enrolment eNou=new Enrolment(id,idStud,idCurs);
        }else{
            System.out.println("Enrolmentul exista deja");
        }
    }

    private void stergereEnrolment(){
        System.out.println("Introduceti id-ul:");
        int id = Integer.parseInt(scanner.nextLine());
        Enrolment enrolment1=enrolmentController.findAdminByIdd(id);
        if(enrolment1==null){
            System.out.println("Enrolmentul nu exista");
        }else {
            enrolmentController.removeEnrolment(enrolment1);
            System.out.println("Enrolmentul a fost sters");
        }
    }


}
