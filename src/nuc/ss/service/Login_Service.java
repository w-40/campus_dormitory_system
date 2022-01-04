package nuc.ss.service;
/**
 * @author 王志凯
 * @description 登录业务层，接收登录控制层的数据，将数据发送到数据访问层，并接收数据访问层的执行结果，返回到登录控制层
 */

import nuc.ss.dao.Login_JDBC;

import java.sql.SQLException;


public class Login_Service {
    public static boolean systemControllerLogin(String username, String password) throws Exception {
        boolean flag = Login_JDBC.systemControllerLogin(username, password);
        return flag;
    }

    public static boolean dormitoryControllerLogin(String username, String password) throws SQLException, ClassNotFoundException {
        boolean flag = Login_JDBC.dormitoryControllerLogin(username, password);
        return flag;
    }

    public static boolean studentLogin(String username, String password) throws SQLException, ClassNotFoundException {
        boolean flag = Login_JDBC.studentLogin(username, password);
        return flag;
    }
}
