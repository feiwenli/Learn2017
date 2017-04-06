import java.io.*;
public class BufferStringTest {
	public static void main(String [] args){
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter("e:\\java-o\\j.txt"));
			BufferedReader br = new BufferedReader(new FileReader("e:\\java-o\\j.txt"));
			String s = null;
			for(int i=0;i<=100;i++){
				s = String.valueOf(Math.random());
				bw.write(s);
				bw.newLine();
			}
			bw.flush();
			while((s=br.readLine())!=null){
				System.out.println(s);
				//System.out.println();
			}
			bw.close();
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}