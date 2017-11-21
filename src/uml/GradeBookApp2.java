/*
Step 2: to implement "take_course" relationship
* add Student.takeCourse(Course) to take course
* add a Course.showCourseInfo() to show course information
* Check overflow of the array in all classes

!! This code has bug, please FIX it.
*/

public class GradeBookApp2 {
	public static void main(String args[]) {
		Student Jie = new Student ("Jie");
		Student Albert = new Student ("Albert");

		Teacher Nick = new Teacher ("Nick");

		Course Java = new Course ("Java");
		Course Python = new Course ("Python");

		Nick.offer(Java);
		Nick.offer(Python);

		Jie.takeCourse(Java);
		Albert.takeCourse(Java);

		Java.showCourseInfo();
	}
	
}

class Course {
	String cName;
	Student[] students = new Student[10];
	int studentCount = 0;
	String teacher = "None";
	public Course (String name) {
		this.cName = name;
	}

	public void registeredBy(Student s) {
		if (studentCount <= 9)
			students[studentCount++] = s;
		else
			System.out.println("Students overflow in a class");
	}

	public void showCourseInfo() {
		System.out.println("Course: "+ cName);
		System.out.println("-- Teacher: " + teacher);
		String s = "";
		for (int i=0; i<studentCount ; i++) {
			s += students[i].sName + ", ";
		}
		System.out.println("-- Students: " + s);
	}
}

class Teacher {
	String tName;
	Course[] courses = new Course[10];
	int courseCount = 0;
	public Teacher(String name) {
		this.tName = name;
	}
	public void offer(Course c) {
		if (courseCount <= 9) {
			courses[courseCount++] = c;	
		}
		else
			System.out.println("Offer too many courses");
	}
	
	public void showCourse() {
		for (Course c: courses) {
			if (c != null)
				System.out.println(c.cName);
			else 
				break;
		}
	}
}

class Student {
	String sName;
	Course[] courses = new Course[10];
	int courseCount = 0;
	public Student (String name){
		this.sName = name;
	}

	public void takeCourse(Course c) {
		if (courseCount <=9)
			courses[courseCount++] = c;
		else 
			System.out.println("Hei, you take too many courses");
	}
}