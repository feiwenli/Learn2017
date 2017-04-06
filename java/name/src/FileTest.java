import java.io.*;
/**
 * 将文件的内容从一个地方拷贝到另一个地方
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
			out = new FileOutputStream ("e:/java-o/t.txt"); //如果文件不存在，则新建文件
			while ((g=in.read())!=-1){		//!=-1 说明文件还没有读完
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
