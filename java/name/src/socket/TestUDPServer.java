package socket;

import java.io.IOException;
import java.net.*;

public class TestUDPServer {
	@SuppressWarnings("resource")
	public static void main(String[]args){
		byte buf[] = new byte[1024];	//一个包裹
		DatagramPacket dp = new DatagramPacket(buf,buf.length);
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(5678);
		} catch (SocketException e1) {
			e1.printStackTrace();
		}
		while(true){
			try {
				ds.receive(dp);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(new String(buf,0,dp.getLength()));  //实际上收了多少数据		
		}
	}
}
