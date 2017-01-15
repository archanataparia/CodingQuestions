package Tree;
/*find the level that has the maximum sum in the binary tree*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaxSumLevelInBinaryTree {

	public static void main(String[] args) {
		Tree tree=new Tree();
		MaxSumLevelInBinaryTree obj=new MaxSumLevelInBinaryTree();
		tree.root=new Node(8);
		tree.root.left=new Node(2);
		tree.root.left.left=new Node(4);
		tree.root.left.left.left=new Node(3);
		tree.root.left.right=new Node(2);
		tree.root.left.right.right=new Node(1);
		tree.root.left.left.right=new Node(6);
		tree.root.right=new Node(3);
		tree.root.right.right=new Node(11);
		tree.displayTree();
		System.out.println("level "+obj.maxSumLevel(tree.root) + " has maximum sum ");

	}

	private int maxSumLevel(Node root) {
		int cSum=0,maxSum=0,level=0,maxLevel=0;
		if(root==null) return 0;
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(root);//add root to the queue
		queue.add(null);//add null as a flag for end of level
		
		while(!queue.isEmpty())
		{
			Node current=queue.poll();
			if(current==null)
			{
				if(maxSum<cSum)
				{
					maxSum=cSum;
					maxLevel=level;
				}
				cSum=0;
				level++;
				if(!queue.isEmpty()) queue.add(null);//add null as a flag for end of level
			}
			else
			{
				cSum +=current.data;
				if(current.left!=null) queue.add(current.left);
				if(current.right!=null) queue.add(current.right);
				
			}
			
			
		}
		System.out.println("max sum "+maxSum);
		return maxLevel;
	}

}
