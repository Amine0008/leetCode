package linkedList.leetcode;

import linkedList.leetcode.PalindromeLinkedListN234.ListNode;

public class ReverseNodesInkGroupN25 {

	
    public ListNode reverseKGroup(ListNode head, int k) {
     
    	
    	int counter = 1;
    	int size = 0;
    	ListNode c = head;
    	
    	//reference to the first node outside of a group
    	ListNode ref = head;
    	while(c != null) {
    		if(counter/k != 0 && counter%k == 1 && k != 1) {
    			ref = c;
    			counter = 1;
    		}
    		c = c.next;
    		size++;
    		counter++;
    	}
      	if(k == 1 || size%k == 0)
    		ref = null;
    	c = head;
    	ListNode pv = ref;
    	ListNode temp = null;
    	while(c != ref) {
    		temp = c.next;
    		c.next = pv;
    		pv = c;
    		c = temp;
    	}
    	head = pv;
    	if(size == k)
    		return head;
    	pv = ref;
    	ListNode c1 = head;
    	ListNode c2 = null;
    	temp = null;
    	for(int i = 1; i <= size/k; i++) {
    		counter = 1;
    		c2 = c1;
    		while(counter != k) {
    			c2 = c2.next;
    			counter++;
    		}
    		temp = c2.next;
    		c2.next = pv;
    		pv = c1;
    		c1 = temp;
    	}
    	return pv;
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }

}
