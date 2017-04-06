import java.io.IOException;
import java.io.PrintWriter;
//import java.lang.reflect.Array;
//import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.*;

public class practice2 {
	public static void main(String [] args) throws IOException {
		//String [] args:表示main方法将接收到一个字符串数组，也就是命令行参数
		String s="byebye!";
		PrintWriter out=new PrintWriter("E:\\javatest\\myfile.txt","UTF-8");
		
		//PrintWriter out=new PrintWriter("E:\\javatest\\myfile1.txt","UTF-8");//如果文件不存在，创建该文件
		//写入文件
		out.println("John,Where are you?");
	    out.println("I'am here!");
	    out.println("How old are you?");
	    out.println(15);
	    out.write(s); 
	    //关闭写出器(如果不关闭，则文件中没有显示写入的字符串）
	    out.close();
	    //对文件进行读取
	    Scanner in =new Scanner(Paths.get("E:\\javatest\\myfile.txt"),"UTF-8");  
		while(in.hasNextLine()){
			System.out.println(in.nextLine());
			//System.out.println("a");
		}
		in.close();
	    
		//创建一个数组
		int [] a =new int [10];
		for(int i=0;i<10;i++)
			a[i]=i+1;
	
		for (int element :a)	//循环a中的每一个元素并输出
			System.out.println(element);
		
		System.out.println(Arrays.toString(a));
		//返回一个包含数组元素 的字符串，这些元素被放在括号内，并用逗号分隔
		
		int [] smallPrimes = {17,19};//创建数组对象并同时赋予出数值的简化书写形式
		
		smallPrimes =new int [] {33,24,99};//在不创建新的变量的情况下重新初始化一个数组
		//相当于
		//int [] anonymous ={33,24,99};
		//smallPrimes=anonymous;		
		
		System.out.println(new int[]{8});//这里创建了一个匿名数组，并打印输出
		
		int [] lucky=smallPrimes;	 //允许将一个数组变量拷贝给另一个数组变量，这时，两个变量将引用同一个数组
		lucky [1]=20;	//此时smallPrimes[1]=20
		System.out.println("smallPrimes[1]="+smallPrimes[1]);
		
		//数组拷贝
		@SuppressWarnings("unused")
		int [] copySmallPrimes =Arrays.copyOf(smallPrimes,smallPrimes.length);
		//增加数组的大小
		System.out.println("数组增加前的长度："+smallPrimes.length);
		smallPrimes=Arrays.copyOf(smallPrimes,2*smallPrimes.length);
		System.out.println("数组增加后的长度："+smallPrimes.length);
		//对数组进行排序
		Arrays.sort(smallPrimes);
		
	}
}
