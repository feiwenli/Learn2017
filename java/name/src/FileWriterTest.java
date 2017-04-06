import java.io.*;

public class FileWriterTest {
	public static void main (String[]args){
		FileWriter w = null;
		try {
			w = new FileWriter("e:/java-o/unicode.dat");
			for (int c=0;c<50000;c++){
				w.write(c);
			}
			w.close();
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("write error");
			System.exit(-1);
		}
	}
}