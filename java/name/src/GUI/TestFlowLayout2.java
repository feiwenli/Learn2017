package GUI;

import java.awt.*;
/**
 * FlowLayout 是 Panel 类的默认布局管理器
 * @author Administrator
 *
 */
public class TestFlowLayout2 {
	public static void main(String [] args){
		Frame f = new Frame("Java Frame");
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER,20,40);
		f.setLayout(fl);
		f.setLocation(300, 300);
		f.setSize(300, 200);
		f.setBackground(new Color(201,201,20));
		for (int i = 1;i<=7;i++){
			f.add(new Button("BUTTON"));
		}
		f.setVisible(true);
	}
}
