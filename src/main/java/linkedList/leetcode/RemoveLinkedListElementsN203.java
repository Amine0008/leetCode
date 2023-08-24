package linkedList.leetcode;

import linkedList.leetcode.PalindromeLinkedListN234.ListNode;

public class RemoveLinkedListElementsN203 {
	
    public ListNode removeElements(ListNode head, int val) {
     // 123456, 6
    	
    	ListNode currentNode = head;
    	ListNode temp;
    	while(currentNode != null) {
    		if(currentNode.val == val) {
    			currentNode = currentNode.next;
    			head = currentNode;
    			continue;
    		}
    		temp = currentNode.next;
    		if(temp == null)
    			return head;
    		while(temp != null && temp.val == val) {
    			temp = temp.next;
    		}
    		currentNode.next = temp;
    		currentNode = temp;
    			
    	}
    	return head;
    	
    }

}
