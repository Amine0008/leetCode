package linkedList.leetcode;

import linkedList.leetcode.PalindromeLinkedListN234.ListNode;

public class SortListN148 {

	
	public static void main(String [] args) {}
	
    public ListNode sortList(ListNode head) {
    	if(head == null)
    		return null;
    	ListNode tail = head;
    	while(tail.next != null) {
    		tail = tail.next;
    	}
    	mergeSort(head, tail);
    	return head;
    }
    
    private static void mergeSort(ListNode left, ListNode right) {
    	if(left == right)
    		return;
    	if(left.next == right) {
    		int temp;
    		if(left.val > right.val) {
    			temp = left.val;
    			left.val = right.val;
    			right.val = temp;
    		}
    		return;
    	}
    	//get mid node
    	ListNode fast = left;
    	ListNode mid = left;
    	while(fast != right && fast != right.next) {
    		fast = fast.next.next;
    		mid = mid.next;
    	}
    	mergeSort(left, mid);
    	mergeSort(mid.next,right);
    	merge(left,mid,right);
    }
    
    private static void merge(ListNode left, ListNode mid, ListNode right) {
    	ListNode sl1 = null;
    	ListNode sl1Head = null;
    	
    	ListNode sl2 = null;
    	ListNode sl2Head = null;
    	boolean passedMid = false;
    	ListNode runner = left;
    	while(runner != right.next) {
    		if(passedMid) {
    			if(sl2 == null){
    				sl2 = new ListNode(runner.val);
    				sl2Head = sl2;
    			}else {
    				sl2.next = new ListNode(runner.val);
    				sl2 = sl2.next;
    			}
    		}
    		else {
    			if(sl1 == null) {
    				sl1 = new ListNode(runner.val);
    				sl1Head = sl1;
    			}else {
    				sl1.next = new ListNode(runner.val);
    				sl1 = sl1.next;
    			}
    		}
    		runner = runner.next;
    		if(runner == mid.next)
    			passedMid = true;
    	}
    	
    	runner = left;
    	sl1 = sl1Head;
    	sl2 = sl2Head;
    	
    	while(sl1 != null && sl2 != null) {
    		if(sl1.val < sl2.val) {
    			runner.val = sl1.val;
    			sl1 = sl1.next;
    		}
    		else {
    			runner.val = sl2.val;
    			sl2 = sl2.next;
    		}
    		runner = runner.next;
    	}
    	
    	while(sl1 != null) {
    		runner.val = sl1.val;
    		runner = runner.next;
    		sl1 = sl1.next;
    	}
    	while(sl2 != null) {
    		runner.val = sl2.val;
    		runner = runner.next;
    		sl2 = sl2.next;
    	}
    	sl1Head = null;
    	sl2Head = null;
    	
    	
    }


}
