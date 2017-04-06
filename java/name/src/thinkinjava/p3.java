package thinkinjava;

import thinkinjava.Print;

class Cup{
	Cup(int marker){
		Print.print("Cup("+marker+")");
	}
	void f(int marker){
		Print.print("f("+marker+")");
	}
}

class Cups{
	static Cup cup1 = new Cup(1);
	static Cup cup2;
	static{
		//cup1 = new Cup(1);
		cup2 = new Cup(2);
	}
	Cups(){
		Print.print("Cups()");
	}
}

public class p3 {

	public static void main(String[] args) {
		Print.print("Inside main()");
		Cups.cup1.f(99);

	}

}
