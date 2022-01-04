package nuc.ss.service;

import nuc.ss.dao.SystemController_VisitorManage_JDBC;
import nuc.ss.domain.Visitor;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author 娄靖彬
 */
public class SystemController_VisitorManage_Service {
    public static ArrayList<Visitor> searchVisitor() {
        ArrayList<Visitor> visitorsArrayList = new ArrayList<Visitor>();
        try {
            visitorsArrayList = SystemController_VisitorManage_JDBC.searchVisitor();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return visitorsArrayList;
    }

    public static boolean updateVisitor(String val, String tid, ArrayList<String> tableHeadList, int column) {
        try {
            SystemController_VisitorManage_JDBC.updateVisitor(val, tid, tableHeadList, column);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean addVisitor(Visitor Visitor) {
        try {
            SystemController_VisitorManage_JDBC.addVisitor(Visitor);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
