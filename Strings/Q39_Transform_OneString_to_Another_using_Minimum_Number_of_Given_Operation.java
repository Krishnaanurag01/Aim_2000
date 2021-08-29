package Strings;

/**
 * Q39_Transform_OneString_to_Another_using_Minimum_Number_of_Given_Operation
 */
public class Q39_Transform_OneString_to_Another_using_Minimum_Number_of_Given_Operation {

    public static void main(String[] args) {
           String A = "EACBD"; String B = "EABCD";
           System.out.println(getMinStepForTransformation(A, B));
    }

    public static int getMinStepForTransformation(String A,String B) {
        
       if(A.length() != B.length()) return -1; // if size different return -1.

       int[] arr = new int[256];

       // this will make the frequency of each element to 0.( first add from str1 and delete from str2)
       for (int i = 0 ; i < A.length() ; i++) {
           arr[A.charAt(i)]++;  
           arr[B.charAt(i)]--;
       }

       // now check if any element of array has frequency > 0 then it means elements are different in both string.

       for (int i : arr) {
           if(i !=0) return -1; // means we can't make string A to B.
       }
       // else we'll start from end of both string and check element if it is equal then we'll move further o/w we'll add 1 in ans.(which denotes that 1 element has been taken and inserted in the front.)

       int i = A.length()-1;
       int j = B.length() -1 ;
       int ans= 0;

       while(i >= 0){
           if(A.charAt(i) != B.charAt(j)){
               ans++;
               // if they are not equal then we won't decreame j becuase we have to check the next character of i with current j.
           }
           else{
               // if there are equal then we'll also decrement j of string 2.
               j--;
           }
           i--;
       }
       return ans;
    
    }
}