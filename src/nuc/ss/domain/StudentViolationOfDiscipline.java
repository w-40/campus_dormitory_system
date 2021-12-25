package domain;

/**
 * 
 * @author 籍乃博
 * @description 学生违纪信息：
 * 学号、违纪内容、违纪时间
 *
 */
public class StudentViolationOfDiscipline {

	private String id; //学号
	private String content; //违纪内容
	private String time; //违纪时间
	
	public StudentViolationOfDiscipline() {}

	public StudentViolationOfDiscipline(String id, String content, String time) {
		super();
		this.id = id;
		this.content = content;
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "StudentViolationOfDiscipline [id=" + id + ", content=" + content + ", time=" + time + "]";
	}

}
