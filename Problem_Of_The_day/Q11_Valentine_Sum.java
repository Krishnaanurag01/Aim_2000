package Problem_Of_The_day ;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


/**
 * Q11_Valentine_Sum
 */
public class Q11_Valentine_Sum {

    public static void main(String[] args) {
        
    }

    static class Node{
        int data ; 
        Node left ;
        Node right ;

        Node(int data ){
            this.data = data ;
            this.left = null ;
            this.right = null ;
        }
    }


    static int sum_at_distK(Node root, int target, int k){
        // Your code goes here

        if(root == null){
            return 0 ;
        }

        HashMap<Node , Node> map = new HashMap<>() ; // this will store parents of each node.

        Node targetNode = storeParent_and_getTargetNode(root, target , map) ;


        int sum = 0 ;

        // using bfs for finding the sum.

        LinkedList<Node> queue = new LinkedList<>() ;
        HashSet<Node> set = new HashSet<>() ;

        queue.add(targetNode);
        set.add(targetNode) ;

        int level = 0 ;

        while (queue.size() > 0 && k >= level ) {

            int size = queue.size() ;

            while (size-- > 0) {
                
                Node rem = queue.removeFirst() ;
                sum += rem.data ;

                if(rem.left != null && !set.contains(rem.left)){
                    queue.add(rem.left) ;
                    set.add(rem.left) ;
                }

                
                if(rem.right != null && !set.contains(rem.right)){
                    queue.add(rem.right) ;
                    set.add(rem.right) ;
                }

                if(map.get(rem) != null && !set.contains(map.get(rem))){
                    queue.add(map.get(rem));
                    set.add(map.get(rem)) ;
                }
            }

            level++ ;
            
        }





        return sum ;
    }


    private static Node storeParent_and_getTargetNode(Node root, int target, HashMap<Node, Node> map) {


        map.put(root, null); // root node parent is null.

        Node targetNode = null ;

        // doing bfs.

        LinkedList<Node> queue = new LinkedList<>() ;

        queue.add(root) ;

        while (queue.size() > 0) {
            
            Node rem = queue.removeFirst() ;

            if(rem.data == target){
                targetNode = rem ;
            }

            if(rem.left != null){
                map.put(rem.left, rem) ;
                queue.add(rem.left) ;
            }

            
            if(rem.right != null){
                map.put(rem.right, rem) ;
                queue.add(rem.right) ;
            }

        }




        return targetNode;
    }
}