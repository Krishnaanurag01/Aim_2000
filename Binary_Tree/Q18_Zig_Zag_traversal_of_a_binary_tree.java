package Binary_Tree;

import java.util.ArrayList;
import java.util.Stack;



public class Q18_Zig_Zag_traversal_of_a_binary_tree {

    private static TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }

    // time and space : o(n)

    public static ArrayList<Integer> get_zig_zag_traversal(TreeNode node) {
        ArrayList<Integer> list = new ArrayList<>() ; // for answer.

        if(node == null){
            return list ;
        }

        Stack<TreeNode> ms = new Stack<>() ; // main stack 
        Stack<TreeNode> ns = new Stack<>() ;  // new stack 

        ms.push(node) ; // pushing the root.

        int leftToright = 0 ; // it will change in each level. first level will traverse left to right. thats why given 0.

        while (!ms.isEmpty()) {
            TreeNode rn = ms.pop() ; // popped the top node.

            list.add(rn.data) ; // add it to the data.

            if(leftToright % 2 == 0){  // when 0 then traverse left to right.
                if(rn.left != null) ns.push(rn.left) ;

                if(rn.right != null) ns.push(rn.right) ;
            }
            else{ // o\w right to left

                if(rn.right != null) ns.push(rn.right) ;

                if(rn.left != null) ns.push(rn.left) ;

            }

            if(ms.isEmpty()){ // it will be empty after each level last node. then replace with the ns(next stack) which have children of next level.
                ms = ns ; // swapped to the main stack.
                ns = new Stack<>() ; // and next stack becomes null to store new childrens.
                leftToright++; // increament will help us in reaching the zig zag,
            }

        }


        System.out.println(list);


        return list ;
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


        get_zig_zag_traversal(root);
      
        
    }
    
}
