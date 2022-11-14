package Problem_Of_The_day;

public class Q293_Design_Circular_Deque {

    class MyCircularDeque {
    
        private class Node{
            int data = 0 ;
            Node next, prev ;
            
            Node(){} ;
            Node(int d){
                data = d ;
            }
            
            public void delete(){
                prev.next = next ;
                next.prev = prev ;
            }
        }
    
        Node head ;
        Node tail ;
        int size = 0 ; 
        int K ;
        
        public MyCircularDeque(int k) {
            K = k ;
            head = new Node() ;
            tail = new Node() ;
            head.next = tail ;
            tail.prev = head ;
        }
        
        public boolean insertFront(int value) {
            if(size == K) return false;
            
            Node n = new Node(value) ;
            n.prev = head ;
            n.next = head.next ;
            head.next = n ;
            n.next.prev = n ;
            size++ ;
            
            return true ;
        }
        
        public boolean insertLast(int value) {
            if(size == K) return false;
            
            Node n = new Node(value) ;
            n.prev = tail.prev ;
            n.next = tail ;
            tail.prev = n ;
            n.prev.next = n ;
            size++ ;
            
            return true ;
        }
        
        public boolean deleteFront() {
            if(size == 0) return false;
            
            Node n = head.next ;
            n.delete() ;
            size-- ;
            return true ;
        }
        
        public boolean deleteLast() {
            if(size == 0) return false ;
            
            Node n = tail.prev ;
            n.delete() ;
            size-- ;
            return true ;
            
        }
        
        public int getFront() {
            if(size == 0) return -1;
            
            return head.next.data;
        }
        
        public int getRear() {
            if(size == 0) return -1;
            
            return tail.prev.data;
        }
        
        public boolean isEmpty() {
            return size == 0 ;
        }
        
        public boolean isFull() {
            return size == K ;
        }
    }
}
