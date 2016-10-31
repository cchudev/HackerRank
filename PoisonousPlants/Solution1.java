import java.io.*;
import java.util.*;

public class Solution1 {
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		long startTime = System.currentTimeMillis() ;
        Scanner scanner = new Scanner(System.in) ;
        int n = scanner.nextInt() ;
        if (n<1 || n>100000) {
            throw new IllegalArgumentException("1 <= N <= 100000") ;
        }
        LinkedList<Integer> list = new LinkedList<Integer>() ;
        for (int i=0;i<n;i++) {
            list.add(scanner.nextInt()) ;
        }
        
        Solution1 solution = new Solution1() ;
        int i = 0 ;
		int sizeBefore = 0 ;
		int sizeAfter = 0 ;
		do {
			i++ ;
			sizeBefore = list.size() ;
			list = solution.removeDeadPlant(list) ;
			sizeAfter = list.size() ;
		} while(sizeBefore != sizeAfter);

        System.out.println(i-1) ;
		System.out.println(System.currentTimeMillis()-startTime) ;
    }
       
    private LinkedList<Integer> removeDeadPlant(LinkedList<Integer> list) {
        if (list.size()<2) {
            return list ;
        }
        //Indicate end of iteration
        LinkedList<Integer> returnList = new LinkedList<Integer>() ;
		
        Integer plantR = list.pollLast() ;
        while(!list.isEmpty()) {
            if (plantR <= list.peekLast()) {
                // plant survive, add to first
                returnList.addFirst(plantR) ;
            }
            plantR = list.pollLast() ;
        }
		returnList.addFirst(plantR) ;
		
        return returnList ;
    }
}