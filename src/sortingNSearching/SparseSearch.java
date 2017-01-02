package sortingNSearching;
/*Given a sorted array of strings which is interspersed with empty strings, write a
method to find the location of a given string.
EXAMPLE
Input: find "ball" in {"at", "", "", "", "ball", "", "", "car",tti) tat ftf4^.j>j t(» <t»\ , aau , , )
Output: 4*/
public class SparseSearch {

	public static void main(String[] args) {
		SparseSearch ss=new SparseSearch();
		String s[]={"at","","","","ball","","","car","","","dad","",""};
		int index=ss.sparseSearch(s,"ball");
		System.out.println("index of ball is "+index);
	}

	private int sparseSearch(String[] s, String string) {
		if(string==null || s==null || string==" ") return -1;
		else
		return search(s,string,0,s.length-1);
	}

	private int search(String[] sArray, String string, int start, int end) {
		// binary search modification for empty string
		if(start>end) return -1;//base condition
		int mid=(start+end)/2;
		
		//change mid value to non empty string if mid is empty
		if(sArray[mid].equals(" ")|| sArray[mid].isEmpty())
		{
			int left=mid-1;
			int right=mid+1;
			//find nearest non empty string
			while(true)
			{
				if(!sArray[left].isEmpty() && left>start)
				{
					mid=left;
					break;
				}
				if(!sArray[right].isEmpty() && right<end)
				{
					mid=right;
					break;
				}
				left--;
				right++;
			}
		}
		
		//apply binary search method
		if(sArray[mid].compareTo(string)==0) return mid;
		else if (sArray[mid].compareTo(string)==-1)//mid is small then value
			return search(sArray, string,mid+1,end);
		else
			return search(sArray,string,start,mid-1);
		
		
	}

}
