package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
/*------------------------------------------------------------------------------------
 * program to perform basic tree operations insert, delete, find and traverse
 */
public class Tree {
	public Node root;
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
		case 1: System.out.println("data in preorder using iteration: ");
				preOrder(root);
				System.out.println("data in preorder using recursion: ");
				preOrderRec(root);
				break;
		case 2: System.out.println("data in postorder using iteration with one stack: ");
				postOrder(root);
				System.out.println("data in postorder using iteration with two stack: ");
				postOrder2(root);
				System.out.println("data in postorder using recursion: ");
				postOrderRec(root);
				break;	
		case 3: System.out.println("data in inorder using iteration: ");
				inOrder(root);
				System.out.println("data in inorder using recursion: ");
				inOrderRec(root);
				break;
		case 4: System.out.println("data in level order (BFS): with recursion");
				BFSRec(root);
				System.out.println("data in level order (BFS): without recursion");
				BFSIterative(root);
				break;
		default: System.out.println("invalid input");
		}
	}



//------------------PREORDER traversal-------------------------
//preorder traversal without recursion
private void preOrder(Node tempRoot) {
		// Root->Left->Right
	Stack<Node> stack=new Stack<Node>();
	
	if(tempRoot == null) return;
	stack.push(tempRoot);//push root node to the stack
	while(!stack.isEmpty())
	{
		Node topNode= stack.peek();
		System.out.print(topNode.data+" ");
		stack.pop();
		
		if(topNode.right!=null)
			stack.push(topNode.right);//push right first in stack to pop left first
	
		if(topNode.left!=null)
			stack.push(topNode.left);
	}
		
	}	
//preorder traversal with recursion
private void preOrderRec(Node tempRoot) {
	// Root->Left->Right
	if(tempRoot!=null)
	{
		System.out.print(tempRoot.data+" ");
		preOrderRec(tempRoot.left);
		preOrderRec(tempRoot.right);
	}
	
}
//------------------POSTORDER traversal-------------------------
//postorder traversal without recursion using one stack
private void postOrder(Node tempRoot) {
	// Left->Right->Root
	Stack<Node> stack=new Stack<Node>();
	
	Node temp=tempRoot;
	Node prev=null;
	if(temp==null) return;
	stack.push(temp);
	
	while(!stack.isEmpty())
	{
		temp=stack.peek();
		//moving down in the tree required push
		/* go down the tree in search of a leaf an if so process it 
        and pop stack otherwise move down */
			if((prev==null)||(prev.left==temp)||(prev.right==temp))//prev node is null or parent
			{
				if(temp.left!=null) stack.push(temp.left);
				else if (temp.right!=null) stack.push(temp.right);
				else //both left and right are null
				{
					System.out.print(temp.data+" ");
					stack.pop();
				}
			}
			
		//Coming up from left
			/* go up the tree from left node, if the child is right 
            push it onto stack otherwise process parent and pop 
            stack */
			else if(prev==temp.left)
			{
				if(temp.right!=null)
					stack.push(temp.right);
				else
				{
					System.out.print(temp.data+" ");
					stack.pop();
				}
			}
			
		//moving up from right
			else if(prev==temp.right)
			{
				System.out.print(temp.data+ " ");
				stack.pop();
			}
			
			prev=temp;
	}//end of while
	System.out.println();
	
}
//------------------POSTORDER traversal-------------------------
//postorder traversal without recursion using two stack
//postorder traversal with recursion
private void postOrder2(Node tempRoot) 
{
	Stack<Node> stack1=new Stack<Node>();
	Stack<Node> stack2=new Stack<Node>();
	Node temp=tempRoot;
	if(temp==null)return;
	stack1.push(temp);
	while(!stack1.isEmpty())
	{
		Node top=stack1.peek();
		stack2.push(stack1.pop());
		if(top.left!=null)
			stack1.push(top.left);
		if(top.right!=null)
			stack1.push(top.right);
	}
	while(!stack2.isEmpty())
	{
		System.out.print(stack2.peek().data+" ");
		stack2.pop();
	}
	System.out.println();
	
}
private void postOrderRec(Node tempRoot) {
		// Left->Right->Root
		if(tempRoot!=null)
		{
			postOrderRec(tempRoot.left);
			postOrderRec(tempRoot.right);
			System.out.print(tempRoot.data+ " ");
		}
		
	}

