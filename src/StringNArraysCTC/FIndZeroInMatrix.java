/*1.7 Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0.*/
package StringNArraysCTC;

import java.util.Scanner;

public class FIndZeroInMatrix {
	static void findZeroInMatrix(int[][] a, int r, int c)
	{
		boolean[] row = new boolean[r];
		boolean[] column = new boolean[c];
		
		//store two arrays with flag if any value is 0 among row or column
		for (int i=0;i<r;i++){
			for (int j=0;j<c;j++)
			{
				if(a[i][j]==0)
				{
					row[i]=true;
					column[j]=true;
				}
			}
		}
		//set entire row and column 0
		for (int i=0;i<r;i++){
			for (int j=0;j<c;j++)
			{
				if(row[i] || column[j])
				{
					a[i][j]=0;
				}
			}
		}
		//print  matrix
				for(int i=0;i<r;i++)
				{
					for(int j=0;j<c;j++)
						System.out.print(a[i][j]+ " ");;
					System.out.println();
				}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int[][] a = new int[r][c];
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
				a[i][j]=sc.nextInt();
		}
		
		findZeroInMatrix(a,r,c);
		sc.close();

	}

}
