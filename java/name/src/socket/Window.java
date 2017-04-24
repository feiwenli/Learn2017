package socket;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Window extends JFrame {

	/**
	 * 窗口类  定义客户端和服务器端的窗口
	 */
	private static final long serialVersionUID = 2L;
	private String windowName;
	private JFrame myWindow;
	private JTextArea area;
	private JTextField field;
	private JButton button;
	
	public Window(String windowName)
	{
		this.windowName = windowName;
		myWindow = new JFrame(windowName);
		myWindow.setLayout(new FlowLayout());
		myWindow.setSize(new Dimension(500, 300));
		//不能改变窗口大小
		myWindow.setResizable(false);
		
		area = new JTextArea();
		field = new JTextField();
		button = new JButton("发送");
		
		//设置field的大小
		field.setPreferredSize(new Dimension(400, 30));
		myWindow.add(field);
		myWindow.add(button);
		myWindow.add(area);
		//改变area的大小
		area.setPreferredSize(new Dimension(470, 210));
		area.setBackground(Color.PINK);
		area.setEditable(false);
		//设置窗口显示在电脑屏幕的某区域
		myWindow.setLocation(400, 200);
		
		myWindow.setVisible(true);
		//点击关闭按钮时触发该方法
		closeMyWindow();
}

	/**
	 * 方法名：closeMyWindow()
	 * @param
	 * @return 
	 * 功能：当用户点击关闭按钮时，退出并且关闭该窗口
	 * */
	private void closeMyWindow() {
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * 方法名：getFieldText()
	 * @param 
	 * @return string
	 * 功能：获取窗口的TextField中的字符串
	 * */
	public String getFieldText()
	{
		return field.getText().toString();
	}
	
	
	/**
	 * 方法名：getButton()
	 * @param
	 * @return JButton
	 * 功能：获得该窗口中的按钮
	 * */
	public JButton getButton()
	{
		return button;
	}
	
	
	/**
	 * 方法名：getJTextArea()
	 * @param
	 * @return JTextArea
	 * 功能：返回窗口中的JTextArea
	 * */
	public JTextArea getJTextArea()
	{
		return area;
	}
	
	
	/**
	 * 方法名：getTextField()
	 * @param
	 * @return JTextField
	 * 功能：获得窗口中的textfield
	 * */
	public JTextField getTextField()
	{
		return field;
	}
}

