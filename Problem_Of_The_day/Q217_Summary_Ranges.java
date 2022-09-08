package Problem_Of_The_day;
import java.util.*;

public class Q217_Summary_Ranges {

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>() ;
        if(nums.length < 1) return ans ;
        
        int si = nums[0] ;
        int ei = nums[0] ;
        
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i-1] + 1 == nums[i]){
                ei++ ;
            }
            else{
                if(si == ei) ans.add(si+"") ;
                else ans.add(si+"->"+ei) ;
                
                si = nums[i] ;
                ei = nums[i] ;
            }
        }
        
        
        if(ans.size() > 0){
            String s = ans.get(ans.size() - 1) ;
            String temp =  "" ;
            if(si == ei) temp = si+"" ;
            else temp = si+"->"+ei ;
            
            if(s.equals(temp) == false) ans.add(temp) ;
        }
        else {
            if(si == ei) ans.add(si+"") ;
                else ans.add(si+"->"+ei) ;
        }
        return ans ;
    }
}
