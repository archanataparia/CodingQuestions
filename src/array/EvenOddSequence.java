package array;
/*Given array of integers, partition it into 2 groups of even and odd numbers, so that all even numbers appear before odd numbers. E.g. given
10, 3, 6, 7, 9, 9, 20
the result could be 10, 6, 20, 3, 7, 9, 9*/
public class EvenOddSequence {

	public static void main(String[] args) {
		EvenOddSequence seq=new EvenOddSequence();
		int[] a={10,3,6,7,9,9,20};
		int start=0;
		int end=a.length-1;
		int[] output=seq.evenOddSequence(a,start,end);
		for(int i=0;i<output.length;i++) System.out.print(output[i]+" ");

	}

	private int[] evenOddSequence(int[] a, int start, int end) {
		int temp;
		for(int i=0;i<a.length &&start<end;i++)
		{
			if(a[start]%2==0)
			{
				start++;
			}
			else
			{
				
				temp=a[end];
				a[end]=a[start];
				a[start]=temp;
				end--;
				start++;
			}
		}
		return a;
	}

}
