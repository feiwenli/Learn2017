import java.io.*;
/**
 * ���ļ������ݴ�һ���ط���������һ���ط�
 * @author Administrator
 *
 */

public class FileTest {
	public static void main(String[]args){
		int g = 0;
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			in = new FileInputStream ("e:/java/name/src/practice1.java");
			out = new FileOutputStream ("e:/java-o/t.txt"); //����ļ������ڣ����½��ļ�
			while ((g=in.read())!=-1){		//!=-1 ˵���ļ���û�ж���
				out.write(g);
			}
			in.close();
			out.close();
		}catch (FileNotFoundException e1){
			System.out.println("file not found");
			System.exit(-1);
		}catch (IOException e2){
			System.out.println("error");
			System.exit(-1);
		}
		System.out.println("success");
	}
}
