package Tree;

import java.util.*;

/*Given a sorted (increasing order) array with unique integer elements, write an algorithm
to create a binary search tree with minimal height
solution -1) Get the Middle of the array and make it root.
2) Recursively do same for left half and right half.
      a) Get the middle of left half and make it left child of the root
          created in step 1.
      b) Get the middle of right half and make it right child of the
          root created in step 1.*/
public class BSTwithMinHeight {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		BSTwithMinHeight bst=new BSTwithMinHeight();
		System.out.println("Enter Integer Array size");
		int size=sc.nextInt();
		int[] a=new int[size]; 
		System.out.println("Enter Integer Array");
		for(int i=0;i<size;i++)
		{
			a[i]=sc.nextInt();
		}
		//calling tree function to create BST
		Arrays.sort(a);
		Node root=bst.createMinHeightBST(a);
		bst.preOrder(root);

	}

	public Node createMinHeightBST(int[] array) {
		return createMinHeightBST(array,0,array.length-1);
		
	}

	private Node createMinHeightBST(int[] array, int start, int end) {
		if(start>end) return null;
		
		int mid=(start+end)/2;
		
		Node newNode = new Node(array[mid]);
		newNode.left=createMinHeightBST(array, start,mid-1);
		newNode.right=createMinHeightBST(array,mid+1,end);
		return newNode;
		
	}
	void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

}
