
/**
 * ��������
 */
public class Quick {

	public static void main (String []args){
		int [] a = {4,2,8,9,6,7,1,3,0,21,33,14};
		QuickSort s = new QuickSort();
		s.sort(a, 0, a.length-1);
		s.show();
	}
}

class QuickSort {
	int [] a;
	
	QuickSort(){
	}
	
	void sort(int []a, int left, int right)
	{
		this.a=a;
	    if(left >= right)/*�������������ڻ��ߵ����ұߵ������ʹ����Ѿ��������һ������*/
	    {
	        return ;
	    }
	    int i = left;
	    int j = right;
	    int key = a[left];
	      
	    while(i < j)                               /*�����ڵ�����Ѱ��һ��*/
	    {
	        while(i < j && key <= a[j])
	        /*��Ѱ�ҽ������������ǣ�1���ҵ�һ��С�ڻ��ߴ���key���������ڻ�С��ȡ�������������ǽ���2��û�з�������1�ģ�����i��j�Ĵ�Сû�з�ת*/ 
	        {
	            j--;/*��ǰѰ��*/
	        }
	          
	        a[i] = a[j];
	        /*�ҵ�һ������������Ͱ�������ǰ��ı����ߵ�i��ֵ�������һ��ѭ����key��a[left]����ô���Ǹ�key��*/
	          
	        while(i < j && key >= a[i])
	        /*����i�ڵ�������ǰѰ�ң�ͬ�ϣ�����ע����key�Ĵ�С��ϵֹͣѭ���������෴����Ϊ����˼���ǰ����������ӣ������������ߵ�����С��key�Ĺ�ϵ�෴*/
	        {
	            i++;
	        }
	          
	        a[j] = a[i];
	    }
	      
	    a[i] = key;/*���ڵ���������һ���Ժ�Ͱ��м���key�ع�*/
	    sort(a, left, i - 1);/*�����ͬ���ķ�ʽ�Էֳ�������ߵ�С�����ͬ�ϵ�����*/
	    sort(a, i + 1, right);/*��ͬ���ķ�ʽ�Էֳ������ұߵ�С�����ͬ�ϵ�����*/
	                       /*��Ȼ�����ܻ���ֺܶ�����ң�ֱ��ÿһ���i = j Ϊֹ*/
	}
	
	void show(){
		for(int e:a){
			System.out.println(e);
		}
	}
}
