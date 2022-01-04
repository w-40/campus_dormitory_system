package nuc.ss.domain;

/**
 * @author 王志凯
 * @description 学生基本信息：
 * 学生基本信息包括学号、姓名、性别、年级、宿舍楼号、宿舍号、床位、联系电话
 */
public class Student {
    private String id;//学号
    private String password; //密码
    private String name;//姓名
    private Character sex;//性别
    private String grade;//年级
    private String apartmentId;//楼号
    private String dormitoryId;//宿舍号

    private int bed;//床位
    private String phoneNumber; //电话
    private String message;

    public Student() {
    }

    public Student(String id, char sex, String apartmentId, String dormitoryId, int bed) {
        this.id = id;
        this.sex = sex;
        this.dormitoryId = dormitoryId;
        this.apartmentId = apartmentId;
        this.bed = bed;
    }

    public Student(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String grade, String id, String name, String password, char sex, String dormitoryId, String apartmentId, int bed, String phoneNumber) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.grade = grade;
        this.dormitoryId = dormitoryId;
        this.bed = bed;
        this.phoneNumber = phoneNumber;
        this.apartmentId = apartmentId;
    }

    public Student(String id, String password, String name, char sex, String grade, String apartmentId,String dormitoryId,  int bed, String phoneNumber) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.grade = grade;
        this.dormitoryId = dormitoryId;
        this.apartmentId = apartmentId;
        this.bed = bed;
        this.phoneNumber = phoneNumber;
    }

    public Student(String id, String password, String name, char sex, String grade, String dormitoryId, String apartmentId, int bed, String phoneNumber, String message) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.grade = grade;
        this.dormitoryId = dormitoryId;
        this.apartmentId = apartmentId;
        this.bed = bed;
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(String apartmentId) {
        this.apartmentId = apartmentId;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
