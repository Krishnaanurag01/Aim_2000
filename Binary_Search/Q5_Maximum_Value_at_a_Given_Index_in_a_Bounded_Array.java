package Binary_Search;

public class Q5_Maximum_Value_at_a_Given_Index_in_a_Bounded_Array {

    public int maxValue(int n, int index, int maxSum) {
        
        long low = 1 ; // as array have only positive value so low will be 1 atleast.
        long high = maxSum ;
        long ans = 0 ;
        
        while(low <= high){
            long mid = low + (high - low)/2 ; // this is value that we will assign to the given index and check the total sum of array.
            
            long sum = getSum(n,index,mid) ;
            
            if(sum <= maxSum){ // if we can make this array using mid then try to find the max value.
                ans = mid ;
                low = mid + 1 ;
            }
            else if(sum > maxSum){
                high = mid - 1;
            }
        }
        
        return (int)ans ;
    }
    
    long getSum(int size, int idx, long mid){
        
        long left = idx ; //left side size of array.
        long right = size - idx - 1; // right side size of the array.
        long sum = mid ; // current sum (taking value at idx in sum by default)
        
        // now we have to assign values to left and right side of the array. as the abs diff between current element and next element is <= 1 so left and right side of element must be either decreasing or same as current value.
        // so in order to get min sum we will decrease the value till 1 and after that we will assign 1 value to everyone.
        
        if(left > 0 ){ 
            long decreasing = mid - 1 ; // matlab agar mid 3 hai toh eske left me 2 values aa saktey i.e 1 aur 2.
            // toh we are checking kitne values aa saktey .
            if(left <= decreasing){ // agar left me jitne blocks chahiy ussey jyda ya equal blocks hai hai decreasin k paas tb. ex : mid 3 hai aur eske bagal me 2 blocks aa saktey with value 1 and 2. aur left me bas 1 he block chaiy toh hum 2 assing karenge kyuki abs diff 1 ya 0 ka chahiy.
                
                long notUsed = total(decreasing - left); // yha hum check kar rhe ki agar left ko kam blocks chahiy toh kitne ko hatana padega.
                
                long temp = total(mid - 1) ; // aur yha hum total sum find kar rhe 2 blocks ka i.e 1 + 2 -> 3
                sum += (temp - notUsed) ; // lekin agar hume bas 2 he chahiy aur 1st block with value 1 nhhi chaiy toh uskoo hata do.
            }
            else{ // jab left bada h.
                long remaining = left - decreasing ; // toh check karo kitne aur blocks chahiy ex: mid 3 hai toh uske bagal me 2 block 1 aur 2 aa saktey leking in case agar left me 3 block cchahiy toh first block 1 hoga jo ki same hoga next block k aur sare block aise honge -> 1 , 1, 2 ,3
                long temp = total(decreasing) ;
                sum += temp + remaining ; // baaki jitne blocks honge sabko 1 assign kar do.
            }
        }
        
        
        // same as left logic.
        if(right > 0){
            
            long decreasing = mid - 1 ;
            if(right <= decreasing){
                long notUsed = total(decreasing - right);
                long temp = total(mid - 1) ;
                sum += (temp - notUsed) ;
            }
            else{ // jab bada h.
                long remaining = right - decreasing ;
                long temp = total(decreasing) ;
                sum += temp + remaining ;
            }
        }
        
        
        return sum ;
    }
    
    long total(long num){ // this is the formula for finding total sum of n values. (i.e  n*(n+1)/2)
        return (num*(num+1))/2;
    }
}
