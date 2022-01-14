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
}
