package linkedList.leetcode;

import linkedList.leetcode.PalindromeLinkedListN234.ListNode;

public class ReverseLinkedList2N92 {

	
    public ListNode reverseBetween(ListNode head, int left, int right) {
     
	    if(left == right)
	    	return head;
	    	
	     int counter = 1;
	     ListNode preL = head;
	     ListNode pv = null;
	     ListNode c = head;
	     ListNode temp = null;
	     ListNode newHead = null;
	     ListNode newTail = null;
	     
	     while(counter <= right) {
	    	 if(counter < left) {
	    		 if(counter == left -1)
	    			 preL = c;
	    		 c = c.next;
	    		 counter ++;
	    		 continue;
	    	 }
	    	 temp = c.next;
	    	 c.next = pv;
	    	 pv = c;
	    	 if(counter == right)
	    		 newHead = c;
	    	 if(counter == left)
	    		 newTail = c;
	    	 c = temp;
	    	 counter++;
	    	 
	     }
	     if(left != 1)
	    	 preL.next = newHead;
	     newTail.next = c;
	     if(left == 1)
	    	 return newHead;
	     return head;
     
    }
    
    
    
    
    
}
