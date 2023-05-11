package ro.mycode.controllers;

import ro.mycode.model.Admin;
import ro.mycode.model.Enrolment;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Predicate;

public class EnrolmentController {


    private ArrayList<Enrolment>enrolments;

    public EnrolmentController(ArrayList<Enrolment>enrolments){
        this.enrolments=enrolments;
    }
    public EnrolmentController(){
        this.enrolments=new ArrayList<>();

        this.load();
    }

    public void load(){
        try{
            File file=new File("C:\\mycode\\OOP\\incapsularea\\library-manager\\src\\ro\\mycode\\data\\enrolment.txt");
            Scanner scanner=new Scanner(file);
            while (scanner.hasNextLine()){
                Enrolment enrolment=new Enrolment(scanner.nextLine());
                this.enrolments.add(enrolment);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void afisareEnrolment(){
        for(int i=0; i<enrolments.size();i++){
            System.out.println(this.enrolments.get(i).descriereEnrolment());
            System.out.println("\n");
        }
    }


    public void addEnrolment(Enrolment enrolment){
        this.enrolments.add(enrolment);}
    public void removeEnrolment(Enrolment enrolment){
        this.enrolments.remove(enrolment);}

    public Enrolment findAdminByIdd(int id){
        for(int i=0; i<enrolments.size();i++){
            if(enrolments.get(i).getId()==id){
                return enrolments.get(i);
            }
        }
        return null;
    }

    public String toSave(){
        String text="";
        int i=0;
        for (i=0; i< enrolments.size()-1; i++){
            text+=enrolments.get(i).toSave()+"\n";
        }
        text+=enrolments.get(i).toSave();
        return text;
    }

    public void save(){
        try{
            File file=new File("C:\\mycode\\OOP\\incapsularea\\library-manager\\src\\ro\\mycode\\data\\enrolment.txt");
            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
public int findMostPopularCourse() {
    int returnValue = -1;
    int maxCount = 0;
    Enrolment[] array = enrolments.toArray(new Enrolment[enrolments.size()]);
    for (int i = 0; i < array.length; i++) {
        int counter = 1;
        for (int j = 0; j < array.length; j++) {
            if (i != j && array[i].getCursId() == array[j].getCursId()) {
                counter++;
            }
        }

        if (counter > maxCount) {
            maxCount = counter;
            returnValue = array[i].getCursId();
        }
    }

    return returnValue;
}
}
