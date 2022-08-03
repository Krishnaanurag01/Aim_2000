package Problem_Of_The_day;

public class Q137_My_Calendar_I {
    
    class MyCalendar {
    
        class Node{
            int start, end ;
            Node left, right ;
            
            Node(){} 
            Node(int x, int y){
                start = x ;
                end = y ;
            }
        } // segment tree node
        Node root ;
        
        public MyCalendar() {    
            root= new Node() ; 
        }
        
        boolean booked ;
        public boolean book(int start, int end) {
            booked = false;
            isAllowed(root,start,end) ;
            return booked ;
        }
        
        Node isAllowed(Node node, int start, int end){
            if(node == null){ // if reach here then it means we can book the new slot so make booked true and return new node.
                booked = true ;
                return new Node(start,end) ;
            }
            
            if(end <= node.start){ // it means there could be any slot on left that may introduce conflict
                node.left = isAllowed(node.left,start,end) ;
            }
            else if(start >= node.end ){ // this shows the right side 
                node.right = isAllowed(node.right,start,end) ;
            }
            
            return node ;
        }
    }
}
