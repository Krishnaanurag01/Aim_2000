package Arrays_and_string;
import java.util.*;

public class Q41_Minimum_Domino_Rotations_For_Equal_Row {
    
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int total = tops.length ;
        
        int[] arr1 = new int[7] ;
        int[] arr2 = new int[7] ;
        
        for(int i = 0 ; i < tops.length ; i++){
            int val1 = tops[i] ;
            int val2 = bottoms[i] ;
            
            if(val1 == val2){
                total-- ;
                continue ;
            }
            
            arr1[val1]++ ;
            arr2[val2]++ ;
        }
        
        int ans = Integer.MAX_VALUE ;
        
        ArrayList<Integer> list = new ArrayList<>() ;
        
        for(int i = 0 ; i < arr1.length ; i++){
            if(arr1[i] + arr2[i] == total){
                list.add(i) ;
            }
        }
        
        // System.out.println(list) ;
        
        int rest = tops.length - total ;
        
        // System.out.println(rest) ;

        for(int i : list){
            int count = 0 ;
            for(int k = 0 ; k < tops.length ; k++){
                if( i == tops[k] && tops[k] == bottoms[k]){
                    count++ ;
                }
            }
            
            if(count == rest){
                // System.out.println(count + " " + rest) ;
                ans = Math.min(arr1[i],arr2[i]);
                break ;
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans ;
        
    }

}
