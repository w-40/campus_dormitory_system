package nuc.ss.service;
import java.sql.SQLException;
import nuc.ss.dao.AllocateDormitory_JDBC;

public class AllocateDormitory_Service {
    public static boolean allocateDormitory(String username, String l1, String l2, String l3) {
        try {
            AllocateDormitory_JDBC.allocateDormitory(username, l1, l2, l3);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean updateDormitory(String l1, String l2) {
        try {
            AllocateDormitory_JDBC.updateDormitory(l1, l2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean searchDormitory(String l1, String l2, String l3) {
        boolean f = true;
        try {
            f = AllocateDormitory_JDBC.searchDormitory(l1, l2, l3);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return f;
    }

}
