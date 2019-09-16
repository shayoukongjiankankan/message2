package ant;
/* 队列的创建与使用LinkedList以及queue，offer、add的区别，peek（），elements区别，poll（）与removed区别
 * 若是有判断空的方法，千万别自己来个==null!!!!.empty(){栈和队列都是如此}
 * 创建队列，队列里面为node元素而不是node.val元素的原因是便于向下循环
 * 对于此题来说层次打印如何向下是重点，因此找清楚规律最为重要借助队列可以完成这种规律（先进先出）；
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class ToptoBottom {
	public static void main(String[] args){
		
	}
	 public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {//从上到下打印二叉树
		 	ArrayList<Integer> al=new ArrayList<Integer>();
		 	if(root==null){
	        	return al;
	        }
	        Queue<TreeNode> qu=new LinkedList<TreeNode>();
	        qu.offer(root);
	        
	        while(!qu.isEmpty()){
	        	TreeNode treenode=qu.poll();
	        	if(treenode.left!=null){
	        		qu.offer(treenode.left);
	        	}
	        	if(treenode.right!=null){
	        		qu.offer(treenode.right);
	        	}
	        	al.add(treenode.val);
	        }
	        return al;
	    }
	 public static ArrayList<Integer> PrintFromTopToBottom1(TreeNode root) {//从上到下打印二叉树，每一行输出
		 	ArrayList<Integer> al=new ArrayList<Integer>();
		 	if(root==null){
	        	return al;
	        }
	        Queue<TreeNode> qu=new LinkedList<TreeNode>();
	        qu.offer(root);
	        int nextlevel=0;
	        int tobePrinted=1;
//	        ArrayList<ArrayList<Integer>> all=new ArrayList<ArrayList<Integer>>();
	        while(!qu.isEmpty()){
	        	TreeNode treenode=qu.poll();
	        	if(treenode.left!=null){
	        		qu.offer(treenode.left);
	        		nextlevel++;
	        	}
	        	if(treenode.right!=null){
	        		qu.offer(treenode.right);
	        		nextlevel++;
	        	}
	        	al.add(treenode.val);
	        	
	        	System.out.print(treenode.val);
	        	tobePrinted--;
	        	if(tobePrinted==0){
	        		System.out.println();
	        		tobePrinted=nextlevel;
	        		nextlevel=0;
	        	}
	        }
	        return al;
	    }
	 /*之字形打印二叉树，利用了栈的先进后出特点作为每一层的容器。
	  *知道为什么要用两个栈
	  * */
	 public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {//之字形打印二叉树
        ArrayList<ArrayList<Integer>> all=new ArrayList<ArrayList<Integer>>();
        if(pRoot==null){
        	return all;
        }
        Stack<TreeNode> stack1=new Stack<TreeNode>();
        Stack<TreeNode> stack2=new Stack<TreeNode>();
        stack1.add(pRoot);
        while(!stack1.isEmpty()||!stack2.isEmpty()){
        	if(!stack1.isEmpty()){
        		ArrayList<Integer> al=new ArrayList<Integer>();
        		while(!stack1.isEmpty()){
        			TreeNode treenode=stack1.pop();
            		if(treenode.left!=null){
            			stack2.add(treenode.left);
            		}
            		if(treenode.right!=null){
            			stack2.add(treenode.right);
            		}
            		al.add(treenode.val);
        		}
        		all.add(al);
        		
        	}
        	else{
        		ArrayList<Integer> al=new ArrayList<Integer>();
        		while(!stack2.isEmpty()){
        			TreeNode treenode=stack2.pop();
            		if(treenode.right!=null){
            			stack1.add(treenode.right);
            		}
            		if(treenode.left!=null){
            			stack1.add(treenode.left);
            		}
            		al.add(treenode.val);
        		}
        		
        		all.add(al);
        	}
        }
        return all;
  }

	 
}
