package Greedy;

import java.util.Arrays;

public class Q2_Activity_Selection {
    
    static class Pair implements Comparable<Pair>{
        int fs ; // start day
        int sd ;  // end day
        
        Pair(int v1 , int v2){
            fs = v1 ;
            sd = v2 ;
        }
        
        
        public int compareTo(Pair obj){ // comparision based on end day
            return this.sd - obj.sd ;
        }
    }
    
     public static int activitySelection(int start[], int end[], int n)
     {
         
         Pair[] pArr = new Pair[n] ;
        
        for(int i = 0 ; i < n ; i++){
            pArr[i] = new Pair(start[i],end[i]) ; // making a pair of start and end day and pushing to new array.
        }
        
        Arrays.sort(pArr) ; // now sorting it based on end day value
        
        int c = 1 ; // took 1 by default
        int j = 0 ; // this will represent the index of last activity.
        
        for(int i = 1 ; i < n ; i++){ // now starting from 1 as we already considered first activity and counted c = 1.
            if(pArr[i].fs > pArr[j].sd){ // checking if start  day of new activity is greater than end day of last activity then it will be considered.
                c++ ; // so incrementing count and 
                j = i ; // updating last index of activity.
            }
        }
        
        return c ;
     }
}
