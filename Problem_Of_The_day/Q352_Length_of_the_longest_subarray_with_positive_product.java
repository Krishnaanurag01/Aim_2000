package Problem_Of_The_day;

public class Q352_Length_of_the_longest_subarray_with_positive_product {
    
    int maxLength(int arr[], int n) { 
        //code here
        int strt=0,first_negative=-1,count_negative=0;
        int ans=0;
        for(int i=0;i<n;i++) {
            if(arr[i]==0) { // zero aaye to sab ko reinitialize kar do.
                strt=i+1;
                first_negative=-1;
                count_negative=0;
                continue;
            } else if(arr[i]<0) { // neg aaye toh increase the count
                count_negative++;
                if(first_negative==-1) first_negative=i; // and mark first neg index.
            }
            
            if(count_negative%2==0) { // agr neg count is even then take whole froms start to i
                ans = Math.max(ans,i-strt+1);
            } else { // else leave one neg val
                ans = Math.max(ans,i-first_negative);
            }
        }
        return ans;
    }
}
