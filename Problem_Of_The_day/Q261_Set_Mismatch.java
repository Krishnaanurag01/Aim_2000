package Problem_Of_The_day ;

public class Q261_Set_Mismatch {

    public int[] findErrorNums(int[] nums) {
        
        int sum = 0 ;
        int duplicate = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            
            int val = Math.abs(nums[i]) ; // taking the current value.
            // as this val can change it's index value into negative
            
            if(nums[ val - 1] < 0) { // if it is already changed then it means same value appeared before.
                duplicate = val ; // so it is duplicate
            }
            
            sum += val ; // and also total the all value it will help in finding the missing val.
            nums[val - 1] *= -1 ; // now making the index value into negative.
        }
        
        // as Question mentioned it will containss values from 1 to n so total sum of these is N*(N+1)/2
        // and if we subtract the current sum from total and we also have to substract the duplicate from curr sum.
        
        int totalSum = (nums.length * (nums.length + 1)/2) - (sum - duplicate) ;
        
        return new int[]{duplicate,totalSum};
    }
}
