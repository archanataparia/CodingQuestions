/*1.6 Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
1 2 3
4 5 6
7 8 9
result: 
7 4 1
8 5 2
9 6 3
*/

package StringNArraysCTC;

import java.util.Scanner;

public class RotateMatrix {
	static void rotateMatrix(int[][] a, int n)
	{
		//use mirror matrix concept along the diagonal as its square matrix...swap positions
		for (int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				int tmp= a[i][j];
				a[i][j]=a[j][i];
				a[j][i]=tmp;
			}
		}
		/*it will give intermediate result that needs to swap horizontally to exact rotation
		1 4 7
	 	2 5 8
		3 6 9
		*/
		
		for (int i=0;i<n/2;i++)
		{
			for(int j =0;j<n;j++)
			{
				int tmp=a[j][i];
				a[j][i]=a[j][n-i-1];
				a[j][n-i-1]=tmp;
			}
		}
		//print rotated matrix
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print(a[i][j]+ " ");;
			System.out.println();
		}
		
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] a = new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				a[i][j]=sc.nextInt();
		}
		
		rotateMatrix(a,n);
		sc.close();

	}

}
