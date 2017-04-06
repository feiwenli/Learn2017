

import java.nio.IntBuffer;
import java.util.Collection;
import java.util.HashSet;

public class BasicContainer {
	public static void main(String[]args){
		Collection c = new HashSet();
		c.add("hello");
		c.add(new Name("fan","wu"));
		c.add(new Integer(100));
		c.remove("hello");
		System.out.println(c.remove(new Name("fan","wu")));		//指向的不是同一个对象   用equals比较
		System.out.println(c);
	}
}


class Name {
	private String FirstName,LastName;
	Name (String FirstName,String LastName){
		this.FirstName = FirstName;
		this.LastName = LastName;
	}
	
	public String getFirstName(){ return FirstName; }	
	public String getLastName(){ return LastName; }	
	public String toString(){ return FirstName+" "+LastName; }
	
	/**
	 * 重写equals方法和hashCode方法
	 */
	public boolean equals(Object obj){
		if (obj instanceof Name){
			Name name = (Name) obj;
			return (FirstName.equals(FirstName)&&(LastName.equals(LastName)));
		}
		return super.equals(obj);
	}
	public int hashCode(){
		return FirstName.hashCode();
	}
	
}