package Binary_Search_Tree ;


/**
 * Q21_Replace_every_element_with_the_least_greater_element_on_its_right
 */
public class Q21_Replace_every_element_with_the_least_greater_element_on_its_right {

    
    Node root;

    public static class Node {

        int data;
        Node left, right;

        public Node(int d) {
            this.data = d;
        }

    }

    public static Node insert(Node node,int data , int[] succ) {
        if(node == null){
            return node = new Node(data) ; // when first time this functions call then it will make a root and return.
        }

        if(node.data > data){ // otherwise it will check if roots data is greater than 
            succ[0] = node.data ; // then it will update the succecor
            node.left = insert(node.left, data, succ) ; // and then it will call recursively in the left.
        }
        else if(node.data < data){ // otherwise if roots data is larger then it will go on the right and insert node.
            node.right = insert(node.right, data, succ) ;
        }

        return node;
    }


    public static void arrange_array(int[] arr) {
        if(arr.length == 0) return ;

        Node root = null ; // creating a node .

        for (int i = arr.length -1 ; i >= 0 ; i--) {
            int[] succ = {-1} ; // for each node succecor will start from -1 .
            root = insert(root, arr[i], succ); // now we are inserting the node in the list with root.

            if(succ[0] != -1){  // so when succ is not -1 then it will replace current array index with successor value.
                arr[i] = succ[0] ;
            }
            else{ // o\w it will place -1.
                arr[i] = -1 ;
            }
        }
    }



    public static void main(String[] args) {

        int[] arr = {8, 58, 71, 18, 31, 32, 63, 92, 
            43, 3, 91, 93, 25, 80, 28};

            arrange_array(arr);

        for (int i : arr) {
            System.out.print(i+" ");
        }
        
    }
}