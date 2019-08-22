package com.murali.ds.collection;

public class BinarySearchTree {

	private Node root; 

	public BinarySearchTree() {  
		root = null;  
	}

	public void insert(int key) {
		this.root = insertRec(root, key); 
	} 

	private Node insertRec(Node root, int key) {

		if (root == null) { 
			root = new Node(key); 
			return root; 
		}

		if (key < root.data) 
			root.left = insertRec(root.left, key); 
		
		else if (key > root.data) 
			root.right = insertRec(root.right, key);

		return root; 
	} 

	public boolean contains(int id) {
		Node current = root;
		while( current != null ) {

			if( current.data == id ) {
				return true;
			} else if (current.data > id) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
	}

	public boolean delete(int id) {
		
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		
		while( current.data !=id ) {
			
			parent = current;
			if( current.data > id ) {
				isLeftChild = true;
				current = current.left;
			} else {
				isLeftChild = false;
				current = current.right;
			}
			if(current == null) {
				return false;
			}
		}
		//if i am here that means we have found the node
		//Case 1: if node to be deleted has no children
		if(current.left == null && current.right == null ) {
			
			if( current == root ) {
				root = null;
			}
			if( isLeftChild == true ) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}
		//Case 2 : if node to be deleted has only one child
		else if( current.right == null ){
			if(current == root) {
				root = current.left;
				
			} else if( isLeftChild){
				parent.left = current.left;
				
			} else {
				parent.right = current.left;
			}
		}
		
		else if( current.left == null ){
			if( current == root ){
				root = current.right;
				
			} else if(isLeftChild) {
				parent.left = current.right;
				
			} else {
				parent.right = current.right;
			}
		} 
		
		else if( current.left !=null && current.right != null) {

			//now we have found the minimum element in the right sub tree
			Node successor	 = getSuccessor(current);
			if(current==root) {
				root = successor;
				
			} else if(isLeftChild){
				parent.left = successor;
				
			} else {
				parent.right = successor;
			}			
			successor.left = current.left;
		}		
		return true;		
	}

	private Node getSuccessor(Node deleleNode) {
		Node successsor = null;
		Node successsorParent =null;
		Node current = deleleNode.right;
		
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		//check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
		//		successsorParent
		if( successsor != deleleNode.right ) {
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}

	public void print(Node root){
		if(root!=null){
			print(root.left);
			System.out.print(" " + root.data);
			print(root.right);
		}
	}

	class Node { 
		int data; 
		Node left;
		Node right; 

		public Node(int item) { 
			data = item; 
			left = right = null; 
		} 
	}
}
