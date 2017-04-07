package socket;

import java.io.IOException;
import java.net.*;

public class TestUDPClient {
	public static void main(String[] args){
		byte[] buf= (new String("Hello")).getBytes();
		DatagramPacket dp = new DatagramPacket(buf,buf.length,new InetSocketAddress("127.0.0.1",5678));
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(9999);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		try {
			ds.send(dp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ds.close();
	}
}
