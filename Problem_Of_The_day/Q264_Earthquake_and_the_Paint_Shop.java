package Problem_Of_The_day;
import java.util.*;

public class Q264_Earthquake_and_the_Paint_Shop {
    
    class alphanumeric {
        public String name;
        public int count;
        alphanumeric(String name, int count) {
            this.name = name;
            this.count = count;
        }
    };
    class Solution {
        alphanumeric[] sortedStrings(int N, String A[]) {
            
            TreeMap<String,Integer> map = new TreeMap<>() ;
            
            for(String s : A){
                map.put(s, map.getOrDefault(s,0)+1) ;
            }
            
            alphanumeric[] ans = new alphanumeric[map.size()] ;
            int a = 0 ;
            
            for(String key : map.keySet()){
                ans[a++] = new alphanumeric(key, map.get(key)) ;
            }
            
            return ans ;
        }
    };
}
