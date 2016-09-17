package StringNArraysCTC;

import java.util.Scanner;
// Program to display delete, insert and search in an unsorted array

class UnsortedArray
{
	private int ua[];
	private int size_ua;
	
	public UnsortedArray(int max)
	{
		ua=new int[max];
		this.size_ua=0;
	}
	//insert
	public void insertArray(int num)
	{
		ua[size_ua++]=num;
	}
	//delete
	public boolean deleteArray(int num)
	{	int i;
		for(i=0; i<size_ua;i++)
		{
			if(num==ua[i]) break;
		}
		if (i==size_ua) return false;//cant find element
		else//found
		{
			//System.out.println("i "+i);
			for(int k=i;k<size_ua-1;k++)
				ua[k]=ua[k+1];
			size_ua--; 
			return true;
		}
	}
	//search
	public String findArray(int num)//linear search
	{
		for(int i=0; i<size_ua;i++)
		{
			if(num==ua[i]) return "match found";
		}
		return "no match";
	}
	public void displayArray()
	{
		for(int i=0;i<size_ua;i++)
		{
			System.out.println(ua[i]+" ");
		}
	}
	//max num
	public int getMax()
	{
		int max=ua[0];
		for(int i=1;i<ua.length-1;i++)
		{
			if(ua[i]>max)
			{
				int temp=max;
				max=ua[i];
				ua[i]=temp;
			}
		}
		return max;
	}
	
}

public class ArrayDeleteInsertFind {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter Size ");
		int N = sc.nextInt();
        
      
        UnsortedArray uarray =new  UnsortedArray(N);
        System.out.print("Enter unsorted array ");
        for (int i = 0; i < N; i++) {
            uarray.insertArray(sc.nextInt());;
        }
        
        System.out.print("Displaying unsorted array ");
        uarray.displayArray();
        
        System.out.print("enter num to find ");
        System.out.print(uarray.findArray(sc.nextInt()));
        
        System.out.print("enter num to delete ");
        uarray.deleteArray(sc.nextInt());
        
        uarray.displayArray();
        System.out.print("max num in array "+uarray.getMax());
        sc.close();
	}

}
