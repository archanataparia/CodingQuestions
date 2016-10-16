package Tree;
/*Design an algorithm and write code to find the first common ancestor of two nodes
in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
necessarily a binary search tree.*/

public class CommanAncestor {
	public Node LCA(Node root, Node a, Node b) {
		   if (root == null) {
		       return null;
		   }

		   // If the root is one of a or b, then it is the LCA
		   if (root == a || root == b) {
		       return root;
		   }

		   Node left = LCA(root.left, a, b);
		   Node right = LCA(root.right, a, b);

		   // If both nodes lie in left or right then their LCA is in left or right,
		   // Otherwise root is their LCA
		   if (left != null && right != null) return root;
		   
		   if(left==null && right==null) return null;

		   return (left != null) ? left : right; 
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommanAncestor ca = new CommanAncestor();
		Tree tree=new Tree();
		tree.insert(50);
		tree.insert(25);
		tree.insert(75);
		tree.insert(37);
		tree.insert(43);
		tree.insert(30);
		tree.insert(33);
		tree.insert(87);
		tree.displayTree();
		Node a=tree.find(30);
		Node b=tree.find(43);
		Node output = ca.LCA(tree.root, a, b);
		System.out.println("comman ancestor is "+output.data);
		

	}
}

