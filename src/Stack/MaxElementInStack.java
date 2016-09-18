package Stack;
import java.util.Scanner;
import java.util.Stack;
/*In a Stack, keep track of max­i­mum value in it. It might be the top ele­ment in 
 * the stack but once it is poped out, the max­i­mum value should be from the rest of the ele­ments in the stack.*/
public class MaxElementInStack {
	// Cre­ate another another Stack(call it as track) which will keep track of max­i­mum in the given Stack(call it as main)
	
	private Stack<Integer> smain=new Stack<Integer>();
	private Stack<Integer> strack=new Stack<Integer>();
	
	public void insert(int num)
	{
		if(smain.isEmpty())
		{
			strack.push(num);
		}
		else
		{
			int temp = strack.peek();
			strack.push(Math.max(temp, num));
		}
		//insert in main
		smain.push(num);
	}
	
	public int remove()
	{
		if(!smain.isEmpty())
		{
			strack.pop();
			return smain.pop();
		} 
		return 0;
	}
	
	public int getMax()
	{
		return strack.peek();
	}

	
	public static void main(String[] args) {
		MaxElementInStack obj = new MaxElementInStack();
		Scanner in = new Scanner(System.in);
		System.out.println("Enetr Number of elements");
		int N = in.nextInt();
		while (N-->0)
		{
			int num =in.nextInt();
			obj.insert(num);
		}
		System.out.println("Do yo wanna remove element y/n");
		String ch= in.next();
		if(ch.equals("y")) System.out.println(obj.remove());
		System.out.println("Max element "+obj.getMax());
	
	}

}
