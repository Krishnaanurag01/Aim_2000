package LeetCode_Contests.BiWeekly_94;

public class Q1_Maximum_Enemy_Forts_That_Can_Be_Captured {

    public int captureForts(int[] forts) {
        
        int ans = 0 ;
        
        
        for(int i = 0 ; i < forts.length ; i++){
            int val = forts[i] ;
            if(val == 1){
                int temp1 = 0 ;
                boolean found1 = false ;
                int x = i - 1 ;
                
                while(x >= 0 && forts[x] == 0){
                    temp1++ ;
                    x-- ;
                }
                
                if(x >= 0 && forts[x] == -1){
                    found1 = true ;
                }
                
                x = i + 1 ;
                int temp2 = 0;
                boolean found2 = false ;
                
                while(x < forts.length && forts[x] == 0){
                    temp2++ ;
                    x++ ;
                }
                
                if(x < forts.length && forts[x] == -1){
                    found2 = true ;
                }
                
                ans = Math.max(ans, Math.max( found1 == true ? temp1 : 0 , found2 == true ? temp2 : 0 )) ;
            }
        }
        
        return ans;
    }
}
