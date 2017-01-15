package Tree;

import java.util.Scanner;
/*convert a tree to its mirror image.mirror of a tree is another tree with left and right children of all non leaf nodes interchanged*/
public class MirrorImage {

	public static void main(String[] args) {
		Tree tree=new Tree();
		MirrorImage obj = new MirrorImage();
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(5);
		tree.root.right=new Node(3);
		
		tree.displayTree();
		System.out.println();
		System.out.println("mirror image");
		
		tree.root = obj.mirrorImage(tree.root);
		tree.displayTree();
		
		Tree tree1=new Tree();
		tree1.root=new Node(1);
		tree1.root.left=new Node(3);
		tree1.root.right=new Node(2);
		tree1.root.right.right=new Node(4);
		tree1.root.right.left=new Node(5);
		Node root2 = obj.mirrorImage(tree.root);
		boolean result=obj.mirrorImage(tree.root, tree1.root);
		System.out.println("result "+result);

	}
//create mirror image of given tree
	private Node mirrorImage(Node root) {
		if(root==null) return null;
		mirrorImage(root.left);
		mirrorImage(root.right);
		Node temp;
		//swap positions of the node
		temp=root.left;
		root.left=root.right;
		root.right=temp;
		
		return root;
	}
//compare two tree if they are mirror image or not
	private boolean mirrorImage(Node root1, Node root2) 
	{
		if(root1==null && root2==null) return true;
		if(root1==null || root2==null) return false;
		if(root1.data!=root2.data) 
		return false;
		
		else 
			return (mirrorImage(root1.left, root2.right) && mirrorImage(root1.right, root2.left));
	}
}
