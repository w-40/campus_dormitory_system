package nuc.ss.service;

import java.sql.SQLException;

import nuc.ss.dao.HouseMasterManager_HouseMasterSelf_JDBC;
import nuc.ss.domain.HouseMaster;

public class HouseMasterManager_HouseMasterSelf_Service {

	 public static HouseMaster searchHouseMasterSelf(String id) throws SQLException, ClassNotFoundException {
	        HouseMaster hm = new HouseMaster();
	        hm = HouseMasterManager_HouseMasterSelf_JDBC.searchStudentMessage(id) ;
	        return hm;
	    } 
}
