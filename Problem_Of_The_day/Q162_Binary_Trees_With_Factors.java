package Problem_Of_The_day;
import java.util.*;

public class Q162_Binary_Trees_With_Factors {

    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer,Long>map=new HashMap<Integer,Long>();
        long ans=1;
        map.put(arr[0],ans); // storing 0th index ans as 1 by defualt because it can only make binary tree of itself
        
        for(int i=1;i<arr.length;i++)
        {
            long sum=1;
            for(int j=0;j<i;j++) // now check if any num can divde nums[i]
            {
                if(arr[i]%arr[j]==0 && map.containsKey(arr[i]/arr[j])) // if yes then find the multiplier
                    sum=sum+(map.get(arr[i]/arr[j])*map.get(arr[j])); // and get the count
            }
            map.put(arr[i],sum);
            ans=ans+sum; // also add in answer
        }
        return (int)(ans%1000000007);
    }
}
