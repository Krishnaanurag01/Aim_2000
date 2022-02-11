package Arrays_and_string_level_02;

public class Q17_Maximum_Product_of_Three_Numbers {

    public int maximumProduct(int[] arr) {
        
        int min1 = Integer.MAX_VALUE ;
        int min2 = Integer.MAX_VALUE ;
         
         int max1 = Integer.MIN_VALUE ;
         
         int max2 = Integer.MIN_VALUE ;
         
         int max3 = Integer.MIN_VALUE ;
         
         
         for(int i = 0 ; i < arr.length ; i++){
             
             int val = arr[i] ;
             
             if(val > max1){
                 max3 = max2 ;
                 max2 = max1 ;
                 max1 = val  ;
             }
             else if(val > max2){
                 max3 = max2 ;
                 max2 = val ;
             }
             else if(val > max3){
                 max3 = val ;
             }
             
             if(val < min1 ){
                 min2 = min1 ;
                 min1 = val ;
             }
             else if(val < min2){
                 min2 = val ;
             }
         }
         
         // if array has two negative element then check their product with max number and also compare all the three max.
         return Math.max(min1*min2*max1 , max1*max2*max3) ;
         
         
     }
     
}
