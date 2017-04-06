package trying;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 测试窗口物体沿着各种方向移动,水平
 * 游戏窗口类
 * @author Administrator
 *
 */

@SuppressWarnings("serial")
public class CopyOfGameFrame02 extends Frame{  //GUI编程：swing ,AWT等 java不擅长做桌面软件
	
	Image img = GameUtil.getImage("images/8.jpg");
	
	/**
	 * 加载窗口
	 */
	private int l=500,w=500;
	public void launchFrame(){
		setSize(l,w);
		
		new PaintThread().start();
		
		addWindowListener(new WindowAdapter(){   //内部类
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
 * 定义一个重画窗口的先成类，是一个内部类
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
