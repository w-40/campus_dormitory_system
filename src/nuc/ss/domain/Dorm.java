package nuc.ss.domain;
/**
 * @author 王志凯
 * @description 宿舍基本信息包括：宿舍号，所在宿舍楼号、人数，六个床位对应学生的。
 */
public class Dorm {
    private Integer id;//宿舍号
    private String dormitoryId;//所在宿舍楼号
    private Integer num;//人数

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
