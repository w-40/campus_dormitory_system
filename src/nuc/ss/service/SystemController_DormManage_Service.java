package nuc.ss.service;
/**
 * @author hsystart，王志凯
 * @create 2021-12-28 18:34
 */
import nuc.ss.dao.SystemController_DormManage_JDBC;
import nuc.ss.dao.SystemController_DormitoryManage_JDBC;
import nuc.ss.domain.Dorm;
import nuc.ss.domain.Dormitory;

import java.sql.SQLException;
import java.util.ArrayList;

public class SystemController_DormManage_Service {
    public static ArrayList<Dorm> searchDorm() {
        ArrayList<Dorm> DormArrayList = new ArrayList<Dorm>();
        try {
            DormArrayList = SystemController_DormManage_JDBC.searchDorm();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DormArrayList;
    }

    public static String deleteDorm(String tid) {
        try {
            SystemController_DormManage_JDBC.deleteDorm(tid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tid;
    }

    public static boolean updateDorm(String val, String tid, ArrayList<String> tableHeadList, int column) {
        try {
            SystemController_DormManage_JDBC.updateDorm(val, tid, tableHeadList, column);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean addDorm(Dorm Dorm) {
        try {
            SystemController_DormManage_JDBC.addDorm(Dorm);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
