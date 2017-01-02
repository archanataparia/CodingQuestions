package sortingNSearching;

import java.util.Scanner;

/*Given an M x N matrix in which each row and each column is sorted in ascending
order, write a method to find an element*/
public class SortedMetrixSearch {

	public static void main(String[] args) {
		SortedMetrixSearch sm=new SortedMetrixSearch();
		int[][] matrix=new int[10][10];
		Scanner sc=new Scanner(System.in);
		System.out.println("enter row and coloumn");
		int r=sc.nextInt();
		int c=sc.nextInt();
		System.out.println("enter sorted element");
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
				matrix[i][j]=sc.nextInt();
		}
		sm.printMatrix(matrix,r,c);
		System.out.println("enter element to find");
		int n=sc.nextInt();
		boolean result =sm.find(matrix,n,r,c);
		System.out.println("element exist in matrix: "+result);
		

	}

	private void printMatrix(int[][] matrix, int r, int c) {
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
				System.out.print(matrix[i][j]+ " ");;
			System.out.println();
		}
		
	}

	private boolean find(int[][] matrix, int n,int r,int c) {
		//start serach from the top right coloum and will move our search accordingly
		int row=0;
		int col=c-1;
		while(row<matrix.length && col>=0)
		{
			//System.out.println(matrix[row][col]);
			if(matrix[row][col]==n) return true;
			else if (matrix[row][col]<n)//if value is less then move to the next row
				row++;
			else
				col--;
		}
		return false;
	}


}
