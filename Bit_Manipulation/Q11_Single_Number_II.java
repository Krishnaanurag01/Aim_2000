package Bit_Manipulation;

public class Q11_Single_Number_II {
    
    public int singleNumber(int[] nums) {

        // tn -> 3n 
        // tnp1 -> 3n+1
        // tnp2 -> 3n+2
        
        int tn = -1 ; // tn
        int tnp1 = 0 ; //tn plus 1
        int tnp2 = 0 ; // tn pplus 2
        
        for(int i = 0 ; i < nums.length ; i++){
            
            // finding common
            int cwtn = tn & nums[i] ; // count of tn 
            int cwtn1 = tnp1 & nums[i] ; // count og tn plus 1
            int cwtn2 = tnp2 & nums[i] ; // fro tn plus 2
            
            tnp1 = tnp1 | cwtn ; // turning on common bit in 3n+1 and
            tn = tn & (~cwtn) ; // turning off common bit
            
            tnp2 = tnp2 | cwtn1 ;
            tnp1 = tnp1 & (~cwtn1) ;
            
            tn = tn | cwtn2 ;
            tnp2 = tnp2 & (~cwtn2) ;
        }
        // System.out.println(tnp1) ;
        return tnp1 ;
    }
}
