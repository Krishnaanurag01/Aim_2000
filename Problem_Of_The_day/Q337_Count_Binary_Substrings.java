package Problem_Of_The_day;

public class Q337_Count_Binary_Substrings {

    public int countBinarySubstrings(String s) {
        ArrayList<Integer> freqCount = new ArrayList<>() ; // freq count of every group 
        
        int total = 1 ;
        
        for(int i = 1 ; i < s.length() ; i++){
            if(s.charAt(i-1) == s.charAt(i)) total++ ; // increasing freq if current char is following the group
            else{
                freqCount.add(total) ; // otherwise add the freq of prev group
                total = 1 ; // and start new count
            }
        }
        
        freqCount.add(total) ; // adding the last count.
        int ans = 0 ;
        
        for(int i = 1 ; i < freqCount.size() ; i++){
            ans += Math.min(freqCount.get(i), freqCount.get(i-1)) ; // taking the min of two pair.
        }
        
        return ans ;
    }
}
