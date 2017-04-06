package socket;
/**
 * ����һ���ȶ�һ����д
 * ��������һ�������һ��д
 */
import java.io.* ;
import java.net.*;

public class TCPserver {
	public static void main(String [] args)throws Exception{
		try{
			@SuppressWarnings("resource")
			ServerSocket ss = new ServerSocket(6666);
			while(true){
				Socket s = ss.accept();		//����ʽ
				DataInputStream dis = new DataInputStream(s.getInputStream());
				System.out.println(dis.readUTF());  	//����ʽ��Ч�ʵͣ�����ͨ�ŵĹ����У�����һ���ͻ��˲�������
				dis.close();
				OutputStream os = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream	(os); 
				dos.writeUTF("Hello,"+s.getInetAddress()+"ports"+s.getPort());		//get IP address �ĳ��� 
				dos.close();
				s.close();
				System.out.println("connected.");
			}
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("�������д���"+e);
		}
	}
}