package Arrays_and_string;

public class Q7_Next_Greater_Element_III {

    public static void main(String[] args) {
        
       System.out.println( nextGreaterElement(321) ) ;
    }

    public static int nextGreaterElement(int n) {
        
        
        int[] arr = new int[ String.valueOf(n).length() ] ;

        for (int i = arr.length - 1 ; i >= 0; i--) {  // storing number into array
            arr[i] = n%10 ;
            n = n/10 ;
        }
        

        int s = -1 ;
        
        for(int i = arr.length-2 ; i >= 0 ; i--){
            
            if(arr[i+1] > arr[i]){  // finding the first number which is smaller than arr[i+1]
                s = i ;
                break ;
            }
        }
         
        // if we didn't find any element then return -1;
        if(s == -1) return -1;
        
    
        // if compiler reach this line then it means that we find one s index.
            
            for(int i = arr.length-1 ; i > s ; i--){  
            if(arr[i] > arr[s] ){ // finding the next greater of arr[s] from arr.length-1 to s+1 // when found first one from right most then break;
                int temp = arr[i] ;
                arr[i] = arr[s] ;
                arr[s] = temp ;
                break ;
            }    
            }
            
            // now sort from s+1 to last index.
            
            int k = arr.length-1 ;
            int m = s+1 ;
        
            // now reversing s+1 to k elements.
            while(m < k ){
                int temp = arr[m] ;
                arr[m] = arr[k] ;
                arr[k] = temp ;
                m++ ;
                k-- ;
            }
            
        
    
            // now making the number from array
        long ans = 0 ;
        long exp = 1 ;

        for (int i = arr.length - 1; i >= 0 ; i--) {
            ans += (arr[i]*exp) ;
            exp *= 10 ;
        }
        
        if(ans > Integer.MAX_VALUE){ // if the value we formed is greater then 32bit integer then return -1;
            return -1;
        }
        
        // else return value
        return (int) ans ;
    }
    
}
