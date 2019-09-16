package ant;

class LinkedNode{
	private ListNode first;
	private ListNode last;
	public boolean isEmpty(){
		return first==null;
	}
	public void reverse(){//链表的反转
		ListNode pre=null;
		ListNode aft=null;
		ListNode tmp=last;
		while(first!=null){
			aft=first.next;
			first.next=pre;
			pre=first;
			first=aft;
		}
		last=first;
		first=tmp;
	}
	public void delete(ListNode node){//删除某一节点；
		ListNode newNode=first;
		
		if(first.val==node.val){
			first=first.next;
		}else if(first.val!=node.val){
			newNode=first;
			ListNode pre=first;//要找出被删除点的前一个节点
			while(newNode.val!=node.val){
				pre=newNode;
				newNode=newNode.next;
			}
			pre.next=pre.next.next;
		}else if(last.val==node.val){
			newNode=first;
			while(newNode!=last){
				newNode=newNode.next;
			}
			newNode.next=last.next;
			last=newNode;
		}
		
	}
	public void insert(int data){
		ListNode newNode=new ListNode(data);
		if(this.isEmpty()){
			first=newNode;
			last=newNode;
		}else{
			last.next=newNode;
			last=newNode;
		}
	}
	public void print(){
		ListNode current=first;
		while(current!=null){
			if(this.isEmpty()){
				return ;
			}else{
				System.out.println(current.val);
			}
			current=current.next;
		}
		
	}
}

public class DeleteNode {
	public static void main(String[] args){
		LinkedNode linkedNode=new LinkedNode();
		
		
		int num=0;
		ListNode node=new ListNode (num);
		
		while(num<7){
			linkedNode.insert(num);
			num++;
		}
		
		linkedNode.print();
		linkedNode.reverse();
		
		ListNode node1=new ListNode(2);
		linkedNode.delete(node1);
		linkedNode.print();
	}
//	public static void quickSort(int lo,int hi,int []array){
//		if(lo>hi){
//			return ;
//		}
//		int key=paTition(lo,hi,array);
//		quickSort(lo,key-1,array);
//		quickSort(key+1,hi,array);
//	}
//	public static int paTition(int lo,int hi,int []array){
//		int key=array[lo];
//		while(lo<hi){
//			while(array[hi]>=key&&lo<hi){
//				hi--;
//			}
//			swap1(lo,hi,array);
//			
//			
//			
//			while(array[lo]<=key&&lo<hi){
//				lo++;
//			}
//			swap1(lo,hi,array);
//			
////			if(array[hi]>=key&&lo<hi){
////				hi--;
////			}else{
////				swap1( lo, hi,array);
////			}
////			
////			
////			if(array[lo]<=key&&lo<hi){
////				lo++;
////			}else{
////				swap1( lo, hi,array);
////			} 
//			
//		}
//		array[hi]=key;
//		return hi;
//	}
//	public static void swap1(int lo,int hi,int []array){
//		int temp=array[lo];
//		array[lo]=array[hi];
//		array[hi]=temp;
//	}
	 public static ListNode ReverseList(ListNode head) {
	       
	        if(head==null)
	            return null;
	        //head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；
	        ListNode pre = null;
	        ListNode next = null;
	        //当前节点是head，pre为当前节点的前一节点，next为当前节点的下一节点
	        //需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
	        //即pre让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点的话，此单链表就此断开了
	        //所以需要用到pre和next两个节点
	        //1->2->3->4->5
	        //1<-2<-3 4->5
	        while(head!=null){
	            //做循环，如果当前节点不为空的话，始终执行此循环，此循环的目的就是让当前节点从指向next到指向pre
	            //如此就可以做到反转链表的效果
	            //先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
	            next = head.next; 
	            //保存完next，就可以让head从指向next变成指向pre了，代码如下
	            head.next = pre;
	            pre = head;//头节点前面为null，所以pre初始值为null，这时候经过一次反转，则pre就会变成它本身作为它下一个节点的前置点。
	            head = next;//next保存的是原本此次循环当前节点指向的下一路径，因为之后指向已经改变了，所以这里不能用head.next.相当于传统链表遍历的head=head.next.
	        }
	        //如果head为null的时候，pre就为最后一个节点了，但是链表已经反转完毕，pre就是反转后链表的第一个节点
	        //直接输出pre就是我们想要得到的反转后的链表
	        return pre;
	    }
}
