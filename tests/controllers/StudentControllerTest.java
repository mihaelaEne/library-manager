package controllers;

import org.junit.Test;
import ro.mycode.controllers.StudentController;
import ro.mycode.model.Student;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StudentControllerTest {

    @Test
    public void testFindByName() {
        ArrayList<Student> students = new ArrayList<>();
        Student s1 = new Student(1, "firt1", "last1", "mail1", 11, "pass1");
        students.add(s1);
        Student s2 = new Student(2, "firt2", "last2", "mail2", 22, "pass2");
        students.add(s2);
        Student s3 = new Student(3, "firt3", "last3", "mail3", 33, "pass3");
        students.add(s3);
        Student s4 = new Student(4, "firt4", "last4", "mail4", 44, "pass4");
        students.add(s4);

        StudentController studentController = new StudentController(students);
        assertEquals(1, studentController.findByName("firt1").getId());
    }

    @Test
    public void testFindWithoutName() {
        ArrayList<Student> students = new ArrayList<>();
        Student s1 = new Student(1, "firt1", "last1", "mail1", 11, "pass1");
        students.add(s1);
        Student s2 = new Student(2, "firt2", "last2", "mail2", 22, "pass2");
        students.add(s2);
        Student s3 = new Student(3, "firt3", "last3", "mail3", 33, "pass3");
        students.add(s3);
        Student s4 = new Student(4, "firt4", "last4", "mail4", 44, "pass4");
        students.add(s4);

        StudentController studentController = new StudentController(students);
        assertNull(studentController.findByName("wedfsef"));
    }

    @Test
    public void testAdd() {
        ArrayList<Student> students = new ArrayList<>();
        Student s1 = new Student(1, "firt1", "last1", "mail1", 11, "pass1");
        students.add(s1);
        Student s2 = new Student(2, "firt2", "last2", "mail2", 22, "pass2");
        students.add(s2);
        Student s3 = new Student(3, "firt3", "last3", "mail3", 33, "pass3");
        students.add(s3);
        Student s4 = new Student(4, "firt4", "last4", "mail4", 44, "pass4");


        StudentController studentController = new StudentController(students);
        assertNotNull(studentController.findByName("firt1"));
    }

    @Test
    public void testRemove() {
        ArrayList<Student> students = new ArrayList<>();
        Student s1 = new Student(1, "firt1", "last1", "mail1", 11, "pass1");
        students.add(s1);
        Student s2 = new Student(2, "firt2", "last2", "mail2", 22, "pass2");
        students.add(s2);
        Student s3 = new Student(3, "firt3", "last3", "mail3", 33, "pass3");
        students.add(s3);
        Student s4 = new Student(4, "firt4", "last4", "mail4", 44, "pass4");
        students.add(s4);
        StudentController studentController = new StudentController(students);
        studentController.removeStudent(s4);
        assertEquals(null, studentController.findByName("firt4"));
    }


}
