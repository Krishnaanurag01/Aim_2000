package Problem_Of_The_day;

public class Q202_Check_If_Array_Pairs_Are_Divisible_by_k {

    public boolean canArrange(int[] arr, int k) {
       
        int[] remArr = new int[k] ; // remainder freq array.
        for(int val : arr){
            int remainder = (val % k + k ) % k ; // this way we can handle negative value's remainder as well.
            remArr[remainder]++ ; //  increasing the freq of remainder.
        }
        
        for(int i = 1 ; i <= k/2 ; i++){ // now if both i and n-i has same freq or not.
            if(remArr[i] != remArr[k-i]) return false;
        }
        
        if(remArr[0] % 2 != 0) return false; // in case of 0 remainder we have to check this 0 remainder must be present even times.

        
        return true;
    }
}
