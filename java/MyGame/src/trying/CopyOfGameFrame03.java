package trying;

import java.awt.Graphics;
import java.awt.Image;


/** 
 * 测试游戏沿着任意角度移动，排球
 * 游戏窗口类
 * @author Administrator
 *
 */

@SuppressWarnings("serial")
public class CopyOfGameFrame03 extends MyFrame{  //GUI编程：swing ,AWT等 java不擅长做桌面软件
	
	Image img = GameUtil.getImage("images/8.jpg");
	
	private double x=100,y=100;
	private  double degree=3.14/3;		//[0,2pi]
	private double speed=10;
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(img,(int) x,(int) y, null);
		x +=speed*Math.cos(degree);
		y +=speed*Math.sin(degree);
		
		if(speed >0){
			speed -=0.02;
		}else{
			speed=0;
		}
		
		
		if(x>Constant.GAME_WIDTH - 45 || x<0){
			degree =Math.PI-degree;
		}
		
		if(y<30 || y>Constant.GAME_HIGHT-40){
			degree = - degree;
		}
		
	}
	
	public static void main (String [] args){
		CopyOfGameFrame03 gf = new CopyOfGameFrame03 ();
		gf.launchFrame();
	}
}
