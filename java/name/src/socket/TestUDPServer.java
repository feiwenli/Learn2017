package socket;

import java.io.*;
import java.net.*;
/**
 * 接受一个long类型的数据
 * @author Administrator
 *
 */
public class TestUDPServer {
	@SuppressWarnings("resource")
	public static void main(String[]args) throws IOException{
		byte buf[] = new byte[1024];	//一个包裹
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
			//System.out.println(new String(buf,0,dp.getLength()));  //实际上收了多少数据		
		}
	}
}
