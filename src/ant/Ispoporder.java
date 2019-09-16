package ant;
//限制条件一定要放在条件之前！！！！
//看懂题意，熟练使用if与while循环

import java.util.Stack;
public class Ispoporder {
	public static void main(String[] args){
		
	}
	public static boolean IsPopOrder(int []pushA,int []pushB){
		Stack<Integer> stack1=new Stack<Integer>();
		int lengthA=pushA.length;
		int lengthB=pushB.length;
//		if(lengthA!=lengthB){
//			return false;
//		}
		if(lengthA==0||lengthB==0){
			return false;
		}
		for(int i=0,j=0;i<lengthA;i++){
			stack1.push(pushA[i]);
			while(stack1.peek()==pushB[j]&&j<lengthB){
				stack1.pop();
				j++;
			}
		}
		return stack1.empty();
	}
}
