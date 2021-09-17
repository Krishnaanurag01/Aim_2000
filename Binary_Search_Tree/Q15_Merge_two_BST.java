package Binary_Search_Tree;
import java.util.* ;


public class Q15_Merge_two_BST {

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

    public static void print_inorder(Node root) {
        if(root == null) return ;

        print_inorder(root.left);
        System.out.print(root.data+" ");
        print_inorder(root.right);

    }












    // total time and space is : o(n+m) where n is size of first tree and m is size of second tree.





    // first find the inorder of both the trees.
    public static void Inorder(Node root ,List<Node> list) {
        if(root == null){
            return ;
        }

        Inorder(root.left,list);
        list.add(root); // storing in list.
        Inorder(root.right, list);
    } 


    // now merge both the trees list into one.

    public static List<Node> merge_list(List<Node> list1 , List<Node> list2) {
        if(list1.size() == 0 || list2.size() == 0) return list1.size() == 0 ? list2 : list1 ;

        List<Node> merged_list = new ArrayList<>() ;

        int i = 0 ;
        int j = 0 ;

        while (i < list1.size() && j < list2.size()) {
            if(list1.get(i).data < list2.get(j).data){

                merged_list.add(list1.get(i));
                i++;

            }
            else if(list1.get(i) == list2.get(j)){
                merged_list.add(list1.get(i));
                merged_list.add(list2.get(j));
                i++;
                j++;
            }
            else{

                merged_list.add(list2.get(j));
                j++;

            }
            
        }

        if(i != list1.size()){
            
            while (i < list1.size()) {
                merged_list.add(list1.get(i));
                i++;
            }
        }
        else{
            while (j < list2.size()) {
                merged_list.add(list2.get(j));
                j++;
            }
        }

        return merged_list ;
    }

    // now do the divide and conqure technique recursively.

    public static Node merge_bst_in_one(List<Node> merged_list , int start , int end) {

        if(start > end) return null;

        int mid = (start+end)/2 ;

        Node node = merged_list.get(mid) ;
        node.left = merge_bst_in_one(merged_list, start, mid - 1) ;
        node.right = merge_bst_in_one(merged_list, mid + 1, end) ;


        return node ;
    }



    public static void main(String[] args) {

        Q15_Merge_two_BST tree1 = new Q15_Merge_two_BST() ;

        tree1.insert_node(4);
        tree1.insert_node(5);
        tree1.insert_node(6);
        tree1.insert_node(7);
        tree1.insert_node(8);
        tree1.insert_node(9);
        tree1.insert_node(10);
     
    
    List<Node> list1 = new ArrayList<>() ;

    Inorder(tree1.root, list1);





    Q15_Merge_two_BST tree2 = new Q15_Merge_two_BST();

        tree2.insert_node(2);
        tree2.insert_node(4);
        tree2.insert_node(6);
        tree2.insert_node(11);
        tree2.insert_node(12);
        tree2.insert_node(13);
        tree2.insert_node(14);
 

    List<Node> list2 = new ArrayList<>() ;

    Inorder(tree2.root, list2);

       
    
    List<Node> merged_list = merge_list(list1, list2);

   Node root =  merge_bst_in_one(merged_list, 0, merged_list.size()-1);
    

   print_inorder(root);




    
    }
    
}
