package LeetCode_Contests.Contest_328;
import java.util.*;

public class Q3_Count_the_Number_of_Good_Subarrays {

    public long countGood(int[] nums, int k) {
        long ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // stores freq of every element.
        int i = -1; // will  used to pick element 
        int j = -1; // will drop this element in below strategy
        int psf = 0; // pair so far.
        int n = nums.length ;

        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            while (i < nums.length - 1 && psf < k) { // tab to pick karo jab tak pair lesser hai.
                i++;
                int val = nums[i];
                map.put(val, map.getOrDefault(val, 0) + 1);
                if (map.get(val) > 1) { // agar 1 se jyda val present hai tab pair count karo
                    psf += (map.get(val) - 1); // toh freq - 1 sabse pair up kar sakta h
                }

                if (psf >= k) { // aur agar psf requirement fulfill kare
                    ans += (n - i) ; // matllab current subarray current value aur eske baad k sare element ko ek ek kr k pick kartey hue count kar rha h kyuki requiremtn already fill ho rha toh sare subarray ko ek he baar count kar lo.
                    break ; // and ab break karo taki starting se element hata k bhi check kar sake.
                }
                f1 = true;
            }

            while (j < nums.length - 1 && psf >= k ) { // jab tak hum requirement fulfill kar rhe tab tak remove kartey rho
                j++;
                int val = nums[j]; // current element ko hata k dekho
                int freq = map.get(val);
                if (freq == 1) {
                    map.remove(val);
                } else {
                    map.put(val, freq - 1); // jab jyda freq hai 
                    psf -= (freq - 1); // toh utne pair kam ho jayenge.
                }

                if (psf >= k) {
                    ans += (n - i) ;
                }
                f2 = true;
            }

            if (!f1 && !f2) break;
        }

        return ans;
    }
}
