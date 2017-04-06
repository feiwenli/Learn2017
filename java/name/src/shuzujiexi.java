/**
 * 把一个字符串解析为数组
 * @author FeiWen Li
 *
 */
public class shuzujiexi {
	public static void main(String[] args){
		String s = "1,2;3,4;5,6;7,8,9";
		String[] sFirst = s.split(";");		//把一个字符串分割成字符串数组
		double [][] d ;
		d = new double [sFirst.length][];
		for(int i=0; i<sFirst.length; i++){
			String[] sSecond = sFirst[i].split(",");
			d[i] = new double [sSecond.length];
			for (int j=0; j<sSecond.length; j++){
				d[i][j] = Double.parseDouble(sSecond[j]);
			}
		}
		
		for (int i=0; i<d.length;i++){
			for (int j =0; j<d[i].length;j++){
				System.out.print(d[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
