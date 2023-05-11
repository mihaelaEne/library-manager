package controllers;

import org.junit.Test;
import ro.mycode.controllers.EnrolmentController;
import ro.mycode.model.Enrolment;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class EnrolmentControllerTest {

    @Test
    public void comunTest(){
        ArrayList<Enrolment> enrolments=new ArrayList<>();
        Enrolment e1=new Enrolment(11,1,2);
        enrolments.add(e1);
        Enrolment e2=new Enrolment(22,1,2);
        enrolments.add(e2);
        Enrolment e3=new Enrolment(33,2,1);
        enrolments.add(e1);


        EnrolmentController enrolmentController=new EnrolmentController(enrolments);
        assertEquals()
    }
}
