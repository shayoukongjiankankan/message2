package ant;
//输出一个数字，依次输出1到这个数字N位数
import java.util.Scanner;

public class Maxnumber {
	  public static void main(String[] args) {	    	
	        Scanner in=new Scanner(System.in);	        
	        int num=in.nextInt();
	        maxPrint(num);
//	        System.out.print(count);
	        
	    }

	private static void maxPrint(int num) {
		int count=0;
		if(num<=0){
		    return ;
		    }
		int[] number = new int[num+1];
		while(true){
			number=count(number,0);
			if(number[num]==1)
				break;
			printNumber(number);
			count++;
		}
	}
//	处于循环内部的两个方法
		public static int [] count(int [] array,int n) {
			if(array[n]<9){
				array[n]=array[n]+1;
			}else{
				array[n]=0;
				count(array,n+1);
			}
			return array;
			}
		
		public static void printNumber(int[] array){
			for (int i = array.length-1; i >=0; i--) {
				if(array[i]!=0){//从左到右找出第一个不为零的数，然后开始打印
					for (int j = i; j >=0; j--) {
						System.out.print(array[j]);
					}
					break;
				}
			}
			System.out.println();
			}


	  

}
