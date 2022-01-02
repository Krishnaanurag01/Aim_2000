package Greedy;

public class Q13_Max_product_subset {


    public static void main(String[] args) {
        
        int[] arr = new int[] {-1, -1, -2, 4, 3} ;

        System.out.println(maxProductSubset(arr, arr.length));
    }

    public static long maxProductSubset(int[] arr, int n) {
	
       
        if(arr.length == 1 ){
            return arr[0] ;
        }
        
        int mod = 1000000000-1 ;
         long product = 1 ;  // product answer 
        int CountOfNve = 0 ;// count of negative
        int largestNegative = Integer.MIN_VALUE ; // largest negative contain smallest value like -1 is largest negative where as -2 is smaller negative so if we multiply any negative number with -5 then it will give us larger value where as if we multiply -1 with any negative value then it will not give larger value so we'll keep track of it and if the total count of negative becomes odd then we'll divide then product with this value.(means we'll exclude this value)
        int zero = 0 ; // count of zero

        for (int i = 0; i < arr.length; i++) {  //-1, -1, -2, 4, 3

            if(arr[i] == 0 ){
                zero++ ;
                continue ;
            }

            product  = (product*arr[i])%mod ;

            if(arr[i] < 0 ){
                CountOfNve++ ;
                largestNegative = Math.max(largestNegative, arr[i]) ;
            }

        }

        if(CountOfNve % 2 != 0 ){ /// if negative count is odd then divide it with largest negative value so that it could becomes positve(it means we are excluding larger value from it)
            product = product/largestNegative ;
        }
        
        // if our array contains only -ve and zero and count of negative is 1 then return 0.
        if(CountOfNve + zero == n && CountOfNve == 1){
            return 0 ;
        }
        
        
        return product % mod;
	}
    
}
