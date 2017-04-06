package socket;
/**
 * 必须一个先读一个先写
 * 不能两个一起读，或一起写
 */
import java.io.* ;
import java.net.*;

public class TCPserver {
	public static void main(String [] args)throws Exception{
		try{
			@SuppressWarnings("resource")
			ServerSocket ss = new ServerSocket(6666);
			while(true){
				Socket s = ss.accept();		//阻塞式
				DataInputStream dis = new DataInputStream(s.getInputStream());
				System.out.println(dis.readUTF());  	//阻塞式，效率低；在你通信的过程中，另外一个客户端不能连接
				dis.close();
				OutputStream os = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream	(os); 
				dos.writeUTF("Hello,"+s.getInetAddress()+"ports"+s.getPort());		//get IP address 的超集 
				dos.close();
				s.close();
				System.out.println("connected.");
			}
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("程序运行错误："+e);
		}
	}
}
