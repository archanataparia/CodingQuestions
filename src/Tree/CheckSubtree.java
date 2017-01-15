package Tree;
/*You have two very large binary trees: Tl, with millions of nodes, and T2, with hundreds of nodes. Create an algorithm to decide ifT2 is a subtree of Tl.
A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree of
n is identical to T2. That is, if you cut off the tree at node n, the two trees would
be identical.*/
public class CheckSubtree {

	private  boolean containsTree1(Node root1, Node root2) {
		//  get string of each tree data and then find substring so create two string builder object to create string
		StringBuilder sb1=new StringBuilder();
		StringBuilder sb2=new StringBuilder();
		
		//get string order of each tree
		getStringOrder(root1,sb1);
		getStringOrder(root2,sb2);
	
		//check substring
		return sb1.indexOf(sb2.toString())!=-1;
	}

	private void getStringOrder(Node root, StringBuilder sb) {
/*idea is to append string with x wherever null value found    3
		 * 													/	\
		 * 												   4	null(x)*/ 
		if(root==null) 
		{
			sb.append("x");
			return;
			
		}
		sb.append(root.data+" ");//add root
		//recursively add left and right
		getStringOrder(root.left,sb);
		getStringOrder(root.right,sb);	
	}

	public static void main(String[] args) {
		CheckSubtree cs=new CheckSubtree();
		// creating T1 (bigger tree) binary tree
		Tree tree1=new Tree();
		tree1.root=new Node(40);
		tree1.root.left=new Node(20);
		tree1.root.left.left=new Node(4);
		tree1.root.left.right=new Node(8);
		tree1.root.left.left.right=new Node(35);
		tree1.root.right=new Node(5);
		tree1.root.right.right=new Node(4);
		
		// creating T2 (smaller binary tree)
		Tree tree2=new Tree();
		tree2.root=new Node(20);
		tree2.root.left=new Node(4);
		tree2.root.left.right=new Node(35);
		tree2.root.right=new Node(8);
		tree1.displayTree();
		System.out.println();
		tree2.displayTree();
		
		//check substree
		boolean result1=cs.containsTree1(tree1.root,tree2.root);
		System.out.println("result is "+result1);

	}

}
