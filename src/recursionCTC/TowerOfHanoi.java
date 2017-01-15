package recursionCTC;
/*you have 3 towers and N disks of diferent sizes.the puzzle starts with disk sorted in ascending order of 
 * size from top to bottom.constraints are: 1. only one disk move at a time. 2. a disk is slid off the top of one tower onto another tower.
 * 3.a disk can not be placed on top of the smaller disk.write a program to move the disk from first tower to the last using stacks */
public class TowerOfHanoi {

	public static void main(String[] args) {
		TowerOfHanoi  toh=new TowerOfHanoi ();
		int N= 3;
		toh.towerOfHanoi(N,"start","destination","buffer");
		//System.out.println(result);

	}

	private void towerOfHanoi(int n, String start, String destination, String buffer) {
		if(n==0) return;
		//move n-1 disk to buffer
		towerOfHanoi(n-1,start,buffer,destination);
		//move nth disk to destination
		System.out.println("move the disk "+n+" from "+ start+ " to "+ destination);
		//move n-1 disk to destination
		towerOfHanoi(n-1,buffer,destination,start);
	}
}
