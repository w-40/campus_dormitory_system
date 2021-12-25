package nuc.ss.domain;

/**
 * @author 王志凯
 * @description 学生基本信息：
 * 学生基本信息包括学号、姓名、性别、年级、宿舍楼号、宿舍号、床位、联系电话
 */
public class Student {
    private String id;//学号
    private String name;//姓名
    private Sex sex;//性别
    private String grade;//年级
    private String dormitoryId;//宿舍号
    private int bed;//床位
    private String phoneNumber;

    public Student() {
    }

    public Student(String id, String name, Sex sex, String grade, String dormitoryId, int bed, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.grade = grade;
        this.dormitoryId = dormitoryId;
        this.bed = bed;
        this.phoneNumber = phoneNumber;
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
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
