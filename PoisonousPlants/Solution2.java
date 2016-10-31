import java.io.*;
import java.util.*;

public class Solution2 {

	List<Integer> days = new ArrayList<Integer>() ;
	
	public Solution2() {
		days.add(Integer.MAX_VALUE) ;
	}
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		long startTime = System.currentTimeMillis() ;
        Scanner scanner = new Scanner(System.in) ;
        int n = scanner.nextInt() ;
        if (n<1 || n>100000) {
            throw new IllegalArgumentException("1 <= N <= 100000") ;
        }

		Solution2 solution = new Solution2() ;

        
        for (int i=0;i<n;i++) {
			solution.addPlant(scanner.nextInt()) ;
        }
        
        System.out.println(solution.days.size()-1) ;
		System.out.println(System.currentTimeMillis()-startTime) ;
    }
       
	private void addPlant(int plant) {
		if (plant <= days.get(0)) {
			// plant survive 1st day, check how many days it will survive
			checkPlantSurvival(plant,1) ;
		} else if (days.size()<2) {
			days.add(days.get(0)) ;
		}
		days.set(0,plant) ;
	}
	
	private void checkPlantSurvival(int plant, int day) {
		for(int i=day;i<days.size();i++) {
			if (plant<=days.get(i)) {
				// plant survive on this day
				days.set(i,plant) ;
				continue ;
			} else {
				//Check if next day exists and add one more day to days if not
				if (days.size()<=i+1) {
					days.add(days.get(days.size()-1)) ;
				}
				// plant die on this day			
				days.set(i,plant) ;
				break ;
			}	
		}		
	}
}