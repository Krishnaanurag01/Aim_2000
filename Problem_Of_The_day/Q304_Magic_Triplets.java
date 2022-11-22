package Problem_Of_The_day ;

public class Q304_Magic_Triplets {
    
    public int countTriplets(int[] nums){
        
        int ans=0;
	    for(int j=0;j<nums.length;j++) { // this is the mid value.
	        int small =0;
	        for(int i=0;i<j;i++) { // now from 0 to less than jth index counting small value for i 
	            if(nums[i]<nums[j]) small++;
	        }
	        
	        int large =0;
	        for(int k=j+1;k<nums.length;k++) {  // counting greater value from j+1 to n index for k
	            if(nums[j]<nums[k]) large++;
	        }
	        ans+=(small*large); // and adding their product in count.
	    }
	    return ans;
    }
}
