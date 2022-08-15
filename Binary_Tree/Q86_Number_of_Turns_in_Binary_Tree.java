package Binary_Tree;
import java.util.*;

public class Q86_Number_of_Turns_in_Binary_Tree {

    static int NumberOfTurns(Node root, int first, int second)
    {
       Node LCA = getCommonAncestor(root, first, second) ; // LCA(Lowest common ancestor is the node who will be root or you can it's the node where both node are sub tree)
       int count = 1 ; //taking by defualt 1 for root 
       LinkedList<Pair> q = new LinkedList<>() ;
       if(LCA.data == first || LCA.data == second){ // if this root node is one the node then make count 0 as there is no turn
           count = 0 ;
       }
       q.add( new Pair(LCA,'#',0)) ; /// adding root node with symbol '#' denotes it can go both left and right with 0 turn
       boolean ff = false; // first found
       boolean sf = false; // second found
       
       while(q.size() > 0 && (!ff || !sf) ){ // it willl run untill we did not found both first and second
           int size = q.size() ;
           while(size-- > 0){
               Pair rp = q.removeFirst() ;
               
               if(rp.node.data == first){ // first found
                   ff = true ;
                   count += rp.count ;
               }
               
               if(rp.node.data == second){ // second found
                   sf = true ;
                   count += rp.count;
               }
               
               if(rp.node.left != null){
                   if(rp.ch == 'L' || rp.ch == '#'){ // going left from left(root's left) with same count as there is no turn in L to L
                     q.add( new Pair(rp.node.left, 'L', rp.count ) );   
                   }
                   else{ // or go left wwith +1 count as L TO R is 1 turn
                     q.add( new Pair(rp.node.left, 'L', rp.count + 1 ) ); 
                   }
                  
               }
               if(rp.node.right != null){ // same as Left conditions
                   if(rp.ch == 'R' || rp.ch == '#'){
                     q.add( new Pair(rp.node.right, 'R', rp.count ) );   
                   }
                   else{
                     q.add( new Pair(rp.node.right, 'R', rp.count + 1 ) ); 
                   }
               }
               
           }
       }
       
       
       return count ;
    }
    
    // this is simple Lowest common ancestor code.
    static Node getCommonAncestor(Node root, int first, int second){
        if(root == null || root.data == first || root.data == second) return root;
        
        Node left = getCommonAncestor(root.left, first,second) ;
        Node right = getCommonAncestor(root.right,first,second) ;
        
        if(left == null) return right ;
        if(right == null) return left ;
        return root ;
    }

    static class Pair{
        Node node;
        char ch ;
        int count ;
        
        Pair(Node x, char y, int z){
            node = x ;
            ch = y ;
            count = z;
        }
    }

    class Node{
        Node left, right ;
        int data ;
    }
}
