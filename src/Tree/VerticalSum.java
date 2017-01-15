package Tree;

import java.util.HashMap;

/* find vertical sum of a binary tree*/
public class VerticalSum {

	public static void main(String[] args) {
		VerticalSum vSum=new VerticalSum();
		Tree tree=new Tree();
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		tree.root.left.right=new Node(5);
		tree.root.left.left=new Node(4);
		tree.root.right=new Node(3);
		tree.root.right.right=new Node(7);
		tree.root.right.left=new Node(6);
		tree.displayTree();
		System.out.println("Vertical sum is ");
		vSum.verticalSum(tree.root);

	}

	private void verticalSum(Node root) {
		if(root==null) return;//base  case
		//create hashmap to store vertical sum
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		//tree has 5 vertical lines that can represented as columns here root is column 0 and left columns are root-1 and right are root+1
		verticalSum(root,map,0);
		
		// print the value
		if(!map.isEmpty())
		{
			System.out.print(map.entrySet());
		}
	}

	public void verticalSum(Node root, HashMap<Integer,Integer> map, int column)
	{
		if(root==null) return;//base condition
		if(map.containsKey(column))
		{
			map.put(column, map.get(column)+root.data);
		}
		else
			map.put(column, root.data);
		
		verticalSum(root.left,map,column-1);//left column will be root column-1
		verticalSum(root.right,map,column+1);//right column will be root column+1
		
	}
}
