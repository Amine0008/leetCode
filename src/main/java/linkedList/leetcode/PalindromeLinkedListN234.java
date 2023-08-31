package linkedList.leetcode;

public class PalindromeLinkedListN234 {
	
	public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
	public boolean isPalindrome(ListNode head) {
		StringBuilder lrVal = new StringBuilder();
		StringBuilder rlVal = new StringBuilder();
		lrVal = getListValue(head);
		rlVal =  getListValue(reverseSinglyLinkedList(head));
		return lrVal.equals(rlVal);
	}
	private StringBuilder getListValue(ListNode head) {
		StringBuilder val = new StringBuilder();
		while(head != null) {
			val.append(head.val);
			head = head.next;
		}
		return val;
	}
	private ListNode reverseSinglyLinkedList(ListNode head) {
		ListNode pn = null;
		ListNode cn = head;
		ListNode nn = null;
		while(cn != null) {
			nn = cn.next;
			cn.next = pn;
			pn = cn;
			cn = nn;
		}
		return pn;
	}

    
    public boolean isPalindromeV2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
        }
        ListNode nHead = reverseList(slow);
        ListNode current = head;
        while(nHead != null && current!= null) {
        	if(nHead.val != current.val)
        		return false;
        	nHead = nHead.next;
        	current = current.next;
        }
        return true;
    }
    
    private ListNode reverseList(ListNode head) {
    	ListNode pn = null;
    	ListNode cn = head;
    	ListNode nn = null;
    	while(cn != null) {
    		nn = cn.next;
    		cn.next = pn;
    		pn= cn;
    		cn = nn;
    	}
    	return pn;
    }
    
}
