package Binary_Tree;


// using same approch which we used in Q44 (node at distance k)
public class Q67_Burning_Tree {

     class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }

    static int time ;
    public static int minTime(Node root, int target) 
    {
        time = 0 ;
        helper(root,target) ; // calling root to node path function.
        return time;
    }
    
    static int helper(Node root, int target){ // this function is nothing but a root to node path function.
        if(root == null) return -1 ; // -1 denotes we did not get our target node yet.
        
        if(root.data == target){ // if we first time found our target then call with 1 time. as it will take 1 sec to burn its adjencent nodes.
            getTime(root.left,1,root) ; //going left with 1 sec and root is blocked means this getTime function can't trvaerse the assigned root.
            getTime(root.right,1,root); // same for right
            return 1 ; // also returning 1 to parent that denotes 1 edge between us and parent or 1 time to burn parent tree as well.
        }
        
        int ld = helper(root.left,target) ; // getting left data
        int rd = helper(root.right,target) ; // getting right data
        
        if(ld != -1){ // if lf is not -1 then it surely has target node in its path so check for current parent.
            getTime(root,ld,root.left) ; // here sending parent and left data and blocking roots left child as we already came from there.
            return ld + 1 ; // now returning ld +1 that is time taken to burn tree till now +1 time to burn parent time.
        }
        else if(rd != -1){ // same as left tree
            getTime(root,rd,root.right) ;
            return rd + 1 ;
        }
        
        return -1 ; // if no one has target node then return -1
    }
    
    static void getTime(Node root, int tsf, Node blockedNode){
        if(root == null || root == blockedNode) return ; // if null pr came to blocked node then return
        
        time = Math.max(time,tsf) ; // finding the max
        getTime(root.left,tsf+1, blockedNode) ; // going to left with +1 time
        getTime(root.right,tsf+1,blockedNode) ; // right with +1 time.
    }
    
}
