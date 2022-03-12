package HashMaps_and_Heaps_Level_02;
import java.util.* ;

public class Q32_Longest_Subarray_With_Equal_Number_Of_0s_1s_And_2s {

    public static int solution(int[] arr) {
        
        HashMap<String,Integer> map = new HashMap<>() ;

        int countz = 0 ; // count of zero
        int counto = 0 ; // count of one
        int countt = 0 ; // count of two

        int delta10 = counto - countz ; // difference of count 1 - count 0 
        int delta21 = countt - counto ; // difference of count 2 - count 1 

        String key = delta10 + "#" + delta21 ; // generating a key
        map.put(key,-1) ; // denotes this key came on -1 index or initially.

        int ans = 0 ;
        for (int i = 0; i < arr.length ; i++) {

            if( arr[i] == 0 )
            {
                countz++ ;
            }
            else if( arr[i] == 1){
                counto++ ;
            }
            else{
                countt++ ;
            }

            delta10 = counto - countz ;
            delta21 = countt - counto ;

            String tempKey = delta10+ "#" + delta21 ; // generating new key

            if(map.containsKey(tempKey)){ // if it is available then calculate the length else put in map
                ans = Math.max(ans, i - map.get(tempKey)) ;
            }
            else{
                map.put(tempKey,i) ;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
        scn.close();
    }
    
}
