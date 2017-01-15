package Tree;
/*construct a binary tree from given preorder and inorder traversal*/
public class BuildTreeFromInorderAndPreOrderTraversal {
	
	static int preStart=0;
	
	public static void main(String[] args) {
		BuildTreeFromInorderAndPreOrderTraversal obj=new BuildTreeFromInorderAndPreOrderTraversal();
		int[] inorder={4,2,5,1,6,7,3,8};
		int[] preorder={1,2,4,5,3,7,6,8};
		Node root= obj.buildTree(inorder, preorder);
		obj.display(root);

	}

	private void display(Node root) {
		if(root==null) return;
		display(root.left);
		System.out.print(root.data+" ");
		
		display(root.right);		
	}
	private Node buildTree(int[] in,int[] pre)
	{
		int inStart=0;
		int inEnd=in.length-1;
		return buildTree(in,pre,inStart,inEnd);
	}
	private Node buildTree(int[] in, int[] pre,int inStart, int inEnd) 
	{
		if(inStart>inEnd) return null;//base condition
		Node root=new Node(pre[preStart++]);//first element is root in pre order
		if(inStart==inEnd) return root;
		int temp=root.data;
		int index=0;
		for(int i=0;i<in.length;i++)//search the root in the inorder
		{
			if(in[i]==temp)
			{
				index=i;//save the index of the root in the inorder
				break;
			}
		}
		
		//costruct tree 
		root.left=buildTree(in,pre,inStart,index-1);//build left subtree
		root.right=buildTree(in,pre,index+1,inEnd);//build right subtree
		
		return root;
	}

}
