package Problem_Of_The_day;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Q10_Activity_Selection {

    static class Pair{
        int first ;
        int second ;

        Pair(int start , int end){
            first = start ;
            second = end ;
        }
    }
    public static int activitySelection(int start[], int end[], int n)
    {
        ArrayList<Pair> ans = new ArrayList<>() ;

        PriorityQueue<Pair> queue = new PriorityQueue<>( (a,b) -> a.second - b.second ) ;

        for (int i = 0; i < end.length; i++) {
            queue.add( new Pair(start[i], end[i])) ;
        }

        Pair FirstPair = queue.poll() ;

        int start_value = FirstPair.first ;
        int finish_value = FirstPair.second ; 
        ans.add( new Pair(start_value, finish_value)) ;

        while ( !queue.isEmpty() ) {
            Pair removed_pair = queue.poll() ;

            if(removed_pair.first >= finish_value){
                finish_value = removed_pair.second ;
                start_value = removed_pair.first ;

                ans.add(new Pair(start_value, finish_value)) ;
            }
        }


        return ans.size() ;
    }
    
}
