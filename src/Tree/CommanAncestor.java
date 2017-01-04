package Tree;
/*Design an algorithm and write code to find the first common ancestor of two nodes
in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
necessarily a binary search tree.*/

public class CommanAncestor {
	
	class Result//creating a class that holds flag value for the existing node
	{
		Node root;
		boolean isAncestor;
		Result(Node root, boolean isAncestor)
		{
			this.root=root;
			this.isAncestor=isAncestor;
		}
	}
	
	private Node LCA2(Node root, Node a, Node b)
	{
		Result result=LCA2SubProgram(root,a,b);
		if(result.isAncestor)
			return result.root;
		return null;
	}
	private Result LCA2SubProgram(Node root, Node a, Node b) {
		if(root==null) return new Result(null, false);
		if(root==a && root==b)return new Result(root, true);
		
		//handle scenario if a and b both are on same side of the subtree
		Result left=LCA2SubProgram(root.left,a,b);
		if(left.isAncestor)//found ancestor
			return left;
		Result right=LCA2SubProgram(root.right,a,b);
		if(right.isAncestor)//found ancestor
			return right;
		
		//if both a and b are in different subtree and not null
		if(left.root!=null && right.root!=null)
			return new Result(root,true);//root is common ancestor
		else if(root==a || root ==b)//if one of the node is null
		{
			//if we are currently at a or b and we also found one of those node in subtree this truly an ancestor and flag should be true
			boolean isAncestor = left.root!=null || right.root!=null;
			return new Result(root,isAncestor);
		}
		else
			return new Result(left.root!=null?left.root:right.root, false);//return the root which is not null
		
	}
	//approach2
	public Node LCA(Node root, Node a, Node b) {
		   if (root == null) 
		       return null;
		   
		   if(a==null || b==null) return null;//if one of node is not present in the tree
		   
		   if (root == a || root == b) {// If the root is one of a or b, then it is the LCA
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
		if(output!=null)
		System.out.println("comman ancestor is "+output.data);
		else
		{
			System.out.println("No comman ancestor found");
		}

	}
}

