import java.util.Arrays;
import java.util.Objects;

public class practice6 {

	public static void main(String[] args) {
		String s = "OK";
		StringBuilder sb = new StringBuilder(s);
		StringBuilder sbb = new StringBuilder(s);
		System.out.println(s.hashCode()+" "+sb.hashCode()+" "+sbb.hashCode());
		String t = new String("OK");
		StringBuilder tb = new StringBuilder(t);
		System.out.println(t.hashCode()+" "+tb.hashCode());
		System.out.println(System.out);
		
		int [] luckyNumbers = {2,3,4,5,7,44,33};
		String ss = Arrays.toString(luckyNumbers);
		System.out.println(ss);
		
		System.out.println(new ger().hashCode());
	}
}

class ger{
	String w = "OK";
	String t = "OK";
	public int hashCode(){
		return Objects.hash(w);
	}
}