package linkedList.leetcode;

import linkedList.leetcode.PalindromeLinkedListN234.ListNode;

public class RemoveNthNodeFromEndOfListN19 {

	
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode runner = head;
        while(runner!= null) {
        	size++;
        	runner = runner.next;
        }
        if(size-n == 0)
        	return head.next;
        
        runner = head;
        for(int i = 0; i < size-n-1; i++) {
        	runner = runner.next;
        }
        runner.next = runner.next.next;
        return head;
    }
    
    public ListNode removeNthFromEndV2(ListNode head, int n) {
    	ListNode l = head;
    	ListNode r = head;
    	while(n>0) {
    		r = r.next;
    		n--;
    	}
    	while(r != null && r.next != null) {
    		r =r.next;
    		l = l.next;
    	}
    	if(l==head && r == null)
    		return head.next;
    	l.next = l.next.next;
    	return head;
    }
    
    
    
    
    
    
    
    
}