//------------------INORDER traversal-------------------------
//inorder traversal with recursion	}
private void inOrderRec(Node tempRoot) {
	// Left->Root->Right
	if(tempRoot!=null)
	{
		inOrderRec(tempRoot.left);
		System.out.print(tempRoot.data+ " ");
		inOrderRec(tempRoot.right);
	}
	
}
//inorder traversal without recursion
private void inOrder(Node tempRoot) {
		//  Left->Root->Right
	Stack<Node> stack=new Stack<Node>();
	Node root=tempRoot;
	
	if(root==null) return;
	//first node to be visited will be left one
	while(root!=null)
	{
		stack.push(root);
		root=root.left;
	}
	List<Integer> a=new ArrayList<Integer>();
	
	while(stack.size()>0)
	{
		root=stack.pop();
		a.add(root.data);
	
		System.out.print(" "+root.data);
		if(root.right!=null)
		{
			root=root.right;
			while(root!=null)//check for left node from this node
			{
				stack.push(root);
				root=root.left;
			}
		}
	}
	//to find kth max element in the binary search tree here k is 3
	int index=a.size()-3;
	//System.out.print(" index "+index);
	System.out.print(" 3 max element "+a.get(index));
}

//------------------BFS or level order traversal with recursion-------------------------
private void BFSRec(Node tempRoot) {
	int i,height;
	height=getHeightRec(tempRoot);
	System.out.println("height is "+ height);
	for(i=1;i<=height;i++) printLevelNode(tempRoot,i);
	
}

//function to calculate height of the tree
private int getHeightRec(Node tempRoot) {
	// function to calculate height of a tree
	int lHeight,rHeight;
	if(tempRoot==null) return 0;
	else
	{
		lHeight=getHeight(tempRoot.left);
		rHeight=getHeight(tempRoot.right);
		if(lHeight>rHeight) return (lHeight+1);
		else return (rHeight+1);
	}
}
//function to calculate height of the tree without recursion
private int getHeight(Node tempRoot) {
	// thi is similar to level ordr traversal BFS
	Queue<Node> queue=new LinkedList<Node>();
	if(root==null)return 0;
	queue.add(root);
	int level=1;
	queue.add(null);
	while(!queue.isEmpty())
	{
		Node current=queue.poll();
		//complete current level first
		if(current==null)
		{
			//increase level
			level++;
			//put another level in queue
			if(!queue.isEmpty())queue.add(null);//to keep loop continue while calculating height
		}
		else
		{
			if(current.left!=null)
				queue.add(current.left);
			if(current.right!=null)
				queue.add(current.right);
		}
	}
	return level;
}

//function to print data in BFS mode
private void printLevelNode(Node tempRoot, int level) {
	if(tempRoot==null) return;
	if(level==1) System.out.print(" "+tempRoot.data);
	else if (level>1)
	{
		printLevelNode(tempRoot.left, level-1);
		printLevelNode(tempRoot.right, level-1);
	}
	
}

//------------------BFS or level order traversal without recursion-------------------------
private void BFSIterative(Node root) {
		// use queue
	Queue<Node> queue=new LinkedList<Node>();
	if(root==null)return;
	queue.add(root);
	while(!queue.isEmpty())
	{
		Node current=queue.poll();
		//print current node
		System.out.print(current.data+" ");
		if(current.left!=null)
			queue.add(current.left);
		if(current.right!=null)
			queue.add(current.right);
	}
		
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
