package linkedList.leetcode;

import linkedList.leetcode.PalindromeLinkedListN234.ListNode;

public class ReorderListN143 {
	
    public void reorderList(ListNode head) {
    	ListNode slowRunner = head;
    	ListNode fastRunner = head;
    	while(fastRunner != null && fastRunner.next != null) {
    		fastRunner = fastRunner.next.next;
    		slowRunner = slowRunner.next;
    	}
    	ListNode runnerB = reverse(slowRunner);
    	ListNode runnerA = head;
    	ListNode temp = null;
    	ListNode tail = head;
    	
    	while(runnerA != null && runnerB != null) {
    		if(runnerA == runnerB) {
    			tail.next = runnerA;
    			return;
    		}
    		if(tail == head) {
    			temp = head.next;
    			tail.next = runnerB;
    		}
    		else {
    			tail.next = runnerA;
    			temp = runnerA.next;
    			runnerA.next = runnerB;
    		}
			runnerA = temp;
			tail = runnerB;
			runnerB = runnerB.next;
    	}
    
    }
    
    private ListNode reverse(ListNode head) {
    	ListNode temp;
    	ListNode cn = head;
    	ListNode pn = null;
    	while(cn != null) {
    		temp = cn.next;
    		cn.next = pn;
    		pn = cn;
    		cn = temp;
    	}
    	return pn;
    }

}
