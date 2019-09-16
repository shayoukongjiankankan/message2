package ant;

import java.util.HashMap;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class Cloneconplex {
	public static void main(String[] args){
		
	}
	//最笨的方法，时间复杂度O(n2)
	  public RandomListNode Clone(RandomListNode pHead)
	    {
	         if (pHead==null){
	             return null;
	         }
	        RandomListNode node = pHead;
	        RandomListNode first = new RandomListNode(-1);//first记录了新建copy的头指针first。next一直会指向这个链表头指针，此时first不能动
	        RandomListNode p = first;
	        while(node != null){
	            p.next = new RandomListNode(node.label);
	            p =p.next;
	            node = node.next;
	        }
	        RandomListNode q = first.next;
	        RandomListNode randomNode = pHead;
	        while(q !=null){
	            int len = getRandomNode(pHead,randomNode.random);
	            RandomListNode ran = first;//这里用first原因是必须使用复制的，因为题目说了不能使用参数上的节点引用
	            if(len==0)
	                ran=null;
	            for(int j = 0;j<len;j++)
	                ran = ran.next;
	            q.random = ran;
	            q =q.next;
	            randomNode = randomNode.next;
	        }
	        return first.next;
	    }
	    public int getRandomNode(RandomListNode pHead,RandomListNode target){
	        if(target==null){
	            return 0;
	        }
	        int pos = 0 ;
	        RandomListNode p = pHead;
	        while(p != null){
	            pos++;
	            if(p == target)
	                break;
	            
	            p = p.next;
	        }
	        return pos;
	    }
//	public static RandomListNode Clone(RandomListNode pHead)
//    {
//       if(pHead==null){
//           return null;
//       }
//      RandomListNode first=new RandomListNode(-1);
//      RandomListNode p=first;
//      RandomListNode node=pHead;
//      while(node!=null){
//          p.next=new RandomListNode(node.label);
//          p=p.next;
//          node=node.next;
//      }
//      RandomListNode q=first.next;
//      RandomListNode randomNode=pHead;
//      
//      while(q!=null){
//          
//          
//          int len=Getpos(pHead,randomNode);
//          RandomListNode head=pHead;
//          if(len==0)
//             head=null;
//          for(int i=0;i<len;i++){
//              head=head.next;
//          }
//          q.random=head;
//          
//          q=q.next;
//          randomNode=randomNode.next;
//      }
//      return first.next;
//      
//    }
//    public static int Getpos(RandomListNode pHead,RandomListNode randomNode){
//        if(randomNode==null){
//            return 0;
//        }
//        int pos=0;
//        RandomListNode p=pHead;
//        while(p!=null){
//            pos++;
//            if(p==randomNode.random){
//                break;
//            }
//            p=p.next;
//        }
//        return pos;
//    }
	    //时间复杂度O(n)
	  public RandomListNode Clone1(RandomListNode pHead)
	    {
		  if(pHead == null)
	            return null;
	         
	        RandomListNode cur = pHead;
	        while(cur != null){
	            RandomListNode node = new RandomListNode(cur.label);//复制一个值在一个新的节点
	            node.next = cur.next;//它插入原先这个节点和这个节点下一个节点之间，让它的后面是原先的后面
	            cur.next = node;//上面的第二步，让他的前面是原先那个节点
	            cur = node.next;//循环到下一点	        	
	        }//这时候的链表就变成了了一个两倍重复的链表了
	         
	        cur = pHead;//cur由于上面的循环，指针不在头了，但是pHead指针还在，因此这里再重新指向头，一会儿可以再找一个试一下
	        RandomListNode node = cur.next;
	        while(cur != null){
	            node = cur.next;//添加节点
	            if(cur.random != null){
	                node.random = cur.random.next;//节省了时间复杂度
	            }
	            cur = node.next;//原先节点向下循环
	             
	        }
	         
	        RandomListNode cloneHead = pHead.next;//指向加长链表的第二个节点
	        cur = pHead;//指向加长链表的头结点
	        RandomListNode temp;
	        while(cur.next != null){
	            temp = cur.next;
	            cur.next = temp.next;//将之前添加的链表的next越过原head指向下一个复制的
	            cur = temp;
	        }
	        return cloneHead;
	    }

//需要额外辅助空间O(n)
		  public RandomListNode Clone2(RandomListNode pHead)
		      {
		          HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		          RandomListNode cur = pHead;
		          while (cur != null) {
		              map.put(cur, new RandomListNode(cur.label));//单纯赋值
		              cur = cur.next;
		          }
		          cur = pHead;
		          while (cur != null) {
		              map.get(cur).next = map.get(cur.next);//建立next链接
		              cur = cur.next;
		          }
		          RandomListNode resHead = map.get(pHead);
		          cur = pHead;
		          while (cur != null) {
		              map.get(cur).random = map.get(cur.random);//建立random链接
		              cur = cur.next;
		          }
		          return resHead;
		      }
	    
}