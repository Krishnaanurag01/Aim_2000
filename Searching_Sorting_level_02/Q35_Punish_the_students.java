package Searching_Sorting_level_02 ;
public class Q35_Punish_the_students {

    public static int shouldPunish (int roll[], int marks[], int n, double avg)
    {
       int count = 0 ;

       // using binary sort for calculating total swaps
       
       for(int i = 1 ; i < n ; i++){
           
           for(int j = 0 ; j < n-i ; j++ ){
               
               if(roll[j] > roll[j+1]){
                   
                   count += 2 ; // becuase we are swapping two students.
                   int temp = roll[j] ;
                   roll[j] = roll[j+1] ;
                   roll[j+1] = temp ;
               }
           }
       }
       
       int total_marks = 0; 
      
       
       for(int val : marks){
           total_marks += val ;
       }
       
    //   System.out.println(count) ;
       
       if((total_marks - count)/n > avg){
           return 1 ;
       }
       
       return 0 ;
    }
    
}
