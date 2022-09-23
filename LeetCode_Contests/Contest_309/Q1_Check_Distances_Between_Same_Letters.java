package LeetCode_Contests.Contest_309;

public class Q1_Check_Distances_Between_Same_Letters {

    public boolean checkDistances(String s, int[] distance) {
        
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i) ;
            int dis = distance[ch-'a'] ;
            if( i + dis + 1 < s.length() && s.charAt(i + dis+1) == ch) continue ;
            if( i - (dis + 1) >= 0 && s.charAt(i - (dis + 1)) == ch) continue ;
            return false;
        }
        
        return true;
    }
}
