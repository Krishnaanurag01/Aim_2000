package Problem_Of_The_day;
public class Q394_Prefix_Suffix_String {
    
    public int prefixSuffixString(String s1[],String s2[])
    {
        Node preroot = new Node() ;
        Node postroot = new Node() ;
        
        for(String s : s1){
            setPrefix(s,preroot) ;
            setPrefix(new StringBuilder(s).reverse().toString(),postroot) ;
        }
        
        int count = 0 ;
        
        for(String s : s2){
            if(isPrefix(s,preroot) || isPrefix(new StringBuilder(s).reverse().toString(), postroot)) count++ ;
        }
        
        return count ;
    }
    
    void setPrefix(String s, Node root){
        
        for(char ch : s.toCharArray()){
            if(root.childs[ch-'a'] == null){
                root.childs[ch-'a'] = new Node() ;
            }
            
            root = root.childs[ch-'a'] ;
        }
    }
    
    boolean isPrefix(String s, Node root){
        
        for(char ch : s.toCharArray()){
            if(root.childs[ch-'a'] == null){
                return false ;
            }
            
            root = root.childs[ch-'a'] ;
        }
        
        return true ;
    }
    
    

class Node{
        Node[] childs = new Node[26] ;
    }
}
