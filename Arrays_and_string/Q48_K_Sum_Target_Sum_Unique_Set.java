package Arrays_and_string;
import java.util.*;

public class Q48_K_Sum_Target_Sum_Unique_Set {


    public static void main(String[] args) {
        
        int[] arr = {-1,0,1,2,-1,-4} ;
        int target = 0 ;
        int k = 3 ;

        Integer[] arr2 = {-1,0,1,2,-1,-4} ;
        Arrays.sort(arr2);
        System.out.println(Arrays.deepToString(arr2));


      System.out.println(  kSum(arr, target, k) ) ;

    }

    public static List<List<Integer>> kSum(int[] arr, int target, int k) {


        if(k > arr.length) return null ;
       Arrays.sort(arr);

       return  helper(arr,0,target,k) ;

    }

    private static List<List<Integer>> helper(int[] arr, int si ,int target, int k) {

        if( k == 2){ // denotes two sum that is base case.

            // normal 2 sum unique path problem solved here
            int i = si ;
            int j = arr.length - 1 ;

            List<List<Integer>> ans = new ArrayList<>() ;

            while (i < j) {

                if( i != si && arr[i] == arr[i-1]){
                    i++ ;
                    continue ;
                }

                int sum = arr[i] + arr[j] ;

                if(sum == target){
                    List<Integer> in = new ArrayList<>() ;
                    in.add(arr[i]) ;
                    in.add(arr[j]) ;

                    ans.add(in) ;
                    i++ ;
                    j-- ;
                }
                else if(sum < target){
                    i++ ;
                }
                else{
                    j--;
                }
                
            }

            return ans ;
        }

        // int i = si ;

        List<List<Integer>> original_ans = new ArrayList<>() ;

        for(int i = si ; i <= arr.length - k ; i++ ){

            if(i != si && arr[i] == arr[i-1])
            continue ;

           List<List<Integer>> temp =  helper(arr, i+1, target - arr[i], k-1); // getting answer from k-1 sum

           if(temp.size() != 0){ // if the answer is not empty then it means we have found a pair


            // so traverse into each list and add to new answer.
            for (int j = 0; j < temp.size() ; j++) {
                
                List<Integer> ni = new ArrayList<>() ;

                ni.add(arr[i]) ;
                // System.out.println(ni);
                ni.addAll(temp.get(j)) ;
                // System.out.println(ni);

                original_ans.add(ni) ;
            }



           }
        }

        return original_ans ;

    }
    
    
}
