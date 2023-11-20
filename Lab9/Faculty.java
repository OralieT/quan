package Lab9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Faculty {
	private String name;
	private String address;
	private List<Course> courses;

	public Faculty(String name, String address, List<Course> courses) {
		super();
		this.name = name;
		this.address = address;
		this.courses = courses;
	}

	public Course getMaxPracticalCourse() {
		Course re = null;
		int maxCourse = 0;
		for (Course course : courses) {
			if (course.getType() != null) {
				int temp = course.getStudents().size();
				if (temp > maxCourse) {
					maxCourse = temp;
					re = course;
				}
			}
		}
		return re;
	}

	public Map<Integer, List<Student>> groupStudentsByYear() {
		Map<Integer, List<Student>> re = new HashMap<>();
		for (Course course : courses) {
			for (Student student : course.getStudents()) {
				if (!re.containsKey(student.getYear())) {
					re.put(student.getYear(), new ArrayList<>());
				}

				re.get(student.getYear()).add(student);
			}
		}

		return re;
	}

	public Set<Course> filterCourses(String type) {
		Set<Course> re = new TreeSet<>(new Comparator<Course>() {

			@Override
			public int compare(Course o1, Course o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.getStudents().size(), o2.getStudents().size());
			}
			
		});
		 for (Course course : courses) {
	            if (course.getType() != null && course.getType().equals(type)) {
	                re.add(course);
	            }
	        }

		return re;
	}
}
