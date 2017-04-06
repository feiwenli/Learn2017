public class TestSync implements Runnable{
	Timer timer = new Timer ();
	public static void main (String [] args){
		TestSync test = new TestSync();
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}
	public void run(){
		timer.add(Thread.currentThread().getName());
	}
}

class Timer{
	private static int num = 0;
	public synchronized void add(String name){  //在执行方法的过程中，当前对象被锁定
		//synchronized (this){	//锁定当前对像
			num ++;
			try{
				Thread.sleep(1);  //即使是不写sleep，在执行的过程中还是有可能被其它线程所打断
			}catch(InterruptedException e){}
			System.out.println(name+"你是第"+num+"个使用timer的线程。");
			// num++ 和此句语句之间不能被打断
		//}
	}
}