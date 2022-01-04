package nuc.ss.service;
/**
 * @author 王志凯，段福泉
 * @description 宿管管理业务层：
 * searchHouseMaster()：将接收到的ArrayList对象传给宿管管理控制层
 * deleteHouseMaster(String tid)：接收宿舍管理控制层界面数据，传递到数据访问层
 * updateHouseMaster(String val,String tid, ArrayList<String> tableHeadList,int column)：接收宿舍管理控制层界面数据，传递到数据访问层
 * addHouseMaster(HouseMaster houseMaster)：接收宿舍管理控制层界面数据，传递到数据访问层
 */
import nuc.ss.dao.SystemController_HouseMasterManage_JDBC;
import nuc.ss.controller.SystemController_HouseMasterManage_Controller;
import nuc.ss.domain.HouseMaster;

import java.sql.SQLException;
import java.util.ArrayList;

public class SystemController_HouseMasterManage_Service {

    public static ArrayList<HouseMaster> searchHouseMaster() {
        ArrayList<HouseMaster> houseMasterArrayList = new ArrayList<HouseMaster>();
        try {
            houseMasterArrayList = SystemController_HouseMasterManage_JDBC.searchHouseMaster();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return houseMasterArrayList;
    }

    public static String deleteHouseMaster(String tid) {
        try {
            SystemController_HouseMasterManage_JDBC.deleteHouseMaster(tid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tid;
    }

    public static boolean updateHouseMaster(String val, String tid, ArrayList<String> tableHeadList, int column)  {
        try {
            SystemController_HouseMasterManage_JDBC.updateHouseMaster(val, tid, tableHeadList, column);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean addHouseMaster(HouseMaster houseMaster) {
        try {
            SystemController_HouseMasterManage_JDBC.addHouseMaster(houseMaster);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
