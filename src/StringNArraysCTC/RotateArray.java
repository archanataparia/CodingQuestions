/* 
1 2 3 4 5 6 
after rotate from kth(3) position from last 
final list
2 1 6 5 4 3*/ 
package StringNArraysCTC;
import java.util.*;

public class RotateArray {
	static void rotateArray(int[] a, int k)
	{
		int[] b=new int[a.length];
		int i,j;
		for(i=0,j=0;i<a.length && j<k;i++)
		{
			if(i<a.length-k) b[i]=a[i];
			else
			{
				a[j]=a[i];
				j++;
			}
		}
		i=0;
		for(int x=k;x<a.length;x++)
		{
			a[x]=b[i];
			i++;
		}
		for(int y=0;y<a.length;y++)
			System.out.print(+a[y]);
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		System.out.println("enter k: ");
		int k = sc.nextInt();
		rotateArray(a,k);
		sc.close();

	}

}
