package linkedList.leetcode;

import linkedList.leetcode.PalindromeLinkedListN234.ListNode;

public class DeleteDuplicatesN83 {

    public ListNode deleteDuplicates(ListNode head) {
     
    	ListNode currentNode = head;
    	ListNode dupNode;
    	int val;
    	while(currentNode != null) {
    		val = currentNode.val;
    		dupNode = currentNode.next;
    		while(dupNode != null && dupNode.val == val) {
    			dupNode = dupNode.next;
    		}
    		currentNode.next = dupNode;
    		currentNode = currentNode.next;
    	}
    	return head;
    }
}
