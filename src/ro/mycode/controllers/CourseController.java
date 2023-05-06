package ro.mycode.controllers;

import ro.mycode.model.Course;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseController {
    private ArrayList<Course> courses;

    public CourseController(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public CourseController() {
        this.courses = new ArrayList<>();
        this.load();
    }

    public void load() {
        try {
            File file = new File("C:\\mycode\\OOP\\incapsularea\\library-manager\\src\\ro\\mycode\\data\\course.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Course course = new Course(scanner.nextLine());
                this.courses.add(course);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afisareCourse() {
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(this.courses.get(i).descriereCurs());
            System.out.println("\n");
        }
    }

    public void addCurs(Course course) {
        this.courses.add(course);
    }

    public void removeCurS(Course course) {
        this.courses.remove(course);
    }

    public void editareCurs(Course course) {
        Course deEditat = findCursById(course.getId());
        if (course.getDepartment() != null) {
            deEditat.setDepartment(course.getDepartment());
        }
        if (course.getName() != null) {
            deEditat.setName(course.getName());
        }
    }

    public Course findCursById(int id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                return courses.get(i);
            }
        }
        return null;
    }

    public String toSave() {
        String text = "";
        int i = 0;
        for (i = 0; i < courses.size() - 1; i++) {
            text += courses.get(i).toSave();

        }
        text += courses.get(i).toSave();
        return text;
    }

    public void save() {
        try {
            File file = new File("C:\\mycode\\OOP\\incapsularea\\library-manager\\src\\ro\\mycode\\data\\course.txt");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
