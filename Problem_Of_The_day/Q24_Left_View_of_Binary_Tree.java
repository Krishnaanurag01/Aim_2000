package Problem_Of_The_day;
import java.util.*;

public class Q24_Left_View_of_Binary_Tree {
    
    static class Node {
        int data ;
        Node left , right ;

        Node(int val){
            this.data = val ;
            left = null ;
            right = null ;
        }
    }

    ArrayList<Integer> leftView(Node root)
    {

        ArrayList<Integer> list = new ArrayList<>() ;

        LinkedList<Node> q = new LinkedList<>() ;

        q.push(root);

        while (q.size() > 0) {
            int size = q.size() ;
            Node rn = q.peekFirst() ;
            list.add(rn.data) ;

            while (size != 0) {
                Node rmoved = q.removeFirst() ;

                if(rmoved.left != null){
                    q.push(rmoved.left);
                }

                
                if(rmoved.right != null){
                    q.push(rmoved.right);
                }
            }
        }
      


        return list ;
    }



}
