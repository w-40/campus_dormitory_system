package nuc.ss.domain;

/**
 * @author 王志凯
 * @description 宿舍楼基本信息：宿舍楼名称，宿舍楼号
 */
public class Dormitory {
    private String id; //宿舍楼号
    private String name; //宿舍名称

    public Dormitory() {
    }

    public Dormitory(String id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Dormitory{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
