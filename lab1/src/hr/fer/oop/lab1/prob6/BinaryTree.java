package hr.fer.oop.lab1.prob6;

public class BinaryTree {
	     TreeNode root;
	     public BinaryTree(){
	    	 root = new TreeNode(null);
		 }
		 public void insert(String data) {
		     if(root.data==null) {
			     root = new TreeNode(data);
			     return;
		     }
		     TreeNode x;
		     x= root;
		     while(true) {
		    	 if(x.data.compareTo(data)>0) {
		    		 if(x.left==null) {
		    			 x.left=new TreeNode(data);
		    			 break;
		    		 }
		    		 x=x.left;
		    	 }	 	
		    	 else if(x.data.compareTo(data)<0) {
		    		 if(x.right==null) {
		    			 x.right=new TreeNode(data);
		    			 break;
		    		 }
		    		 x=x.right;
		    	 }	 
		    	else
		    	   System.out.println("on vec postoji");
		     }
		  
		 }
		 private boolean subTreeContainsData2(TreeNode node, String data) {
		      if(node==null)
		    	  return false;
		    else if(node.data.equals(data))
		    	return true;
		      return subTreeContainsData2(node.left,data)||subTreeContainsData2(node.right,data);
		 }
		 public boolean containsData2(TreeNode root,String data) {
			 return subTreeContainsData2(root, data);
		 }
		 public boolean containsData(TreeNode root,String data) {
			 return subTreeContainsData(root, data);
		 }
		 private boolean subTreeContainsData(TreeNode node, String data) {
		      if(node==null)
		    	  return false;
		    else if(node.data.equals(data))
		    	return true;
		    else if(node.data.compareTo(data)>0)
		    	return subTreeContainsData(node.left,data);
		    else
		      return subTreeContainsData(node.right,data);
		 }
		 
		 private int sizeOfSubTree(TreeNode node) {
			 if(node==null)
				 return 0;
			 return 1+ sizeOfSubTree(node.left)+sizeOfSubTree(node.right);
		 }

		 public int sizeOfTree() {
			 return sizeOfSubTree(root);
		 }

		 private void writeSubTree(TreeNode node) {
			 if(node==null)
				 return;
			 writeSubTree(node.left);
			 System.out.println(node.data);
			 writeSubTree(node.right);
			 
		 }

		 public void writeTree() {
			 writeSubTree(root);
		 }
		 private void reverseSubTreeOrder(TreeNode node) {
			 if(node==null)
				 return;
			 reverseSubTreeOrder(node.left);
			 reverseSubTreeOrder(node.right);
			 TreeNode x=node.left;
			 node.left=node.right;
			 node.right=x;
			 
		 }

		 public void reverseTreeOrder() {
			 reverseSubTreeOrder(root);
		 }
		 public static void main(String[] args) {
			 BinaryTree tree = new BinaryTree();
			 tree.insert("Jasna");
			 tree.insert("Ana");
			 tree.insert("Ivana");
			 tree.insert("Anamarija");
			 tree.insert("Vesna");
			 tree.insert("Kristina");
			System.out.println("Writing tree inorder:");
			 tree.writeTree();
			 System.out.println("prije reverseTreeOrdera");
			 boolean found = tree.containsData(tree.root, "Ivana");
			System.out.println("Searched element is found: "+found);
			 tree.reverseTreeOrder();
			System.out.println("Writing reversed tree inorder:");
			tree.writeTree();
			int size = tree.sizeOfTree();
			System.out.println("Number of nodes in tree is "+size+".");
			boolean found2 = tree.containsData2(tree.root, "Ivana");
			System.out.println("Searched element is found: "+found2);
		}
}
