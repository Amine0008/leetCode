package linkedList.leetcode;

public class ReverseLinkedListN206 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public ListNode reverseListV1(ListNode head) {
		if(head == null)
			return null;
		ListNode secondNode = head.next;
		head.next = null;
		return reverseOrder(head, head, secondNode);
	}
	private ListNode reverseOrder(ListNode head, ListNode fNode, ListNode sNode) {
		if(sNode == null) {
			return fNode;
		}
		ListNode newHead = reverseOrder(head,sNode, sNode.next);
		sNode.next = fNode;
		return newHead;
		
	}
	
	public ListNode reverseListV2(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode fn = head;
		ListNode  sn = head.next;
		ListNode tn = sn.next;
		ListNode newHead = null;
		while(true) {
			if(head == fn)
				head.next = null;
			sn.next = fn;
			if(tn == null){
				newHead = sn;
				break;
			}
			fn = sn;
			sn = tn;
			tn = sn.next;
		}
		
		return newHead;
	}
	
	
}
