package linkedList.leetcode;

public class DesignCircularQueueN622 {

	static class Node{
		int val;
		Node next;
		Node(int val){
			this.val = val;
		}
	}
	static class MyCircularQueue {
		Node front;
		Node rear;
		int size;
		int capacity;
	    public MyCircularQueue(int k) {
	        this.capacity = k;
	        size = 0;
	    }
	    
	    public boolean enQueue(int value) {
	    	if(size == capacity)
	    		return false;
	    	if(rear == null) {
	    		rear = new Node(value);
	    		front = rear;
	    	}
	    	else {
	    		rear.next = new Node(value);
	    		rear = rear.next;
	    	}
	    	size++;
	    	return true;
	    }
	    
	    public boolean deQueue() {
	        if(size == 0)
	        	return false;
	        front = front.next;
	        size--;
	        if(size == 0)
	        	rear = rear.next;
	        return true;
	    }
	    
	    public int Front() {
	        if(front == null)
	        	return -1;
	        return front.val;
	    }
	    
	    public int Rear() {
	        if(rear == null)
	        	return -1;
	        return rear.val;
	    }
	    
	    public boolean isEmpty() {
	        return size == 0;
	    }
	    
	    public boolean isFull() {
	        return size == capacity;
	    }
	}


}
