package ant;
//切绳子，得最大乘积问题
public class Cut {
	public static void main(String[] args){
		int max=cutMax(10);
		System.out.println(max);
		int max1=Cutmax(10);
		System.out.println(max1);
	}
	public static int cutMax(int length){//动态规划解法，主要是从子集一次上升到最后总的；也有递归的意思
		if(length<2)
			return 0;
		if(length==2)
			return 1;
		if(length==3)
			return 2;
		int []length1=new int[length+1];
		/*前面是必须要剪得出的值，而在这里，作为子集，本身并不一定需要剪成几段，
		 所以这个若干其实可能是本身不用减去而作为一个原始长度加入乘积的一个部分，
		就比如2>1*1；和3>1*2；*/
		length1[0]=0;
		length1[1]=1;
		length1[2]=2;
		length1[3]=3;
		int max=0;
		for(int i=4;i<=length;++i){
			for(int j=1;j<=i/2;++j){
				int product=length1[j]*length1[i-j];
				if(max<product){
					max=product;
				}
				length1[i]=max;
			}
		}
		max=length1[length];
		return max;
	}
	public static int Cutmax(int length){//贪心算法，依靠数学证明
		if(length==0)
			return 0;
		if(length==1)
			return 0;
		if(length==2)
			return 1;
		if(length==3)
			return 2;
		int timeOf3=length/3;
		if(length-3*timeOf3==1){
			timeOf3-=1;
		}	
		int timeOf2=(length-3*timeOf3)/2;
		int max=(int) (Math.pow(3,timeOf3)*Math.pow(2,timeOf2));
		return max;

	}
}
