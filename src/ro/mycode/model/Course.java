package ro.mycode.model;

public class Course {
    private int id;
    private String name;
    private String department;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    public Course(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Course() {
    }

    public String descriereCurs() {
        String text = "";
        text += "Id-ul cursului " + this.name + " este " + this.id + " si se afla in departamentul:" + this.department;
        return text;
    }

    public Course(String prop) {
        String[] split = prop.split(",");
        this.id = Integer.parseInt(split[0]);
        this.name = split[1];
        this.department = split[2];
    }


    public String toSave() {
        return id + "," + name + "," + department;
    }
}
