package GUI;

import java.awt.*;
import java.awt.event.*;
/**
 * 密码的输入
 * 设置回显字符
 * @author Administrator
 *
 */
public class TFPassword {

	public static void main(String[] args) {
		new TFFrame2();
	}

}

@SuppressWarnings("serial")
class TFFrame2 extends Frame{
	TFFrame2(){
		TextField tf = new TextField();
		add(tf);
		tf.addActionListener(new TFActionListener2());
		tf.setEchoChar('*');	//设置回显字符
		pack();
		setVisible(true);
	}
}

class TFActionListener2 implements ActionListener{
	public void actionPerformed(ActionEvent e){
		TextField tf = (TextField)e.getSource();
		System.out.println(tf.getText());
		tf.setText(""); 	//清空
	}
}