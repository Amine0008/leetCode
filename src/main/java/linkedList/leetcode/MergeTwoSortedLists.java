package linkedList.leetcode;

public class MergeTwoSortedLists {

	
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
	 	
	
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
     ListNode cn1 = list1;
     ListNode cn2 = list2;
     
     ListNode resultHead = new ListNode();
     ListNode cn3 = resultHead;
     
     while(cn1 != null && cn2 != null) {
    	 if(cn1.val <= cn2.val) {
    		 cn3.next = new ListNode(cn1.val);
    		 cn1 = cn1.next;
    	 }
    	 else {
    		 cn3.next = new ListNode(cn2.val);
    		 cn2 = cn2.next;
    	 }
    	 cn3 = cn3.next;
     }
     if(cn1 != null)
    	 cn3.next = cn1;
     else if(cn2 != null)
    	 cn3.next = cn2;
    	 
     return resultHead.next;
	  
    }
	
}
