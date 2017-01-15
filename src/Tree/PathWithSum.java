package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/*You are given a binary tree in which each node contains a value. Design an algorithm to print all paths which sum to a given value. 
 * The path does not need to start or end at the root or a leaf.*/
public class PathWithSum {
	
	ArrayList<Integer> resultList=new ArrayList<Integer>();//to store all paths
	
	private int countPathWithSum1(Node root, int sum) {
		// brute force method
		if(root==null) return 0;//base condition
		
		int countRoot=countPathFromNode(root,sum,0);//check sum from root to leaf
		int countRight=countPathWithSum1(root.right,sum);//check sum from right
		int countLeft=countPathWithSum1(root.left,sum);//check sum from left
		//return total sum
		return countRoot+countRight+countLeft;
	}

	private int countPathFromNode(Node root, int sum, int currentSum) {
		// this method returns the number of paths with this sum starting from this node
		int totalPath=0;
		if(root==null) return 0;//base condition
		
		currentSum+=root.data;
		resultList.add(root.data);
		if(currentSum==sum)//check currentsum
		{
			totalPath++;
			System.out.print(resultList+" ");
		}
		//System.out.println();
		totalPath+=countPathFromNode(root.left,sum,currentSum);//add left node value to sum
		totalPath+=countPathFromNode(root.right,sum,currentSum);
		return totalPath;
	}
	/*check existence of path from root to node*/
	private boolean pathWithSum(Node root, int sum) {
		int remSum;
		if(root==null) return (sum==0);
		else
		{
			if(sum==0) return true;
			remSum=Math.abs(sum - root.data);
			if((root.left!=null && root.right!=null)||(root.left==null&&root.right==null))//in case of both nodes or empty node
			{
				return (pathWithSum(root.left,remSum)||(pathWithSum(root.right,remSum)));
			}
			else if(root.left!=null)
				return pathWithSum(root.left,remSum);
			else 
				return pathWithSum(root.right,remSum);
		}	
	}
		
		public static void main(String[] args) {
		// creating binary tree
		Tree tree=new Tree();
		PathWithSum obj=new PathWithSum();
		int sum;
		Scanner sc=new Scanner(System.in);
		/*tree.root=new Node(10);
		tree.root.left=new Node(5);
		tree.root.left.left=new Node(3);
		tree.root.left.left.left=new Node(3);
		tree.root.left.right=new Node(2);
		tree.root.left.right.right=new Node(1);
		tree.root.left.left.right=new Node(-2);
		tree.root.right=new Node(-3);
		tree.root.right.right=new Node(11);
		tree.displayTree();
		System.out.println("insert sum value ");
		sum=sc.nextInt();
		
		int count=obj.countPathWithSum1(tree.root,sum);
		System.out.println(" count is "+count);*/
		
		tree.root=new Node(8);
		tree.root.left=new Node(2);
		tree.root.left.left=new Node(5);
		tree.root.right=new Node(4);
		tree.root.right.right=new Node(8);
		tree.root.right.left=new Node(3);
		tree.root.right.right.right=new Node(10);
		tree.displayTree();
		
		boolean result=obj.pathWithSum(tree.root,20);
		System.out.println(" result is "+result);
		//LinkedList<LinkedList<Node>> result = findSumPaths(tree.root, 8);
        //printResult(result);
	}
		/* 
	    public static LinkedList<LinkedList<Node>> findSumPaths(Node root, int target) {
	        LinkedList<LinkedList<Node>> result = new LinkedList<LinkedList<Node>>();
	        findSumPaths(root, target, new LinkedList<Node>(), result);
	        return result;
	    }

	    @SuppressWarnings("unchecked")
	    private static void findSumPaths(Node n, int target, LinkedList<Node> path, LinkedList<LinkedList<Node>> result) {
	        if (n == null) return;
	        path.add(n);
	        int sum = 0;
	        LinkedList<Node> nodes = new LinkedList<Node>();
	        for (int i = path.size() - 1; i >= 0; --i) {
	            Node node = path.get(i);
	            nodes.add(node);
	            sum += node.data;
	            if (sum == target) {
	                result.add((LinkedList<Node>) nodes.clone());
	            }
	        }
	        findSumPaths(n.left,  target, path, result);
	        findSumPaths(n.right, target, path, result);

	        // "Pop" recursion stack top.
	        // Alternatively, clone path when passing it in recursive
	        // calls, or use native array to hold path.
	        path.removeLast();
	    }
	        private static void printResult(LinkedList<LinkedList<Node>> result) {
	        for (LinkedList<Node> path : result) {
	            for (Node n : path) {
	                System.out.print(n.data + " ");
	            }
	            System.out.println();
	        }
	        System.out.println();
	    }
	}

	}*/


}
