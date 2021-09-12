package Binary_Tree;


import java.util.Stack;


public class Q10_pre_post_in_one_loop {
    
    private static TreeNode root ;

   public static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }

   public static class Pair{

        TreeNode node ;
        int state ;

        public Pair(TreeNode node, int state) {
            this.node = node ;
            this.state = state ;
        }
    }

    public static void pre_post_in_traversal(TreeNode node) {
        if(node == null){
            return ;
        }

        Stack<Pair> stack = new Stack<>() ;
        Pair pair = new Pair(node , 1 );
        stack.push(pair);

        String pre = " ";
        String post = " ";
        String in = " ";

      

        while (stack.size() > 0 ) {

            Pair top = stack.peek() ;

            if(top.state == 1){  // this is for pre order : move forward : left side.
                pre += top.node.data + " " ; 
                top.state++ ;

                if(top.node.left != null){

                    Pair lp =  new Pair(top.node.left, 1);

                    stack.push(lp);
                }

            }
            else if(top.state == 2){
               in += top.node.data + " " ; 
                top.state++ ;

                if(top.node.right != null){

                    Pair rp = new Pair(top.node.right, 1) ; 
                    stack.push( rp );
                }
            }

            else{
                post += top.node.data + " " ;
                 stack.pop();
            }
            
        }




        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }





    public static void main(String[] args) {
        
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        pre_post_in_traversal(root);
    }
}
