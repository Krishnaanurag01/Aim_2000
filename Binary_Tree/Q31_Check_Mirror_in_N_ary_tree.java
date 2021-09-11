package Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q31_Check_Mirror_in_N_ary_tree {




    public static int check_mirror(int n , int e , int[] A,int[] B) {

        ArrayList<Stack<Integer>> first_tree = new ArrayList<>();
        ArrayList<Queue<Integer>> second_tree = new ArrayList<>();

        for (int i = 0; i < n; i++) { // add n stack and queue to both list. as they could be n(number of nodes) child.
            first_tree.add(new Stack<>());
            Queue<Integer> que = new LinkedList<>();
            second_tree.add(que);            
        }


        for (int i = 0; i < 2*e; i+=2) { 
            first_tree.get(A[i]).push(A[i+1]);
            second_tree.get(B[i]).add(B[i+1]);
        }
        

        for (int i = 0 ; i < n; i++) {
            while (!first_tree.get(i).isEmpty() && !second_tree.get(i).isEmpty()) {
                int a = first_tree.get(i).pop();
                int b = second_tree.get(i).poll();

                if(a != b ){
                    return 0 ;
                }
            }
        }

        return 1;
        
    }











    public static void main(String[] args) {

        System.out.println(check_mirror(3, 2, new int[]{1,3,1,2}, new int[]{1,2,1,3}));
        
    }
    
}
