import java.io.*;
import java.util.*;
/**
 * 日志
 * @author Administrator
 *
 */
public class TestPrintStream {
	public static void main (String []args ){
		String s = null;
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); //InputStreamReader 将字节流转化为字符流
		try{
			FileWriter fw = new FileWriter("e:/java-o/logfile.log",true);
			PrintWriter log = new PrintWriter (fw);
			while ((s=br.readLine())!=null){
				if (s.equalsIgnoreCase("exit")) break;
				System.out.println(s.toUpperCase());
				log.println(s.toUpperCase());
				log.println("-------");
				log.println(s.toUpperCase());
				log.flush();
			}
			log.println("==="+new Date()+"===");
			log.flush();
			log.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}