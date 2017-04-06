

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
		System.out.println(c.remove(new Name("fan","wu")));		//ָ��Ĳ���ͬһ������   ��equals�Ƚ�
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
	 * ��дequals������hashCode����
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