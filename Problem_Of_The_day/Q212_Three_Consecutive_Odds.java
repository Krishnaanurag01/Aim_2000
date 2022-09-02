package Problem_Of_The_day;

public class Q212_Three_Consecutive_Odds {
    public boolean threeConsecutiveOdds(int[] arr) {
        
        if(arr.length < 3) return false;
        
        int odd = 0 ;
        int even = 0 ;
        int i = 0 ;
        
        for(;i < 3 ; i++){
            if(arr[i] % 2 == 0) even++ ;
            else odd++ ;
        }
        
        if(odd == 3) return true ;
        int j = 0 ;
        for(;i < arr.length ; i++){
            if(arr[i] % 2 == 0) even++ ;
            else odd++ ;
            
            if(arr[j] % 2 == 0) even-- ;
            else odd-- ;
            j++;
            
            if(odd == 3) return true ; 
        }

        System.out.println(even);
        
        return false;
    }
}
