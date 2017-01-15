package Tree;

import java.util.*;


/*
 * Given a binary tree, design an algorithm which creates a linked list of all the
nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked
lists).*/
public class CreateLinkListFromBTree {
	
	//Approach1 using BFS method
	public ArrayList<LinkedList<Node>> createLevelLinkListWithBFS(Node root)
	{
		ArrayList<LinkedList<Node>> result=new ArrayList<LinkedList<Node>>();
		LinkedList<Node> current= new LinkedList<Node>();
		if(root==null) return null;
		else//visit the root
		{
			current.add(root);
		}
		LinkedList<Node> parent;
		while(current.size()>0)
		{
			result.add(current);//add prev level to output
			parent=current;//go to next level
			current=new LinkedList<Node>();
			for(Node p:parent)
			{
				if(p.left!=null) current.add(p.left);
				if(p.right!=null) current.add(p.right);
				
			}
		}
		
		return result;
	}
	
	//Approach2 using DFS-preorder method
	public ArrayList<LinkedList<Node>> createLevelLinkListWithDFS(Node root)
	{
		ArrayList<LinkedList<Node>> result=new ArrayList<LinkedList<Node>>();
		createLevelLinkListWithDFS(result,root,0);
		return result;
	}
	private void createLevelLinkListWithDFS(ArrayList<LinkedList<Node>> result, Node root, int level) {
		if(root==null) return;//base case
		LinkedList<Node> list=null;
		if(result.size()==level)//level not in the list
		{
			list =new LinkedList<Node>();
			//add level to the result
			result.add(list);
		}
		else
		{
			list=result.get(level);
		}
		list.add(root);
		createLevelLinkListWithDFS(result,root.left,level+1);
		createLevelLinkListWithDFS(result,root.right,level+1);
		
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Tree tree=new Tree();
		CreateLinkListFromBTree obj=new CreateLinkListFromBTree();
		tree.insert(50);
		tree.insert(25);
		tree.insert(75);
		tree.insert(37);
		tree.insert(43);
		tree.insert(30);
		tree.insert(33);
		tree.insert(87);
		 tree.displayTree();
		 ArrayList<LinkedList<Node>> output=new ArrayList<LinkedList<Node>>();
		 ArrayList<LinkedList<Node>> output2=new ArrayList<LinkedList<Node>>();
		 //calling function 1
		 output=obj.createLevelLinkListWithBFS(tree.root);
		//calling function 1
		 output2=obj.createLevelLinkListWithDFS(tree.root);
		 int count=0;
		 //print arraylist of link list of type node
		 for(int i=0;i<output.size();i++)
		 {
			 count++;
			 for(Node s:output.get(i))//printing each link list
			 {
				 System.out.print(s.data+" ");
			 }
		 }
		 System.out.print("no oflist...... "+ count);
		 
		 //print arraylist of link list of type node
		 count=0;
		 for(int i=0;i<output2.size();i++)
		 {
			 count++;
			 System.out.println("list ");
			 for(Node s:output2.get(i))//printing each link list
			 {
				 System.out.print(s.data+" ");
			 }
			
		 }
		 System.out.print("no oflist "+ count);
	}


}
