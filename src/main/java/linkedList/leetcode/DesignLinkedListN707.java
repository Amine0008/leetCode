package linkedList.leetcode;

public class DesignLinkedListN707 {
	/*
	 on Get - treat negaive index as zero if node list is empty

 	 on AddAtIndex - insert element at index zero 
	 */
	
	static class MyLinkedList {
		
		class Node {
			int val;
			Node next;
			Node(int val){this.val = val;}
		}
		
		Node head;
	   
		public MyLinkedList() {}
	    
		public void print() {
			Node cn = head;
			while(cn != null) {
				System.out.println(cn.val);
				cn = cn.next;
			}
		}
	    public int get(int index) {
	    	Node current = head;
	    	while(index > 0 && current != null) {
	    		current = current.next;
	    		index--;
	    	}
	    	if(current == null)
	    		return -1;
	    	return current.val;
	    	
	    }
	    
	    public void addAtHead(int val) {
	        Node newHead = new Node(val);
	        newHead.next = head;
	        head = newHead;
	    }
	    
	    public void addAtTail(int val) {
	    	if(head == null) 
	    		head = new Node(val);
	    	else {
		        Node runner = head;
		        while(runner.next != null) {
		        	runner = runner.next;
		        }
		        runner.next = new Node(val);
	    	}

	    }
	    
	    //index < 0 => insert at 0
	    //index > size => don't insert node
	    public void addAtIndex(int index, int val) {
	    	if(index <= 0) {
	    		Node newHead = new Node(val);
	    		newHead.next = head;
	    		head = newHead;
	    		return;
	    	}
	        Node current = head;
	        int counter = 1;
	        while(counter < index && current != null) {
	        	current = current.next;
	        	counter++;
	        }
	        if(current == null)
	        	return;
	        Node temp = current.next;
	        current.next = new Node(val);
	        current.next.next = temp;
	    }
	    
	    public void deleteAtIndex(int index) {
	    	if(index == 0) {
	    		head = head.next;
	    	}
	    	if(index < 0)
	    		return;
	        Node current = head;
	        int counter = 1;
	        while(counter < index && current != null) {
	        	current = current.next;
	        	counter++;
	        }
	        if(current == null|| current.next == null)
	        	return;
	        current.next = current.next.next;
	    }
	}

	public static void main(String[] args) {
		MyLinkedList ll = new MyLinkedList();
		ll.addAtHead(2);
		ll.print();
		System.out.println("////");
		ll.addAtIndex(0,1);
		ll.print();
		System.out.println("////");
		ll.get(1);

		ll.print();
	}
}
