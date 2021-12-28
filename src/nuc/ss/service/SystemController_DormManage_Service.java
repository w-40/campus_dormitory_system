package nuc.ss.service;

import nuc.ss.dao.SystemController_DormManage_JDBC;
import nuc.ss.dao.SystemController_DormitoryManage_JDBC;
import nuc.ss.domain.Dorm;
import nuc.ss.domain.Dormitory;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author hsystart
 * @create 2021-12-28 18:34
 */
public class SystemController_DormManage_Service {
    public static ArrayList<Dorm> searchDorm() throws SQLException, ClassNotFoundException {
        ArrayList<Dorm> DormArrayList = new ArrayList<Dorm>();
        DormArrayList = SystemController_DormManage_JDBC.searchDorm();
        return DormArrayList;
    }

    public static String deleteDorm(String tid) throws SQLException, ClassNotFoundException {
        SystemController_DormManage_JDBC.deleteDorm(tid);
        return tid;
    }
    public static boolean updateDorm(String val,String tid, ArrayList<String> tableHeadList,int column) throws SQLException, ClassNotFoundException {
        SystemController_DormManage_JDBC.updateDorm(val,tid,tableHeadList,column);
        return true;
    }

    public static boolean addDorm(Dorm Dorm) throws SQLException, ClassNotFoundException{
        SystemController_DormManage_JDBC.addDorm(Dorm);
        return true;
    }
}
