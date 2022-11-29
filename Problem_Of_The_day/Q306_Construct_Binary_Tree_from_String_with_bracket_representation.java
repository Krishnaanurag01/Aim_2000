package Problem_Of_The_day ;

public class Q306_Construct_Binary_Tree_from_String_with_bracket_representation {

    public static Node treeFromString(String s) {
        return helper(s, 0, s.length() - 1) ; // sending start index and end index.
     }
     
     static Node helper(String s, int si, int ei){
         
         if(si > ei) return null ; // if out of bound then return null.
         
         int val = 0 ; // now getting the value. 
         
         boolean val_found = false;
         int opening = 0 ; // counting the opening bracket count.
         
         int start = -1 ; // index of start bracket.
         int closed = -1 ; // index of closed bracket.
         
         for(int i = si ; i <= ei ; i++){
             char ch = s.charAt(i) ;
             
             // if it is a digit and value is not completely found then add in the value part.
             // when the values are of more than of one digit then this is helpful in extracting value
             if(Character.isDigit(ch)  &&  val_found == false){
                 val = val * 10 + (ch - '0') ;
                 continue ;
             }
             
             // now as we have found first bracket so no other digit is part of value.
             val_found = true ;
             
             if(ch == '('){
                 opening++ ;
             }
             else if(ch == ')'){
                 opening-- ; // subtracting when close found
             }
             
             if(start == -1 && opening == 1){ 
                 start = i ; // marking first opening bracket index.
             }
             
             if(opening == 0){ // this case denotes that our left part side is found completely
                 closed = i ;
                 break ;
             }
         }
         
         
         Node node = new Node(val) ; // making the node.
         
         if(start != -1 &&  closed != -1){ // if start node and end node for child is present then only run this.
         node.left = helper(s, start + 1 , closed - 1) ;
         node.right = helper(s, closed + 2, ei - 1) ;
         }
         
         
         return node;
     }

     static class Node{
        int data;
        Node left ;
        Node right ;
        Node(int x){
            data = x ;
        }
     }
    

}