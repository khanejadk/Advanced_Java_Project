package Comparator;

import java.util.ArrayList;
import java.util.List;


// here, we will implement the class Students with the comparable and in main method we will use sort(null) -- natural ordering and provide the compareTo definition in Students class

// Comparable is just used for natural ordering. if data's primitive then internally compareTo will work easily. But if it is custom class/object then implementing and overriding compareTo will work

public class Comparable1 {

	public static void main(String[] args) {
		
		List<Students> students = new ArrayList<>();
		
		students.add(new Students("Deepak",4));
		students.add(new Students("Ramesh", 8));
		students.add(new Students("Karishma", 5));
		students.add(new Students("Kritika", 10));
		
		students.sort(null);
		
		System.out.println(students);
		
		for(Students s: students) {
			System.out.println(s.getName() + "   :  " + s.getGpa());
		}
	
	}

}

class Students implements Comparable<Students>{
	
	private String name;
	private int gpa;
	
	public Students(String name, int gpa) {
		
		this.name = name;
		this.gpa = gpa;
	}
	
	@Override
	public int compareTo(Students o) {
		
		return this.getGpa() - o.getGpa(); // here this = o1 and o = o2. so this - o ---> o1 - o2, that means ascending ordering
		
		// return o.getGpa() - this.getGpa(); -- it is like o2 - o1, so that means descendign ordering.
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public int getGpa() {
		return gpa;
	}

	public void setGpa(int gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", gpa=" + gpa + "]";
	}

}	