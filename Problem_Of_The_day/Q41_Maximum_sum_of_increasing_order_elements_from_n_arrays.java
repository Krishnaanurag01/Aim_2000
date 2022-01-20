package Problem_Of_The_day;

public class Q41_Maximum_sum_of_increasing_order_elements_from_n_arrays {
    
    public static int maximumSum (int n, int m, int arr[][]) {
        //Complete the function
        int sum = 0 ;
        int preLargest = Integer.MAX_VALUE ;
        for(int i = n-1 ; i >= 0 ; i--){
            
            int tempMax = Integer.MIN_VALUE ;
            for(int k = 0 ; k < m ; k++){
                if(arr[i][k] > tempMax && arr[i][k] < preLargest ){
                    tempMax = arr[i][k] ;
                }
            }
            
            // preLargest = tempMax ;
            // sum += tempMax ;
            
            if(tempMax == Integer.MIN_VALUE) return 0 ;
            
            if(tempMax < preLargest){
                preLargest = tempMax ;
            }
            else{
                return 0 ;
            }
            
            sum += tempMax  ;
            //  System.out.println(sum) ;  
            
        }
        
        return sum ;
    }
}
