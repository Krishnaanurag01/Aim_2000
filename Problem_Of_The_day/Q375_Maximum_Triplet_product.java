package Problem_Of_The_day ;
public class Q375_Maximum_Triplet_product {

    Long maxTripletProduct(Long arr[], int n)
    {
        long max1 = (int)-1e9 , max2= (int)-1e9, max3 = (int)-1e9 ;
        long min1 = (int)1e9 , min2 = (int)1e9 , min3 = (int)1e9 ;
        
        for(long val : arr){
            // max 
            if(val > max1){
                max3 = max2 ;
                max2 = max1 ;
                max1 = val ;
            }
            else if(val > max2){
                max3 = max2 ;
                max2 = val ;
            }
            else if(val > max3){
                max3 = val ;
            }
        
            
            // min         
            if(val < min1){
                min3 = min2 ;
                min2 = min1 ;
                min1 = val ;
            }
            else if(val < min2){
                min3 = min2 ;
                min2 = val ;
            }
            else if(val > min3){
                min3 = val ;
            }
        }
            
            
            return Math.max(max1*max2*max3, max1*min1*min2) ;
    }
}