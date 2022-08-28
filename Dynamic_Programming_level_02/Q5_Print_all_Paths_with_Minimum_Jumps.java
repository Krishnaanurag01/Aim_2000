package Dynamic_Programming_level_02;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class Q5_Print_all_Paths_with_Minimum_Jumps {

    public static void main(String[] args) {
        
    }


    // this will help in printing the path.
    static class pair{
        int index,size,jumps ;
        String path ;

        public pair(int i , int s , int j , String str) {
            index = i ;
            size = s ; 
            jumps = j ;
            path = str ;
        }
    }

    public static void print_path(int[] arr) {
        
        int n = arr.length ;
        Integer[] dp = new Integer[ n ] ;

        dp[n-1] = 0 ; // on last stair it won't jump.

        // first finding the path and storing it to the dp.
        for (int i = n-2 ; i >= 0; i--) {
            int min = Integer.MAX_VALUE ; // this will find the min .
            for (int j = 1 ; j <= arr[i] && i + j < dp.length ; j++) { // now going to 1 - arr[i] and fetching min value.
                if(dp[i+j] != null){
                    min = Math.min(min, dp[i+j]) ;
                }
            }
            if(min != Integer.MAX_VALUE){ // if min is not integer max then it is changed.
                dp[i] = min + 1 ; // so ad it to the dp with + 1(this denotes current jump + min jump.)
            }
        }

        // System.out.println(dp[0]);
        ArrayDeque<pair> queue = new ArrayDeque<>() ; // this acts like a bfs.
        queue.add( new pair(0, arr[0], dp[0], 0+"") ) ; // storing first pair of 0th index. (this 0+"" store the path to the end.)

        while (queue.size() > 0) {
            pair rpair = queue.removeFirst() ; // removing first pair.
            if(rpair.jumps == 0){ // if its jump becomes 0 then it means it reached the end so print it.
                System.out.println(rpair.path +" .");
            }

            // now starting loop from 1 to rpair.size(acts as arr[i] which we used as size) and rpair.index  + i is condition so that we'll not go beyond the loop.
            for (int i = 1 ; i <= rpair.size && rpair.index + i < dp.length ; i++) { 

                // now adding the pairs .
                
                int ci = rpair.index + i ; // storing current index.
                if(dp[ci] != null && dp[ci] == rpair.jumps - 1 ){ // checking if current index is not null and its dp value is rpair.jump-1 ( this means rpairs.jump made up by finding the min jump + 1 jump from its index so if we substract 1 jump of itself then we'll be able to find the previous jump value). then add this by making new pair.
                    queue.add( new pair(ci, arr[ci] , dp[ci] , rpair +" -> "+ci) ) ; // making pair of current index , current index array size, it dp jump,and adding to the path.
                }
            }

            
        }


    }


    public static void print_path2(int[] arr) {
        
       int n = arr.length ;
       Integer[] dp = new Integer[n] ;

       dp[n-1] = 0 ;

       for (int i = n-2 ; i >= 0 ; i--) {
           int step = arr[i] ;
           int min = Integer.MAX_VALUE ;

           for (int j = 1 ; j <= step && i + j < dp.length ; j++) {
               if(dp[i+j] < min){
                   min = dp[i+j] ;
               }
           }

           if(min != Integer.MAX_VALUE){
               dp[i] = min + 1 ;
           }
       }

       LinkedList<pair> q = new LinkedList<>() ;
       
       q.add( new pair(0, arr[0], dp[0], 0 +"") );

       while (q.size() > 0) {
           pair rp = q.removeFirst() ;

           for (int i = 1 ; i <= rp.size && rp.index + i < dp.length ; i++) {
               if (dp[i+rp.index] != null && dp[i + rp.index] == rp.jumps - 1 ) {
                   q.addLast(new pair(i+rp.index, arr[i+rp.index], dp[i+rp.index], rp.path + " -> " + i));
               }
           }
       }

    }
    
}
