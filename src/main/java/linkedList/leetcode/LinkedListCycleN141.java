package linkedList.leetcode;

import java.util.HashSet;

import linkedList.leetcode.PalindromeLinkedListN234.ListNode;

public class LinkedListCycleN141 {

	
    public boolean hasCycleV1(ListNode head) {
     HashSet<ListNode> nodeSet = new HashSet<>();
     
     ListNode runner = head;
     
     while(runner != null) {
    	 if(nodeSet.contains(runner))
    		 return true;
    	 nodeSet.add(runner);
    	 runner = runner.next;
     }
     return false;
    }
    
    public boolean hasCycleV2(ListNode head) {
    	//O(1) space
    	ListNode slow = head;
    	ListNode fast = head.next;
    	while(fast != null && fast.next != null) {
    		if(fast == slow)
    			return true;
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	return false;
    }
}
