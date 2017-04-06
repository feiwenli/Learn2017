

import java.io.File;
/**
 * 将文件中的子目录列出来
 * @author Administrator
 *
 */
public class zimulu {
	public static void main (String [] args){
		File f = new File("E:\\考研");
		System.out.println(f.getName());
		Tree(f,1);
	}	

	private static void Tree (File file,int level){
		String p ="";
		for(int j=0;j<level;j++){
			p +="    ";
		}
		File [] child = file.listFiles();
		for (int i=0;i<child.length; i++){
			System.out.println(p+child[i].getName());
			if (child[i].isDirectory()){			
				//System.out.println(child[i]+"   is directory");
				Tree(child[i],level+1);
			}		
		}
	}
}

//public class zimulu {
//	public static void main(String [] args){
//		File f = new File("e:/考研");
//		tree(f,0);
//		
//	}
//
//	private static void tree (File f,int level){
//	
//		String preStr = "";
//		for (int i=0; i<level ; i++){
//			preStr +="    ";
//		}
//	
//		File[] childs = f.listFiles();
//		for(int i=0;i<childs.length;i++){
//			System.out.println(preStr+childs[i].getName());
//			if(childs[i].isDirectory()){
//				tree(childs[i],level+1);
//			}
//		}
//	}
//}

