package HashMaps_and_Heaps_Level_02 ;
import java.util.*;

public class Q7_Largest_Subarray_With_Contiguous_Elements {


    public static int solution(int[] arr) {
	
		int n = arr.length ;

		int ans = 0 ;

		for(int i = 0 ; i < n - 1 ; i++ ){

            /// taking min and max 
			int min = arr[i] ;
			int max = arr[i] ;

            // using set for removing the duplicacy
			HashSet<Integer> set = new HashSet<>() ;
			set.add(min) ;

			for (int j = i+1 ; j < n ; j++) {

                // if this element already exist then break the subarray

				if(set.contains(arr[j]))
				break ;

				set.add(arr[j]) ;				// else add for detecting duplicacy

				min = Math.min(min,arr[j]);
				max = Math.max(max,arr[j]);


                // here max - min denotes the contiguous subarray and j-i denotes same number of element present so updatimg the answer 
				if(max - min == j-i ){
					ans = Math.max(ans, j-i+1) ; // updating with length
				}
			}
		}

		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
        scn.close();
	}
    
}