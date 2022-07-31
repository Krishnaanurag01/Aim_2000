package Problem_Of_The_day;

public class Q132_Range_Sum_Query_Mutable {

    class NumArray {
    
        class SegmentTreeNode{
            int start, end ; // this is range for current node.
            SegmentTreeNode left, right ; // childrens
            int sum ; // current node value
            
            SegmentTreeNode(int start, int end){
                this.start = start ;
                this.end = end ;
                left = null ;
                right = null;
                sum = 0;
            }
        }
    
        
        // building segment tree at the time of initialization. ( check explanation by coding decoded)
        SegmentTreeNode root ;
        public NumArray(int[] nums) {
            root = buildSegmentTree(nums,0,nums.length-1) ;
        }
        
        SegmentTreeNode buildSegmentTree(int[] nums, int start, int end){
            if(start > end) return null ;
            else{
                SegmentTreeNode node = new SegmentTreeNode(start,end) ;
                if(start == end){ // means leaf node then assign directly value
                    node.sum = nums[start] ;
                }
                else{
                    int mid = start + (end - start)/2 ;
                    node.left = buildSegmentTree(nums,start,mid) ;
                    node.right = buildSegmentTree(nums,mid+1,end) ;
                     node.sum = node.left.sum + node.right.sum ; // node value will be sum of it's children
                }
                return node ;
            }
        }
        
        public void update(int index, int val) {
            updateHelper(root,index,val) ; //for updating the segment tree
        }
        
        void updateHelper(SegmentTreeNode node, int index, int val){
            
            if(node.start == node.end){ // means leaf node which we were looking for
                node.sum = val ; // update the value
                return ;
            }
            else{
                int mid = node.start + (node.end - node.start)/2; // finding mid index
                if(mid >= index){ // if our index lieas between 0 to mid index then go left 
                    updateHelper(node.left,index,val) ;
                }
                else{ // otherwise go right
                    updateHelper(node.right,index,val) ;
                }
                node.sum = node.left.sum + node.right.sum ; // also updating the parent node value while backtracking
            }
        }
        
        
        public int sumRange(int left, int right) {
            return sumRangeHelper(root,left,right) ;
        }
        
        int sumRangeHelper(SegmentTreeNode node, int start, int end){
            if(node.start == start && node.end == end){ // if found the range then return sum
                return node.sum ;
            }
            else{
                int mid = node.start + (node.end - node.start)/2;
                if(mid >= end){ // if the range lieas between 0 to mid then go left
                    return sumRangeHelper(node.left,start,end) ;
                }
                else if(mid+1 <= start){ // else if starts after mid then go right
                    return sumRangeHelper(node.right,start,end) ;
                }
                // otherwise the range must be half in left side and other half in right side so return both sum side answer sum.
                return sumRangeHelper(node.left,start,mid) + sumRangeHelper(node.right,mid+1,end) ;
            }
            
        }
    }
}
