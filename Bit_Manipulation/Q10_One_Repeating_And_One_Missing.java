package Bit_Manipulation;
import java.util.Scanner;

public class Q10_One_Repeating_And_One_Missing {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
          arr[i] = scn.nextInt();
        }
        solution(arr);
        scn.close();
      }

      // Application of Q9
    
      public static void solution(int[] nums){
    
            int mask = 0 ;
            
            for(int val : nums)
                mask = mask ^ val;
            
            // adding duplicate from 1 to N so now it becomes previous question as it contains two numbers where one number has 3 occurance and another has one occurance so after xor both number will have only one occurance
    
            for(int i = 1 ; i <= nums.length ; i++){
              mask = mask ^ i ;
            }
    
           
            int rsb = mask & -mask ; // got the right most set bit.
            
            int num1 = 0 ;
            int num2 = 0 ;
    
            for(int val : nums){
                if( (rsb & val) == 0){
                    /// means set bit does not matched.
                    num2 = num2 ^ val ;
                }
                else{
                    num1 = num1 ^ val ;
                }
            }
    
            // also masking for externally added numbers
            for(int val = 1 ; val <= nums.length ; val++ ){
                if( (rsb & val) == 0){
                    /// means set bit does not matched.
                    num2 = num2 ^ val ;
                }
                else{
                    num1 = num1 ^ val ;
                }
            }
    
    
            // now checking which number is repeating and which one is missing
    
            for(int num : nums){
              if(num == num1){
                System.out.println("Missing Number -> "+ num2);
                System.out.println("Repeating Number -> "+ num1);
                break;
              }
              else if(num == num2){
                System.out.println("Missing Number -> "+ num1);
                System.out.println("Repeating Number -> "+ num2);
                break;
              }
            }
       
      }
    
}
