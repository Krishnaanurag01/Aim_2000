package Arrays;
/**
 * SmallestSubArrayWithSumGreaterThanX_Q36
 */
public class SmallestSubArrayWithSumGreaterThanX_Q36 {

    public static void main(String[] args) {
        
        int[] arr= {1, 4, 45, 6, 0, 19};
        int X= 51;
        System.out.println(getLengthOfSmallestSubArrayGreaterThanX(arr, arr.length , X));
    }
    
    public static int getLengthOfSmallestSubArrayGreaterThanX(int[] arr , int n , int x) {{

        
        int start = 0 ; 
        int end  =1 ;
        int answer = Integer.MAX_VALUE ;
        int sum  = arr[start];
        if(sum > x ) return 1;
        
        if(end < n) sum += arr[end];

        while(start < n && end < n){
            if(sum > x){
                answer = Math.min(answer, end - start +1);
                sum -= arr[start];
                start++;

            }
            else{
                end++;
                if(end < n){
                    sum += arr[end];
                }
            }
        }


    
        
        
        
        return answer;
    }
        
    }
}