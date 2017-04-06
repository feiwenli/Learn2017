

import java.io.*;
/**
 * 新建文件
 * @author FeiWen Li
 *
 */
public class TestFile {
	public static void main (String[] args){
		String separator = File.separator;
		String fileName = "myfile1.txt";
		String directory = "myfile1" +separator+"mydile2";
		//String directory = "myfile1/myfile2";   等效于上面的三句话
		File f = new File(directory,fileName);
		if (f.exists()){
			System.out.println("filename:"+f.getAbsolutePath());
			System.out.println("文件大小："+f.length());
		}else{
			f.getParentFile().mkdirs();
			try{
				f.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
