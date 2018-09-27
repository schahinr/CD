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
        List<Integer> save = new ArrayList<Integer>(); //arraylist to add number of common cds since add is O(1)
        
        int cd = 0;
        int count = 0;
        int n = 1;
        int m = 1;
        
        HashSet<Integer> set = new HashSet<Integer>(1000000, 1.0f);
            
        while(n > 0 || m > 0){
            count = 0;  //reset counter
            
            n = sc.nextInt();
            m = sc.nextInt();
            //debugging time
            //long startTime = System.currentTimeMillis();
            if(n < 0 || m < 0)
                System.exit(0); //terminate program if a negative integer is entered
            if(n == 0 && m == 0)
                break;  //break out of while loop if 0 0 has been entered
            
            //enter values to hashset
            if(n > 0){
                for(int i = 0; i < n; i++){
                    //debugging purposes
                    /*for(int load = 0; load < 1000000; load++){
                    cd = load;*/
                    cd = sc.nextInt();
                    set.add(cd);
                    }
            }
        
            if(m > 0){
                for(int j = 0; j < m; j++){
                    //debugging purposes
                    /*for(int load = 0; load < 1000000; load++){
                    cd = load;*/
                    cd = sc.nextInt();
                    if(set.contains(cd))    //checks if catalog number is already int hashset
                        count++;
                    }
            }
        
            
            save.add(count);
    
            set.clear();
            //debugging time
            /*long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println("elapsed time from adding values to clearing hashset: " + elapsedTime);*/
            
        }
        
        for(int klar = 0; klar < save.size(); klar++)
            System.out.println(save.get(klar));
    //closes main
    }
//closes class
}
