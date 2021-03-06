import java.io.*;

public class TestObjectIO {
	public static void main (String[] args)throws Exception{
		T t = new T();
		t.k = 8;
		FileOutputStream fos = new FileOutputStream("e:/java-o/testobjectio.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(t);
		oos.flush();
		oos.close();
		
		FileInputStream fis = new FileInputStream("e:/java-o/testobjectio.txt");
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(fis);
		T tRead = (T)ois.readObject();
		System.out.println(tRead.i+" "+tRead.j+" "+tRead.d+" "+tRead.k);
	}
}

@SuppressWarnings("serial")
class T implements Serializable{
	int i = 10;
	int j = 9;
	double d = 2.3;
	//int k = 15;
	transient int k = 15;	//transient修饰的成员变量，在序列化时，该变量不予考虑
}