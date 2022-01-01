package nuc.ss.service;

import java.sql.SQLException;
import nuc.ss.dao.AllocateDormitory_JDBC;

public class AllocateDormitory_Service {
	public static boolean allocateDormitory(String username,String l1,String l2,String l3) throws SQLException, ClassNotFoundException {
		AllocateDormitory_JDBC.allocateDormitory(username, l1, l2, l3);
		return true;
    }
	
	public static boolean updateDormitory(String l1,String l2) throws SQLException, ClassNotFoundException {
		AllocateDormitory_JDBC.updateDormitory(l1, l2);
        return true;
    }
	
	public static boolean searchDormitory(String l1,String l2,String l3) throws SQLException, ClassNotFoundException {
        boolean f = true;
        f = AllocateDormitory_JDBC.searchDormitory(l1, l2, l3);
        return f;
	}

}
