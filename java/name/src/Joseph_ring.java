import java.util.Scanner;


public class Joseph_ring {

	public static void main(String[] args) {
		int m,n;
		Scanner in = new Scanner(System.in);
		System.out.println("�������������Ϸ����������");
		m = in.nextInt();
		System.out.println("������Ҫ��Ȧ����ֵ��");
		n = in.nextInt();
		in.close();
		
		int [] a =new int [m];
		for (int i=0;i<m;i++){
			a [i] = i+1;
		}
		
		System.out.println("��Ȧ˳��Ϊ��");
		int i=n;
		while(m>=0){
			if (n>m){
				while(n>m)	
					n=n-m;
				System.out.print(" "+a[n-1]);
			} 
			else 
				System.out.print(" "+a[n-1]);
			int p=n;
			while(p<m){
				a [p-1]=a [p];
				p++;
			}
			n=i+n-1; 
			m--;
		}
		
	}

}
