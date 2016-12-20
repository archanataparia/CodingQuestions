package Tree;
/*given a sorted array give an algorithm for converting the array to BST*/
public class CreateBSTFromSortedArray {

	public static void main(String[] args) {
		CreateBSTFromSortedArray obj=new CreateBSTFromSortedArray();
		int[] array={2,4,6,7,8,9,10};
		Node  root=obj.createBST(array,0,array.length-1);
		obj.printTree(root);
	}
//print tree in inorder 
	private void printTree(Node root) {
		if(root==null) return;
		printTree(root.left);
		System.out.print(root.data+" ");
		printTree(root.right);
	}

	private Node createBST(int[] a,int start,int end) {
		if(start>end) return null;
		int mid =(start+end)/2;//mid element is root as array is sorted
		Node newNode=new Node(a[mid]);//create the new node
		newNode.left=createBST(a,start,mid-1);//left node
		newNode.right=createBST(a,mid+1,end);//right node
		return newNode;
	}

}
