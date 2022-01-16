package Arrays_and_string;


public class Q38_Maximum_Swap {

    public static void main(String[] args) {
        
        maximumSwap2(8394) ;
    }

    // public static int maximumSwap(int num) {
        
    //     TreeMap<Integer,Integer> map = new TreeMap<>( Collections.reverseOrder() ) ;

    //     Integer[] arr = new Integer[String.valueOf(num).length()] ;
        
    //     int temp = num ;
    //     for(int i = String.valueOf(num).length() - 1 ; i >= 0; i--){
    //         int digit = temp % 10 ;
    //         map.put(digit, i) ;
    //         arr[i] = digit ;
    //         temp = temp/10 ;
    //     }

    //     System.out.println(Arrays.deepToString(arr)) ;

    //     for (int i = 0; i < arr.length; i++) {
            
            
    //         if(arr[i] < (int) map.firstKey()){
    //             // System.out.println(map.firstKey());
    //             int t = arr[i] ;
    //             arr[i] = map.firstKey() ;
    //             arr[map.get(map.firstKey())] = t ;
    //             break ;
    //         }

    //     }
        
    //     System.out.println(Arrays.deepToString(arr)) ;


        
        
    //     return  0 ;
        
    // }


    // method 02 :

    public static int maximumSwap2(int num) {
        
       String val = String.valueOf(num) ;

       char[] arr = val.toCharArray() ;
       int[] li = new int[10] ; // stores last index of 

       for (int i = 0; i < arr.length ; i++) {
           int digit = arr[i] - '0';
        //    System.out.print(digit);
           li[digit] = i ;
       }

       boolean flag = false ;
       for (int i = 0; i < arr.length ; i++) {
             int digit = arr[i] - '0';
           for (int j = 9 ; j > digit ; j--) {
               
                if(li[j] > i){
                
                    char temp = arr[i] ;
                    arr[i] = arr[ li[j] ] ;
                    arr[ li[j] ]  = temp ;
                    flag = true ;
                    break ;
                }
           }

           if(flag){
               break ;
           }
       }

       String ans = "" ;

       for (int i = 0; i < arr.length ; i++) {
           ans += arr[i] ;
       }
        

    //    System.out.println(ans);



       return Integer.parseInt(ans) ;
    }
    
}
