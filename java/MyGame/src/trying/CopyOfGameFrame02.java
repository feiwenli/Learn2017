package trying;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ���Դ����������Ÿ��ַ����ƶ�,ˮƽ
 * ��Ϸ������
 * @author Administrator
 *
 */

@SuppressWarnings("serial")
public class CopyOfGameFrame02 extends Frame{  //GUI��̣�swing ,AWT�� java���ó����������
	
	Image img = GameUtil.getImage("images/8.jpg");
	
	/**
	 * ���ش���
	 */
	private int l=500,w=500;
	public void launchFrame(){
		setSize(l,w);
		
		new PaintThread().start();
		
		addWindowListener(new WindowAdapter(){   //�ڲ���
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}	
		});
	}	
	
	private double x=110,y=110;
	private boolean left;
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(img,(int) x,(int) y, null);
		if(left){
			x-=10;
		}else{
			x+=10;
		}
		if (x>500-50){
			left=true;
		}
		if(x<10){
			left=false;
		}
		
	}
/**
 * ����һ���ػ����ڵ��ȳ��࣬��һ���ڲ���
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
		CopyOfGameFrame02 gf = new CopyOfGameFrame02 ();
		gf.launchFrame();
	}
		
}
