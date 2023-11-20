
package Lab9;

import java.util.List;

public class Course {
	private String id;
	private String title;
	private String type;
	private List<Student> students;
	private String lecturer;
	public Course(String id, String title, String type, List<Student> students, String lecturer) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.students = students;
		this.lecturer = lecturer;
	}
	@Override
	public String toString() {
		return "Course: id=" + id + ", title=" + title + ", type=" + type + ", students=" + students + ", lecturer="
				+ lecturer
				;
	}
	public String getType() {
		return type;
	}
	public List<Student> getStudents() {
		return students;
	}
	
}
