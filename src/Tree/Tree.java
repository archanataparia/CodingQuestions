package Tree;

import java.util.Stack;
//this is basic tree operations insert, delete, find and traverse
public class Tree {
	private Node root;
	public Tree()
	{
		root=null;
	}
	
/*------function to insert in tree-------------*/
	
	//insert value in tree---insert function without recursion
	public void insert(int value)
	{
		//System.out.println("in insert");
		Node newNode = new Node(value);
		if(root==null)
		{
			root=newNode;
			return;
		}
		else
		{
			Node current=root;
			Node parent;
			while(true)
			{
				parent=current;
				if(value<current.data)//go left
				{
					current=current.left;
					if(current==null)
					{
						parent.left=newNode;
						return;
					}
				}
				else//go right
				{
					current=current.right;
					if(current==null)
					{
						parent.right=newNode;
						return;
					}
				}
			}
		}
	}//end of insert function
	
	//insert function with recursion
	public void insertRec(int value)
	{
		root=insertRec(root,new Node(value));//calling insert function
	}//end of insertRec function
	
	private Node insertRec(Node root, Node newNode) {
		if(root==null) 
			root= newNode;
		else if(newNode.data<root.data)
			root.left=insertRec(root.left, newNode);
		else if (newNode.data>root.data)
			root.right=insertRec(root.right,newNode);
		return root;
	}//end of insert recursion function
	
/*------function to find value in tree-------------*/	
	public Node find(int value)
	{
		Node current=root;
		while(current.data!=value)
		{
			if(value>current.data)
				current=current.right;
			else 
				current=current.left;
			if(current==null)return null;
		}
		return current;
	}//end of find function
	
/*------function to delete value in tree
 * case 1.deleted leaf node
 * case 2. deleted node has one child
 * case 3 deleted node has 2 child-------------*/
	public boolean delete(int key)
	{
		Node current=root;
		Node parent=root;
		boolean isLeftChild=true;
		while(current.data!=key)//find node to delete
		{
			parent=current;
			if(key>current.data)
			{
				isLeftChild=false;
				current=current.right;//go right
			}
			else
			{
				isLeftChild=true;
				current=current.left;//go left
				
			}
			if(current==null) return false;
		}//end while and found node to delete
		System.out.println("out of while "+isLeftChild);
		
//---CASE-1 leaf node to be deleted-so set parent of leaf node point to null
		if((current.left==null)&&(current.right==null))
		{
			if(current==root) root=null;//if tree is empty
			else if(isLeftChild) parent.left=null;//disconnect from parent
			else parent.right=null;
		}
//---CASE2-node has one child so set parent node child node of the deleted node
		else if(current.right==null)//if no right child replace the node with left subtree
		{
			if(current==root) root=current.left;
			else if(isLeftChild)
				parent.left=current.left;//left child of parent
			else
				parent.right=current.left;//right child of parent
		}
		else if(current.left==null)//if no left child replace the node with right subtree
		{
			if(current==root) root=current.right;
			else if(isLeftChild)
				parent.left=current.right;//left child of parent
			else
				parent.right=current.right;//right child of parent
		}
//---CASE3-node has two children so replace with inorder successor
		else
		{
			Node successor=getSuccessor(current);
			
			//connect parent of current to successor instead
			if(current==root) root=successor;
			else if(isLeftChild)
				parent.left=successor;
			else
				parent.right=successor;
			
			//connect successor to the left child of current 
			successor.left=current.left;
		}
		return true;
	}
	
	private Node getSuccessor(Node delNode)
	{
		Node successor=delNode;
		Node succParent=delNode;
		Node current=delNode.right;
		while(current!=null)//go to the right child until no more left child
		{
			succParent=successor;
			successor=current;
			current=current.left;
		}
		//if successor is not right child make connection
		if(successor!=delNode.right)
		{
			succParent.left=successor.right;
			successor.right=delNode.right;
		}
		System.out.println("in get successor "+successor.data);
		return successor;
	}
	
	public void traverse(int choice)
	{
		switch(choice)
		{
		case 1: preOrder(root);
				preOrderRec(root);
				break;
		case 2: postOrder(root);
				postOrderRec(root);
				break;	
		case 3: inOrder(root);
				inOrderRec(root);
				break;
		default: System.out.println("invalid input");
		}
	}
	
private void inOrderRec(Node root2) {
		// TODO Auto-generated method stub
		
	}

private void postOrderRec(Node root2) {
		// TODO Auto-generated method stub
		
	}

private void preOrderRec(Node root2) {
		// TODO Auto-generated method stub
		
	}

private void inOrder(Node root2) {
		// TODO Auto-generated method stub
		
	}

private void postOrder(Node root2) {
		// TODO Auto-generated method stub
		
	}

private void preOrder(Node root2) {
		// TODO Auto-generated method stub
		
	}

//------------function to display tree-------------
	public void displayTree()
	{
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		while(isRowEmpty==false)
		{
			Stack localStack = new Stack();
			isRowEmpty = true;
			for(int j=0; j<nBlanks; j++)
			System.out.print(" ");
			while(globalStack.isEmpty()==false)
			{
			Node temp = (Node)globalStack.pop();
			if(temp != null)
			{
			System.out.print(temp.data);
			localStack.push(temp.left);
			localStack.push(temp.right);
			if(temp.left != null ||temp.right!= null)
			isRowEmpty = false;
			}
			else
			{
			//System.out.print("---");
			localStack.push(null);
			localStack.push(null);
			}
			for(int j=0; j<nBlanks*2-2; j++)
			System.out.print(" ");
			} // end while globalStack not empty
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty()==false)
			globalStack.push( localStack.pop() );
			} // end while isRowEmpty is false
			//System.out.println("----------------------------");
			
	}//end of display function
	
	
}
