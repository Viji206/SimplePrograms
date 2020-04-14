package main;

import util.BinaryTree;
import util.TreeNode;

public class TreeTraversal {
	
	
	
	public static void main(String args[]){
		
		BinaryTree tree = new BinaryTree();
		
		tree.setRoot(new TreeNode("1"));		
		tree.getRoot().setLeft(new TreeNode("2"));
		tree.getRoot().setRight(new TreeNode("3"));
		
		tree.getRoot().getLeft().setLeft(new TreeNode("4"));
		tree.getRoot().getLeft().setRight(new TreeNode("5"));	
	
		System.out.println();
		tree.inorderTraversal(tree.getRoot());
		System.out.println();
		tree.preorderTraversal(tree.getRoot());
		System.out.println();
		tree.postorderTraversal(tree.getRoot());
	}
	

}
