package ant;
import java.util.Stack;
public class Stackwithmin {
	public static void main(String[] args){
		
	}

 	 static Stack<Integer> stack=new Stack<Integer>();
     static Stack<Integer> stack2=new Stack<Integer>();

	 public void push(int node) {
		 stack.push(node);
		 if(stack2.empty())
			 stack2.push(node);
		 else if(node<=stack2.peek()){
			 stack2.push(node);
		 }
	       
//	        	stack.push(node);
//	        	
//	        	if(stack2==null){
//	        		stack2.push(node);
//	        	}
//	        	int min=stack2.peek();
//	        	if(node<min){
//	        		stack2.push(node);
//	        	}else{
//	        		stack2.push(min);
//	        	}	        
	    }
	    
	    public static void pop() {
	    	if(stack.peek()==stack2.peek()){
	    		stack2.pop();
	    	}
	    	stack.pop();
//            if(stack.size()>0&&stack2.size()>0){
	    		stack.pop();
	    		stack2.pop();
//     	        
//            }else{
//            	return;
//            }
//	       
	    }
	    
	    public static int top() {
	   		return stack.peek();
	    }
	    
	    public static int min() {
	    	return stack2.peek();
//	    	if(stack.size()>0&&stack2.size()>0){
//	    		return stack2.peek();
//	    	}else{
//	    	    return (Integer) null ;
//	    	}
	    }
}
