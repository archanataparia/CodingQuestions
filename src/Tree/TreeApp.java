package Tree;

import java.util.Scanner;

public class TreeApp {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice,value;
		Tree tree=new Tree();
		tree.insert(50);
		tree.insert(25);
		tree.insert(75);
		tree.insert(37);
		tree.insert(43);
		tree.insert(30);
		tree.insert(33);
		tree.insert(87);
		tree.insertRec(93);
		tree.insertRec(97);
		while(true)
		{
			System.out.println("Enter choice 1.display, 2.insert, 3.find, 4.delete, 5.traverse ");
			choice=sc.nextInt();
			switch (choice)
			{
			case 1: tree.displayTree();
					break;
			case 2: System.out.println("enter value to insert");
					value=sc.nextInt();
					tree.insert(value);
					break;
			case 3: System.out.println("enter value to find");
					value=sc.nextInt();
					Node result=tree.find(value);
					System.out.println(result.data);
					break;
			case 4: System.out.println("enter value to delete");
					value=sc.nextInt();
					System.out.println(tree.delete(value));
					break;
			case 5: System.out.println("enter type of traverse 1.PreOrder, 2.PostOrder, 3.InOrder");
					value=sc.nextInt();
					break;
			default: System.out.println("invalid entry");
			
			}
		}

	}

}
