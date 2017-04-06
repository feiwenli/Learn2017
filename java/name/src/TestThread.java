/**
 * 线程的创立与结束
 * @author Administrator
 *
 */
public class TestThread{
	public static void main(String[]args){
		Runner1 r = new Runner1();
		//r.run();   //只是方法调用
		Thread t = new Thread(r);
		t.start();
		for (int i=0;i<100;i++){ 
			System.out.println("Main Thread:"+i);
		}
		System.out.println("Thread main is over");
		r.shutDown();  	//结束线程 
	}
}

class Runner1 implements Runnable{
	private boolean flag = true;
	@Override
	public void run() {		//当run方法结束时，线程结束
		System.out.println(Thread.currentThread().isAlive());	//当前线程是否还存活S
		for (int i=0;i<100 && flag==true;i++){
			System.out.println("Runner1:"+i);
		}
	}
	
	public void shutDown(){
		flag = false;
	}
}