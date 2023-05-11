import ro.mycode.controllers.*;
import ro.mycode.model.Admin;
import ro.mycode.model.Book;
import ro.mycode.model.Student;
import ro.mycode.view.ViewLogin;
import ro.mycode.view.ViewStudent;

import java.awt.image.AreaAveragingScaleFilter;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main( String[] args) {
       //ViewStudent viewStudent=new ViewStudent();

        //ViewLogin viewLogin=new ViewLogin();

        EnrolmentController e1=new EnrolmentController();

        e1.load();
        System.out.println(e1.findMostPopularCourse());


//        StudentController studentController=new StudentController();
//        Student student=studentController.findStudentConectare("maria.popescu@gmail.com","pass1");
//
//        if(student!=null){
//            System.out.println("Studentul este: "+student.getFirstName()+" "+student.getLastName());
//
//        }else {
//            System.out.println("eroare");
//        }


//        AdminController adminController=new AdminController();
//        adminController.load();
//        adminController.afisareAdmin();
//




    }
}