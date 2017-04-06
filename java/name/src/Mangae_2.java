

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
		System.out.println("请输入要查询的学生的学号：");
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
	//学生
	String name="";
	String sex="";
	String school="";
	String major="";
	String studentNum="";						

	//课程
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
		System.out.println("第"+numb+"个学生");
		reader = new Scanner(System.in);	
		System.out.print("请输入学生的姓名：");
		name=reader.next();   //输入name
		System.out.print("请输入学生的性别：");
		sex=reader.next();  //输入sex
		System.out.print("请输入学生的学校：");
		school=reader.next();  //输入school
		System.out.print("请输入学生的专业：");	
		major=reader.next(); //输入major
		System.out.print("请输入学生的学号：");
		studentNum=reader.next();   //输入学号
			
		int i=0;
		for(i=0;i<5;i++){
			System.out.println("第"+(i+1)+"门课程");
			System.out.print("请输入课程的名字：");
			subjectName=reader.next();  //输入subjectName
			System.out.print("请输入课程的老师：");
			teacher=reader.next(); //输入teacher
			System.out.print("请输入是否出勤(是 or否)：");
			attend=reader.next();   //输入是否出勤
			
			System.out.print("请输入课程的序号：");		
			subjectNum=reader.next();  //输入subjectNum
			System.out.print("请输入课程的成绩：");
			score=Double.parseDouble(reader.next());   //输入score
					
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
		if(count>=1) 	System.out.println(name+"已经挂了"+count+"门课，予以警告！");	
		else	System.out.println(name+"成绩还不错，继续加油！");
	}
	
	public void Show()
	{
		System.out.println("姓名："+name+"  性别："+sex+"  学校："+school+"  专业："+major+"  学号："+studentNum);
		int i=0;

			for(i=0;i<5;i++){
				System.out.println("课程："+NameScore[i][0]);
				System.out.println("序号："+NameScore[i][1]);
				System.out.println("老师："+NameScore[i][2]);
				System.out.println("分数："+NameScore[i][3]);
				System.out.println("出席："+NameScore[i][4]);
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
			System.out.print("请输入研究生的导师：");
			tutor=reader.next();
			System.out.print("请输入研究生的生源地：");
			origin=reader.next();
	}	
	
	public void Show()
	{
		System.out.println("姓名："+name+"  性别："+sex+"  学校："+school+"  专业："+major+"  学号："+studentNum+"  导师："+tutor+"  生源地："+origin);
		int i=0,j=0;
		for(i=0;i<1;i++){
				System.out.println("课程："+NameScore[i][0]);
				System.out.println("序号："+NameScore[i][1]);
				System.out.println("老师："+NameScore[i][2]);
				System.out.println("分数："+NameScore[i][3]);
				System.out.println("出席："+NameScore[i][4]);	
		}
	}
}

 
class Calculate
{
	public  Calculate(double score_1,double score_2,double score_3,String classname,String ab_1,String ab_2,String ab_3)
	{			//计算最高分最低分
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
		//计算平均分
		double ave=(score_3+score_2+score_1)/3.0;
		System.out.println("the average score of "+classname+" is "+ave);		
		//计算缺席人数
		int count=0;
		String n="否";
		if( ab_1.equals(n)) count++;
		if( ab_2.equals(n)) count++;
		if( ab_3.equals(n)) count++;
		System.out.println("the absence of "+classname+" is "+count);
	}
	
}


