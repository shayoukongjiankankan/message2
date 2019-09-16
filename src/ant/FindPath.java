package ant;

import java.util.ArrayList;

//二叉树中和为某一值得路径
public class FindPath {
	public static void main(String[] args){
		
	}
//	public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
//        
//    }

		 public ArrayList<ArrayList<Integer>> FindPath1(TreeNode root,int target) {
		        ArrayList<ArrayList<Integer>> paths=new ArrayList<ArrayList<Integer>>();
		        if(root==null)return paths;
		        find(paths,new ArrayList<Integer>(),root,target);
		        return paths;
		    }
		    public void find(ArrayList<ArrayList<Integer>> paths,ArrayList<Integer> path,TreeNode root,int target){
		        path.add(root.val);
		        if(root.left==null&&root.right==null){
		            if(target==root.val){
		                paths.add(path);
		            }
		            return;
		        }
		        ArrayList<Integer> path2=new ArrayList<>();
		        path2.addAll(path);
		        if(root.left!=null)find(paths,path,root.left,target-root.val);
		        if(root.right!=null)find(paths,path2,root.right,target-root.val);
		    }
		    
		    
/*
 		    * FindPath功能：在给定root子树中，找出合理的路径以达到目标和target 
		    * FindPath实质：二叉树的深度优先遍历 + 每次遍历均判断是否达到条件,若是则输出
		    * 大致策略
		    * 1、root入栈，跳入该子树进行寻路操作 
		    * 2、若root的这条路径，已满足要求，则将该路径加入到listAll中去
		    * 3、对root左右子树，继续寻路
		    * 4、root出栈，该子树访问完毕
		    * 并不是没找到路径要回退，找到了也要回退的。因为一直使用了同一个list的空间，
		    * 遍历完一条路径后回退去找别的路径一定要从list后面删掉回退的元素，不然list会越来越长。
		    * 其实每次递归都会返回U一个listAll，只是每个子树的遍历的结果返回的listAll不完全
		    * ，当一直遍历完全了，最后返回的listAll，能包含所有满足的路径list集合了
		    */
		    		private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
		    	    private ArrayList<Integer> list = new ArrayList<Integer>();
		    	    public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root,int target) {
		    	        if(root == null)
		    	        	return listAll;
		    	        list.add(root.val);
		    	        target =target-root.val;
		    	        if(target == 0 && root.left == null && root.right == null)
		    	            listAll.add(new ArrayList<Integer>(list));//新建一个和list元素一样的ArrayList
		    	        FindPath2(root.left, target);
		    	        FindPath2(root.right, target);
		    	        list.remove(list.size()-1);//考虑递归本质，参考后序遍历，输出总是要执行的，
		    	        return listAll;				//这里也一样，子节点回到父节点时，应该把子节点的值删掉	    	        
		    	    }
}
