import java.util.Scanner;

public class practice3
{
	public static void main (String [] args){
		System.out.println("请输入做这个游戏的总人数：");
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int [] a =new int [m];
		System.out.println("请输入出圈人数：");
		int n = in.nextInt();		
		System.out.println("出圈顺序：");
		in.close();
		
		for (int i=0;i<m;i++){
			a [i]=i+1;
		}
		//用i作为下标，j为当前要报的数
		int i = 0;
		int j = 1;
		int len = m;
		
		while (len>=0){
			if(a[i%m]>0){
				if(j%n == 0){
					System.out.println(a[i%m]+" ");
					a[i%m] = -1;
					j = 1;
					i++;
					len--;
				}else {
					j++;
					i++;
				}
			}else{
				i++;
			}
		}
		
		
	}

}