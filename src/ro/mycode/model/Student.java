package ro.mycode.model;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;

    public Student(int id, String firstName, String lastName, String email, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Student(){}

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


    public Student(String prop){
        String [] split= prop.split(",");
        this.id=Integer.parseInt(split[0]);
        this.firstName=split[1];
        this.lastName=split[2];
        this.email=split[3];
        this.age=Integer.parseInt(split[4]);
    }
    public String descriereStudent(){
        String text="";
        text+="Id: "+this.id+"\n";
        text+="First name: "+this.firstName+"\n";
        text+="Last name: "+this.lastName+"\n";
        text+="Email: "+this.email+"\n";
        text+="Age: "+this.age;
        return text;
    }

}
