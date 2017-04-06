package util;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class MyFrame extends Frame{	
	/**
	 * ���ش���
	 */
	
	public void launchFrame(){
		setSize(Constant.GAME_WIDTH,Constant.GAME_HIGHT);
		setLocation(100,100);
		setVisible(true);
		
		new PaintThread().start();
		
		addWindowListener(new WindowAdapter(){   //�ڲ���
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}	
		});
	}	
	
	/**
	 * ����һ���ػ����ڵ������࣬��һ���ڲ���
	 * @author Administrator
	 *
	 */
		class PaintThread extends Thread {
			
			public void run(){
				while(true){
					repaint();
					try {
						Thread.sleep(40);  //1s=1000ms
					} catch (InterruptedException e) {
						e.printStackTrace();
					}    
				}
			}
		}


		public static void main (String [] args){
			MyFrame gf = new MyFrame ();
			gf.launchFrame();
		}
	
}
