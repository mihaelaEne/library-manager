package ro.mycode.view;

import ro.mycode.controllers.AdminController;
import ro.mycode.controllers.BookController;
import ro.mycode.controllers.CourseController;
import ro.mycode.controllers.StudentController;
import ro.mycode.model.Admin;
import ro.mycode.model.Course;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewAdmin {

    private CourseController courseController;
    private Scanner scanner;
    private Admin admins;
    private StudentController studentController;
    private AdminController adminController;


    public ViewAdmin(Admin admin) {
        adminController = new AdminController();
        courseController = new CourseController();
        scanner = new Scanner(System.in);
        play();
    }


    public void meniu() {
        System.out.println("Buna, administratorule");
        System.out.println("Apasa 1 ca sa vezi toti administratorii");
        System.out.println("Apasa 2 pentru a adauga un admin");
        System.out.println("Apasa 3 pentru a sterge un admin");
        System.out.println("Apasa 4 pentru a edita un admin");
        System.out.println("Apasa 5 pentru a salava adminul si a ieesi");
        System.out.println("8-afisare cursuri");
        System.out.println("9-adaugare Curs");
        System.out.println("10-stergere curs");
        System.out.println("11-editare curs");
        System.out.println("12-salveaza cursul si iesi");
        System.out.println("13-iesire fara salvarea cursului");
    }

    public void play() {
        int alegere = 0;
        boolean running = true;
        while (running) {
            meniu();
            alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    adminController.afisareAdmin();
                    break;
                case 2:
                    adaugareAdmin();
                    break;
                case 3:
                    stergereAdmin();
                    break;
                case 4:
                    editareAdmin();
                    break;
                case 5:
                    running = false;
                    adminController.save();
                    System.out.println("V-ati delogat");
                    break;
                case 8:
                    courseController.afisareCourse();
                    break;
                case 9:
                    adaugareCurs();
                    break;
                case 10:
                    stergereCurs();
                    break;
                case 11:
                    editareCurs();
                    break;
                case 12:
                    running = false;
                    courseController.save();
                    System.out.println("V-ati delogat");
                    break;
                case 13:
                    running = false;
                    System.out.println("V-ati delogat");

                default:
                    System.out.println("Alegere incorecta!");
                    break;
            }
        }
    }


    private void adaugareAdmin() {
        System.out.println("Id:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Last name:");
        String laastName = scanner.nextLine();
        System.out.println("First name:");
        String fistName = scanner.nextLine();
        System.out.println("Mail:");
        String mail = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();
        Admin admin = adminController.findAdminById(id);
        if (admin == null) {
            Admin aNou = new Admin(id, laastName, fistName, mail, password);
            adminController.addAdmin(aNou);

        } else {
            System.out.println("Adminul exista deja");
        }

    }

    private void stergereAdmin() {
        System.out.println("Intr id-ul:");
        int id = Integer.parseInt(scanner.nextLine());
        Admin admin = adminController.findAdminById(id);
        if (admin == null) {
            System.out.println("Nu exista adminul");
        } else {
            adminController.removeAdmin(admin);
            System.out.println("Adminul a fost sters");
        }
    }


    private void editareAdmin() {
        System.out.println("Intr id-ul:");
        int id = Integer.parseInt(scanner.nextLine());
        Admin admin = adminController.findAdminById(id);
        if (admin == null) {
            System.out.println("Nu exista un admin cu id-ul introdus");
        } else {
            System.out.println("Introduceti cu virgula ce doresti sa modifici(mail,lastName):");
            String[] upd = scanner.nextLine().split(",");
            Admin nou = new Admin();

            nou.setId(admins.getId());
            for (int i = 0; i < upd.length; i++) {
                switch (upd[i]) {
                    case "mail":
                        System.out.println("Intr mail-ul:");
                        String mail = scanner.nextLine();
                        nou.setMail(mail);
                        break;
                    case "lastName":
                        System.out.println("Intr lastName-ul:");
                        String lastName = scanner.nextLine();
                        nou.setLastName(lastName);
                        break;
                    default:
                        System.out.println("Eroare");
                }
            }
            adminController.editareAdmin(nou);
        }


    }


    private void adaugareCurs() {
        System.out.println("Id:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("Department:");
        String department = scanner.nextLine();

        Course course1 = courseController.findCursById(id);
        if (course1 == null) {
            Course cNou = new Course(id, name, department);
            courseController.addCurs(cNou);
        } else {
            System.out.println("Cursul exista deja");
        }
    }

    private void stergereCurs() {
        System.out.println("Intr id-ul:");
        int id = Integer.parseInt(scanner.nextLine());
        Course course1 = courseController.findCursById(id);
        if (course1 == null) {
            System.out.println("Nu exista cursul");
        } else {
            courseController.removeCurS(course1);
            System.out.println("Cursul a fost sters");
        }
    }

    private void editareCurs() {
        System.out.println("Intr id=ul");
        int id = Integer.parseInt(scanner.nextLine());

        Course course1 = courseController.findCursById(id);
        if (course1 == null) {
            System.out.println("Nu exista un curs cu id-ul introdus");
        } else {
            System.out.println("Intr cu virgula ce dorestib sa modifici (name, department");
            String[] upd = scanner.nextLine().split(",");
            Course nou = new Course();
            for (int i = 0; i < upd.length; i++) {
                switch (upd[i]) {
                    case "name":
                        System.out.println("Intr numele:");
                        String name = scanner.nextLine();
                        break;
                    case "department":
                        System.out.println("Intr departamentul:");
                        String department = scanner.nextLine();
                        break;

                    default:
                        System.out.println("Eroare");
                        break;
                }
            }
            courseController.editareCurs(nou);
        }
    }


}
