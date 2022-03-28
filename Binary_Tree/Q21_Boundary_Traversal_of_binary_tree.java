package Binary_Tree;

import java.util.ArrayList;



public class Q21_Boundary_Traversal_of_binary_tree {

    private static TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }


    // bt : left view + leafs + reversed right view.

    // static ArrayList<Integer> ansList = new ArrayList<>();

    // public static ArrayList<Integer> get_boundry_nodes(TreeNode node) {

     

    //     if(node == null) return ansList;
    //     ansList.add(node.data);

    //    leftView(node.left);


    //     getBottomNode(node);


    //     reversed_rightView(node.right);

    //     // for (int i = 0; i < ansList.size() ; i++) {
    //     //     ansList.add(ansList.get(i).data);
    //     // }

    //     return ansList;

    
        
    // }



    // private static void getBottomNode(TreeNode node) {

    //     if(node == null){
    //         return;
    //     }
    //     getBottomNode(node.left);

    //     if(node.left == null && node.right == null){
    //        ansList.add(node.data);
    //     }

    //     getBottomNode(node.right);
    // }




    // public static void leftView(TreeNode node) {
    //     if(node == null) return ;


    //     LinkedList<TreeNode> queue = new LinkedList<>() ;
    //     queue.add(node) ;

    //     while (queue.size() != 0) {
    //         int size = queue.size() ;
    //         TreeNode left = queue.getFirst();

    //         if( left.left != null ){
    //             ansList.add(left.data);

    //         }
    //         while (size-- > 0) {
    //             TreeNode rn = queue.removeFirst();

    //             if(rn.left != null) queue.addLast(rn.left) ;
    //             if(rn.right != null) queue.addLast(rn.right) ;
    //         }
    //     }

    // }


    // public static void reversed_rightView(TreeNode node) {
    //     ArrayList<TreeNode> right_list = new ArrayList<>() ;

    //     if(node == null) return;


    //     LinkedList<TreeNode> queue = new LinkedList<>() ;
    //     queue.add(node) ;

    //     while (queue.size() != 0) {
    //         int size = queue.size() ;
    //         TreeNode right = queue.getLast();
    //         if(  right.right != null){
                
    //            right_list.add(right);
    //         }
    //         while (size-- > 0) {
    //             TreeNode rn = queue.removeFirst();

    //             if(rn.left != null) queue.addLast(rn.left) ;
    //             if(rn.right != null) queue.addLast(rn.right) ;
    //         }
    //     }

    //     Collections.reverse(right_list);
    //    for (int i = 0; i < right_list.size(); i++) {
    //        ansList.add(right_list.get(i).data);
    //    }

    // }




















    // method 2nd. 

    public static boolean isLeaf(TreeNode node) {
        if(node == null){
            return false; 
        }

        if(node.left == null && node.right == null) return true ;

        return false;
    }







    public static ArrayList<Integer> get_boundry_node(TreeNode node) {
        ArrayList<Integer> list = new ArrayList<>() ;

        if(node == null) return list ;

        if(isLeaf(node) == false) list.add(node.data); // when it is leaf then don't add becuase the below add_leaves function will automatically add those leaves 

        add_left_boundry(node,list);

        add_leaves_boundry(node,list);


        add_right_boundry(node,list);

        return list;
    }

    
    
    private static void add_left_boundry(TreeNode node, ArrayList<Integer> list) {
        TreeNode curr = node.left;

        while(curr != null){
            if(isLeaf(curr)== false) list.add(curr.data);

            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }



        
    private static void add_leaves_boundry(TreeNode node, ArrayList<Integer> list) {
        if(isLeaf(node)){
            list.add(node.data);
            return;
        }

        if(node.left != null) add_leaves_boundry(node.left, list);
        if(node.right != null) add_leaves_boundry(node.right, list);

    }






    private static void add_right_boundry(TreeNode node, ArrayList<Integer> list) {
        ArrayList<Integer> rightNode = new ArrayList<>() ;

        TreeNode curr = node.right ;

        while (curr != null) {
            if(isLeaf(curr)==false) rightNode.add(curr.data);
            if(curr.right != null) curr = curr.right;
            else{
                curr = curr.left;
            }
        }

        for (int i = rightNode.size()-1 ; i >= 0; i--) {
            list.add(rightNode.get(i));
        }
    }







    public static void main(String[] args) {

        root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.left.right.right = new TreeNode(14);
        root.left.right.left = new TreeNode(10);
        root.right.right = new TreeNode(25);

        System.out.println(get_boundry_node(root));
        
    }
    
}
