package Binary_Tree;

import java.util.LinkedList;


public class Q38_K_th_ancestor_of_a_node_in_Binary_Tree {

    private  TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }


    public static void setup_ancestor(TreeNode node , int[] ancestor_Arr) { // this will store the ancestor for every node.
        if(node == null){
            return ;
        }

        // roots ancestor will also be -1;
        ancestor_Arr[node.data] = -1 ;

        LinkedList<TreeNode> queue = new LinkedList<>() ;  // for bfs
        queue.add(node);

        while (queue.size() != 0 ) {
            int size = queue.size()  ;
            // TreeNode temp = queue.getFirst() ;
            while (size-- > 0) {
                TreeNode temp = queue.removeFirst() ;

                if(temp.left != null){  // storing ancestor of left child.
                    ancestor_Arr[temp.left.data] = temp.data ;
                    queue.addLast(temp.left);
                }
                if(temp.right != null){ // storing the ancestor of right child.
                    ancestor_Arr[temp.right.data] = temp.data ;
                    queue.addLast(temp.right);
                }
            }
        }
    }

            
    
        public static int get_kth_ancestor(TreeNode root , int n , int k , int node) {

            if(root == null ) return -1 ;

            int[] arr = new int[n + 1] ;  // this will create an array for storing the acestor of each node.
            setup_ancestor(root,arr); // generating the ancestor. 

            int count = 0 ; // count updating so that when its equal to k then break it.
           
            while (node != -1) { // if node becomes -1 then break it.

               node = arr[node] ; // getting the ancestor until it becomes equal to k.
               count++; // updating the count.

               if(count == k){ // when become equal to k then break.
                   break ;
               }

                
            }

            return node;
        }


    






    public static void main(String[] args) {

        Q38_K_th_ancestor_of_a_node_in_Binary_Tree tree = new Q38_K_th_ancestor_of_a_node_in_Binary_Tree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
     
        int k = 2;
        int node = 5;

        System.out.println(get_kth_ancestor(tree.root,5, k, node));
        
    }
    
}
