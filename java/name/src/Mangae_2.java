

import java.util.Scanner;

public class Mangae_2 {

	public static void main(String[] args) {

		Sstudent student_1,student_2,student_3;
		student_1=new Sstudent(1);
		student_2=new Sstudent(2);
		student_3=new Sstudent(3);
		
		Sstudent postgrauduate_1,postgrauduate_2,postgrauduate_3;
		postgrauduate_1=new Postgrauduate(1);
		postgrauduate_2=new Postgrauduate(2);
		postgrauduate_3=new Postgrauduate(3);
		
		int j=0;
		for(j=0;j<5;j++){
			double score_1,score_2,score_3;
			score_1=Double.parseDouble(student_1.NameScore[j][3]);
			score_2=Double.parseDouble(student_2.NameScore[j][3]);
			score_3=Double.parseDouble(student_3.NameScore[j][3]);		
			Calculate course_1;
			course_1=new Calculate(score_1,score_2,score_3,student_1.NameScore[j][0],student_1.NameScore[j][4],student_2.NameScore[j][4],student_3.NameScore[j][4]);			
			double score_4,score_5,score_6;
			score_4=Double.parseDouble(postgrauduate_1.NameScore[j][3]);
			score_5=Double.parseDouble(postgrauduate_2.NameScore[j][3]);
			score_6=Double.parseDouble(postgrauduate_3.NameScore[j][3]);	
			Calculate course_11;
			course_11=new Calculate(score_4,score_5,score_6,postgrauduate_1.NameScore[j][0],postgrauduate_1.NameScore[j][4],postgrauduate_2.NameScore[j][4],postgrauduate_3.NameScore[j][4]);
		}
		student_1.Warning();
		student_2.Warning();
		student_3.Warning();
		
		postgrauduate_1.Warning();
		postgrauduate_2.Warning();
		postgrauduate_3.Warning();
		
		String number="";
		do{
		System.out.println("������Ҫ��ѯ��ѧ����ѧ�ţ�");
		Scanner reader=new Scanner(System.in);
		number=reader.next();
		if(student_1.studentNum.equals(number))
			student_1.Show();
		if(student_2.studentNum.equals(number))
			student_2.Show();
		if(student_3.studentNum.equals(number))
			student_3.Show();
		if(postgrauduate_1.studentNum.equals(number))
			postgrauduate_1.Show();
		if(postgrauduate_2.studentNum.equals(number))
			postgrauduate_2.Show();
		if(postgrauduate_3.studentNum.equals(number))
			postgrauduate_3.Show();
		}while(!number.equals(0));
			
	}

}

class Sstudent 
{
	private static int numb=0;
	//ѧ��
	String name="";
	String sex="";
	String school="";
	String major="";
	String studentNum="";						

	//�γ�
	String subjectName="";
	String subjectNum="";
	String teacher="";
	double score=0.0;	
	String attend="";
	
	String [][] NameScore=new String[5][5];
	Scanner reader;
	
	public Sstudent(int num)
	{
		numb++;
		System.out.println("��"+numb+"��ѧ��");
		reader = new Scanner(System.in);	
		System.out.print("������ѧ����������");
		name=reader.next();   //����name
		System.out.print("������ѧ�����Ա�");
		sex=reader.next();  //����sex
		System.out.print("������ѧ����ѧУ��");
		school=reader.next();  //����school
		System.out.print("������ѧ����רҵ��");	
		major=reader.next(); //����major
		System.out.print("������ѧ����ѧ�ţ�");
		studentNum=reader.next();   //����ѧ��
			
		int i=0;
		for(i=0;i<5;i++){
			System.out.println("��"+(i+1)+"�ſγ�");
			System.out.print("������γ̵����֣�");
			subjectName=reader.next();  //����subjectName
			System.out.print("������γ̵���ʦ��");
			teacher=reader.next(); //����teacher
			System.out.print("�������Ƿ����(�� or��)��");
			attend=reader.next();   //�����Ƿ����
			
			System.out.print("������γ̵���ţ�");		
			subjectNum=reader.next();  //����subjectNum
			System.out.print("������γ̵ĳɼ���");
			score=Double.parseDouble(reader.next());   //����score
					
			NameScore[i][0]=subjectName;
			NameScore[i][1]=subjectNum;
			NameScore[i][2]=teacher;
			NameScore[i][3]=score+"";
			NameScore[i][4]=attend;
			}
		}
	
	public void Warning()
	{
		int count=0,j;
		for(j=0;j<5;j++)
		{
			if(  Double.parseDouble(NameScore[j][3])<60)  count++;
		}
		if(count>=1) 	System.out.println(name+"�Ѿ�����"+count+"�ſΣ����Ծ��棡");	
		else	System.out.println(name+"�ɼ��������������ͣ�");
	}
	
	public void Show()
	{
		System.out.println("������"+name+"  �Ա�"+sex+"  ѧУ��"+school+"  רҵ��"+major+"  ѧ�ţ�"+studentNum);
		int i=0;

			for(i=0;i<5;i++){
				System.out.println("�γ̣�"+NameScore[i][0]);
				System.out.println("��ţ�"+NameScore[i][1]);
				System.out.println("��ʦ��"+NameScore[i][2]);
				System.out.println("������"+NameScore[i][3]);
				System.out.println("��ϯ��"+NameScore[i][4]);
			}		
	}
	
}

  
class Postgrauduate extends Sstudent
{
	String tutor="";
	String origin="";
	
	public Postgrauduate(int num)
	{
		
			super(0);
			System.out.print("�������о����ĵ�ʦ��");
			tutor=reader.next();
			System.out.print("�������о�������Դ�أ�");
			origin=reader.next();
	}	
	
	public void Show()
	{
		System.out.println("������"+name+"  �Ա�"+sex+"  ѧУ��"+school+"  רҵ��"+major+"  ѧ�ţ�"+studentNum+"  ��ʦ��"+tutor+"  ��Դ�أ�"+origin);
		int i=0,j=0;
		for(i=0;i<1;i++){
				System.out.println("�γ̣�"+NameScore[i][0]);
				System.out.println("��ţ�"+NameScore[i][1]);
				System.out.println("��ʦ��"+NameScore[i][2]);
				System.out.println("������"+NameScore[i][3]);
				System.out.println("��ϯ��"+NameScore[i][4]);	
		}
	}
}

 
class Calculate
{
	public  Calculate(double score_1,double score_2,double score_3,String classname,String ab_1,String ab_2,String ab_3)
	{			//������߷���ͷ�
		double lowest=0;
		double highest=100;
		if(  score_3>score_2){
			if(  score_2>score_1)
				lowest=score_1;
			else
				lowest=score_2;
			highest=score_3;		
		}else if(  score_2>score_3)
		{	
			if(  score_3>score_1)
				lowest=score_1;
			else
				lowest=score_3;
			highest=score_2;			
		}else {	
			if( score_3>score_2)
				lowest=score_2;
			else
				lowest=score_3;
			highest=score_1;
		}	
		System.out.println("the lowest score of "+classname+" is "+lowest);
		System.out.println("the higest score of "+classname+" is "+highest);
		//����ƽ����
		double ave=(score_3+score_2+score_1)/3.0;
		System.out.println("the average score of "+classname+" is "+ave);		
		//����ȱϯ����
		int count=0;
		String n="��";
		if( ab_1.equals(n)) count++;
		if( ab_2.equals(n)) count++;
		if( ab_3.equals(n)) count++;
		System.out.println("the absence of "+classname+" is "+count);
	}
	
}


