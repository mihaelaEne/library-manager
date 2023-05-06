package controllers;

import org.junit.Test;
import ro.mycode.controllers.AdminController;
import ro.mycode.model.Admin;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AdminControllerTest {
    @Test
    public void testFindById() {
        ArrayList<Admin> admins = new ArrayList<>();
        Admin a1 = new Admin(1, "lastName1", "firstName1", "mail1", "pass1");
        admins.add(a1);
        Admin a2 = new Admin(2, "lastName2", "firstName2", "mail2", "pass2");
        admins.add(a2);
        Admin a3 = new Admin(3, "lastName3", "firstName3", "mail3", "pass3");
        admins.add(a3);
        Admin a4 = new Admin(4, "lastName4", "firstName4", "mail4", "pass4");
        admins.add(a4);

        AdminController adminController = new AdminController(admins);
        assertEquals("firstName4", adminController.findAdminById(4).getFirstName());
    }

    @Test
    public void testFindByIdNull() {
        ArrayList<Admin> admins = new ArrayList<>();
        Admin a1 = new Admin(1, "lastName1", "firstName1", "mail1", "pass1");
        admins.add(a1);
        Admin a2 = new Admin(2, "lastName2", "firstName2", "mail2", "pass2");
        admins.add(a2);
        Admin a3 = new Admin(3, "lastName3", "firstName3", "mail3", "pass3");
        admins.add(a3);
        Admin a4 = new Admin(4, "lastName4", "firstName4", "mail4", "pass4");
        admins.add(a4);

        AdminController adminController = new AdminController(admins);
        assertNull(adminController.findAdminById(88));
    }

    @Test
    public void testAdd() {
        ArrayList<Admin> admins = new ArrayList<>();
        Admin a1 = new Admin(1, "lastName1", "firstName1", "mail1", "pass1");
        admins.add(a1);
        Admin a2 = new Admin(2, "lastName2", "firstName2", "mail2", "pass2");
        admins.add(a2);
        Admin a3 = new Admin(3, "lastName3", "firstName3", "mail3", "pass3");
        admins.add(a3);
        Admin a4 = new Admin(4, "lastName4", "firstName4", "mail4", "pass4");


        AdminController adminController = new AdminController(admins);
        assertNotNull(adminController.findAdminById(1));
    }

    @Test
    public void testRemove() {
        ArrayList<Admin> admins = new ArrayList<>();
        Admin a1 = new Admin(1, "lastName1", "firstName1", "mail1", "pass1");
        admins.add(a1);
        Admin a2 = new Admin(2, "lastName2", "firstName2", "mail2", "pass2");
        admins.add(a2);
        Admin a3 = new Admin(3, "lastName3", "firstName3", "mail3", "pass3");
        admins.add(a3);
        Admin a4 = new Admin(4, "lastName4", "firstName4", "mail4", "pass4");
        admins.add(a4);

        AdminController adminController = new AdminController(admins);
        adminController.removeAdmin(a4);
        assertEquals(null, adminController.findAdminById(4));
    }

}
