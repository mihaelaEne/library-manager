package ro.mycode.controllers;

import ro.mycode.model.Admin;
import ro.mycode.model.Book;
import ro.mycode.model.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminController {

    private ArrayList<Admin>admins;
    public AdminController(ArrayList<Admin>admins){
        this.admins=admins;
    }

    public AdminController(){
        this.admins=new ArrayList();
        this.load();
    }

    public void load(){
        try{
            File file=new File("C:\\mycode\\OOP\\incapsularea\\library-manager\\src\\ro\\mycode\\data\\admin.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Admin admin=new Admin(scanner.nextLine());
                this.admins.add(admin);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }



    public void afisareAdmin(){
        for(int i=0; i< admins.size(); i++){
            System.out.println(this.admins.get(i).descriereAdmin());
            System.out.println("\n");
        }
    }


    public void addAdmin(Admin admin){
        this.admins.add(admin);
    }

    public void removeAdmin(Admin admin){
        this.admins.remove(admin);
    }


    public Admin findAdminById(int id){
        for(int i=0; i<admins.size();i++){
            if(admins.get(i).getId()==id){
                return admins.get(i);
            }
        }
        return null;
    }

public String toSave(){
        String text="";
        int i=0;
        for (i=0; i< admins.size()-1; i++){
            text+=admins.get(i).toSave()+"\n";
        }
        text+=admins.get(i).toSave();
        return text;
}

public void save(){
        try{
            File file=new File("C:\\mycode\\OOP\\incapsularea\\library-manager\\src\\ro\\mycode\\data\\admin.txt");
            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
}




public void editareAdmin(Admin admin){
        Admin deEdiatat=findAdminById(admin.getId());
        if(admin.getMail()!=null){
            deEdiatat.setMail(admin.getMail());
        }
        if(admin.getLastName()!=null){
            deEdiatat.setLastName(admin.getLastName());
        }
}


    public Admin findAdminConectare(String email, String password){
        for(int i=0; i<admins.size();i++){
            Admin admin=admins.get(i);
            if(admin.getMail().equals(email)&&admin.getPassword().equals(password)){
                return admin;
            }
        }
        return null;
    }






}
