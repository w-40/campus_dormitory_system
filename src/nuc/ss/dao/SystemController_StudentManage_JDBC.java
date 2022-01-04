package nuc.ss.dao;

import nuc.ss.domain.HouseMaster;
import nuc.ss.domain.Student;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author hsystart
 * @create 2021-12-27 16:20
 */
public class SystemController_StudentManage_JDBC {
    public static ArrayList searchStudent() {
        ArrayList<Student> studentslist = new ArrayList<Student>();
        String grade = null;//年级
        String id = null;
        String name = null; //姓名
        String password = null; //姓名
        char sex = 0;//性别
        String dormitoryId; //管理宿舍楼号
        String apartmentId;//宿舍号
        int bedId = 0;//床号
        String phoneNumber = null; //联系电话

        Student sd = null;
        // 1.导入jar包
        // 2.注册驱动
        // 3.获取连接
        Connection con = null;
        // 4.获取执行者对象
        Statement stat = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");//MySQL5版本后可以省略注册步骤
            con = DriverManager.getConnection("jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8", "wzk", "2013040431");

            stat = con.createStatement();

            // 5. 执行sql语句，并且接收结果
            String sql = "SELECT * FROM 学生基本信息";
            rs = stat.executeQuery(sql);
            // 6.处理结果
            while (rs.next()) {
                grade = rs.getString("年级");
                id = rs.getString("学号");
                name = rs.getString("姓名");
                password = rs.getString("密码");
                sex = rs.getString("性别").charAt(0); //性别
                dormitoryId = rs.getString("宿舍楼号");//管理宿舍楼号
                apartmentId = rs.getString("宿舍号");
                bedId = Integer.parseInt(rs.getString("床位"));
                phoneNumber = rs.getString("联系电话");//联系电话
                sd = new Student(grade, id, name, password, sex, dormitoryId, apartmentId, bedId, phoneNumber);
                studentslist.add(sd);
            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (stat != null) {
                    stat.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        // 7.释放资源
        return studentslist;
    }

    public static boolean deleteStudent(String tid) {
        ArrayList<Student> studentslist = new ArrayList<Student>();
        String grade = null;//年级
        String id = null;
        String name = null; //姓名
        String password = null; //姓名
        char sex = 0;//性别
        String dormitoryId; //管理宿舍楼号
        String apartmentId;//宿舍号
        int bedId = 0;//床号
        String phoneNumber = null; //联系电话

        Student sd = null;
        // 2.注册驱动
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
            con = DriverManager.getConnection(url, "wzk", "2013040431");
            String sql = "DELETE FROM 学生基本信息 WHERE 学号=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, tid);
            pstmt.executeUpdate();//执行删除SQL语句，数据库中即删掉一条记录
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        // 释放资源

        return true;
    }

    public static boolean updateStudent(String val, String tid, ArrayList<String> tableHeadList, int column) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
            conn = DriverManager.getConnection(url, "wzk", "2013040431");
            String sql = "UPDATE 学生基本信息 SET " + tableHeadList.get(column) + " = ? WHERE 学号 = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, val);
            pstmt.setString(2, tid);
            pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return true;
    }

    public static boolean updateSet(String val, String tid, ArrayList<String> tableHeadList, int column) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
            conn = DriverManager.getConnection(url, "wzk", "2013040431");
            String sql = "UPDATE 学生基本信息 SET " + tableHeadList.get(column) + " = ? WHERE 学号 = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, val);
            pstmt.setString(2, tid);
            pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return true;
    }


    public static boolean addStudent(Student Student) {
        String grade = Student.getGrade();
        String id = Student.getId();
        String name = Student.getName();
        String password = Student.getPassword();
        char sex = Student.getSex();
        String dormitoryId = Student.getDormitoryId();
        String apartmentId = Student.getApartmentId();
        int bedId = Student.getBed();
        String phoneNumber = Student.getPhoneNumber();
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
            conn = DriverManager.getConnection(url, "wzk", "2013040431");
            String sql = "insert into 学生基本信息 values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, grade);
            pstmt.setString(2, id);
            pstmt.setString(3, name);
            pstmt.setString(4, password);
            pstmt.setString(5, sex + "");
            pstmt.setString(6, dormitoryId);
            pstmt.setString(7, apartmentId);
            pstmt.setString(8, bedId + " ");
            pstmt.setString(9, phoneNumber);
            pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return true;
    }
}
