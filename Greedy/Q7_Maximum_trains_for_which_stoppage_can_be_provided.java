package Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q7_Maximum_trains_for_which_stoppage_can_be_provided {

    public static void main(String[] args) {
        int arr[][] = { {1000, 1030, 1},
            {1010, 1020, 1},
            {1025, 1040, 1},
            {1130, 1145, 2},
            {1130, 1140, 2} 
        };


        get_max_train(arr);

    }


    static class Pair implements Comparable<Pair> {

        int st ;
        int et ;
        int pl ;

        Pair(int x , int y , int z){
            st = x ;
            et = y ;
            pl = z ;
        }

        @Override
        public int compareTo(Pair o) 
        {
            return this.et - o.et;
        }


        
    }

    public static void get_max_train(int[][] arr) {

        int platform = 0 ; // max number of platform.

        for (int[] is : arr) {
            platform = Math.max(platform, is[2]) ;
        }

        // Arrays.sort(arr , (a,b) -> a[1] - b[1]);

        System.out.println( Arrays.deepToString(arr) );

        int ans = 0 ;

        for (int i = 1 ; i <= platform; i++) {
            PriorityQueue<Pair> q = new PriorityQueue<>() ; // making pq for every platform and then calculating train.
            for (int j = 0; j < arr.length; j++) {
                if(arr[j][2] == i){
                    q.add( new Pair(arr[j][0], arr[j][1], arr[j][2] ) );
                }
            }

            int c = 0 ;
            int last_depart = 0 ;
            while (!q.isEmpty()) {
                Pair rp = q.poll() ;

                if(rp.st >= last_depart){
                    c++ ;
                    last_depart = rp.et ;
                }
            }
            
            ans += c ;
            
        }

        System.out.println( ans );
        
    }

        
    
}
