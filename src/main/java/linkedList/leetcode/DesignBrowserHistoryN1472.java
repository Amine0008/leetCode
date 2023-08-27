package linkedList.leetcode;

public class DesignBrowserHistoryN1472 {
	
	class BrowserHistory {
		
		class Node{
			String val;
			Node next;
			Node(String val){ this.val = val; }
			Node(){}
		}

		Node head;
		Node current;
	    public BrowserHistory(String homepage) {
	    	head = new Node(homepage);
	    	current = head;
	    }
	    
	    public void visit(String url) {
	    	current.next = new Node(url);
	    	current = current.next;
	    }
	    
	    public String back(int steps) {
	    	Node l = head;
	    	Node r = head;
	    	while(steps > 0 && r != current) {
	    		r = r.next;
	    		steps--;
	    	}
	    	while(r != current) {
	    		r = r.next;
	    		l = l.next;
	    	}
	    	current = l;
	    	return current.val;
	    	
	    }
	    
	    public String forward(int steps) {
	        while(steps > 0 && current.next != null) {
	        	current = current.next;
	        	steps--;
	        }
	        return current.val;
	    }
	}

}
