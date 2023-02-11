package Problem_Of_The_day ;
public class Q355_Minimum_Days {
    public static int getMinimumDays(int N, String S, int[] p) {
       
        char[] arr = S.toCharArray() ;
        int ipv = 0 ; // initial potential violation.
        
        for(int i = 0 ; i < S.length() - 1 ; i++){
            if(arr[i] == arr[i+1]) ipv++ ;
        }
        
        if(ipv == 0) return 0 ;
        
     //   System.out.println(ipv) ;
        
        // now trying every permutation until all the violation is resolved.
        for(int i = 0 ; i < p.length ; i++){
            if(p[i] - 1 >= 0 && arr[p[i]] == arr[p[i] - 1]) ipv-- ; // agar char at i == i-1 same hoga toh i ko ? karne k ek baad ek violation resolved hoga
            if(p[i] + 1 < N && arr[p[i]] == arr[p[i] + 1]) ipv-- ; // same agar next char se same hoga toh woh bhi resolve hoga.
            
            // now change kardo ab.
            arr[p[i]] = '?' ;
            if(ipv == 0) return i + 1 ; // returning current day such that all violation is resolved
        }
        
        return 0 ;
     }
}
