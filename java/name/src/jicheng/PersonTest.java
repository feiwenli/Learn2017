package jicheng;

/**
 * This program demonstrates abstract classes
 * @author Feiwen Li
 * @version 2017/3/5
 */

public class PersonTest {

	public static void main(String[] args) {
		Person [] people =new Person[2];
		
		people [0]=new Employee("harry hacker",5000,1989,10,1);
		people [1]=new Student("maria morris","computer science");
		
		for(Person p : people){
			System.out.println(p.getName()+", "+p.getDescription());
		}
	}

}
