package Generic_Trees_Level_01;

import java.util.ArrayList;
import java.util.Stack;

public class Q1_Implement_Generic_tree {

    static class Node{
        int data ;
        ArrayList<Node> childs = new ArrayList<>() ;
    }

    static Node root ;

    public static void insert(int[] arr){

        Stack<Node> stack = new Stack<>() ;

        for (int val : arr) {
            
            if(val == -1){ // -1 denotes end of a level so delete the top node from the stack.
                stack.pop() ;
            }
            else{

                Node nNode = new Node() ;
                nNode.data = val ;

                if(stack.size() == 0){
                    root = nNode ; // first node becomes the root
                }
                else{
                    stack.peek().childs.add(nNode) ; // adding new node as a child of stack top node
                }
                // now push new node in stack

                stack.push(nNode) ;
            }

        }
    }


    public static void display(Node head){


        // printing current node with it's children
        StringBuilder sb = new StringBuilder() ; // using sb instead normal string for optimality.
        sb.append(head.data +" -> ") ;

        for (Node child : head.childs ) {
            sb.append(child.data +", ") ;
        }
        sb.append(".") ;

        System.out.println(sb);

        // now calling every child for display
        for (Node child : head.childs ) {
           display(child);
        }


    }

    public static void main(String[] args) {
        
        root = new Node() ;

        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,50,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1} ;

        insert(arr);
        display(root);
    }
    
}
