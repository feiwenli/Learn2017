import java.io.IOException;
import java.io.PrintWriter;
//import java.lang.reflect.Array;
//import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.*;

public class practice2 {
	public static void main(String [] args) throws IOException {
		//String [] args:��ʾmain���������յ�һ���ַ������飬Ҳ���������в���
		String s="byebye!";
		PrintWriter out=new PrintWriter("E:\\javatest\\myfile.txt","UTF-8");
		
		//PrintWriter out=new PrintWriter("E:\\javatest\\myfile1.txt","UTF-8");//����ļ������ڣ��������ļ�
		//д���ļ�
		out.println("John,Where are you?");
	    out.println("I'am here!");
	    out.println("How old are you?");
	    out.println(15);
	    out.write(s); 
	    //�ر�д����(������رգ����ļ���û����ʾд����ַ�����
	    out.close();
	    //���ļ����ж�ȡ
	    Scanner in =new Scanner(Paths.get("E:\\javatest\\myfile.txt"),"UTF-8");  
		while(in.hasNextLine()){
			System.out.println(in.nextLine());
			//System.out.println("a");
		}
		in.close();
	    
		//����һ������
		int [] a =new int [10];
		for(int i=0;i<10;i++)
			a[i]=i+1;
	
		for (int element :a)	//ѭ��a�е�ÿһ��Ԫ�ز����
			System.out.println(element);
		
		System.out.println(Arrays.toString(a));
		//����һ����������Ԫ�� ���ַ�������ЩԪ�ر����������ڣ����ö��ŷָ�
		
		int [] smallPrimes = {17,19};//�����������ͬʱ�������ֵ�ļ���д��ʽ
		
		smallPrimes =new int [] {33,24,99};//�ڲ������µı�������������³�ʼ��һ������
		//�൱��
		//int [] anonymous ={33,24,99};
		//smallPrimes=anonymous;		
		
		System.out.println(new int[]{8});//���ﴴ����һ���������飬����ӡ���
		
		int [] lucky=smallPrimes;	 //����һ�����������������һ�������������ʱ����������������ͬһ������
		lucky [1]=20;	//��ʱsmallPrimes[1]=20
		System.out.println("smallPrimes[1]="+smallPrimes[1]);
		
		//���鿽��
		@SuppressWarnings("unused")
		int [] copySmallPrimes =Arrays.copyOf(smallPrimes,smallPrimes.length);
		//��������Ĵ�С
		System.out.println("��������ǰ�ĳ��ȣ�"+smallPrimes.length);
		smallPrimes=Arrays.copyOf(smallPrimes,2*smallPrimes.length);
		System.out.println("�������Ӻ�ĳ��ȣ�"+smallPrimes.length);
		//�������������
		Arrays.sort(smallPrimes);
		
	}
}
