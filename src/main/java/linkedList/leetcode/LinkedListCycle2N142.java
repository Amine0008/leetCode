package linkedList.leetcode;

import linkedList.leetcode.PalindromeLinkedListN234.ListNode;

public class LinkedListCycle2N142 {

	
    public ListNode detectCycle(ListNode head) {
    	ListNode f = head;
    	ListNode s = head;
    	if(f == null || f.next == null || f.next.next == null)
    		return null;
    	do {
    		f = f.next.next;
    		s = s.next;
    	}while(f != s && f != null && f.next != null);
    	if(f != s)
    		return null;
    	f = head;
    	while(f != s) {
    		f = f.next;
    		s = s.next;
    	}
    	return f;
    }
    
}
