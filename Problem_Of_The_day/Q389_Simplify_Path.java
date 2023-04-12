package Problem_Of_The_day;

public class Q389_Simplify_Path {
    public String simplifyPath(String path) {
        
        Stack<String> st = new Stack<>() ;
        String[] p= path.split("/") ;
        StringBuilder sb = new StringBuilder() ;
        
        for(int i = 0 ; i < p.length ; i++){
            if(!st.isEmpty() && p[i].equals("..")) st.pop() ;
            else if(!p[i].equals("") && !p[i].equals("..") && !p[i].equals(".")) st.push(p[i]) ;
        }
        
        if(st.isEmpty()) return "/" ;
        
        while(st.size() > 0){
            sb.insert(0, st.pop()).insert(0,"/") ;
        }
        
        return sb.toString() ;
    }
}
