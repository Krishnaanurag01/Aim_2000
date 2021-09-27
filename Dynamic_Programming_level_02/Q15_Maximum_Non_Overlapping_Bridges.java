package Dynamic_Programming_level_02;

import java.util.*;

public class Q15_Maximum_Non_Overlapping_Bridges {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();  // number of pair(north and south).
        
        bridge[] arr = new bridge[n];
        
        for(int i = 0 ; i < n ; i++){
            int north = sc.nextInt();  // asking north value
            int south = sc.nextInt(); // asking south value
            
            arr[i] = new bridge(north,south) ; // made a bridge object and addit to the array.
        }
        
        print_max_non_overlapping_bridges(arr);

        sc.close(); 
        
    }


    // this class will help in solving problem.
    static class bridge implements Comparable<bridge>{
        int n ; // n : north
        int s ;  // s : south

        bridge(int n , int s){
            this.n = n ;
            this.s = s ;
        }

        @Override
        public int compareTo(bridge o) {
           if(this.n != o.n){ // when both north side are not same then sort it in ascending manner by looking north value.
               return this.n - o.n ;
           }
           else{ // else sort on south value.
               return this.s - o.s ;
           }
        }
    }



    // algo :
    /// 1>> sort north side pole of bridge (this will make north side increasing order so no overlap at north side.)
    // 2>> and perform LIS on south side pole of bridge. (and this will find the increasing sequence of south) so answer would be the value x which define that x bridges do not overlap.


    public static void print_max_non_overlapping_bridges(bridge[] bridges) {
        
        Arrays.sort(bridges); // now sorting the array

        int n = bridges.length ;



        // now doing the LIS (Q11).
        int[] dp = new int[n] ;

        int ans = 0 ;
        
        for (int i = 0; i < dp.length; i++) {
            
            int max = 0 ;

            for (int j = 0 ; j < i ; j++) {
                if(bridges[j].s <= bridges[i].s){ // here checking the south value if it is lesser than i or equals then run this else don't run.
                    max = Math.max(max, dp[j]);
                }
            }

            dp[i] = max + 1 ; // now adding 1 means adding current bridge to answer.
            ans = Math.max(ans, dp[i]) ;
        }

        System.out.println(ans);
    }
    
}
