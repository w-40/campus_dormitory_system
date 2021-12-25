package nuc.ss.domain;

/**
 * @author 王志凯
 * @description 宿舍基本信息包括：宿舍号，所在宿舍楼号、人数，六个床位对应学生的。
 */
public class Dorm {
    private int id;//宿舍号
    private String dormitoryId;//所在宿舍楼号
    private int num;//人数
    //private String firstStudentId;//一号床学号
    //private String secondName;//二号床
    //private String thirdName;//三号床
    //private String fourthName;//四号床
    //private String fifthName;//五号床
    //private String sixthName;//六号楼

    public Dorm() {
    }

    public Dorm(int id, String dormitoryId, int num) {
        this.id = id;
        this.dormitoryId = dormitoryId;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(String dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Dorm{" +
                "id=" + id +
                ", dormitoryId='" + dormitoryId + '\'' +
                ", num=" + num +
                '}';
    }
}
