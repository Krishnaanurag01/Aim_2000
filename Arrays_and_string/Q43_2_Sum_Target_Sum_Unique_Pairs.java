package Arrays_and_string;
import java.util.*;

public class Q43_2_Sum_Target_Sum_Unique_Pairs {

    // method 01:

    public static List<List<Integer>> twoSum(int[] arr, int target) {
        // write your code here

        List<List<Integer>> list = new ArrayList<>() ;
        HashSet<Integer> visited = new HashSet<>() ;

        Arrays.sort(arr);

        int i = 0 ;
        int j = arr.length - 1;

        while (i < j ) {

            if(visited.contains(arr[i])){
                i++ ;
            }
            else if( visited.contains(arr[j]) ){
                j-- ;
            }
            else if(  arr[i] + arr[j] == target ){

                List<Integer> in = new ArrayList<>() ;
                in.add(arr[i]) ;
                in.add(arr[j]) ;
                list.add( in ) ;
                
                visited.add(arr[i]) ;
                visited.add(arr[j]) ;

                i++ ;
                j-- ;
            }
            else if(arr[i] + arr[j] < target){
                i++ ;
            }
            else{
                j-- ;
            }        
        }




        return list ;
    }

    // method 02 :

    public static List<List<Integer>> twoSum2(int[] arr, int target) {
        // write your code here

        List<List<Integer>> list = new ArrayList<>() ;

        Arrays.sort(arr);

        int i = 0 ;
        int j = arr.length - 1;

        while (i < j ) {

            if( i > 0 && arr[i] == arr[i-1]){
                i++ ;
            }
            else if( arr[i] + arr[j] == target ){

                List<Integer> in = new ArrayList<>() ;
                in.add(arr[i]) ;
                in.add(arr[j]) ;
                list.add( in ) ;

                i++ ;
                j-- ;
            }
            else if(arr[i] + arr[j] < target){
                i++ ;
            }
            else{
                j-- ;
            }        
        }




        return list ;
    }


    
}
