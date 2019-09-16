package ant;

public class Road {
	public static void main(String[] args){
//		int count=fond(5,10,10);
//		System.out.println(count);
		String aa="abcdealibabafg";
		String bb="alibaba";
		
		int flag = stringMatch(aa, bb);
		System.out.println(flag);
		
	}
	private static int stringMatch(String aa, String bb) {
		char [] a=aa.toCharArray();
		char [] b=bb.toCharArray();
		int flag=find(a,b);
		return flag;
	}
	public static int find(char[] array,char[] str){
		boolean[] flag=new boolean[array.length+1];
		for(int i=0;i<array.length;i++){
			if(judge(array,str,flag,i,0)){
				return i;
			}
		}
		return 10086;
	}
	public static boolean judge(char[] array,char[] str,boolean []flag,int i,int k){
		if(i<0||k>=str.length||array[i]!=str[k]||flag[i]==true){
			return false;
		}
		if(k==str.length-1){
			return true;
		}
		flag[i]=true;
		
		if(judge(array,str,flag,i+1,k+1)){
			return true;
		}
		flag[i]=false;
		return false;
	}
	public static int fond(int max,int rows,int cols){
		boolean []flag=new boolean[rows*cols];
		int count=roadCount(0,0,rows,cols,flag,max);
		return count;
	}
	public static int roadCount(int i,int j,int rows,int cols,boolean []flag,int max){
		int index=i*cols+j;
		int sum=i/10+i%10+j/10+j%10;
		if(i<0||j<0||i>=rows||j>=cols||flag[index]||sum>max){
			return 0;
		}
		flag[index]=true;
		int count=roadCount(i-1,j,rows,cols,flag,max)+roadCount(i+1,j,rows,cols,flag,max)+roadCount(i,j-1,rows,cols,flag,max)+roadCount(i,j+1,rows,cols,flag,max)+1;
		return count;
	}
}

