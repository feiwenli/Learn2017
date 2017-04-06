import java.util.*;
/**
 * something wrong
 * @author Administrator
 *
 */
public class TestArgsWords {
	private static final Integer ONE = new Integer(1);
	@SuppressWarnings({ "null", "resource" })
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String [] arg = null ;
		int u=0;
		while(in.hasNextLine()){
			arg [u]=in.nextLine();
			u++;
		}
		Map<String, Integer> m = new HashMap<String, Integer>();
		for(int i = 0;i < arg.length;i++){
			Integer freq = (Integer)m.get(arg[i]);
			m.put(arg[i], (freq == null ? ONE : new Integer(freq.intValue()+1)));
		}
		System.out.println(m.size()+" distinct words detected:");
		System.out.println(m);
	}
}
