import java.time.LocalDate;


public class practice4 {

	public static void main(String[] args) {
		Emploee [] staff = new Emploee[3];
		
		staff[0]=new Emploee("carl",75000,1987,12,15);
		staff[1]=new Emploee("harry",50000,1989,12,15);
		staff[2]=new Emploee("tony",40000,1990,12,15);
		
		for (Emploee e:staff)
			e.raiseSalsry(5);
		
		for (Emploee e:staff)
			System.out.println("name="+e.getName()+",salary="+e.getSalary()+",hireDay="+e.getHireDay());
	}
	
	

}
class Emploee{
	private String name;
	private double salary;
	private LocalDate hireday;
	
	public Emploee(String n,double s,int year,int month,int day){
		name=n;
		salary=s;
		hireday=LocalDate.of(year, month, day);
	}
	
	public String getName(){
		return name;
	}
	
	public double getSalary(){
		return salary;
	}
	
	public LocalDate getHireDay(){
		return hireday;
	}
	
	public void raiseSalsry(double byPercent){
		double raise =salary*byPercent/100;
		salary += raise;
	}
}