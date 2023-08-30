package linkedList.leetcode;

import linkedList.leetcode.PalindromeLinkedListN234.ListNode;

public class PartitionListN86 {
	
    public ListNode partition(ListNode head, int x) {
    
    	if(head == null)
    		return null;
    	ListNode c = head;
    	ListNode lxHead = null;
    	ListNode sxHead = null;
    	ListNode lr=  null;
    	ListNode sr = null;
    	
    	while(c != null) {
    		if(c.val < x) {
    			if(lxHead == null) {
    				lr = c;
    				lxHead = c;
    				c = c.next;
    				lr.next = null;
    			}else {
    				lr.next = c;
    				c = c.next;
    				lr = lr.next;
    				lr.next = null;
    			}
    			
    		}
    		else {
    			if(sxHead == null) {
    				sr = c;
    				sxHead = c;
    				c = c.next;
    				sr.next = null;
    			}else {
    				sr.next = c;
    				c = c.next;
    				sr = sr.next;
    				sr.next = null;
    			}
    		}
    	}
    	if(lxHead == null)
    		return sxHead;
    	if(sxHead == null)
    		return lxHead;
    	lr.next = sxHead;
    	return lxHead;

    }	

}
