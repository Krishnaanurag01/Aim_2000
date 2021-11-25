package Problem_Of_The_day;

import java.util.Arrays;

public class Q14_Minimum_sum {


    public static void main(String[] args) {
        
        int[] arr = {6, 8, 4, 5, 2, 3} ;

       String ans = solve(arr, arr.length) ;

       System.out.println(ans);
        
    }

    static String solve(int[] arr, int n) {
        // code here

        Arrays.sort(arr);

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder() ;

        for (int i = 0 , j = 1; i < arr.length; i += 2 , j += 2) {
            
            // System.out.println(arr[i]);

            sb1.append(arr[i]) ;

            if( j < arr.length)
            sb2.append(arr[j]) ;

            // System.out.println(arr[j]);
        }

        return add_numbers(sb1.toString() , sb2.toString()) ;
    }

    private static String add_numbers(String s1, String s2) {

        StringBuilder sb = new StringBuilder() ;

        int i = s1.length() - 1 ;
        int j = s2.length() - 1 ;
        int carry = 0 ;

        while (i >= 0 && j >= 0) { // adding both char of s1 and s2.
            
            int sum = s1.charAt(i) - '0' + s2.charAt(j) - '0' + carry ; // calculating sum

            carry = sum / 10 ; // getting carry

            if(sum > 0){ // adding sum to sb
             sb.append(sum % 10) ;
            }

            i-- ;
            j-- ;
        }


        while (i >= 0) { // if s1 left with numberse then add it to the sb

            int sum = s1.charAt(i) - '0' + carry ;

            carry = sum / 10 ;

            if(sum > 0){
                sb.append(sum % 10) ;
            }

            i-- ;
            
        }

        while (j >= 0) { // if s1 left with numberse then add it to the sb

            int sum = s2.charAt(j) - '0' + carry ;

            carry = sum / 10 ;

            if(sum > 0){
                
                 sb.append(sum % 10) ;
            }
            
            j-- ;
            
        }


        if( carry > 0){
         
            sb.append(carry);
        }


        return sb.reverse().toString();
    }
    
}
