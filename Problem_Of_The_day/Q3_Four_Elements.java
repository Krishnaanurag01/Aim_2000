package Problem_Of_The_day;

public class Q3_Four_Elements {

    public static void main(String[] args) {
        
    }

    static boolean find4Numbers(int A[], int n, int X) 
    {

        for (int i = 0; i < A.length - 3 ; i++) {
            
            if ( three_sum(A, i+1 , X - A[i])){
                return true ;
            }
        }
     
        


        return false ;
    }

    public static boolean three_sum(int[] arr , int i  , int x) {
        
        
        for (int m = i ; m < arr.length; m++) {

           if( check_two_sum(  arr , m , x - arr[m]) ) return true ;
        }



        return false ;

    }

    private static boolean check_two_sum(int[] arr, int i , int sum) {

        int j = arr.length - 1 ;

        while (i < j ) {
            int inner_sum = arr[i] + arr[j] ;

            if( inner_sum < sum){
                i++;
            }
            else if( inner_sum > sum ){
                j-- ;
            }
            else{
                return true ;
            }
        }
        //
        return false;
    }
    
}
