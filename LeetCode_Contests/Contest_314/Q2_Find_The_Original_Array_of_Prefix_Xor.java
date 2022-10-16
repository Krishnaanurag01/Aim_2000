package LeetCode_Contests.Contest_314;

public class Q2_Find_The_Original_Array_of_Prefix_Xor {

    public int[] findArray(int[] pref) {
        int[] ans = new int[pref.length] ;
        ans[0] = pref[0] ; 
        
        int mask = ans[0] ;
        for(int i = 1 ; i < pref.length ; i++){
            int val = mask ^ pref[i] ;
            ans[i] = val ;
            mask = mask ^ val ;
        }
        
        return ans ;
    }
}
