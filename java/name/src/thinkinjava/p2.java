/********************* Exercise 12 ********************
* Create a class called Tank that can be filled
* and emptied, with a termination condition that it
* must be empty when the object is cleaned up.
* Write a finalize() that verifies this termination
* condition. In main(), test the possible
* scenarios that can occur when you use Tank.
******************************************************/

package thinkinjava;

class Tank{
	static int counter;
	int id = counter++;
	boolean full = true;
	void empty(){
		full=false;
	}
	protected void finalize(){
		if (full){
			System.out.println("the id of "+id+" is true");
		}else
			System.out.println("the id of "+id+" is false");

	}
}

public class p2 {

	public static void main(String[] args) {
		new Tank().empty();
		new Tank();
		//Tank a = new Tank();
		System.gc();
		System.runFinalization();
	}

}
