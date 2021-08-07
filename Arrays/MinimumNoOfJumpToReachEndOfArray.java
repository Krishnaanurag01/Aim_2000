package Arrays;

public class MinimumNoOfJumpToReachEndOfArray {
    public static void main(String[] args) {
        int[] arr ={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(getMinJump(arr,arr.length));
        System.out.println(getTotalJumps(arr,arr.length));
    }

// this algorithm taking extra time in traversing every element.
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


// this algorithm is much more effecient and optimized as it does not traversed every element unless and until it get the max value.

public static int getTotalJumps(int[] arr , int n) {

    int max = 0 , halt = 0 , jump =0 ;

    if(arr[0] == 0){
        return -1;
    }

    for (int i = 0; i < n-1; i++) {
        max = Math.max(max, arr[i]+1);
        
        if(max >= n-1){
            jump++;
            return jump;
        }
        if(halt == i){
            halt = max;
            jump++;
        }
    }
    
    if(halt>=  n-1){
        return jump;
    }


    return -1;
    
}
}
