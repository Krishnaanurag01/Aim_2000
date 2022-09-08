package Graph_level_02;
import java.util.*;

public class Q70_Most_Stones_Removed_with_Same_Row_or_Column {

    int mergedCount ;
    public int removeStones(int[][] stones) {
        
        HashMap<String,String> parent = new HashMap<>() ;
        
        for(int[] s: stones){
            String temp = s[0] + " - " + s[1] ;
            parent.put(temp,temp) ; // initially sab khud k parent h.
        }
        mergedCount = stones.length ; /// initial value.
        
        for(int[] s1: stones){
            String temp = s1[0] + " - " + s1[1] ;
            for(int[] s2 : stones){
                if(s1[0] == s2[0] || s1[1] == s2[1]){ // row ya col common hai toh merge it.
                    String temp2 = s2[0]+ " - " + s2[1];
                    union(parent,temp,temp2) ;
                }
            }
        }
        
        
        return stones.length - mergedCount ;
    }
    
    
    void union(HashMap<String,String> parent, String x, String y){
        String px = find(parent,x);
        String py = find(parent,y);
        
        if(px.equals(py) == false){ // agar dono k parent same nhi h to same kar do.
            parent.put(px,py); // y ka parent ab x ka bhi parent h.
            mergedCount-- ; // decreasing count means ab humare par n-1 component. hai kyuki do comp 1 me merged ho gya 
            return ;
        }
    }
    
    String find(HashMap<String,String> parent, String x){
        if(parent.get(x).equals(x) ) return x; // agar x khud ka parent h toh return.
        String temp = find(parent, parent.get(x)) ; // nhi to find ki x ka parent kon h
        parent.put(x,temp) ; // aur updating x parents. for optimization.
        return temp ;
    }
}
