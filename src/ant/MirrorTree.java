package ant;

import java.util.Stack;

//二叉树的镜像
public class MirrorTree {
	public static void main(String []args){
		
	}
	public static void MirrorRecursively(TreeNode root){//使用递归解决问题
		if(root==null){
			return ;
		}
		if(root.left==null&&root.right==null){
			return ;
		}
		swap(root);
		MirrorRecursively(root.left);
		MirrorRecursively(root.right);
	}
	//栈的特点，压入，弹出特性，当把一个树压入进去后，弹出依次从根节点弹出，做一个循环，依次弹出一些，便和递归类似了
	public static void Mirror(TreeNode root){//使用栈解决问题
			 if(root == null){
			            return;
			        }
			        Stack<TreeNode> stack = new Stack<TreeNode>();
			        stack.push(root);
			        while(!stack.isEmpty()){
			            TreeNode node = stack.pop();
			            if(node.left != null||node.right != null){
			                TreeNode temp = node.left;
			                node.left = node.right;
			                node.right = temp;
			            }
			            if(node.left!=null){
			                stack.push(node.left);
			            }
			            if(node.right!=null){
			                stack.push(node.right);
			            }
			        }
	}
	private static void swap(TreeNode root) {
		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
	}
}
