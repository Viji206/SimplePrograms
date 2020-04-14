package util;


public class BinaryTree {
	
	TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	public void inorderTraversal(TreeNode node){
		
		
		if(node == null){
			return;
		}
		
		//Traverse through left
		inorderTraversal(node.getLeft());
		
		System.out.print(node.getName());
		
		//Traverse through right		
		inorderTraversal(node.getRight());
	}

	public void preorderTraversal(TreeNode node){
		
		
		if(node == null){
			return;
		}
		

		System.out.print(node.getName());
		
		//Traverse through left
		preorderTraversal(node.getLeft());		
		
		//Traverse through right		
		preorderTraversal(node.getRight());
	}

	public void postorderTraversal(TreeNode node){
	
	
	if(node == null){
		return;
	}
	
	//Traverse through left
	postorderTraversal(node.getLeft());
	
	//Traverse through right		
	postorderTraversal(node.getRight());
	
	System.out.print(node.getName());
	
}
}
