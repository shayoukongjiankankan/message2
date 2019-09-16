package ant;
//倒数第k个节点

public class Backward {
	public static ListNode backward(ListNode node,int k){
		ListNode pre=node;
		int count=0;
		while(pre!=null){
			count++;
			pre=pre.next;
		}
		if(k>count){
			return null;
		}
		ListNode currentNode=null;
		for(int i=0;i<count-k;i++){
			node=node.next;
		}
		return node;
	}
}
