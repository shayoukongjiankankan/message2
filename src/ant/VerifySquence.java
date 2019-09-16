package ant;
//考查二叉搜索树的后序遍历
//二叉搜索树特点，根左面数字小于根，根右边数字大于根
public class VerifySquence {
	public static void main(String[] args){
		int []sequence={4,6,7,5};
		System.out.print(VerifySquenceOfBST(sequence));
	}
	public static boolean VerifySquenceOfBST(int [] sequence) {
		 int length=sequence.length;
	        
		 if(length==0){
	        	return false;
	        }
		
	     return patition(sequence,0,length-1);
	}
	public static boolean patition(int[] sequence,int start,int end){
		 int index=0;
		 if(end<=start){
			 return true;
		 }
	     int root=sequence[end];
//	     int i=start;
	     for(int i=start;i<end;i++){
	    	 if(sequence[i]>sequence[end]){
	    		 index=i;//错误之处在于，如果是后几次，循环完了之后都没进入这个if条件里，此时分界点应该是i<end最后一个i输出，而不是你定义的
	    		 break;
	    	 }else{
	    		 index=i+1;//代表都在左面，而这里Index是代表的根节点右面第一个，所以i+1
	    	 }
	     }
//	     for(;i<end;i++){
//	    	 if(sequence[i]>sequence[end]){
//	    		 index=i;//错误之处在于，如果是后几次，循环完了之后都没进入这个if条件里，此时分界点应该是i<end最后一个i输出，而不是你定义的
//	    		 break;
//	    	 }
//	     }
	     System.out.println(index);
//	     System.out.println(i);
//	     for(int j=i;j<end;j++){
//	    	 if(sequence[j]<sequence[end]){
//	    		 return false;	    		 
//	    	 } 
//	     }
//	     return patition(sequence,start,i-1)&&patition(sequence,i,end-1);
	     for(int j=index;j<end;j++){
	    	 if(sequence[j]<sequence[end]){
	    		 return false;	    		 
	    	 } 
	     }
	     return patition(sequence,start,index-1)&&patition(sequence,index,end-1);
	    
	}
}
