package Binary_Tree ;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;



/**
 * Q11_Valentine_Sum
 */
public class Q43_Valentine_Sum {

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
       
        if(root == null){ // if root node is null then return 0.
            return 0 ;
        }

        HashMap<Node , Node> map = new HashMap<>() ; // this will have the store parents of each node.

        // this function will store parents of each node and return the reference of traget node.
        Node targetNode = storeParent_and_getTargetNode(root, target , map) ;


        int sum = 0 ;

        // using bfs for finding the sum.

        LinkedList<Node> queue = new LinkedList<>() ;
        HashSet<Node> set = new HashSet<>() ; // using this will helps in not using the same node twice.

        queue.add(targetNode); // adding target node by default.
        set.add(targetNode) ;

        int level = 0 ;

        while (queue.size() > 0 && k >= level ) {

            int size = queue.size() ; // for level order traversal.

            while (size-- > 0) {
                
                Node rem = queue.removeFirst() ; // removing first node.
                sum += rem.data ; // and adding its data to sum as it is in the distance of k.

                if(rem.left != null && !set.contains(rem.left)){ // if left child is not null and not used before then add it to the queue and set.
                    queue.add(rem.left) ;
                    set.add(rem.left) ;
                }

                
                if(rem.right != null && !set.contains(rem.right)){ // if right child is not null and not used before then add it to the queue and set.
                    queue.add(rem.right) ;
                    set.add(rem.right) ;
                }

                if(map.get(rem) != null && !set.contains(map.get(rem))){ // if parent node is not null and not used before then add it to the queue and set.
                    queue.add(map.get(rem));
                    set.add(map.get(rem)) ;
                }
            }

            level++ ; // incresing level.
            
        }

        return sum ;
    }


    private static Node storeParent_and_getTargetNode(Node root, int target, HashMap<Node, Node> map) {


        map.put(root, null); // root node's parent is null.

        Node targetNode = null ; // this will have the reference of target value node.

        // doing bfs.

        LinkedList<Node> queue = new LinkedList<>() ;

        queue.add(root) ;

        while (queue.size() > 0) {
            
            Node rem = queue.removeFirst() ;

            if(rem.data == target){
                targetNode = rem ;
            }

            if(rem.left != null){  // adding left child with current node as parent in map.
                map.put(rem.left, rem) ;
                queue.add(rem.left) ;
            }

            
            if(rem.right != null){ // adding right child with current node as parent in map.
                map.put(rem.right, rem) ;
                queue.add(rem.right) ;
            }

        }


        return targetNode;
    }
}