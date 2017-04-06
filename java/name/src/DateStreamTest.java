import java.io.*;

public class DateStreamTest{
	public static void main (String [] args){
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream d = new DataOutputStream (b);
		try {
			d.writeDouble(Math.random());
			d.writeBoolean(true);
			ByteArrayInputStream bs = new ByteArrayInputStream(b.toByteArray());
			System.out.println(bs.available());
			DataInputStream ds = new DataInputStream (bs);
			System.out.println(ds.readDouble());
			System.out.println(ds.readBoolean());
			ds.close();
			d.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}