package ant;
//链表中环的入口节点
//反转链表并输出头结点
//合并两个排序的链表为一个链表
public class Rank {
	public static void main(String[] args){
		
	}
	public static ListNode isRank(ListNode pHead){
		 ListNode quickOne=pHead;
			ListNode quickOne1=pHead;
			ListNode slowOne1=pHead;
			if(pHead==null||pHead.next==null){
				return null;
			}
			while(quickOne!=null){
				quickOne=quickOne.next.next;
				pHead=pHead.next;
				if(quickOne==pHead){
					break;
				}
			}
			if(quickOne==null){
				return null;
			}
			int count=1;
	        ListNode quickOne2=quickOne;
			while(quickOne.next!=quickOne2){
				count++;
	            quickOne=quickOne.next;
			}
			
			for(int i=0;i<count;i++){
				quickOne=quickOne.next;
			}
			while(slowOne1!=quickOne1){
				slowOne1=slowOne1.next;
				quickOne1=quickOne1.next;
			}
			return null;
	}
	public static ListNode ReverseList(ListNode head){
		if(head==null||head.next==null){
			return head;
		}
//		ListNode pre=null;
//		ListNode aft=null;
//		while(head!=null){
//			pre=head.next;
//			head.next=aft;
//			aft=head;
//			head=pre;
//		}
//		return aft;
		while(head!=null){
			ReverseList(head.next);
		}
		return head;
	}
	public ListNode Merge(ListNode list1,ListNode list2) {
	   	if(list1==null){
				return list2;
			}
			if(list2==null){
				return list1;
			}
			ListNode pre=null;
			
		
			
			
		if(list1.val<=list2.val){
			pre=list1;	                
			pre.next=Merge(list1.next,list2);
		}else{
			pre=list2;
			pre.next=Merge(list1,list2.next);
		}
				
			
			return pre;
	    }
}
