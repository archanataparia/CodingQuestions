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

	}

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

}
