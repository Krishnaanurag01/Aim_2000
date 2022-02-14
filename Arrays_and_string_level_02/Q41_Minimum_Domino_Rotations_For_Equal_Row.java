package Arrays_and_string_level_02;
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


    // method 02 : 


    public static int minDominoRotations2(int[] tops, int[] bottoms) {
        
        int count1 = 0  ;
        int count2 = 0  ;
        int count3 = 0  ;
        int count4 = 0  ;

        int num1 = tops[0] ;
        int num2 = bottoms[0] ;

        for(int i = 0 ; i < tops.length ; i++){

            // count 1 : no of swap required to make top as num1

            if(count1 != Integer.MAX_VALUE){
                if (tops[i] == num1) {
                    // this denotes we have already num1 in top so skip.
                    // continue ;
                }
                else if(bottoms[i] == num1){
                   
                    count1++ ;
                }
                else{
                    count1 = Integer.MAX_VALUE ;
                }

            }


            
           if(count2 != Integer.MAX_VALUE){
               
                if(bottoms[i] == num1){
                    // this denotes we have already num1 in bottom so skip.
                    // continue ;
                }
                else if (tops[i] == num1) {
                    count2++ ;
                }
                else{
                    count2 = Integer.MAX_VALUE ;
                }

            }


            
            // count 3 : no of swap required to make top as num2

            if(count3 != Integer.MAX_VALUE){
                if (tops[i] == num2) {
                    // this denotes we have already num2 in top so skip.
                    // continue ;
                }
                else if(bottoms[i] == num2){
                    // no of swap required to make top1 as num1 by swapping element of bottom
                    count3++ ;
                }
                else{
                    count3 = Integer.MAX_VALUE ;
                }

            }


            
            // count 4 : no of swap required to make bottom as num 2

            if(count4 != Integer.MAX_VALUE){
                if (bottoms[i] == num2) {
                    // this denotes we have already num2 in bottom so skip.
                    // continue ;
                }
                else if(tops[i] == num2){
                    // no of swap required to make top1 as num1 by swapping element of bottom
                    count4++ ;
                }
                else{
                    count4 = Integer.MAX_VALUE ;
                }

            }

        }

        int ans = Math.min( Math.min(count1, count2), Math.min(count3, count4)) ;


        return ans != Integer.MAX_VALUE ? ans : -1 ;
    }



}
