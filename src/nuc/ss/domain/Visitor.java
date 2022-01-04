package nuc.ss.domain;

import java.util.Calendar;
/**
 * @author 籍乃博
 * @description 访客信息：
 * 姓名、联系方式、来访事宜、访客身份
 */
public class Visitor {

    private String name; // 姓名
    private String tel; //联系方式
    private String visitMatters; //来访事宜
    private String identity; //访客身份

    Calendar cal = Calendar.getInstance();

    int year = cal.get(Calendar.YEAR);   //年
    int month = cal.get(Calendar.MONTH) + 1;  //月 默认是+1，即1月是0
    int day = cal.get(Calendar.DAY_OF_MONTH);  //日
    int hour = cal.get(Calendar.HOUR_OF_DAY);  //时
    int minute = cal.get(Calendar.MINUTE);  //分

    private String time = year + "-" + month + "-" + day + " " + hour + ":" + minute; // 获取系统时间

    public Visitor() {
    }

    public Visitor(String name, String tel, String time, String visitMatters, String identity) {
        this.name = name;
        this.tel = tel;
        this.time = time;
        this.visitMatters = visitMatters;
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getVisitMatters() {
        return visitMatters;
    }

    public void setVisitMatters(String visitMatters) {
        this.visitMatters = visitMatters;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", visitMatters='" + visitMatters + '\'' +
                ", identity='" + identity + '\'' +
                ", cal=" + cal +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                ", minute=" + minute +
                ", time='" + time + '\'' +
                '}';
    }
}
