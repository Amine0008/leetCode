package linkedList.leetcode;

import linkedList.leetcode.PalindromeLinkedListN234.ListNode;

public class SwapNodesInPairsN24 {
	
    public ListNode swapPairs(ListNode head) {
    	ListNode c = head;
    	ListNode temp = null;
    	ListNode pv = null;
    	while(c != null && c.next != null) {
    		temp = c.next;
    		c.next = temp.next;
    		temp.next = c;
    		if(pv != null)
    			pv.next = temp;
    		else
    			head = temp;
    		pv = c;
    		c = c.next;
    	}
    	return head;
    }

}
