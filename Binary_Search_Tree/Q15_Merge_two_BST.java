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

    public static void Inorder(Node root ,List<Integer> list) {
        if(root == null){
            return ;
        }

        Inorder(root.left,list);
        list.add(root.data); // storing in list.
        Inorder(root.right, list);
    }

    public static List<Integer> merge_list(List<Integer> list1 , List<Integer> list2) {
        if(list1.size() == 0 || list2.size() == 0) return list1.size() == 0 ? list2 : list1 ;

        List<Integer> merged_list = new ArrayList<>() ;

        int i = 0 ;
        int j = 0 ;

        while (i < list1.size() && j < list2.size()) {
            if(list1.get(i) < list2.get(j)){

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




    public static void main(String[] args) {
       List<Integer> list1 = new ArrayList<>() ;

       list1.add(2);
       list1.add(3);
       list1.add(4);
       list1.add(5);
       list1.add(7);
       list1.add(8);
       list1.add(9);

       List<Integer> list2 = new ArrayList<>() ;
       
    //    list2.add(7);
       list2.add(2);
       list2.add(3);
       list2.add(4);
       list2.add(6);
       list2.add(10);
       list2.add(12);

       merge_list(list1, list2);
    
    }
    
}
