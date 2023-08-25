package linkedList.leetcode;

import linkedList.leetcode.PalindromeLinkedListN234.ListNode;

public class IntersectionOfTwoLinkedListsN160 {
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	int sizeA = 0;
    	int sizeB = 0;
    	ListNode nodeA = headA;
    	ListNode nodeB = headB;
    	
    	while(nodeA !=null || nodeB != null) {
    		if(nodeA != null) {
    			sizeA++;
    			nodeA = nodeA.next;
    		}
    		if(nodeB != null) {
    			sizeB++;
    			nodeB = nodeB.next; 
    		}
    	}
    	ListNode mainListHead;
    	ListNode secondListHead;
    	int mainListSize;
    	int secondListSize;
    	if(sizeA >= sizeB) {
    		mainListHead = headA;
    		secondListHead = headB;
    		mainListSize = sizeA;
    		secondListSize = sizeB;
    	}
    	else {
    		mainListHead = headB;
    		secondListHead = headA;
    		mainListSize = sizeB;
    		secondListSize = sizeA;
    	}
    	//pii : potential intersection index
    	int pii = mainListSize-secondListSize;
    	ListNode piNode = mainListHead;
    	while(pii > 0) {
    		piNode = piNode.next;
    		pii--;
    	}
    	ListNode node = secondListHead;
    	for(int i = secondListSize; i>=1; i--) {
    		if(piNode == node)
    			return piNode;
    		node = node.next;
    		piNode = piNode.next;
    	}
    	return null;
    	
    	
    	
    }

}
