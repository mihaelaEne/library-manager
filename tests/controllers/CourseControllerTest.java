package controllers;

import org.junit.Test;
import ro.mycode.controllers.CourseController;
import ro.mycode.model.Course;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CourseControllerTest {
    @Test
    public void testFindById() {
        ArrayList<Course> courses = new ArrayList<>();
        Course c1 = new Course(1, "nume1", "depart1");
        courses.add(c1);
        Course c2 = new Course(2, "nume2", "depart2");
        courses.add(c2);
        Course c3 = new Course(3, "nume 3", "depart3");
        courses.add(c3);
        Course c4 = new Course(4, "nume4", "depart4");
        courses.add(c4);

        CourseController courseController = new CourseController(courses);
        assertEquals("depart1", courseController.findCursById(1).getDepartment());
    }

    @Test
    public void testFindByIdNull() {
        ArrayList<Course> courses = new ArrayList<>();
        Course c1 = new Course(1, "nume1", "depart1");
        courses.add(c1);
        Course c2 = new Course(2, "nume2", "depart2");
        courses.add(c2);
        Course c3 = new Course(3, "nume 3", "depart3");
        courses.add(c3);
        Course c4 = new Course(4, "nume4", "depart4");
        courses.add(c4);

        CourseController courseController = new CourseController(courses);
        assertNull(courseController.findCursById(100));
    }

    @Test
    public void testAdd() {
        ArrayList<Course> courses = new ArrayList<>();
        Course c1 = new Course(1, "nume1", "depart1");
        courses.add(c1);
        Course c2 = new Course(2, "nume2", "depart2");
        courses.add(c2);
        Course c3 = new Course(3, "nume 3", "depart3");
        courses.add(c3);
        Course c4 = new Course(4, "nume4", "depart4");
        courses.add(c4);

        CourseController courseController = new CourseController(courses);
        assertNotNull(courseController.findCursById(1));
    }

    @Test
    public void testRemove() {
        ArrayList<Course> courses = new ArrayList<>();
        Course c1 = new Course(1, "nume1", "depart1");
        courses.add(c1);
        Course c2 = new Course(2, "nume2", "depart2");
        courses.add(c2);
        Course c3 = new Course(3, "nume 3", "depart3");
        courses.add(c3);
        Course c4 = new Course(4, "nume4", "depart4");
        courses.add(c4);

        CourseController courseController = new CourseController(courses);
        courseController.removeCurS(c2);
        assertEquals(null, courseController.findCursById(2));
    }

}
