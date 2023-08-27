package linkedList.leetcode;

import linkedList.leetcode.PalindromeLinkedListN234.ListNode;

public class SwappingNodesInaLinkedListN1721 {
	
    public ListNode swapNodes(ListNode head, int k) {
        ListNode kend = head;
        ListNode kstart = head;
        ListNode f = head;
        int counter = k;
        while(counter > 0) {
        	f = f.next;
        	counter--;
        }
        while(f != null) {
        	f = f.next;
        	kend = kend.next;
        }
        counter = k;
        while(counter > 1) {
        	kstart = kstart.next;
        	counter--;
        }
        int temp;
        temp = kstart.val;
        kstart.val = kend.val;
        kend.val = temp;
        return head;
    }
}














