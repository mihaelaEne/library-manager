package ro.mycode.model;

import com.sun.source.tree.BreakTree;

public class Admin {
    private int id;
    private String lastName;
    private String firstName;
    private String mail;
    private String password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin(int id, String lastName, String firstName, String mail, String password) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.mail = mail;
        this.password = password;
    }

    public String descriereAdmin(){
        String text="";
        text+="Numele si prenumele administratorului: "+this.lastName+" "+this.firstName;
        text+="Id: "+this.id;
        text+="Mail: "+this.mail;
        return text;
    }
}
