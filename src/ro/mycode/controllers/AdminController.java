package ro.mycode.controllers;

import ro.mycode.model.Admin;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminController {

    private ArrayList<Admin>admins=new ArrayList<>();
    public AdminController(ArrayList<Admin>admins){
        this.admins=admins;
    }

    public AdminController(){
        this.admins=new ArrayList<>();
        this.load();
    }

    public void load(){
        try{
            File file=new File("C:\\mycode\\OOP\\incapsularea\\library-manager\\src\\ro\\mycode\\model\\Admin.java");
            Scanner scanner=new Scanner(file);
            while (scanner.hasNextLine()){
                Admin admin=new Admin(scanner.nextLine());
                this.admins.add(admin);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
