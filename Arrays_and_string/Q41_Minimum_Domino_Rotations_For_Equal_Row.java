package Arrays_and_string;
import java.util.*;

public class Q41_Minimum_Domino_Rotations_For_Equal_Row {


    // method 01 :
    
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int total = tops.length ; // this denotes that we must need to swap this much element in order to have a row completely filled with same number
        
        // as dominos can have 1 to 6 numbers so making array of 7 length
        int[] arr1 = new int[7] ;
        int[] arr2 = new int[7] ;
        
        for(int i = 0 ; i < tops.length ; i++){
            int val1 = tops[i] ;
            int val2 = bottoms[i] ;
            
            if(val1 == val2){ // if both the elements are same then decrement the total
                total-- ;
                continue ;
            }

            // else increase the freq.
            
            arr1[val1]++ ;
            arr2[val2]++ ;
        }
        
        int ans = Integer.MAX_VALUE ;
        
        ArrayList<Integer> list = new ArrayList<>() ; // this will contain the potential numbers
        
        for(int i = 0 ; i < arr1.length ; i++){
            if(arr1[i] + arr2[i] == total){ // if freq for i in both the array equal to total then add it to the list
                list.add(i) ;
            }
        }
        
        // System.out.println(list) ;
        
        int rest = tops.length - total ; // this denotes that as we already have element which equals to total and this total got redued when same element appears in top and down array. so this will contains count of elements which comes in same index in both the arrays.
        
        // System.out.println(rest) ;

        for(int i : list){ // check for potential ans
            int count = 0 ;
            for(int k = 0 ; k < tops.length ; k++){
                if( i == tops[k] && tops[k] == bottoms[k]){ // if the same element of top and bottom equals to potential ans then increase the count
                    count++ ;
                }
            }
            
            if(count == rest){ // if the count of potential ans is  equals to rest then update the ans and break
                // System.out.println(count + " " + rest) ;
                ans = Math.min(arr1[i],arr2[i]);
                break ;
            }
        }
         
    
        return ans == Integer.MAX_VALUE ? -1 : ans ;
        
    }

}
