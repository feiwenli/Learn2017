import java.time.DayOfWeek;
import java.time.LocalDate;

public class calendar {
	public static void main(String[] args){
		LocalDate date = LocalDate.now();
		int month = date.getMonthValue();
		int today = date.getDayOfMonth();
		
		date = date.minusDays(today-1);//set the start of month    为什么“-1”？？？？？？？
		DayOfWeek weekday = date.getDayOfWeek();
		int value = weekday.getValue();  //1=Monday,...,7 = Sunday
		
		System.out.println("Mon Tue Wen Thr Fri Sat Sun");
		for (int i = 1;i < value;i++){
			System.out.print("        ");  //打印第一行的缩进
			while( date.getMonthValue()==month ){
				 System.out.printf("%3d",date.getDayOfMonth());
				 if (date.getDayOfMonth()==today)
					 System.out.print("*");
				 else System.out.print(" ");
				 	date = date.plusDays(1);
				 if (date.getDayOfWeek().getValue() == 1)
					 System.out.println(); 
			}
			 if (date.getDayOfWeek().getValue() == 1)
				 System.out.println(); 
		}
		
	}		
}
	
