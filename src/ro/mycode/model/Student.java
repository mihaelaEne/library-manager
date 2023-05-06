package ro.mycode.model;

import java.util.ArrayList;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String password;

    public Student(int id, String firstName, String lastName, String email, int age, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.password = password;

    }


    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Student(String prop) {
        String[] split = prop.split(",");
        this.id = Integer.parseInt(split[0]);
        this.firstName = split[1];
        this.lastName = split[2];
        this.email = split[3];
        this.age = Integer.parseInt(split[4]);
        this.password = split[5];
    }

    public String descriereStudent() {
        String text = "";
        text += "Id: " + this.id + "\n";
        text += "First name: " + this.firstName + "\n";
        text += "Last name: " + this.lastName + "\n";
        text += "Email: " + this.email + "\n";
        text += "Age: " + this.age + "\n";
        text += "Parola este " + this.password;
        return text;
    }

    public String toSave() {
        return id + "," + firstName + "," + lastName + "," + email + "," + age + "," + password;
    }
}
