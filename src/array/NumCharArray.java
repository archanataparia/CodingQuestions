package array;

public class NumCharArray {
    public static void main(String[] args) {
   	 String s="1234abcd";
   	 char[] a=s.toCharArray();//convert string to char array
  	 int end=a.length;
   	 int mid;
   	 char temp1;

   	 for(int i=0;i<end;i=i+2)//swaping 2 values in one pass so increment value of i by 2
   	 { 
   		 mid=(i+end)/2;
   		 temp1=a[mid];//store mid value in temp variable
   		 //shift array towards mid value 
   		 for(int j=mid;j>i;j--)
   		 {
   			a[j]=a[j-1]; 
   		 }
   		 a[i+1]=temp1;
   		 
   	 }
   	 for(int i=0;i<a.length;i++)
			System.out.print(" "+a[i]);	
   }
	

}
