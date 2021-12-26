package nuc.ss.domain;

/**
 * @author 王志凯
 * @description 宿管基本信息：
 * 工号、姓名、性别、管理宿舍楼号、联系电话
 */
public class HouseMaster {
    private String id;  //工号
    private String password;
    private String name; //姓名
    private char sex; //性别
    private String dormitoryId; //管理的宿舍楼号
    private String phoneNumber; //联系电话

    public HouseMaster() {
    }

    public HouseMaster(String id, String password, String name, char sex, String dormitoryId, String phoneNumber) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.dormitoryId = dormitoryId;
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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(String dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    @Override
    public String toString() {
        return "HouseMaster{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", dormitory_id='" + dormitoryId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
