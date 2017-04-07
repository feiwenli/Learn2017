package GUI;

import java.awt.*;

public class TestMultiFrame {
	@SuppressWarnings("unused")
	public static void main(String[] args){
		MyFrame f1 = 
				new MyFrame(100,100,200,200,Color.BLUE);
		MyFrame f2 =
				new MyFrame(300,100,200,200,Color.GRAY);
	}
}

@SuppressWarnings("serial")
class MyFrame extends Frame{
	static int id = 0;
	MyFrame(int x,int y,int w,int h,Color c){
		super("MyFrame "+(++id));
		setBackground(c);
		setLayout(null);	//把布局管理器设为空
		setBounds(x,y,w,h);
		setVisible(true);
	}
}
