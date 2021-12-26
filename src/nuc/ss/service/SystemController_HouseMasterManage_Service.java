package nuc.ss.service;
/**
 * @author 王志凯
 * @description 宿管管理业务层：
 * searchHouseMaster()：将接收到的ArrayList对象传给宿管管理控制层
 */
import nuc.ss.dao.SystemController_HouseMasterManage_JDBC;
import nuc.ss.domain.HouseMaster;

import java.sql.SQLException;
import java.util.ArrayList;

public class SystemController_HouseMasterManage_Service {

    public static ArrayList<HouseMaster> searchHouseMaster() throws SQLException, ClassNotFoundException {
        ArrayList<HouseMaster> houseMasterArrayList = new ArrayList<HouseMaster>();
        houseMasterArrayList = SystemController_HouseMasterManage_JDBC.searchHouseMaster();
        return houseMasterArrayList;
    }
}
