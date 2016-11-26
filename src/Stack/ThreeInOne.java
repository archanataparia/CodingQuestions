package Stack;


/*implement 3 stacks with one array?
 * sol- You can start one of the stacks from one end of the array. 
 * You can start the other stack from the other end of the array. 
 * You can put the third stack in the middle. 
 * When, one of the side stacks need space, you need to shift the middle stack.*/
public class ThreeInOne {
	 
	//This is the stack node class
    class StackNode {
        int value;
        int prev;//link to prev node

        StackNode(int value, int prev) {
            this.value = value;
            this.prev = prev;
        }
    }
   
    private StackNode[] stackNodes = null; //This keeps the stack nodes
    private static int CAPACITY = 10;
    private int freeListTop = 0;//This keeps the top of free list
    private int size = 0;// size of stack
    private int[] stackPointers = { -1, -1, -1 }; //These are the pointers to the three stacks
    ThreeInOne() {
        stackNodes = new StackNode[CAPACITY];
        initFreeList();
    }

    //Initialize the free list
    private void initFreeList() {
    	for (int i = 0; i < CAPACITY; i++) {
            //The value of each node is 0 and it points to the next node
            stackNodes[i] = new StackNode(0, i + 1);
        }
		
	}


	public static void main(String[] args) {
		ThreeInOne mulStack = new ThreeInOne();
        try {
            //Adding to those three stacks
            mulStack.push(1, 11);
            mulStack.push(1, 12);
            mulStack.push(1, 13);
            mulStack.push(1, 14);
            mulStack.push(2, 21);
            mulStack.push(2, 22);
            mulStack.push(3, 31);
            mulStack.push(3, 32);
            //Popping from those three stacks
            mulStack.pop(1);
            mulStack.pop(2);
            mulStack.pop(3);

        } catch (Exception e) {
            e.printStackTrace();
        }

	}

	private StackNode pop(int sNumber) throws Exception{
		
        int currentStackTop = stackPointers[sNumber - 1];//From which stack you want to pop. -1, since it starts from 0
       
        if (currentStackTop == -1) {
            throw new Exception("UNDERFLOW");
        }
       
        StackNode temp = stackNodes[currentStackTop]; //Get the node as a temp node
        stackPointers[sNumber- 1] = temp.prev;//Remove the node from stack
        freeStackNode(currentStackTop);//Put this node as free node
        
        System.out.println("Pop from stack "+sNumber+" value: "+temp.value);
        return temp;
	}

	private void freeStackNode(int index) {
		 stackNodes[index].prev = freeListTop;
	        freeListTop = index;//Put the index in free list
	        size--;
	}

	private void push(int sNumber, int value) throws Exception 
	{
        System.out.println("Push to stack "+sNumber+" value "+value);
        int freeIndex;
        int currentStackTop = stackPointers[sNumber- 1];
        
        //Find the free index
        freeIndex = getFreeNodeIndex();
        
        StackNode n = stackNodes[freeIndex]; //Make a new node in the free index
        n.prev = currentStackTop; //Setting the previous node
        n.value = value;
        
        stackPointers[sNumber- 1] = freeIndex;
		
	}

	private int getFreeNodeIndex() throws Exception{
		 int temp = freeListTop;
	        if (size >= CAPACITY)
	            throw new Exception("OVERFLOW");
	        freeListTop = stackNodes[temp].prev;
	        size++;
	        return temp;
	}

}
