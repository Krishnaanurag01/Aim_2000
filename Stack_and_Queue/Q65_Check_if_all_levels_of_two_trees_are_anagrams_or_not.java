package Stack_and_Queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


public class Q65_Check_if_all_levels_of_two_trees_are_anagrams_or_not {

    static class Node {
        int data ;
        Node left , right ;

        Node(int val){
            data = val ;
            left = null ;
            right = null ;
        }
    }


    public static void main(String[] args) {
        
        Node root1 = new Node(1);
        root1.left = new Node(3);
        root1.right = new Node(2);
        root1.right.left = new Node(5);
        root1.right.right = new Node(4);
      
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);

        System.out.println( areAnagrams(root1, root2) );
    }


    // here we are finding level order of both trees and then comparing it after sorting it.
    static boolean areAnagrams(Node root1, Node root2)
    {

        LinkedList<Node> q1 = new LinkedList<>() ;
        LinkedList<Node> q2 = new LinkedList<>() ;

        q1.add(root1) ;
        q2.add(root2) ;

        // doing level order traversal.

        while (true) {
            
            if(q1.size() != q2.size()){ // if size is not equal then it means its not anagram so  returning false.
                return false ;
            }

            if(q1.size() == 0) break ; // breaking when size becomes 0.

            int size = q1.size() ;

            // here we'll add all data .
            ArrayList<Integer> a1 = new ArrayList<>() ;
            ArrayList<Integer> a2 = new ArrayList<>() ;

            while (size-- > 0) {
                Node rn1 = q1.removeFirst() ;

                // adding to queue for further level 
                if (rn1.left != null) q1.addLast(rn1.left);
                if (rn1.right != null) q1.addLast(rn1.right);

                Node rn2 = q2.removeFirst() ;

                // same as above
                if (rn2.left != null) q2.addLast(rn2.left);
                if (rn2.right != null) q2.addLast(rn2.right);


                /// now adding in list
                a1.add(rn1.data) ;
                a2.add(rn2.data) ;

            }

            // sorting the list

            Collections.sort(a1);
            Collections.sort(a2);

            // if data are not same then return false.
            if( !a1.equals(a2) ) return false ;

        
        }


        // returning true if we didn't get false so far.
        return true ;
    }
    
}
