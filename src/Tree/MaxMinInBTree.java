package Tree;

import java.util.LinkedList;
import java.util.Queue;

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
		//int max=findMaxRec(tree.root);
		int max=findMax(tree.root);
		int min=findMin(tree.root);
		System.out.println("Maximum value is "+max+" minimum value is "+min);
	}
	// without recursion
	private static int findMax(Node root) {
		Queue<Node> queue=new LinkedList<Node>();
		int max=Integer.MIN_VALUE;
		if(root==null)return 0;
		queue.add(root);
		while(!queue.isEmpty())
		{
			Node temp=queue.poll();
			if(temp.data>max)
				max=temp.data;
			if(temp.left!=null)
				queue.offer(temp.left);
			if(temp.right!=null)
				queue.offer(temp.right);
		}
		
		return max;
	}

	private static int findMaxRec(Node root) {
		if(root==null) return Integer.MIN_VALUE;

	    // Return maximum of 3 values: 1) Root's data 2) Max in Left Subtree 3) Max in right subtree
		int max=root.data;
		int lmax=findMaxRec(root.left);
		int rmax=findMaxRec(root.right);
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
