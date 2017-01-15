package Heap;

import java.util.Scanner;

public class HeapApp {

	public static void main(String[] args) 
	{
	int value, value2;
	boolean success;
	Scanner sc=new Scanner(System.in);
	Heap theHeap = new Heap(31); // make a Heap; max size 31
	theHeap.insert(70); // insert 10 items
	//theHeap.insert(40);
	theHeap.insert(50);
	theHeap.insert(20);
	theHeap.insert(60);
	theHeap.insert(100);
	theHeap.insert(80);
	theHeap.insert(30);
	theHeap.insert(10);
	theHeap.insert(90);
	while(true) // until [Ctrl]-[C]
	{
		System.out.println("Enter choice 1.display, 2.insert, 3.delete ");
		int choice=sc.nextInt();
	
	switch(choice)
	{
	case 1: theHeap.displayHeap();;
			break;
	case 2: System.out.println("enter value to insert");
			value=sc.nextInt();
			theHeap.insert(value);
			break;
	case 3:
			if( !theHeap.isEmpty()){
				HeapNode output= theHeap.remove(); System.out.println("node deleted "+output.data);}
			else System.out.println("Can’t remove; heap empty");
			break;
	/*case 4: System.out.print("Enter current index of item: ");
			value=sc.nextInt();
			System.out.print("Enter new key: ");
			value2 = sc.nextInt();
			success = theHeap.change(value, value2);
			if( !success )
				System.out.println("Invalid index");
			break;*/
			default:
				System.out.println("Invalid entry");
	} // end switch
	} // end while

} // end main()

}
