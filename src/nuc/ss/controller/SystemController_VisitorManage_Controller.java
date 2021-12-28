package nuc.ss.controller;

import nuc.ss.domain.HouseMaster;
import nuc.ss.domain.Visitor;
import nuc.ss.service.SystemController_VisitorManage_Service;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author 娄靖彬
 * 
 */
public class SystemController_VisitorManage_Controller {
    public static ArrayList<Visitor> searchVisitorMaster() throws SQLException, ClassNotFoundException {
        ArrayList<Visitor> visitorsArrayList = new ArrayList<Visitor>();
        visitorsArrayList = SystemController_VisitorManage_Service.searchVisitor();
        return visitorsArrayList;
    }

    public static boolean updateVisitor(String val, String tid, ArrayList<String> tableHeadList, int column) throws SQLException, ClassNotFoundException {
        SystemController_VisitorManage_Service.updateVisitor(val,tid,tableHeadList,column);
        return true;
    }

    public static boolean addVisitor(Visitor Visitor) throws SQLException, ClassNotFoundException{
        SystemController_VisitorManage_Service.addVisitor(Visitor);
        return true;
    }
}
