package linkedList.leetcode;

import linkedList.leetcode.PalindromeLinkedListN234.ListNode;

public class RotateListN61 {
	
    public ListNode rotateRight(ListNode head, int k) {
    	if(head == null || head.next == null)
    		return head;
    	int counter = 1;
    	ListNode l = head;
    	ListNode r = head;
    	ListNode current =  head;
    	int size = 0;
    	while(current != null) {
    		current = current.next;
    		size++;
    	}
    	//real rotations
    	int rr = k % size;
		if(rr == 0)
			return head;
    	while(counter < rr+1) {
    		r = r.next;
    		counter++;
    	}
    	while(r != null && r.next != null) {
    		r = r.next;
    		l = l.next;
    	}
    	ListNode newHead = l.next;
    	l.next = null;
    	r.next = head;
    	return newHead;
    }

}
