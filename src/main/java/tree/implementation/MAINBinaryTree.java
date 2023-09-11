package tree.implementation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class MAINBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode("10");
		root.left = new TreeNode("5");
		root.left.left = new TreeNode("4");
		root.left.right = new TreeNode("7");
		
		root.right = new TreeNode("20");
		root.right.left = new TreeNode("15");
		root.right.right = new TreeNode("21");
		////////////////////////////////////////
		inOrderTraversalIterative2(root);
	}
	


	public static void deleteFromTree(TreeNode root, TreeNode node) {
		deleteNode(null, root, node);
	}
	private static void deleteNode(TreeNode parent, TreeNode current, TreeNode nodeToDelete) {
		if(current == null)
			return;
		if(current == nodeToDelete) {
			if(current.right == null && current.left == null) {
				if(parent == null)
					return;
				if(parent.right == current)
					parent.right =  null;
				else
					parent.left = null;
				return;
			}
			else {
				if(current.left != null) {
					current.data = current.left.data;
					deleteNode(current, current.left, current.left);
					return;
				}
				else {
					current.data = current.right.data;
					deleteNode(current, current.right, current.right);
					return;
				}
			}
		}
		deleteNode(current, current.left, nodeToDelete);
		deleteNode(current, current.right, nodeToDelete);
		
			
	}

	public static void preOrderTraversal(TreeNode node) {
		if(node == null)
			return;
		System.out.println(node.data);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}
	public static void preOrderTraversal2(TreeNode node, StringBuilder s) {
		if(node == null)
			return ;
		s.append("\n"+node.data) ;
		preOrderTraversal2(node.left, s);
		preOrderTraversal2(node.right, s);
	}
	public static void traverseIteratevly(TreeNode node) {
		if(node == null)
			return;
		Stack<TreeNode> nodeStack = new Stack<>();
		nodeStack.add(node);
		StringBuilder result = new StringBuilder();
		TreeNode currentNode = null;
		while(!nodeStack.isEmpty()) {
			currentNode = nodeStack.pop();
			result.append("\n");
			result.append(currentNode.data);
			if(currentNode.right != null)
				nodeStack.add(currentNode.right);
			if(currentNode.left != null)
				nodeStack.add(currentNode.left);
		}
		System.out.println(result.toString());
	}
	private static void inOrderTraversal(TreeNode node) {
		if(node == null)
			return;
		inOrderTraversal(node.left);
		System.out.print(" "+node.data);
		inOrderTraversal(node.right);
	}
	private static void postOrderTraversal(TreeNode node) {
		if(node == null)
			return;
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(" "+ node.data);
	}
	public static void levelOrderTraversal(TreeNode node) {
		if(node == null)
			return;
		Queue<TreeNode> nodesQueue = new LinkedList<>();
		nodesQueue.add(node);
		TreeNode current = null;
		while(!nodesQueue.isEmpty()) {
			current = nodesQueue.remove();
			if(current != null) {
				System.out.print(" "+current.data);
				nodesQueue.add(current.left);
				nodesQueue.add(current.right);
			}
		}
	}
	
	public static TreeNode search(TreeNode node, String data) {
		if(node == null)
			return null;
		if(node.data == data)
			return node;
		TreeNode foundNode =  search(node.left, data);
		if(foundNode != null)
			return foundNode;
		foundNode = search(node.right, data);
		if(foundNode != null)
			return foundNode;
		return null;
	}
	public static TreeNode searchIteratevly(TreeNode node, String data) {
		if(node == null)
			return null;
		Stack<TreeNode> stack = new Stack<>();
		stack.add(node);
		TreeNode current = null;
		while(!stack.isEmpty()) {
			current = stack.pop();
			if(current.data == data)
				return current;
			if(current.right != null)
				stack.add(current.right);
			if(current.left != null)
				stack.add(current.left);
		}
		return null;
	}
	public static TreeNode levelOrderSearch(TreeNode root, String val) {
		Queue<TreeNode> nodesQueue = new LinkedList<>();
		nodesQueue.add(root);
		TreeNode current = null;
		while(!nodesQueue.isEmpty()) {
			current = nodesQueue.remove();
			if(current.data == val)
				return current;
			if(current.left != null)
				nodesQueue.add(current.left);
			if(current.right != null)
				nodesQueue.add(current.right);
		}
		return null;
	}

	public static TreeNode insert(TreeNode root, String val) {
		if(root == null)
			return new TreeNode(val);
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		TreeNode current = null;
		while(!q.isEmpty()) {
			current = q.remove();
			if(current.left == null) {
				current.left = new TreeNode(val);
				break;
			}
			if(current.right == null) {
				current.right = new TreeNode(val);
				break;
			}
			q.add(current.left);
			q.add(current.right);
		}
		return root;
	}
	
	public static void inOrderTraversalIterative(TreeNode node) {
		if(node == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		Set<TreeNode> set = new HashSet<>();
		stack.add(node);
		TreeNode c = null;
		while(!stack.isEmpty()) {
			c = stack.pop();
			if(c.left != null) {
				if(set.contains(c.left)) {
					System.out.print(" "+ c.data);
					set.add(c);
					if(c.right != null)
						stack.add(c.right);
				}
				else {
					stack.add(c);
					stack.add(c.left);
				}
			}
			else {
				set.add(c);
				System.out.print(" "+c.data);
			}
		}
	}
	
	
	public static void inOrderTraversalIterative2(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode c = root;
		
		while(c != null || !stack.isEmpty()) {
			while(c != null) {
				stack.add(c);
				c = c.left;
			}
			c = stack.pop();
			System.out.print(" "+c.data);
			c = c.right;
			
		}
	}















}
