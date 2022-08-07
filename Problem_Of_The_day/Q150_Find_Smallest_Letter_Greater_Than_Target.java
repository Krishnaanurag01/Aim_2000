package Problem_Of_The_day;

public class Q150_Find_Smallest_Letter_Greater_Than_Target {
    
    public char nextGreatestLetter(char[] letters, char target) {
        
        int low = 0 ;
        int high = letters.length -1 ;
        
        while(low <= high){
            int mid = low + (high-low)/2 ;
            if(letters[mid] <= target){
                low = mid + 1 ;
            }
            else{
                high = mid - 1;
            }
        }
        
        if(low >= letters.length) return letters[0] ;
        
        return letters[low] ;
    }
}
