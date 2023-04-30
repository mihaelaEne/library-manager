package ro.mycode.model;

import java.time.LocalDate;

public class Book {
    private int id;
    private int studentId;

    private String title;

    private String autor;

    LocalDate createAt;


    public Book(){};

    public Book(String prop){
        String [] split=prop.split(",");
        this.id=Integer.parseInt(split[0]);
        this.studentId=Integer.parseInt(split[1]);
        this.title=split[2];
        this.autor=split[3];
        this.createAt=LocalDate.parse(split[4]);

    }
    public Book(int id, int studentId, String title, String autor, LocalDate createAt) {
        this.id = id;
        this.studentId = studentId;
        this.title = title;
        this.autor = autor;
        this.createAt = createAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public String descriereBook(){
        String text="";
        text+="Id: "+this.id+"\n";
        text+="Student Id: " +this.studentId+"\n";
        text+="Title: "+this.title+"\n";
        text+="Autor: "+this.autor+"\n";
        text+="Created at: "+this.createAt;
        return text;
    }

    public String toSave(){
        return id+","+studentId+","+title+","+autor+","+createAt;
    }
}
