package socket;

import java.io.*;
import java.net.*;
/**
 * ����һ��long���͵�����
 * @author Administrator
 *
 */
public class TestUDPServer {
	@SuppressWarnings("resource")
	public static void main(String[]args) throws IOException{
		byte buf[] = new byte[1024];	//һ������
		DatagramPacket dp = new DatagramPacket(buf,buf.length);
		
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(5678);
		} catch (SocketException e1) {
			e1.printStackTrace();
		}
		while(true){
			ds.receive(dp);
			ByteArrayInputStream bis = new ByteArrayInputStream(buf);
			DataInputStream dis = new DataInputStream(bis);
			System.out.println(dis.readLong());
			//System.out.println(new String(buf,0,dp.getLength()));  //ʵ�������˶�������		
		}
	}
}
