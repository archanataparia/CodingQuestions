package recursionCTC;
/*write a recursive function to multiply two positive integers without using * operator. you can use addition, subtraction and bit operator.*/
public class RecursiveMultiply {

	public static void main(String[] args) {
		RecursiveMultiply rm=new RecursiveMultiply();
		int a= 2;
		int b =24;
		int mult=rm.recuMultiply(a,b);
		System.out.println("multiplicatio is "+mult);
	}

	private int recuMultiply(int a, int b) {
		//find small an big element
		int big=(a<b?b:a);
		int small =(a<b?a:b);
		return recMultiplySub(big,small);
	}
	
	
	private int recMultiplySub(int big, int small) {
		if(small==0||big==0) return 0;
		if(small==1) return big;
		
		int s=small/2;//divide small element in half
		int s1=recMultiplySub(big,s);
		int s2=s1;
		if(small%2==1)
			s2=recMultiplySub(big,small-s);
		return s1+s2;
	}
}
