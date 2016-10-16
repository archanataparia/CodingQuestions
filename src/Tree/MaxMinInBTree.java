package Tree;

public class MaxMinInBTree {

	public static void main(String[] args) {
		Tree tree=new Tree();
		tree.insert(50);
		tree.insert(25);
		tree.insert(75);
		tree.insert(37);
		tree.insert(43);
		tree.insert(30);
		//display tree
		tree.displayTree();
		int max=findMax(tree.root);
		int min=findMin(tree.root);
		System.out.println("Maximum value is "+max+" minimum value is "+min);
	}

	private static int findMax(Node root) {
		if(root==null) return Integer.MIN_VALUE;

	    // Return maximum of 3 values: 1) Root's data 2) Max in Left Subtree 3) Max in right subtree
		int max=root.data;
		int lmax=findMax(root.left);
		int rmax=findMax(root.right);
		if(lmax> max)
			max=lmax;
		if(rmax>max)
			max=rmax;
		return max;
	}

	private static int findMin(Node root) {
		if(root==null) return Integer.MIN_VALUE;
		int min=root.data;
		if(root.left!=null)
		{
			min=Math.min(min, findMin(root.left));
		}
		if(root.right!=null)
		{
			min=Math.min(min, findMin(root.right));
		}
		return min;
	}

}
