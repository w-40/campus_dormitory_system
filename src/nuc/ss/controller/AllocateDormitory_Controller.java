package nuc.ss.controller;

import java.sql.SQLException;

import nuc.ss.service.AllocateDormitory_Service;

//调service
public class AllocateDormitory_Controller {
    public static boolean allocateDormitory(String username, String l1, String l2, String l3) throws SQLException, ClassNotFoundException {
        AllocateDormitory_Service.allocateDormitory(username, l1, l2, l3);
        return true;
    }

    public static boolean updateDormitory(String l1, String l2) throws SQLException, ClassNotFoundException {
        AllocateDormitory_Service.updateDormitory(l1, l2);
        return true;
    }

    public static boolean searchDormitory(String l1, String l2, String l3) throws SQLException, ClassNotFoundException {
        boolean f = true;
        f = AllocateDormitory_Service.searchDormitory(l1, l2, l3);
        return f;
    }

}
