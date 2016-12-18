package Tree;
/*Given a binary tree print out all its root to leaf path*/
import java.util.ArrayList;

public class PrintRootToLeafPath {

	public static void main(String[] args) {
		Tree tree=new Tree();
		PrintRootToLeafPath obj=new PrintRootToLeafPath();
		tree.root=new Node(8);
		tree.root.left=new Node(2);
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(2);
		tree.root.left.right.right=new Node(1);
		tree.root.right=new Node(3);
		tree.root.right.left=new Node(7);
		tree.root.right.right=new Node(11);
		tree.root.right.right.right=new Node(10);
		tree.displayTree();
		System.out.println();
		int[] list=new int[10];
		obj.printPath(tree.root,list,0);

	}

	private void printPath(Node root, int[] list,int len) {
		if(root==null) return;
		list[len++]=root.data;//append list
		
		if(root.left==null && root.right==null)//check for leaf node
			printList(list,len);//print list
		else
		{
			printPath(root.left,list,len);
			printPath(root.right,list,len);
		}
	
		System.out.println();
	}

	private void printList(int[] list,int len) {
		for(int i=0;i<len;i++)
		{
			System.out.print(list[i]+" ");
		}
		
	}

}
