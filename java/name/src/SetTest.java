import java.util.*;

public class SetTest {
	public static void main (String [] args){
		Set<String> s1 = new HashSet<String>();
		Set<String> s2 = new HashSet<String>();
		s1.add("a");
		s1.add("b");
		s1.add("c");
		s2.add("a");
		s2.add("f");
		s2.add("k");
		Set<String> sn = new HashSet<String>(s1);
		sn.retainAll(s2);	//È¡½»¼¯
		System.out.println(sn);
		Set<String> su = new HashSet<String>(s1);
		su.addAll(s2);
		System.out.println(su);
	}
}