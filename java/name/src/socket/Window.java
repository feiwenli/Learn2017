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
	 * ������  ����ͻ��˺ͷ������˵Ĵ���
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
		//���ܸı䴰�ڴ�С
		myWindow.setResizable(false);
		
		area = new JTextArea();
		field = new JTextField();
		button = new JButton("����");
		
		//����field�Ĵ�С
		field.setPreferredSize(new Dimension(400, 30));
		myWindow.add(field);
		myWindow.add(button);
		myWindow.add(area);
		//�ı�area�Ĵ�С
		area.setPreferredSize(new Dimension(470, 210));
		area.setBackground(Color.PINK);
		area.setEditable(false);
		//���ô�����ʾ�ڵ�����Ļ��ĳ����
		myWindow.setLocation(400, 200);
		
		myWindow.setVisible(true);
		//����رհ�ťʱ�����÷���
		closeMyWindow();
}

	/**
	 * ��������closeMyWindow()
	 * @param
	 * @return 
	 * ���ܣ����û�����رհ�ťʱ���˳����ҹرոô���
	 * */
	private void closeMyWindow() {
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * ��������getFieldText()
	 * @param 
	 * @return string
	 * ���ܣ���ȡ���ڵ�TextField�е��ַ���
	 * */
	public String getFieldText()
	{
		return field.getText().toString();
	}
	
	
	/**
	 * ��������getButton()
	 * @param
	 * @return JButton
	 * ���ܣ���øô����еİ�ť
	 * */
	public JButton getButton()
	{
		return button;
	}
	
	
	/**
	 * ��������getJTextArea()
	 * @param
	 * @return JTextArea
	 * ���ܣ����ش����е�JTextArea
	 * */
	public JTextArea getJTextArea()
	{
		return area;
	}
	
	
	/**
	 * ��������getTextField()
	 * @param
	 * @return JTextField
	 * ���ܣ���ô����е�textfield
	 * */
	public JTextField getTextField()
	{
		return field;
	}
}

