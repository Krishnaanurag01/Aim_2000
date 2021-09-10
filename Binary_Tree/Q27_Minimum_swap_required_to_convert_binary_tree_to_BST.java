package Binary_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Q27_Minimum_swap_required_to_convert_binary_tree_to_BST {

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }






    // time and space is  o(n) in general.

    
    // The idea is to use the fact that inorder traversal of Binary Search Tree is in increasing order of their value. 
// So, find the inorder traversal of the Binary Tree and store it in the array and try to sort the array. The minimum number of swap required to get the array sorted will be the answer




    
    // doing the same thing as Q18 of Searching and sorting.

    private static void swap(int[] arr, int i, int swappingIdx) { // its simple swap function.

        int temp = arr[i];
        arr[i] = arr[swappingIdx];
        arr[swappingIdx] = temp ;
    }


    public static void inorder2(int[] arr , ArrayList<Integer> list , int size , int index) { // here took arraylist not array because it will not be possible to store value in array without any index.
        if(index >= size ) return ;

        inorder2(arr, list, size, 2*index + 1); /// here 2*index  + 1 denotes the left child which in on (2*index  + 1)index.
        list.add(arr[index]); // storing the inorder to llist.
        inorder2(arr, list, size, 2*index + 2); // 2*index + 2 is right child.

    }


    public static int min_swap_for_bst(int[] arr) {
     

        ArrayList<Integer> list = new ArrayList<>(); // for finding the inorder.
        inorder2(arr, list, arr.length-1 ,0);

        int[] inOrder = list.stream().mapToInt(i -> i).toArray();  // converting the list into array.
        list.clear(); // removed the nodes of list. as its of no use.

        HashMap<Integer,Integer> map = new HashMap<>() ; // for storing the original index of inorder.

        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i); // we have to sort the inorder so we'll store its original value.
        }

        Arrays.sort(arr); // now sorting the given array.
        int ans = 0;// total swaps.

        for (int i = 0; i < inOrder.length; i++) { // rest is same.
            if(arr[i] != inOrder[i]){

                ans++;

                int originalVal = inOrder[i];

                swap(inOrder, i, map.get(arr[i]));

                map.put(originalVal, map.get(arr[i]));
                map.put(arr[i], i) ;

            }
        }
        return ans ;
        
    }

    public static void main(String[] args) {
        // System.out.println(get_min_swaps_to_bst(new int[]{ 5, 6, 7, 8, 9, 10, 11 }));
        System.out.println(min_swap_for_bst(new int[]{ 5, 6, 7, 8, 9, 10, 11 }));
    }



    
}
