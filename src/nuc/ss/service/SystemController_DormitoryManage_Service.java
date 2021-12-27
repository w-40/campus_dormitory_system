package nuc.ss.service;
/**
 * @author 王志凯,卫黎明
 * @description 宿舍楼管理业务层：
 * searcDormitory()：将接收到的ArrayList对象传给宿舍楼管理控制层
 * deleteDormitory(String tid)：接收宿舍管理控制层界面数据，传递到数据访问层
 * updateDormitory(String val,String tid, ArrayList<String> tableHeadList,int column)：接收宿舍管理控制层界面数据，传递到数据访问层
 * addDormitory(Dormitory dormitory)：接收宿舍管理控制层界面数据，传递到数据访问层
 */
import nuc.ss.dao.SystemController_DormitoryManage_JDBC;
import nuc.ss.controller.SystemController_DormitoryManage_Controller;
import nuc.ss.domain.Dormitory;

import java.sql.SQLException;
import java.util.ArrayList;

public class SystemController_DormitoryManage_Service {

    public static ArrayList<Dormitory> searchDormitory() throws SQLException, ClassNotFoundException {
        ArrayList<Dormitory> dormitoryArrayList = new ArrayList<Dormitory>();
        dormitoryArrayList = SystemController_DormitoryManage_JDBC.searchDormitory();
        return dormitoryArrayList;
    }

    public static String deleteDormitory(String tid) throws SQLException, ClassNotFoundException {
        SystemController_DormitoryManage_JDBC.deleteDormitory(tid);
    	return tid;
    }
    public static boolean updateDormitory(String val,String tid, ArrayList<String> tableHeadList,int column) throws SQLException, ClassNotFoundException {
        SystemController_DormitoryManage_JDBC.updateDormitory(val,tid,tableHeadList,column);
        return true;
    }

    public static boolean addDormitory(Dormitory dormitory) throws SQLException, ClassNotFoundException{
        SystemController_DormitoryManage_JDBC.addDormitory(dormitory);
        return true;
    }
}
