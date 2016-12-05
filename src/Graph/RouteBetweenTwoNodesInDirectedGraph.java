package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*Given a Directed Graph and two vertices in it, check whether there is a path from the first given vertex to second. */
class Graph
{
	private int ver;//total vertices
	private LinkedList<Integer>[] adj;//list of adjacent vertices 
	Graph(int v)
	{
		this.ver=v;
		this.adj=new LinkedList[v];
		for(int i=0;i<v;i++)
			adj[i]=new LinkedList();
	}
	
	//function to add edge in a graph from one vertices to another
	public void addEdge(int sourceV, int destV)
	{
		adj[sourceV].add(destV);
	}

	public boolean checkForPath(int v1, int v2) {
		Queue<Integer> queue=new LinkedList<Integer>();
		if(v1==v2) return false;
		boolean[] visit=new boolean[ver];//create a boolean array with size of total vertices
		int temp;
		Iterator<Integer> itr;//iterator can be used to iterate through vertices
		queue.add(v1);//add source to the queue and mark it visited
		visit[v1]=true;
		while(!queue.isEmpty())
		{
			v1=queue.poll();//dequeue 
			itr=adj[v1].listIterator();//returns iterator list over v1
			
			//get all adjacent verices of v1 and visit these verices and mark visited
			while(itr.hasNext())//continue search
			{
				temp=itr.next();
				if(temp==v2) return true;//found path return
				if(!visit[temp])//mark vertex
				{
					visit[temp]=true;
					queue.add(temp);//add next vertex to the queue
				}
			}
			
		}
		return false;
	}
	
}
public class RouteBetweenTwoNodesInDirectedGraph {

	public static void main(String[] args) {
		// Create a graph
		Graph graph=new Graph(5);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		graph.addEdge(3, 4);
		graph.addEdge(4, 4);
		
		//check for path 
		boolean result1=graph.checkForPath(2,4);
		boolean result2=graph.checkForPath(4,1);
		System.out.println("results "+result1+" & "+result2);

	}

}
