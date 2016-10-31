import java.io.*;
import java.util.*;

public class Solution3 {

	List<Integer> days = new ArrayList<Integer>() ;
	Integer firstN ;
	Integer firstNValue ;
	
	public Solution3() {
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

		Solution3 solution = new Solution3() ;

        
        for (int i=0;i<n;i++) {
			solution.addPlant(scanner.nextInt()) ;
        }
        
        System.out.println(solution.days.size()-1) ;
		System.out.println(System.currentTimeMillis()-startTime) ;
    }
       
	private void addPlant(int plant) {
		if (plant <= days.get(0)) {
			// plant survive 1st day, check how many days it will survive
			checkPlantSurvival(plant) ;
		} else if (days.size()<2) {
			days.add(days.get(0)) ;
		}
		days.set(0,plant) ;
	}
	
	private void checkPlantSurvival(int plant) {
		int i=1 ;
		if (firstNValue!=null && plant<=firstNValue) {
			i = firstN ;
		}
		boolean plantDead = false ;
		for(;i<days.size();i++) {
			if (plant>getPlantOnDay(i)) {
				plantDead = true ;
				//Plant die on current day, plant survie on all previous days
				if (firstN!=null && i-1 < firstN) {
					for (int j=i;j<=Math.min(firstN,days.size()-1);j++) {
						days.set(j,firstNValue) ;
					}
				}
				firstN = i-1 ;
				firstNValue = plant ;
				
				//Check if next day exists and add one more day to days if not
				if (days.size()<=i+1) {
					days.add(getPlantOnDay(days.size()-1)) ;
				}
				// plant die on this day			
				days.set(i,plant) ;
				break ;
			}	
		}
		if (!plantDead) {
			//Plant survive and set to all days
			firstN = days.size() ;
			firstNValue = plant ;
		}
	}
	
	private Integer getPlantOnDay(int day) {
		if (firstN!=null && firstNValue!=null && day <= firstN && day > 0) {
			return firstNValue ;
		} else {
			return days.get(day) ;
		}
	}
}