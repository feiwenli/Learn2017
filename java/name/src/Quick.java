
/**
 * 快速排序
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
	    if(left >= right)/*如果左边索引大于或者等于右边的索引就代表已经整理完成一个组了*/
	    {
	        return ;
	    }
	    int i = left;
	    int j = right;
	    int key = a[left];
	      
	    while(i < j)                               /*控制在当组内寻找一遍*/
	    {
	        while(i < j && key <= a[j])
	        /*而寻找结束的条件就是，1，找到一个小于或者大于key的数（大于或小于取决于你想升序还是降序）2，没有符合条件1的，并且i与j的大小没有反转*/ 
	        {
	            j--;/*向前寻找*/
	        }
	          
	        a[i] = a[j];
	        /*找到一个这样的数后就把它赋给前面的被拿走的i的值（如果第一次循环且key是a[left]，那么就是给key）*/
	          
	        while(i < j && key >= a[i])
	        /*这是i在当组内向前寻找，同上，不过注意与key的大小关系停止循环和上面相反，因为排序思想是把数往两边扔，所以左右两边的数大小与key的关系相反*/
	        {
	            i++;
	        }
	          
	        a[j] = a[i];
	    }
	      
	    a[i] = key;/*当在当组内找完一遍以后就把中间数key回归*/
	    sort(a, left, i - 1);/*最后用同样的方式对分出来的左边的小组进行同上的做法*/
	    sort(a, i + 1, right);/*用同样的方式对分出来的右边的小组进行同上的做法*/
	                       /*当然最后可能会出现很多分左右，直到每一组的i = j 为止*/
	}
	
	void show(){
		for(int e:a){
			System.out.println(e);
		}
	}
}

