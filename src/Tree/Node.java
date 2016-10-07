package Tree;

public class Node {
	
		Integer data;
		Node left;
		Node right;
		Node(Integer data)
		{
			this.data=data;
			left=right=null;
		}
	public void displayNode(){
		System.out.println("{"+data+"}");
	}

}
