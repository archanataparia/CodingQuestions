package array;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class twoDArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        
        for(int i=0; i < 3; i++){
            for(int j=0; j < 3; j++){
                arr[i][j] = in.nextInt();
            }
        }
   
        int sum = 0, max = Integer.MIN_VALUE;
        int i;
        for (i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                int line1 = arr[i - 1][j - 1] + arr[i - 1][j] + arr[i - 1][j + 1];
                int line2 = arr[i][j];
                int line3 = arr[i + 1][j - 1] + arr[i + 1][j] + arr[i + 1][j + 1];
                sum = line1 + line2 + line3;
                if (max <= sum) {
                    max = sum;
                }
            }

        }
        System.out.println(max);
	}

}
