package Binary_Tree ;



/**
 * Q22_Construct_Binary_Tree_from_String_with_bracket_representation
 */
public class Q22_Construct_Binary_Tree_from_String_with_bracket_representation {

    // private static TreeNode root ;

    static class TreeNode {

        char data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(char d) {
            data = d ;
        }
    }


    // public static TreeNode construct_binary_tree(String s) {
    //     if(s == null){
    //         return null;
    //     }

    //     Stack<Character> stack = new Stack<>() ;

    //     for (int i = s.length() - 1 ; i >= 0 ; i--) {
    //         stack.push(s.charAt(i));
    //     }

    //     TreeNode root = new TreeNode(stack.pop());
    //     TreeNode curr  = root ;

    //     while (!stack.isEmpty()) {
    //         char ch = stack.pop();

    //         if(ch == '('){
    //             while (ch) {
                    
    //             }

    //         }
    //         else if(ch==')'){

    //         }
    //         else{

    //         }
            
    //     }















    //     return null;
    // }





















    public static void main(String[] args) {
        
    }
}