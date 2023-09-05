package tree.implementation;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	public static void main(String[] args) {
/*		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(70);
		Node n50 = bst.insert(50);
		bst.insert(90);
		bst.insert(30);
		bst.insert(60);
		bst.insert(80);
		bst.insert(100);
		bst.insert(20);
		bst.insert(40);
		bst.insert(55);
*/
		BinarySearchTree bst = new BinarySearchTree();
		Node n50  = bst.insert(50);
		Node n100 = bst.insert(100);
		Node n60 = bst.insert(60);
		
		System.out.println(bst.getTreeStructureType(null,n100,70));

	}
	
	static class Node{
		int value;
		Node left;
		Node right;
		int height;
		Node(int value){this.value = value;this.height = 0;}
		}
	Node root;
	BinarySearchTree(){this.root = null;}

	
	public Node insert(int value) {
		if(this.root == null) {
			this.root = new Node(value);
			return this.root;
		}
		return this.inserting(root,value);
	}
	private Node inserting(Node node, int value) {
		if(node.value == value)
			return node;
		node.height = node.height + 1;
		if(value > node.value) {
			if(node.right == null) {
				node.right = new Node(value);
				return node.right;
			}
			return inserting(node.right, value);
		}else {
			if(node.left == null) {
				node.left = new Node(value);
				return node.left;
			}
			return inserting(node.left, value);
		}
	}

	public void levelOrderTraversal() {
		if(root == null)
			return;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		Node c = null;
		while(!q.isEmpty()) {
			c = q.remove();
			System.out.println(" "+c.value);
			if(c.left != null)
				q.add(c.left);
			if(c.right != null)
				q.add(c.right);
		}
		
		
		
		
	}
	
	public void preOrderTraversal() {
		preOrderTraversing(root);
	}
	private void preOrderTraversing(Node node) {
		if(node == null)
			return;
		System.out.print(" "+node.value);
		preOrderTraversing(node.left);
		preOrderTraversing(node.right);
	}

	public void inOrderTraversal() {
		inOrderTraversing(root);
	}
	private void inOrderTraversing(Node node) {
		if(node == null)
			return;
		inOrderTraversing(node.left);
		System.out.print(" " + node.value);
		inOrderTraversing(node.right);
	}
	
	public void postOrderTraversal() {
		postOrderTraversing(root);
	}
	private void postOrderTraversing(Node node) {
		if(node == null)
			return;
		postOrderTraversing(node.left);
		postOrderTraversing(node.right);
		System.out.print(" " + node.value);
	}
	
	public Node search(int value) {
		return searching(root, value);
	}
	private Node searching(Node node, int value) {
		if(node == null)
			return null;
		if(node.value == value)
			return node;
		if(value > node.value)
			return searching(node.right, value);
		return searching(node.left, value);
	}
	
	
	private Node findBiggestInSubTree(Node node) {
		if(node == null)
			return null;
		while(node.right != null) {
			node = node.right;
		}
		return node;
	}
	private Node findSmallestInSubTree(Node node) {
		if(node == null)
			return null;
		while(node.left != null){
			node = node.left;
		}
		return node;
	}
	private void prune(int leafNodeValue) {
		pruneSearch(null, root,leafNodeValue);
	}
	private void pruneSearch(Node parent,Node node ,int value) {
		if(node.value == value) {
			if(parent.left != null && parent.left.value == value)
				parent.left = null;
			else
				parent.right = null;
			return;
		}
		if(node.value > value)
			pruneSearch(node, node.left, value);
		else
			pruneSearch(node, node.right, value);
	}

	private void deleteNode(Node ntd) {
		if(ntd.left == null && ntd.right == null)
			prune(ntd.value);
		else if(ntd.left != null) {
			Node bn = findBiggestInSubTree(ntd.left);
			ntd.value = bn.value;
			deleteNode(bn);
		}
		else {
			Node sn = findSmallestInSubTree(ntd.right);
			ntd.value = sn.value;
			deleteNode(sn);
		}
	}
	public void delete(int value) {
		deleteNode(search(value));
	}
	

	public void rightRotation(Node parent, Node node) {
		if(parent == null) {
			root = node.left;
			node.left = root.right;
			root.right = node;
		}
		else if(parent.left != null && parent.left == node) {
			parent.left = node.left;
			node.left = node.left.right;
			parent.left.right = node;
		}
		else {
			parent.right = node.left;
			node.left = node.left.right;
			parent.right.right = node;
		}
	}
	public void leftRotation(Node parent, Node node) {
		if(parent == null) {
			root = node.right;
			node.right = node.left;
			root.left = node;
		}
		else if(parent.left != null && parent.left == node) {
			parent.left = node.right;
			node.right = parent.left.left;
			parent.left.left = node;
		}
		else {
			parent.right = node.right;
			node.right = parent.right.left;
			parent.right.left = node;
		}
	}
	
	
	private String getTreeStructureType(Node parent,Node node,int value) {
		Queue<Character> type = new LinkedList<>();
		findStructureType(type,parent, node, value);
		if(type.size() == 3)
			type.remove();
		return ""+type.remove()+type.remove();
	}
	private void findStructureType(Queue<Character> q, Node parent, Node node, int value){

		if(node == null) {
			if(value > parent.value) {
				parent.right = new Node(value);
				q.add('R');
			}
				
			else {
				parent.left = new Node(value);
				q.add('L');
			}
			return;
		}
		else {
			if(node.value > value)
				findStructureType(q, node, node.left, value);
			else
				findStructureType(q, node, node.right, value);
		}
		if(q.size() != 0) {
			if(q.size() == 3)
				q.remove();
			if(parent == null)
				return;
			if(parent.left != null && parent.left == node)
				q.add('L');
			else
				q.add('R');
		}
	}

	public void balancedInsertion(int value) {
		LinkedList<Character> directionsQ = new LinkedList<>();
		balancedInserting(directionsQ, null, root, value);
	}
	
	private void balancedInserting(LinkedList<Character> directionsQ, Node parent, Node node, int value) {
		if(node == null) {
			if(parent.value > value) {
				parent.left = new Node(value);
				directionsQ.addFirst('L');
			}
			else if(parent.value < value) {
				parent.right = new Node(value);
				directionsQ.addFirst('R');
			}
			parent.height = parent.height + 1;
			return;
		}
		else {
			if(node.value > value)
				balancedInserting(directionsQ, node, node.left, value);
			else
				balancedInserting(directionsQ, node, node.right, value);
		}
		if(directionsQ.size() != 0 && parent != null) {
			if(directionsQ.size() == 3)
				directionsQ.removeLast();
			if(parent.left == node)
				directionsQ.add('L');
			else
				directionsQ.add('R');
		}
		if(!nodeIsBalanced(node)) {
			
		}
	}
	private boolean nodeIsBalanced(Node node) {
		if(node.left != null && node.right != null)
			return Math.abs(node.left.height - node.right.height) < 2;
		if(node.height == 0)
			return true;
		if(node.left != null)
			return node.left.height +1 < 2 ;
		else 
			return node.right.height +1 < 2 ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
