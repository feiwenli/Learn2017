import java.util.*;

public class practice7 {

	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		System.out.println("Enter a size:(SMALL,MEDIUM,LARGE,EXTRA_LARGE");
		String input = in.next().toUpperCase();
		Size size = Enum.valueOf(Size.class, input);//��s���ó�Size.input
		System.out.println("size="+size);
		System.out.println("abbreviation="+size.getAbbreviation());
		if(size == Size.EXTRA_LARGE)
			System.out.println("God job--you paid attention to the _.");
	}

}

enum Size{
	SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL");
	
	private Size(String abbreviation){
		this.abbreviation=abbreviation;
	}
	public String getAbbreviation(){
		return abbreviation;
	}
	
	private String abbreviation;
}