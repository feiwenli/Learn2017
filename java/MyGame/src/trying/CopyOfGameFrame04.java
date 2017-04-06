package trying;

import java.awt.Graphics;
import java.awt.Image;

/**
 * 椭圆移动
 * 游戏窗口类
 * @author Administrator
 *
 */

@SuppressWarnings("serial")
public class CopyOfGameFrame04 extends MyFrame{  //GUI编程：swing ,AWT等 java不擅长做桌面软件
	
	Image img = GameUtil.getImage("images/8.jpg");
	
	private double x=100,y=100;
	private double degree = 3.14/3;
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, (int)x,(int) y, null);
		
		x = 100 + 100*Math.cos(degree);
		y = 100 + 50*Math.sin(degree);
		
		degree +=0.1;				
	}
	
	public static void main (String [] args){
		CopyOfGameFrame04 gf = new CopyOfGameFrame04 ();
		gf.launchFrame();
	}

}
