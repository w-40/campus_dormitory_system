package nuc.ss.domain;

/**
 * @author 王志凯
 * @description 学生基本信息：
 * 学生基本信息包括学号、姓名、性别、年级、宿舍楼号、宿舍号、床位、联系电话
 */
public class Student {

    private String password; //密码
    private String id;//学号
    private String username = id; //账号
    private String name;//姓名
    private char sex;//性别
    private String grade;//年级
    private String dormitoryId;//宿舍号
    private int bed;//床位
    private String phoneNumber;

    public Student() {
    }

    public Student(String username, String password, String id, String name, char sex, String grade, String dormitoryId, int bed, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.grade = grade;
        this.dormitoryId = dormitoryId;
        this.bed = bed;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(String dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", grade='" + grade + '\'' +
                ", dormitoryId='" + dormitoryId + '\'' +
                ", bed=" + bed +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
