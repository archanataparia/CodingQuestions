package array;

import java.util.Scanner;

class SortedArray
{
	private int sa[];
	private int size_sa;
	
	public SortedArray(int max)
	{
		sa=new int[max];
		this.size_sa=0;
	}
	
	public void insertArray(int num)
	{
		int i;
		for(i=0; i<size_sa;i++)
			if(num<sa[i]) break;//find index location
		
			for(int k=size_sa;k>i;k--)//move bigger ones up
				sa[k]=sa[k-1];
			sa[i]=num;// insert element
			size_sa++; 

	}
	public boolean deleteArray(int num)
	{
		int index=findArray(num);
		if(index==size_sa)
		{
			System.out.println("no element to delete");
			return false;
		}
		else
		{
			for (int k=index;k<size_sa-1;k++)
			{
				sa[k]=sa[k+1];
			}
			size_sa--;
			return true;
		}
	}
	public int findArray(int num)
	{
		int start=0, end= sa.length -1;
		int mid;
		while(start<=end)
		{
			mid = (start+end)/2;
			if(sa[mid]==num) 
			{
				System.out.println("match found");
				return mid;
			}
			else
			{
				if(sa[mid]<num) start = mid+1;
				else end = mid-1;
			}
		}
		return size_sa;
	}
	public void displayArray()
	{
		for(int i=0;i<size_sa;i++)
		{
			System.out.println(sa[i]+" ");
		}
	}
}
public class SortedArrayInsertDelFind {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter Size ");
		int N = sc.nextInt();
        
      
        SortedArray sarray =new  SortedArray(N);
        System.out.print("Enter sorted array ");
        for (int i = 0; i < N; i++) {
            sarray.insertArray(sc.nextInt());
        }
        
        System.out.print("Displaying sorted array ");
        sarray.displayArray();
        
        System.out.print("enter num to find ");
        System.out.print(sarray.findArray(sc.nextInt()));
        
        System.out.print("enter num to delete ");
        sarray.deleteArray(sc.nextInt());
        
        sarray.insertArray(sc.nextInt());
        sarray.displayArray();
        sc.close();

	}

}
