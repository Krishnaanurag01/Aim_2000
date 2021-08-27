package Searching_and_Sorting;

import java.util.Scanner;

/**
 * Q33_DoubleHelix_SPOJ
 */
public class Q33_DoubleHelix_SPOJ {

      // its simply two pointers approach.
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        while (true) {
            
            int size1 = sc.nextInt();
            if(size1 == 0) break;
            int[] sequence1 = new int[size1];
            
            for (int i = 0; i < sequence1.length; i++) {
                sequence1[i] = sc.nextInt();
            }
    
            int size2 = sc.nextInt();
            int[] sequence2 = new int[size2];
    
            for (int i = 0; i < sequence2.length; i++) {
                sequence2[i] = sc.nextInt();
            }
    
            getMaxSum(sequence1, sequence2);
        }
    }

    public static void getMaxSum(int[] sequence1 , int sequence2[]) {
        

        int i = 0 ;
        int j = 0 ;
        int ans = 0;
        int sum1 = 0;
        int sum2 = 0 ;

        while (i < sequence1.length && j < sequence2.length) {
            
            if(sequence1[i] == sequence2[j]){

                ans = ans + Math.max(sum1, sum2) + sequence1[i];
                sum1 = 0 ;
                sum2 = 0 ;
                i++;
                j++;
            }
            else if(sequence1[i] < sequence2[j]){
                sum1 += sequence1[i];
                i++;
            }
            else{
                sum2 += sequence2[j] ;
                j++ ; 
            }

           

        }
    

        while (i < sequence1.length) {
            sum1 += sequence1[i++];
        }

        while (j < sequence2.length) {
            sum2 += sequence2[j++];
        }

        ans = ans + Math.max(sum1 , sum2) ;

        System.out.println(ans);

    }
}