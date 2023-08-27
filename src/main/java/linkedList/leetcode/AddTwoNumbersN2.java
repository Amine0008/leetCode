package linkedList.leetcode;

public class AddTwoNumbersN2 {
	  public class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int runnerAVal = l1.val;
        int runnerBVal = l2.val;
        ListNode runnerA = l1;
        ListNode runnerB = l2;
        
        ListNode resultHead = null;
        ListNode runnerC = new ListNode();
        
        int temp = 0;
        while(runnerA != null || runnerB != null || temp > 0) {
        	if(runnerA != null)
        		runnerAVal = runnerA.val;
        	else
        		runnerAVal = 0; 
        	if(runnerB != null)
        		runnerBVal = runnerB.val;
        	else
        		runnerBVal = 0;
        	if(temp+runnerAVal+runnerBVal/10 > 0) {
        		runnerC.next = new ListNode((temp + runnerAVal + runnerBVal)%10);
        		temp = (temp + runnerAVal + runnerBVal)/10;
        	}
        	else {
        		temp =0;
        		runnerC.next = new ListNode(temp + runnerAVal + runnerBVal);
        	}
        	if(runnerA == l1 && runnerB == l2)
        		resultHead = runnerC.next;
        	runnerC = runnerC.next;
        	if(runnerA != null )
        		runnerA = runnerA.next;
        	if(runnerB != null)
        		runnerB = runnerB.next;
        	
        }
        return resultHead;
        
    }

}
