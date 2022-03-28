package Binary_Tree;
import java.util.*;

public class Q50_Diagonal_Sum_In_Binary_Tree {

    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }
    

    public static ArrayList <Integer> diagonalSum(Node root) 
    {
        ArrayList<Integer> ans = new ArrayList<>() ;
           
           LinkedList<Node> q = new LinkedList<>() ;
           
           q.add(root) ;
           
           while(q.size() != 0 ) {
               
               int size = q.size() ;
               ArrayList<Integer> r = new ArrayList<>() ;
               
               while(size-- > 0){
                   Node rn = q.removeFirst() ;
                   
                   while(rn != null){
                       r.add(rn.data) ;
                       if(rn.left != null) q.addLast(rn.left) ;
                       
                       rn = rn.right ;
                   }
               }
               int sum = 0 ;
               while(r.size() != 0){
                   sum = sum + r.remove(0) ;
               }
               ans.add(sum) ;
               
           }
           
           return ans ;
    }

    // recursive approach.

    public static ArrayList <Integer> diagonalSum2(Node root) 
    {
        ArrayList <Integer> ans = new ArrayList<>() ;
        helper(root,0,ans) ; // 0 denotes currently we are at 0th level diagonal
        return ans ;
    }
    
    static void helper(Node root, int lvl , ArrayList<Integer> ans){
        
        if(root == null) return ;
        
        if(lvl == ans.size() ) ans.add(0) ; // when size equals level then add one 0, it denotes we have found a new diagonal
        ans.set( lvl, ans.get(lvl) + root.data ) ; // add the value on lvl index 
        
        helper(root.left, lvl + 1 ,ans); // go left with lvl + 1
        helper(root.right, lvl ,ans); // and right with lvl + 0
    }
}
