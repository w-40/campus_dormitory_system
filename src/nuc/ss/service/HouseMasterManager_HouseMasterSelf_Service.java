package nuc.ss.service;

import java.sql.SQLException;

import nuc.ss.dao.HouseMasterManager_HouseMasterSelf_JDBC;
import nuc.ss.domain.HouseMaster;

public class HouseMasterManager_HouseMasterSelf_Service {

    public static HouseMaster searchHouseMasterSelf(String id) {
        HouseMaster hm = new HouseMaster();
        try {
            hm = HouseMasterManager_HouseMasterSelf_JDBC.searchStudentMessage(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return hm;
    }

    public static boolean updateHouseMasterPassWord(String tid, String newPassWord) {
        try {
            HouseMasterManager_HouseMasterSelf_JDBC.updateHouseMasterPassWord(tid, newPassWord);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;

    }
}
