package Lab9;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		Student stu1 = new Student("01", "Long", 2001);
		Student stu2 = new Student("02", "Hao", 2002);
		Student stu3 = new Student("03", "Thang", 2002);
		Student stu4 = new Student("04", "Yen", 2003);
		List<Student> stu = new ArrayList<>();
		stu.add(stu1);
		stu.add(stu2);
		stu.add(stu3);

		Student stu5 = new Student("05", "Anh", 2004);
		Student stu6 = new Student("06", "Trang", 2002);
		Student stu7 = new Student("07", "Huong", 2003);
		Student stu8 = new Student("08", "Ngoc", 2003);
		Student stu9 = new Student("09", "Ngan", 2003);
		List<Student> re = new ArrayList<>();
		re.add(stu8);
		re.add(stu7);
		re.add(stu4);
		re.add(stu6);
		List<Student> re1 = new ArrayList<>();
		re1.add(stu9);
		re1.add(stu5);
		Course cou1 = new Course("111", "CTDL", "TH", stu, "Thay Du");
		Course cou2 = new Course("111", "LTCB", "LT", re, "Thay Hung");
		Course cou3 = new Course("111", "LTNC", "LT", re1, "Thay Hung");
		List<Course> co1 = new ArrayList<>();
		co1.add(cou1);
		co1.add(cou2);
		co1.add(cou3);
		Faculty fac = new Faculty("CNTT", "123", co1);

		System.out.println(fac.getMaxPracticalCourse());
		System.out.println(fac.groupStudentsByYear());
		System.out.println(fac.filterCourses("LT"));
	}
}
