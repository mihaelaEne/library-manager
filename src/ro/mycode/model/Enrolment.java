package ro.mycode.model;

public class Enrolment {
    private int id;
    private int studentId;
    private int cursId;

    public Enrolment(int id, int studentId, int cursId) {
        this.id = id;
        this.studentId = studentId;
        this.cursId = cursId;
    }

    public Enrolment(){}

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

    public int getCursId() {
        return cursId;
    }

    public void setCursId(int cursId) {
        this.cursId = cursId;
    }

    public String descriereEnrolment(){
       return "Id: "+this.id+", id-ul STUDENTULUI este: "+this.studentId+", id-ul cursului: "+this.cursId;
    }

    public Enrolment(String prop){
        String [] split=prop.split(",");
        this.id = Integer.parseInt(split[0]);
        this.studentId = Integer.parseInt(split[1]);
        this.cursId = Integer.parseInt(split[2]);
    }

    public String toSave(){
        return id + "," + cursId + "," + studentId;
    }


}
