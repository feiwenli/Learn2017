import java.util.Scanner;

public class practice1 {
	public static void main(String [] args){
		//Scanner in =new Scanner(System.in);
		StringBuilder builder=new StringBuilder();
		builder.append("ch");
		builder.append("kkkk");

		String ch=builder.toString();
		
		int c=ch.length();
		int cq=ch.codePointCount(0, c);
		
		System.out.println("ch的代码单元数量为："+c+"  ch的码点数量是："+cq);
		System.out.println("ch="+ch);
		
		String name="wangming";
		int age=22;
		String message=String.format("Hello,%s.Next year, you'll be %d", name, age);
		System.out.println(message);
		
		for(int i=0;i<c-1;){
			int cp=ch.codePointAt(i);
			if (Character.isSupplementaryCodePoint(cp)) 	i +=2;
			else i++;
			System.out.println(cp);
		}
	}
}
 