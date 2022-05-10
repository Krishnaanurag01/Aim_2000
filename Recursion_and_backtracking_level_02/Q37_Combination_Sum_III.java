package Recursion_and_backtracking_level_02;
import java.util.*;

public class Q37_Combination_Sum_III {

    List<List<Integer>> ans ;
    HashSet<HashMap<Integer,Integer>> set ;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>() ;
        set = new HashSet<>() ;
        helper(1,n,k,new ArrayList<>()) ;
        return ans ;
    }
    
    void helper(int si,int n, int k, List<Integer> list){
        
        if(n == 0 && list.size() == k){
            HashMap<Integer,Integer> map = new HashMap<>() ;
            
            for(int i : list){
                map.put(i, map.getOrDefault(i,0)+1) ;
            }
            if(set.contains(map)) return ;
            set.add(map) ;
            ans.add(new ArrayList<>(list));
            return ;
        }
        
        if(n == 0) return ;
        
        for(int i = si; i <= 9 ; i++){
            if(i <= n){
                list.add(i) ;
                helper(i+1,n-i,k,list) ;
                list.remove(list.size() - 1) ;
            }
        }
    }
}
