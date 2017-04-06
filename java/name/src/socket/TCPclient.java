package socket;

import java.io.*;
import java.net.*;

public class TCPclient {
	public void main (String[] args){
		try {
			Socket s = new Socket("127.0.0.1",6666);
			OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF("hello,server!");
			dos.flush(); 
			dos.close();
			InputStream is = s.getInputStream();
			DataInputStream dis = new DataInputStream (is);
			System.out.println(dis.readUTF());
			dis.close();
			s.close();
		}catch(ConnectException connExc){
			System.out.println("服务器连接失败！");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
