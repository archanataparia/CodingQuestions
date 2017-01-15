package Tree;

import java.util.Stack;

/*Give an algorithm to traverse a binary tree in Zigzig order*/
public class ZigZagTreeTraversal {
	Stack<Node> currentLevel=new Stack<Node>();
	Stack<Node> nextLevel=new Stack<Node>();

	public static void main(String[] args) {
		ZigZagTreeTraversal obj=new ZigZagTreeTraversal();
		Tree tree=new Tree();
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		tree.root.left.right=new Node(5);
		tree.root.left.left=new Node(4);
		tree.root.right=new Node(3);
		tree.root.right.right=new Node(7);
		tree.root.right.left=new Node(6);
		tree.displayTree();
		System.out.println("Zigzag order is ");
		//output should be 1324567
		obj.zigzagTraversal(tree.root);
	}

	private void zigzagTraversal(Node root) {
			int leftToRightOrder=1;//setting direction from left to right
		
		currentLevel.push(root);
		while(!currentLevel.isEmpty())
		{
			Node temp=currentLevel.pop();
			System.out.print(temp.data+" ");
			if(leftToRightOrder==1)//direction is left to right
			{
				if(temp.left!=null) nextLevel.push(temp.left);
				if(temp.right!=null)nextLevel.push(temp.right);
			}
			else//direction is right to left
			{
				if(temp.right!=null)nextLevel.push(temp.right);
				if(temp.left!=null) nextLevel.push(temp.left);
			}
			if(currentLevel.isEmpty())
			{
				leftToRightOrder=1-leftToRightOrder;//setting direction from right to left
				swap(currentLevel,nextLevel);//swap the stacks
			}
		}
	}

	private void swap(Stack<Node> currentLevel, Stack<Node> nextLevel) {
		Stack<Node> temp=new Stack<Node>();
		if(nextLevel==null) return;
		while(!nextLevel.isEmpty())
		{
			temp.push(nextLevel.pop());
		}
		while(!temp.isEmpty())
		{
			currentLevel.push(temp.pop());
		}
		
	}

}
