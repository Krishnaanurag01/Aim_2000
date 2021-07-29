package Arrays;

public class MinimumNoOfJumpToReachEndOfArray {
    public static void main(String[] args) {
        int[] arr ={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(getMinJump(arr,arr.length));
    }

    public static int getMinJump(int[] arr,int n) {
        int maxReach = arr[0];
        int steps = arr[0];
        int jump = 1;
        if(n == 1){
            return 0;
        } 
        else if (arr[0] == 0 )return -1;
        else{
            for (int i = 1; i < n ; i++) {
                if(i == n-1)return jump;
                maxReach = Math.max(maxReach, i+arr[i]);
                steps--;
                if(steps == 0){
                    jump++;
                    if(maxReach <= i ){
                        return -1;
                    }
                    steps = maxReach-i;
                }                
            }
        }
        return jump;

        
    }
}
