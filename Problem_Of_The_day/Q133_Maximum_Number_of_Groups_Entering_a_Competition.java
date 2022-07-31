package Problem_Of_The_day;
import java.util.* ;

public class Q133_Maximum_Number_of_Groups_Entering_a_Competition {

    public int maximumGroups(int[] grades) {
        Arrays.sort(grades) ;
        int count = 1 ;

        // prev group details
        int prev = grades[0] ; // prev sum
        int prevFreq = 1 ; // prev count
        
        int currfreq = 0 ;
        int sum = 0 ;
        
        for(int i = 1 ; i < grades.length ; i++){
            sum += grades[i] ;
            currfreq++ ;
            if(sum > prev && currfreq > prevFreq){ // current group sum and freq should be greater then prev
                count++ ;
                prevFreq = currfreq ;
                currfreq = 0 ;
                prev = sum ;
                sum = 0 ;
            }
        }
        
        return count;
    }
}
