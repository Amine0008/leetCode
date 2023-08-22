package linkedList.implementation;


public class SinglyLinkedList {

	public static void main(String[] args) {
		SinglyLinkedList ll = new SinglyLinkedList(0);
		ll.insertInLinkedList("Node1", 0);
		ll.insertInLinkedList("Node2", 1);
		ll.insertInLinkedList("Node3", 2);
		System.out.println(ll.toString());
		System.out.println(
		ll.deleteNodeAtLocation(1));
		System.out.println(ll.toString());
		
	}
	
	class Node {
		Node next;
		String value = "value:empty";
		public Node(String value) {
			this.value = value;
		}
		public Node() {}
		public String toString() {return value;};
	}
	
	Node head;
	Node tail;
	long size;
	
	public SinglyLinkedList(long initialSize) {
		for(int i = 1; i<=initialSize; i++) {
			if(this.size == 0) {
				head = new Node();
				tail = head;
				size++;
			}
			else {
				tail.next = new Node();
				tail = tail.next;	
				size++;	
			}
			
		}
	}
	
	@Override
	public String toString() {
			
		return printSubChainList(head);
	}
	
	private String printSubChainList(Node node) {
		if(node == null)
			return "";
		else
			return node.value +" -> " + printSubChainList(node.next);
	}
	
	
	public void insertInLinkedList(String value, long location) {
		if( location < 0 || location > size)
			return;
		Node node = new Node(value);
		if(location == 0) {
			node.next = head;
			head = node;
		}
		else {
			Node nodeBeforeLocation = head;
			for(int i = 1; i < location; i++) {
				nodeBeforeLocation = nodeBeforeLocation.next;
			}
			node.next  = nodeBeforeLocation.next;
			nodeBeforeLocation.next = node;
		}
		
		//update tail
		
		Node lastNode = head;
		while(true) {
			if(lastNode.next == null)
				break;
			lastNode = lastNode.next;
		}
		tail = lastNode;
		size++;
		
	}
	
	public Node searchByValue(String value) {
		Node currentNode = head;
		while(true) {
			if(currentNode == null)
				return null;
			if(currentNode.value.equals(value))
				return currentNode;
			currentNode = currentNode.next;
		}
	}
	public Node searchByValueV2(String value) {
		return searchNodeByValue(head, value);
	}
	
	private Node searchNodeByValue(Node node, String value) {
		if(node == null)
			return null;
		if(node.value.equals(value))
			return node;
		else
			return searchNodeByValue(node.next, value);
	}
	
	
	public Node deleteNodeAtLocation(int location) {
		System.out.println("deleting node at location: "+location);
		if(location<0 || location>size-1)
			return null;
		Node result = head;
		if(location == 0) {
			head = head.next;
			return result;
		}
			
		Node nodeBeforeLocation = head;
		int counter = 1;
		while(counter < location) {
			nodeBeforeLocation = nodeBeforeLocation.next;
			counter++;
		}
				
		result = nodeBeforeLocation.next;
		nodeBeforeLocation.next = nodeBeforeLocation.next.next;
		if(location == size-1)
			tail = nodeBeforeLocation;
		return result;
	}
	

	
	
	
	
	
	
	
	

}
