package Searching_and_Sorting;

import java.util.*;

public class QR_4SUM_II {
    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b ={-2,-1};
        int[] c ={-1,2};
        int[] d ={0,2};
        System.out.println(fourSumCount(a, b, c, d));
    }
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i : nums1){
            for(int j : nums2){
                map.put(i+j, map.getOrDefault(i+j , 0 )+1);
            }
        }
        
        int target = 0; 
        int count = 0 ;
        
        for(int i : nums3){
            for(int j : nums4){
                count+= map.getOrDefault(target - (i+j),0);
            }
        }
        return count;
    }
}
