package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q22_Group_Anagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<HashMap<Character,Integer>, List<String> > map = new HashMap<>() ;
        
        for(String s : strs){
            HashMap<Character,Integer> inmap = new HashMap<>() ;
            
            for(char ch : s.toCharArray()){
                inmap.put(ch,inmap.getOrDefault(ch,0)+1) ;
            }
            
            
            if(map.containsKey(inmap)){
                List<String> inlist = map.get(inmap) ;
                inlist.add(s) ;
            }
            else{
                List<String> inlist = new ArrayList<>() ;
                inlist.add(s) ;
                
                map.put(inmap,inlist) ;
            }
        }
        
        List<List<String>> ans = new ArrayList<>() ;
        
        for(List<String> a : map.values()){
            ans.add(a) ;
        }
        
        return ans ;
    }
    
}
