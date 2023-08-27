package linkedList.leetcode;

public class CopyListWithRandomPointerN138 {
	class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}

	//not accepted because it modifies the original nodes
    public Node copyRandomListV1(Node head) {
        Node copyHead = null;
        Node runner = head;
        Node copy;
        while(runner != null) {
        	copy = new Node(runner.val);
        	copy.random = runner.random;
        	runner.random = copy;
        	if(runner == head)
        		copyHead = copy;
        	runner = runner.next;
        }
        runner = copyHead;
        Node ogRunner = head;
        while(runner != null && ogRunner != null) {
        	if(runner.random != null) {
        		runner.random = runner.random.random;
        	}
        	runner = runner.next;
        }
        return copyHead;
    }
    
    public Node copyRandomList(Node head) {
    	Node runner = head;
    	Node copy = null;
    	Node temp;
    	while(runner != null) {
    		copy = new Node(runner.val);
    		temp = runner.next;
    		runner.next = copy;
    		copy.next = temp;
    		
    		runner = temp;
    	}
    	runner = head;
    	while(runner != null) {
    		if(runner.random != null)
    			runner.next.random = runner.random.next;
    		else
    			runner.next.random = null;
    		runner = runner.next.next;
    	}
    	runner = head;
    	
    	while(runner != null) {
    		if(runner == head)
    			copy = runner.next;
    		temp = runner.next;
    		runner.next = runner.next.next;
    		if(runner.next != null)
    			temp.next = runner.next.next;
    		else
    			temp.next = null;
    		runner = runner.next;
    	}

    	return copy;
    }
    
    
    
    
    
    

}
