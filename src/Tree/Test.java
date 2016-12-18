package Tree;
import java.util.LinkedList;
import java.util.Scanner;

public class Test {

 
	    /*public static LinkedList<LinkedList<Node>> findSumPaths(Node root, int target) {
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

	    //TEST----------------------------------
	    public static void main(String[]args) {
	    	Tree tree=new Tree();
	    	tree.root=new Node(10);
			tree.root.left=new Node(5);
			tree.root.left.left=new Node(3);
			tree.root.left.left.left=new Node(3);
			tree.root.left.right=new Node(2);
			tree.root.left.right.right=new Node(1);
			tree.root.left.left.right=new Node(-2);
			tree.root.right=new Node(-3);
			tree.root.right.right=new Node(11);
			tree.displayTree();
	        
	        System.out.println();
	        LinkedList<LinkedList<Node>> result = findSumPaths(tree.root, 8);
	        printResult(result);
	      
	    }

	    private static void printResult(LinkedList<LinkedList<Node>> result) {
	        for (LinkedList<Node> path : result) {
	            for (Node n : path) {
	                System.out.print(n.data + " ");
	            }
	            System.out.println();
	        }
	        System.out.println();
	    }*/
	public static void main(String[] args) {
		// creating binary tree
		Tree tree=new Tree();
		Test obj = new Test();
		Scanner sc=new Scanner(System.in);
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
	}

	private boolean pathWithSum(Node root, int sum) {
		int remSum;
		System.out.println("sum "+sum);
		if(root==null) return (sum==0);
		else
		{
			if(sum==0) return true;
			remSum=Math.abs(sum - root.data);
			System.out.println("remainin sum "+remSum+ " root data "+root.data);
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
	}
