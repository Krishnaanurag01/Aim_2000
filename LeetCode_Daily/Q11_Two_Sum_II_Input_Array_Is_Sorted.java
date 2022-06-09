package LeetCode_Daily;

public class Q11_Two_Sum_II_Input_Array_Is_Sorted {

    public int[] twoSum(int[] numbers, int target) {
        
        int i = 0 ;
        int j = numbers.length - 1 ; 
        
        while(i < j ){
            int val = numbers[i] + numbers[j] ;
            if(val > target){
                j-- ;
            }
            else if(val < target){
                i++ ;
            }
            else{
                return new int[]{i+1,j+1} ;
            }
        }
        
        return null ;
    }
}
