package GUI;

import java.awt.*;
import java.awt.event.*;

/**
 * 加法 的实现
 * 内部类
 * @author Administrator
 *
 */
public class TFMath{
	public static void main(String[] args){
		new MFrame().launchFrame();
	}
}

@SuppressWarnings("serial")
class MFrame extends Frame{
	TextField num1,num2,num3;
	
	public void launchFrame(){
		num1 = new TextField(10);
		num2 = new TextField(10);
		num3 = new TextField(15);
		Button bEqual = new Button("=");
		Label ladd = new Label("+");
		MMonitor mm = new MMonitor();
		bEqual.addActionListener(mm);
		setLayout(new FlowLayout());
		add(num1);
		add(ladd);
		add(num2);
		add(bEqual);
		add(num3);
		pack();
		setVisible(true);
	}
	class MMonitor implements ActionListener{	//内部类
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int n1 = Integer.parseInt(num1.getText());
			int n2 = Integer.parseInt(num2.getText());
			num3.setText(""+(n1+n2));  
		}

	}
	
}
/*
class MMonitor implements ActionListener{
	MFrame mf = null;
	MMonitor(MFrame mf){
		this.mf = mf;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int n1 = Integer.parseInt(mf.num1.getText());
		int n2 = Integer.parseInt(mf.num2.getText());
		mf.num3.setText(""+(n1+n2));  
	}

}
*/