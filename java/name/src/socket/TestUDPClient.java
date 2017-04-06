package socket;

import java.net.*;
import java.io.*;
/**
 * 传输一个long类型的数据
 * @author Administrator
 *
 */
public class TestUDPClient {
	public static void main(String[] args){
		long q = 100000L;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		try {
			dos.writeLong(q);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//byte[] buf= (new String("Hello")).getBytes();
		byte [] buf = baos.toByteArray();
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
