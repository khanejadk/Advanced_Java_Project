package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparator2 {

	public static void main(String[] args) {
		

		List<Student> students = new ArrayList<>();
		
		students.add(new Student("Deepak",4.5));
		students.add(new Student("Ramesh", 3.9));
		students.add(new Student("Karishma", 2.0));
		students.add(new Student("Kritika", 2.0));
		
		students.sort((s1, s2) -> {
			
			if(s1.getGpa() - s2.getGpa() < 0) {       // here we are using if else becasue of double value of gpa. otherwise direct can be done without using if else.
				return -1;
			}else if(s1.getGpa() - s2.getGpa() > 0) {
				return 1;
			}else {
				return 0;
				// return s1.getName().compareTo(s2.getName());
			}
		});
		
		System.out.println(students);
		
		for(Student s: students) {
			System.out.println(s.getName() + "   :  " + s.getGpa());
		}
		
		//another way to use sorting using comparator
		
		Comparator<Student> comparatorObj = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);
		
		students.sort(comparatorObj);
		
		for(Student s: students) {
			System.out.println(s.getName() + "   :  " + s.getGpa());
		}
		
		// ordering list using the Collections class
		Collections.sort(students, comparatorObj);
		
	}

}

class Student {
	
	private String name;
	private double gpa;
	
	public Student(String name, double gpa) {
		
		this.name = name;
		this.gpa = gpa;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", gpa=" + gpa + "]";
	}
	
	
	
}
