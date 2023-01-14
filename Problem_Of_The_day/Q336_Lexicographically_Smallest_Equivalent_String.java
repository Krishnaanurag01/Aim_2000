package Problem_Of_The_day;

public class Q336_Lexicographically_Smallest_Equivalent_String {

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
        char[] parent = new char[26] ;
        
        for(int i = 0 ; i < 26 ; i++){
            parent[i] = (char) ('a' + i) ;
        }
        
        for(int i = 0 ; i < s1.length() ; i++){
            char ch1 = s1.charAt(i) ;
            char ch2 = s2.charAt(i) ;
            union(ch1, ch2, parent) ;
        }

        StringBuilder sb = new StringBuilder() ;
        
        for(int i = 0 ; i < baseStr.length() ; i++){
            char currParent = find(baseStr.charAt(i), parent);
            sb.append(currParent) ;
        }
        
        
        return sb.toString() ;
    }
    
    public boolean union(char x, char y, char[] parent){
        char px = find(x,parent) ;
        char py = find(y,parent) ;
        
        if(px == py) return false; // agar both parent same h to return 
        
        if(px < py){ // agar x parent lexico chota h py se 
            parent[py - 'a'] = px ; // toh py bhi px ko apna baap bna dega
        }
        else{
            parent[px - 'a'] = py ; // nhi toh x ka parent py ko apna baap bna lega
        }
        
        return true ;
    }
    
    char find(char ch, char[] parent){
        if(parent[ch - 'a'] == ch) return ch ;
        return parent[ch - 'a'] = find(parent[ch - 'a'], parent) ;
    }
}
