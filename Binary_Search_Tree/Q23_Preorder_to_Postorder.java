package Binary_Search_Tree;

public class Q23_Preorder_to_Postorder {

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


    public static void construct_bst_from_pre(int[] arr , int start , int end) {
        if(start > end) return ;

        int mid = start+1 ;

        while (mid<= end && arr[mid] < arr[start]) {
            mid++;
        }

        mid-- ; /// we increamented 1 extra so decreamenting here.

        construct_bst_from_pre(arr, start + 1  , mid);  // here sending start from start + 1 . // so it will print left first
        construct_bst_from_pre(arr,  mid + 1 , end); // then right and then right.
        System.out.print(arr[start] + " ");  // becuase start of pre is root.

    }



    public static void main(String[] args) {

        int[] arr = {40,30,32,35,80,90,100,120} ;
        construct_bst_from_pre(arr, 0, arr.length-1);
        
    }
    
}
