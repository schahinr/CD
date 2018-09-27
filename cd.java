/*
*
* Author: Schahin Rajab
* 
* Problem Description (source: https://open.kattis.com/problems/cd):
* Jack and Jill have decided to sell some of their Compact Discs, while they still have some value. They have decided 
* to sell one of each of the CD titles that they both own. How many CDs can Jack and Jill sell?
*
* Neither Jack nor Jill owns more than one copy of each CD.
*
*
* ##INPUT
*
* The input consists of a sequence of test cases. The first line of each test case contains two non-negative integers N
* and M, each at most one million, specifying the number of CDs owned by Jack and by Jill, respectively. This line is 
* followed by N lines listing the catalog numbers of the CDs owned by Jack in increasing order, and M more lines
* listing the catalog numbers of the CDs owned by Jill in increasing order. Each catalog number is a positive integer
* no greater than one billion. The input is terminated by a line containing two zeros. This last line is not a test case 
* and should not be processed.
*
* ##OUTPUT
* For each test case, output a line containing one integer, the number of CDs that Jack and Jill both own.
*
* #Sample Input 1
* 
* 3 3
* 1
* 2
* 3
* 1
* 2
* 4
* 0 0
* 
* # Sameple Output 1
* 2
*
*/

import java.util.*;

public class cd{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);			
		int count = 0;
		List<Integer> save = new ArrayList<Integer>();
		
		int n, m, zero1, zero2;
		
		n = 1;
		m = 1;
		
		int[] jack;
		int[] jill;
			
		while(n > 0 || m > 0){
			count = 0;
			
			n = sc.nextInt();
			m = sc.nextInt();
			
			if(n < 0 || m < 0)
				System.exit(0);
	    	if(n == 0 && m == 0)
				break;
			
			jack = new int[n];
			jill = new int[m];
			
			//enter values to array
			if(n > 0){
			for(int i = 0; i < n; i++)
				jack[i] = sc.nextInt();
			}
		
			if(m > 0){
			for(int j = 0; j < m; j++)
				jill[j] = sc.nextInt();
			}
			//debugging purposes
			//System.out.println("Entered array: " + Arrays.toString(jack));
			//System.out.println("Entered array: " + Arrays.toString(jill));
		
			//debugging time
			//long startTime = System.currentTimeMillis();
			
			//sort arrays
			if(n > 1)
			Arrays.sort(jack);
			if(m > 1)
			Arrays.sort(jill);
			
			//debugging purposes
			//System.out.println("Sorted array: " + Arrays.toString(jack));
			//System.out.println("Sorted array: " + Arrays.toString(jill));
			
			//debugging time
			//long stopTime = System.currentTimeMillis();
			//long elapsedTime = stopTime - startTime;
			//System.out.println("elapsed time after sort " + elapsedTime);
		
			//binary search to find common integers
			
			for(int s = 0; s < n; s++)
			count = count + binarySearch(jack[s],jill,0,m-1);
			
			
			save.add(count);
			//debugging time
			//stopTime = System.currentTimeMillis();
			//elapsedTime = stopTime - startTime;
			//System.out.println("elapsed time after search" + elapsedTime);
			
			jack = null;
			jill = null;
		}
		
		for(int klar = 0; klar < save.size(); klar++)
			System.out.println(save.get(klar));
	//closes main
	}

	public static int binarySearch(int value, int[] arr, int start, int end){
			int len = end - start + 1;
			int mid = start + (end - start) / 2;
			if(len == 1){
				if(arr[mid] == value)
					return 1;
				else
					return 0;
			}
			
			if (arr[mid] == value)
				return 1;
			else{
				if(arr[mid] < value)
					return binarySearch(value, arr, mid+1, end);
				else
					return binarySearch(value, arr, start, mid-1);
				}
	}
	
//closes class
}