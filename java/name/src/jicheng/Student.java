package jicheng;

public class Student extends Person{

	private String major;
	
	/**
	 * @param name the student'name
	 * @param major the student'major
	 */
	
	public Student(String name,String major) {
		super(name);
		this.major=major;
	}
	
	public String getDescription(){
		return "a student's majoring in "+major;
	}
	
}
