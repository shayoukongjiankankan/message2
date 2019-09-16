package ant;

public class Number {
	public static void main(String[] args){
		int num=5;
		int count=numberOf1(num);
		System.out.println(count);
		int count1=numBerOf1(num);
		System.out.println(count1);
	}
	public static int numberOf1(int num){
		int count=0;
		int flag=1;
		while(flag!=0){
			if((num&flag)!=0){
				count++;
			}
			flag=flag<<1;
		}
		return count;
	}
	public static int numBerOf1(int num){
		int count=0;
		while(num!=0){
			count++;
			num=num&(num-1);
		}
		return count;
	}
}
