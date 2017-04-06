/**
 * 一个面试题
 * @author Administrator
 *
 */
public class Mianshi implements Runnable {
	static int b = 100;
	
	public synchronized void m1() throws Exception{
		b = 1000; 
		Thread.sleep(5000);
		System.out.println("in m1 b ="+b);
	}
	
	public synchronized void m2 ()throws Exception{
		Thread.sleep(1000);
		b = 2000;
		System.out.println("in m2 b="+b);
	}
	
	public void run(){
		try{
			m1();
		}catch (Exception e ){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)throws Exception{
		Mianshi m = new Mianshi();
		Thread t = new Thread(m);
		t.start();
		try {
			m.m2();
		} catch (Exception e) { 
			e.printStackTrace();
		}
		System.out.println("in main b="+b);
	}
}
