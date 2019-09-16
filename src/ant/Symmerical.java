package ant;
//对称二叉树，前序遍历从左到右来一个对称的前序遍历从右到左，如果二者相同，则为对称
public class Symmerical {
	public static void main(String[] args){
		
	}
	public static boolean isSymmetrical(TreeNode pRoot){
		return isSymmetrical(pRoot,pRoot);
		}
//	@ overload
	public static boolean isSymmetrical(TreeNode pRoot1,TreeNode pRoot2){
		if(pRoot1==null&&pRoot2==null){
			return true;
		}
		if(pRoot1==null||pRoot2==null){
			return false;
		}
		if(pRoot1.val!=pRoot2.val){
			return false;
		}
		return isSymmetrical( pRoot1.left, pRoot2.right)&&isSymmetrical( pRoot1.right, pRoot2.left); 
	}
}
