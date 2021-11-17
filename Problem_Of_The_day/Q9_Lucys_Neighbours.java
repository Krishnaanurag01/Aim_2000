package Problem_Of_The_day ;

import java.util.*;

/**
 * Q9_Lucys_Neighbours
 */
public class Q9_Lucys_Neighbours {

    public static void main(String[] args) {
        
        int[] arr = {-21, 21, 4, -12, 20};

        Kclosest(arr,0,0,4);
    }

    static class Pair implements Comparable<Pair>{
        int value ;
        int index ;

        Pair(int value , int idx){
            this.value = value ;
            this.index = idx ;
        }

        @Override
        public int compareTo(Pair o) {
           
            return this.value - o.value ;
        }
    }

    public static ArrayList<Integer> Kclosest(int arr[], int n, int x, int k) 
	{ 
	   
        Arrays.sort(arr);

        Pair[] list = new Pair[arr.length] ;

        for (int i = 0; i < arr.length; i++) {
            list[i] = new Pair( Math.abs( arr[i] - x ) , i ) ;
        }

        Arrays.sort(list);

        ArrayList<Integer> ans = new ArrayList<>() ;

        for (int i = 0; i < k ; i++) {
            ans.add( arr[ list[i].index ]);
        }

        Collections.sort(ans);
	    return ans;
	}
}