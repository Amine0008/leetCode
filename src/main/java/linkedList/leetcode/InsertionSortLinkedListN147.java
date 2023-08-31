package linkedList.leetcode;

import linkedList.leetcode.PalindromeLinkedListN234.ListNode;

public class InsertionSortLinkedListN147 {
	
    public ListNode insertionSortList(ListNode head) {
        
    	ListNode newHead = new ListNode(Integer.MIN_VALUE);
    	ListNode b = newHead;
    	ListNode a = head;
    	ListNode temp;
    	ListNode temp2;
    	while(a != null) {
    		//find the position
    		b = newHead;
    		while(b.next != null && b.next.val <= a.val) {
    			b = b.next;
    		}
    		//insert node in sorted ll
    		temp = a;
    		a = a.next;
    		temp.next = null;
    		temp2 = b.next;
    		b.next = temp;
    		temp.next = temp2;
    	}
    	return newHead.next;
    }

}
