package ant;
//判断B是否是A的子树
//树的镜像
//回溯法思想，递归找根节点，然后再进入另外一个函数判断之后的是否符合
public class Hassubtree {
	public static void main(String []args){
		
	}
	public static boolean HasSubtree(TreeNode root1,TreeNode root2){
		if(root1==null&&root2!=null){
			return false;
		}
		if(root1==null||root2==null){
			return false;
		}
		boolean result=false;
		if(root1!=null&&root2!=null){
			if(root1.val==root2.val){//注意这里树的大小比较比的是value而不是这个节点！
				result=DoesTree1HasTree2(root1,root2);
			}
			if(!result){
				result=HasSubtree(root1.left,root2);
			}
			if(!result){
				result=HasSubtree(root1.right,root2);//找到开始这个点
			}
		}
		
		return result;
	}
	public static boolean DoesTree1HasTree2(TreeNode root1,TreeNode root2){
		if(root2==null){
			return true;
		}
		if(root1==null){
			return false;
		}
		if(root1.val!=root2.val){//注意这里树的大小比较比的是value而不是这个节点！
			return false;
		}
		return DoesTree1HasTree2(root1.left,root2.left)&&DoesTree1HasTree2(root1.right,root2.right) ;
	}
}
