package nuc.ss.service;

import nuc.ss.dao.SystemController_VisitorManage_JDBC;
import nuc.ss.domain.Visitor;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author 娄靖彬
 * 
 */
public class SystemController_VisitorManage_Service {
    public static ArrayList<Visitor> searchVisitor() throws SQLException, ClassNotFoundException {
        ArrayList<Visitor> visitorsArrayList = new ArrayList<Visitor>();
        visitorsArrayList = SystemController_VisitorManage_JDBC.searchVisitor();
        return visitorsArrayList;
    }

    public static boolean updateVisitor(String val, String tid, ArrayList<String> tableHeadList, int column) throws SQLException, ClassNotFoundException {
        SystemController_VisitorManage_JDBC.updateVisitor(val,tid,tableHeadList,column);
        return true;
    }

    public static boolean addVisitor(Visitor Visitor) throws SQLException, ClassNotFoundException{
        SystemController_VisitorManage_JDBC.addVisitor(Visitor);
        return true;
    }
}
