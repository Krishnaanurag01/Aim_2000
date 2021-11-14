package Problem_Of_The_day;

import java.util.HashMap;

public class Q5_Ruling_Pair {

    public static void main(String[] args) {

        int[] arr = {55, 23, 32, 46, 88} ;
        System.out.println( RulingPair(arr, 5) );
    }
    static int RulingPair(int arr[], int n) { 
        

        HashMap<Integer,Integer> map = new HashMap<>() ;

        int max = 0 ;
        for (int i : arr) {
            int sum = getsum(i) ;
           
            if(map.containsKey(sum)){
                int previous_value = map.get(sum) ;
                max = Math.max(max, previous_value + i ) ;
                map.put(sum, Math.max(previous_value, i)) ;
            }
            else{
                map.put(sum, i ) ;
            }
        }

        // for (Map.Entry e : map.entrySet()) {
        //     ArrayList<Integer> inner = (ArrayList<Integer>) e.getValue() ;

        //     System.out.println(inner);
        // }
        //



        return max ;
	}  
    

    public static int getsum(int n) {
        
        int sum = 0 ;

        int mod = 10 ;
        int m = 1 ;
        for (int i = 0; i < String.valueOf(n).length() ; i++) {
            sum += (n  / m ) % mod ;
            m *= 10 ;

            // System.out.println( sum );
        }

        return sum ;
    }
}
