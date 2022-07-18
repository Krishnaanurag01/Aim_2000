package Problem_Of_The_day;

public class Q99_Move_Zeroes {
    
    public void moveZeroes(int[] nums) {
        
        int lzero = -1 ; // index of last zero
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0 && lzero == -1) lzero = i ; 
            else if(nums[i] != 0 && lzero >= 0){
                int k = lzero + 1 ;
                nums[lzero] = nums[i];
                nums[i] = 0 ;
                lzero = -1 ;
                while(k <= i && nums[k] != 0) k++ ;
                if(k > i) continue ;
                else lzero = k ;
            }
        }
    }
}
