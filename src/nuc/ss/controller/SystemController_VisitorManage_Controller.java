package nuc.ss.controller;
/**
 * @author 娄靖彬
 */
import nuc.ss.domain.Visitor;
import nuc.ss.service.SystemController_VisitorManage_Service;
import java.sql.SQLException;
import java.util.ArrayList;

public class SystemController_VisitorManage_Controller {
    public static ArrayList<Visitor> searchVisitorMaster(String username) throws SQLException, ClassNotFoundException {
        ArrayList<Visitor> visitorsArrayList = new ArrayList<Visitor>();
        visitorsArrayList = SystemController_VisitorManage_Service.searchVisitor(username);
        return visitorsArrayList;
    }

    public static boolean updateVisitor(String val, String tid, ArrayList<String> tableHeadList, int column,String time) throws SQLException, ClassNotFoundException {
        SystemController_VisitorManage_Service.updateVisitor(val, tid, tableHeadList, column,time);
        return true;
    }

    public static boolean addVisitor(Visitor Visitor,String username) throws SQLException, ClassNotFoundException {
        SystemController_VisitorManage_Service.addVisitor(Visitor,username);
        return true;
    }
}
