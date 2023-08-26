package linkedList.leetcode;

import linkedList.leetcode.PalindromeLinkedListN234.ListNode;

public class MaximumTwinSumOfALinkedListN2130 {

	public int pairSum(ListNode head) {
		int maxTwinSum = Integer.MIN_VALUE;
		//getting mid node
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast!= null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode mid = slow.next;
		slow.next = null;
		//reversing from mid node
		ListNode cn = mid;
		ListNode pn = null;
		ListNode temp;
		while(cn != null) {
			temp = cn.next;
			cn.next = pn;
			pn = cn;
			cn = temp;
		}
		//traversing both lists to get maxTwinSum
		temp = head;
		while(pn != null && temp != null) {
			if(pn.val+temp.val > maxTwinSum)
				maxTwinSum = pn.val+temp.val;
			pn = pn.next;
			temp = temp.next;
		}
		return maxTwinSum;
	}
}
