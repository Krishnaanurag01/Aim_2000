package Problem_Of_The_day;

public class Q95_Sign_of_the_Product_of_an_Array {

    public int arraySign(int[] nums) {
        
        // instead of calculating product we are finding the positivity and negativity and zero operator after calculation.
        int flag = 1 ; 
        for(int val : nums){
            if((val < 0 && flag == 1) || (val > 0 && flag == -1)) flag = -1 ;
            else if( (val < 0 && flag < 0) || (val > 0 && flag > 0)) flag = 1 ;
            else{
               return  0 ;
            }
            
        }
        return flag ;
    }
}
