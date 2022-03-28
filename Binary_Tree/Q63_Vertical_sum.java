package Binary_Tree;
import java.util.*;

public class Q63_Vertical_sum {

    class Node{
        int data ;
        Node left,right ;
    }


    //  using vertical order traversal and instead of storing values of each level just add them
    void getWidth(Node root,int lvl, int[] minMax){
        if(root == null) return  ;
        
        minMax[0] = Math.min(minMax[0], lvl ) ;
        minMax[1] = Math.max(minMax[1], lvl ) ;
        
        getWidth(root.left,lvl-1,minMax) ;
        getWidth(root.right,lvl+1,minMax) ;
        
    }
    
    public ArrayList <Integer> verticalSum(Node root) {
        
        int[] minMax = {0,0} ;
        getWidth(root,0,minMax) ;
        int width = minMax[1] - minMax[0] + 1 ;
        
        ArrayList<Integer> ans = new ArrayList<>() ;
        for(int i = 0 ; i < width ; i++){
            ans.add(0) ;
        }
        
        LinkedList<Pair> q = new LinkedList<>();
        q.add(new Pair(root,(int)Math.abs( minMax[0]) )) ;
        
        while(q.size() != 0 ){
            int size = q.size() ;
            while(size-- > 0){
                Pair rp = q.removeFirst() ;
                
                int val = ans.get(rp.lvl) ;
                val += rp.node.data ;
                
                ans.set(rp.lvl,val) ;
                
                if(rp.node.left != null)
                q.add(new Pair(rp.node.left,rp.lvl - 1) ) ;
                
                if(rp.node.right != null)
                q.add(new Pair(rp.node.right,rp.lvl+1) ) ;
                
            }
        }
        
        return ans ;
    }
    
    class Pair{
        Node node ;
        int lvl ;
        
        Pair(Node n, int l){
            node = n ;
            lvl = l ;
        }
    }
    

    // using recursive solution.
    
    public ArrayList <Integer> verticalSum2(Node root) {
        
        int[] minMax = {0,0} ;
        getWidth(root,0,minMax) ;
        int width = minMax[1] - minMax[0] + 1 ;
        
        ArrayList<Integer> ans = new ArrayList<>() ;
        for(int i = 0 ; i < width ; i++){
            ans.add(0) ;
        }
        
        helper(root, (int)Math.abs(minMax[0]), ans ) ;
        return ans ;
    }
    
    void helper(Node root, int lvl, ArrayList<Integer> ans){
        if(root == null){
            return ;
        }
        
         ans.set( lvl, ans.get(lvl) + root.data );
         
         helper(root.left,lvl -1 , ans) ;
         helper(root.right, lvl + 1,ans) ;
    }
}
