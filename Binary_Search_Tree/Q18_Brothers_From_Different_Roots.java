package Binary_Search_Tree;

import java.util.HashSet;

public class Q18_Brothers_From_Different_Roots {
    
    
    Node root;

    public static class Node {

        int data;
        Node left, right;
        public Node(int d) {
            this.data = d;
        }

    }

    
    public void insert_node(int data) {
        root = insert_node(root, data);
    }

    public static Node insert_node(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (root.data > data) {
            root.left = insert_node(root.left, data);
        } else {
            root.right = insert_node(root.right, data);
        }

        return root;
    }


    static HashSet<Integer> list = new HashSet<>() ;

    public static void Inorder(Node root) {
        
        if(root == null) return ;

        Inorder(root.left);

        list.add(root.data) ;

        Inorder(root.right);
    }



    public static void get_pair_count(Node root , int x , int[] count) {
        if (root == null) {
            return ;
        }

        get_pair_count(root.left,x,count);

        if( list.contains(x-root.data)){
            count[0]++;
        }

        get_pair_count(root.right,x,count);
    }



    // method 2 :

    // taking o(n*m) time .

    public static void getcount(Node root1, Node root2 , int k , int[] ans) {
        if(root1 == null) return ;

        getcount(root1.left, root2, k,ans);

        if(fetch_pair(root2,k-root1.data)){
            ans[0]++;
        }


        getcount(root1.right, root2, k,ans);
    }




    private static boolean fetch_pair(Node root2, int i) {

        if(root2 == null) return false ;

        if(root2.data == i) return true ;

        return fetch_pair(root2.left, i) || fetch_pair(root2.right, i);
    }




    public static void main(String[] args) {

        Q18_Brothers_From_Different_Roots tree = new Q18_Brothers_From_Different_Roots() ;

        tree.insert_node(5);
        tree.insert_node(3);
        tree.insert_node(2);
        tree.insert_node(4);
        tree.insert_node(7);
        tree.insert_node(6);
        tree.insert_node(8);

        Q18_Brothers_From_Different_Roots tree2 = new Q18_Brothers_From_Different_Roots() ;

        tree2.insert_node(1);
        tree2.insert_node(3);
        tree2.insert_node(6);
        tree2.insert_node(7);
        tree2.insert_node(8);
        tree2.insert_node(9);
        tree2.insert_node(10);

        // Inorder(tree.root); 

        // get_pair_count(tree2.root, 6);
        // System.out.println(count);


        // getcount(tree.root, tree2.root, 6);
        // System.out.println(ans);
        
    }
}
