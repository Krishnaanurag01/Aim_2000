package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q14_Maximum_Consecutive_Ones_1 {

    // same as Q15. only difference is here we can swap only one zeros where as in Q15 we can swap atmax k zeros.
    public static int solution(int[] arr){
        // write your code here
        
        int n = arr.length ;
        int msc = 0 ;
        int j = -1 ;
        int ans = 0 ;
        
        for(int i = 0 ; i < n ; i++){
            int num = arr[i] ;
            
            if(num == 0 ){
                msc++ ;
            }
            
            while(msc > 1){
                j++ ;
                int nj = arr[j] ;
                
                if(nj == 0)
                msc-- ;
            }
            
            ans = Math.max(ans, i - j ) ;
            
        }

        return ans;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
        scn.close();
	}
    
}
