package Tree;

public class Node {
	
		Integer data;
		public int size=0;
		Node left;
		Node right;
		Node parent;
		Node(Integer data)
		{
			this.data=data;
			left=right=parent=null;
			size=1;
		}
	public void displayNode(){
		System.out.println("{"+data+"}");
	}
	

}
