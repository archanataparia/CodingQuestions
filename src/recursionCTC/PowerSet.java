package recursionCTC;

import java.util.ArrayList;

//Write a method to return all subsets of a set.
public class PowerSet {

	public static void main(String[] args) {
		PowerSet ps=new PowerSet();
		ArrayList<Integer> set =new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		ArrayList<ArrayList<Integer>> result=ps.getSubset(set,0);
		System.out.println(result);
	}

	private ArrayList<ArrayList<Integer>> getSubset(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> subset;
		
		if(set.size()==index){//if list is empty-base condition
			//System.out.println("inside base size "+set.size()+ " index "+ index);
			subset=new ArrayList<ArrayList<Integer>>();//initiate the list
			subset.add(new ArrayList<Integer>());//empty set
		}
		else
		{
			subset=getSubset(set,index+1);//recursion
			//System.out.println("subset "+subset);
			int item=set.get(index);
			ArrayList<ArrayList<Integer>> extraSubset=new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> temp:subset)
			{
				ArrayList<Integer> newSubset=new ArrayList<Integer>();
				newSubset.addAll(temp);//add subset to the newsubset
				newSubset.add(item);//add a new value in the list
				//System.out.println("neew subset "+newSubset);
				extraSubset.add(newSubset);
				//System.out.println(" extra subset "+extraSubset);
			}
			subset.addAll(extraSubset);
			//System.out.println("final subset "+subset);
		}
		return subset;
	}

}
