package StringNArraysCTC;
/*You are given a string which represents the width of a river. River contains rocks represented by 
an asterisk (*), and water is represented by an empty space. You need to write a method that determines whether you can cross the river assuming you follow the following rules:
river = "*****  *   * * *  *  *  "
Initial location: 0
Initial speed: 0
each step:
   1. choose a speed from {current speed, current speed + 1, current speed - 1} (speed cannot be negative)
   2. move speed spaces on the river: current location += speed
   3. if you land on water (empty space), you fail
   4. if you land past end of river, you win
   5. otherwise, keep going
   river = "*****  *   * * *  *  *  "
               011  2   3    4     4  3   3   4 (crossed)

impossible_river = "****  *      *   *"
                               01  2  3 234  (failed)*/
import java.util.Scanner;

public class River {
	public static void main(String[] args) {
		String river="****  *      *   *";
		
		boolean result= crossRiverResult(river);
		System.out.println("result is "+result);
	}

	private static boolean crossRiverResult(String river) {
		char[] a=river.toCharArray();
		return crossRiverResult(a,1,1);
	}

	private static boolean crossRiverResult(char[] a, int speed, int location) {
		if(a.length==location) return true;
		if(a[location]==' ') return false;
		if(location==0) return false;
		if(speed==0) return false;
		return crossRiverResult(a,speed,location+speed)||crossRiverResult(a, speed-1,location+speed-1)||crossRiverResult(a,speed+1,location+speed+1);
	}
}
