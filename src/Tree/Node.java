package Tree;

public class Node {
	
		Integer data;
		Node left;
		Node right;
		Node parent;
		Node(Integer data)
		{
			this.data=data;
			left=right=parent=null;
		}
	public void displayNode(){
		System.out.println("{"+data+"}");
	}

}
