package socket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyServer implements ActionListener {

	/**
	 * ��������
	 * */
	private Window window;
	private ServerSocket server;
	private static Socket socket;
	private JButton button;
	private static JTextArea area;
	private JTextField field;
//	private BufferedWriter writer;
	private OutputStream writer;
	private static BufferedReader reader;

	// ���TextField�е��ַ���
	private static String fromClient;

	public MyServer() {

		window = new Window("��������");
		button = window.getButton();
		area = window.getJTextArea();
		field = window.getTextField();
		button.addActionListener(this);

		try {
			//�����˿�5000
			server = new ServerSocket(30000);
			System.out.println("�������Ѵ��������ڵȴ��ͻ������ӡ�����");
			socket = server.accept();
			System.out.println("�ͻ���������");
			//�����������
			writer = socket.getOutputStream();
			reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		new MyServer();
		// �����߳�ȥ��ȡ�ͻ��˷���������
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while (socket != null) {
						fromClient = reader.readLine();
						area.append("�ͻ��ˣ�" + fromClient + '\n');
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					try {
						reader.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		}).start();
	}

	/**
	 * ��ť���������������ťʱ�����÷�����
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		String me = field.getText().toString() + '\n';
		area.append("��������" + me);
		field.setText("");
		try {
			writer.write(me.getBytes("utf-8"));
			//ˢ�������
			writer.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			try {
				writer.close();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}

	}
}