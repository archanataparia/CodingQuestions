package recursionCTC;

import java.util.ArrayList;

/*Implement an algorithm to print all valid (e.g., properly opened and closed)
combinations of n-pairs of parentheses.
EXAMPLE
Input: 3
Output: ((())), (()()), (())(), ()(()), ()()()*/
public class Parenthesis {

	public static void main(String[] args) {
		Parenthesis ps=new Parenthesis();
		int n=3;
		ArrayList<String> list=ps.createValidParenthesis(n);
		System.out.println(list);

	}

	private ArrayList<String> createValidParenthesis(int n) {
		ArrayList<String> list=new ArrayList<String>();
		createValidParenthesis(list,"",n,n);
		return list;
	}

	private void createValidParenthesis(ArrayList<String> list, String s, int left, int right) {
		// left=number of left ( parenthesis and right=total right ) parenthesis remianing
		if(left<right)
			return;//base condition as ( less than ) so invalid answer
		if(left==0 &&right==0)
		{
			list.add(s);
			return;
		}
		if(left>0)
		{
			createValidParenthesis(list,s+")",left-1,right);
		}
		if(right>0)
		{
			createValidParenthesis(list,s+"(",left,right-1);
		}
		
	}

}
