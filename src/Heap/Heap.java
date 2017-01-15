package Heap;
/*A Binary Heap is either Min Heap or Max Heap. In a Min Binary Heap, the key at root must be minimum among all keys present in Binary Heap. 
 * The same property must be recursively true for all nodes in Binary Tree. Max Binary Heap is similar to Min Heap. this implementaton is for max heap*/

import Tree.Node;

//heap can be implemented using array as heaps are for forming complete binary tree so there will not be any wastage of the location

class HeapNode
{
	public int data;
	HeapNode left;
	HeapNode right;
	HeapNode(int data)
	{
		this.data=data;
		left=right=null;
	}
	public int getData(){
		return this.data;
	}
	public void setData(int data)
	{
		this.data=data;
	}
	public void displayNode(){
	System.out.println("{"+data+"}");
	}
}//end of class heapnode

public class Heap {
	
	private HeapNode[] heapArray;//creating an array of nodes
	private int maxSize;//size of array
	int currentSize;//number of nodes in array
	
	Heap(int capacity)
	{
		this.maxSize=capacity;
		this.currentSize=0;
		heapArray=new HeapNode[maxSize];//create  array
	}
	
	public boolean isEmpty()
	{
		return currentSize==0;
	}
	//create a max heap
	public void insert(int data)
	{
		if(currentSize==maxSize) return;//check array length
		HeapNode newNode=new HeapNode(data);//create a new node
		heapArray[currentSize]=newNode;//insert the new node at the end of the array
		trickleUp(currentSize++);//trickle up the new node to the appropriate position
	}
	//heapfying
	private void trickleUp(int index) {
		int parent = (index-1)/2;//find parent  index of the node to be trickle up
		HeapNode bottom=heapArray[index];//save inserted node
		
		while(index>0 && heapArray[parent].getData()<bottom.getData())
		{
			heapArray[index]=heapArray[parent];//move down the parent
			index=parent;
			parent=(parent-1)/2;
		}
		heapArray[index]=bottom;//move up the node
	}

	public HeapNode remove(){
		HeapNode root =heapArray[0];//save the root
		heapArray[0]=heapArray[--currentSize];//copy last element to the root
		trickleDown(0);//trickle down the root node to the appropriate position
		return root;
	}
	private void trickleDown(int index) {
		int largeChild;
		HeapNode top= heapArray[index];//save root
		
		//check for atleast one child
		while(index>currentSize/2)
		{
			//find index for left and right child
			int lchild= 2*index+1;
			int rchild=2*index+2;
			System.out.println("in");
			//find larger child
			if (rchild<currentSize && heapArray[lchild].getData()<heapArray[rchild].getData())
			largeChild=rchild;
			else
				largeChild=lchild;
			System.out.println("large child "+heapArray[largeChild]);
			if(top.getData()>=heapArray[largeChild].getData()) break;
			
			//shift child up
			heapArray[index]=heapArray[largeChild];
			index=largeChild;//go down
		}
		heapArray[index]=top;
	}

	public boolean change(int v1, int v2){return false;}
	public void displayHeap()
	{
	System.out.println("heapArray: "); // array format
	for(int m=0; m<currentSize; m++)
	if(heapArray[m] != null)
	System.out.print( heapArray[m].getData() + " ");
	else
	System.out.print( "--");
	System.out.println();
	// heap format
	int nBlanks = 32;
	int itemsPerRow = 1;
	int column = 0;
	int j = 0; // current item
	String dots = "...............................";
	System.out.println(dots+dots); // dotted top line
	while(currentSize > 0) // for each heap item
	{
	if(column == 0) // first item in row?
	for(int k=0; k<nBlanks; k++) // preceding blanks
	System.out.print(" ");
	// display item
	System.out.print(heapArray[j].getData());
	if(++j == currentSize) // done?
		break;
		if(++column==itemsPerRow) // end of row?
		{
		nBlanks /= 2; // half the blanks
		itemsPerRow *= 2; // twice the items
		column = 0; // start over on
		System.out.println(); // new row
		}
		else // next item on row
		for(int k=0; k<nBlanks*2-2; k++)
		System.out.print(" "); // interim blanks
		} // end for
		System.out.println(" "+dots+dots); // dotted bottom line
		} // end displayHeap()

}
