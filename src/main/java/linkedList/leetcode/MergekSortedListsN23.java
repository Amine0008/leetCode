package linkedList.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

import linkedList.leetcode.PalindromeLinkedListN234.ListNode;

public class MergekSortedListsN23 {

	
    public ListNode mergeKLists(ListNode[] lists) {
    	if(lists.length == 0)
    		return null;
    	if(lists.length == 1)
    		return lists[0];
    	
    	Deque<ListNode> q = new ArrayDeque<>();
    	for(ListNode l: lists) {
    		if(l != null)
    			q.add(l);
    	}
    	while(q.size() >= 2) {
    		q.add(mergeTwoLists(q.remove(),q.remove()));
    	}
    	return q.poll();
    }
    
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
    	ListNode c1 = head1;
    	ListNode c2 = head2;
    	ListNode newHead = null;
    	ListNode c = null;
    	while(c1 != null && c2 != null) {
    		if(c1.val <= c2.val) {
    			if(newHead == null) {
    				newHead = c1;
    				c = c1;
    				c1 = c1.next;
    			}
    			else {
    				c.next = c1;
    				c1 = c1.next;
    				c = c.next;
    			}
    		}
    		else {
    			if(newHead == null) {
    				newHead = c2;
    				c = c2;
    				c2 = c2.next;
    			}
    			else {
    				c.next = c2;
    				c2 = c2.next;
    				c = c.next;
    			}
    		}
    	}
    	if(c2 != null)
    		c.next = c2;
    	if(c1 != null)
    		c.next = c1;
    	return newHead;
    }
    
    
}
