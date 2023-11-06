package Extra;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

public class Clazz {
	private String name;
	private String year;// 2017, 2018, 2019, ...
	private ArrayList<Student> students = new ArrayList<Student>();

	public Clazz(String name, String year, ArrayList<Student> students) {
		super();
		this.name = name;
		this.year = year;
		this.students = students;
	}

	// sort students according to the given comparator c
	public void sortStudents(Comparator<Student> c) {
		students.sort(c);
	}

	// get top n students with highest GPA
	public ArrayList<Student> getTopNStudents(int n) {
		// TODO
		if (n == 0) {
			return null;
		}
		ArrayList<Student> result = new ArrayList<Student>(students);
		result.sort(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return Double.compare(o1.getGPA(), o2.getGPA());
			}
		});
		ArrayList<Student> topStudent = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			topStudent.add(result.get(i));
		}
		return topStudent;
	}

	// get random n students from the list of students
	public ArrayList<Student> getRandomNStudents(int n) {
		// TODO
		if (n < 0 || n > students.size()) {
			return null;
		}
		ArrayList<Student> rdStudent = new ArrayList<Student>();
		Random rd = new Random();

		ArrayList<Integer> rdNum = new ArrayList<Integer>();
		for (int i = 0; i < students.size(); i++) {
			rdNum.add(i);
		}
		for (int i = 0; i < n; i++) {
			int rdIndex = rd.nextInt(rdNum.size());
			int stuIndex = rdNum.remove(rdIndex);
			rdStudent.add(students.get(stuIndex));
		}
		return rdStudent;
	}

// remove a student with a given id
	public boolean removeStudent(String id) {
		// TODO
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId().equals(id)) {
				students.remove(i);
				return true;
			}
		}
		return false;
	}

	// get all students who were born in a given birth year.
	public ArrayList<Student> getStudentByBirthYear(int birthYear) {
		// TODO
		ArrayList<Student> studentByBirthYear = new ArrayList<>();

		for (Student student : students) {
			if (student.getBirthYear() == birthYear) {
				studentByBirthYear.add(student);
			}
		}
		return studentByBirthYear;
	}

	// similar as toString method, this method prints the name, year, and all
	// students of the class. Note that, using iterator
	public void display() {
		Iterator<Student> iterator = students.iterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			System.out.println(student.toString());
		}
	}

	public void display(ArrayList<Student> students) {
		Iterator<Student> iterator = students.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	public static void main(String[] args) {
		Path currentPath = Paths.get("");
		String s = currentPath.toAbsolutePath() + "\\New folder\\students.txt";
		Clazz clazz;
		try {
			clazz = new Clazz("CNTT", "2022", StudentUtils.loadStudents(s));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		clazz.display();
		clazz.sortStudents(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return Double.compare(o1.getGPA(), o2.getGPA());
			}
		});
		System.out.println("Sort: ");
		clazz.display();
		System.out.println("Top 3 GPA: ");
		clazz.display(clazz.getTopNStudents(5));
		System.out.println("Random 3 Stu: ");
		clazz.display(clazz.getRandomNStudents(3));
		System.out.println("Remove Stu: "); 
     	System.out.println(clazz.removeStudent("18130090"));
		System.out.println("Get Stu year: ");
		clazz.display(clazz.getStudentByBirthYear(1998));
		
	}
}
