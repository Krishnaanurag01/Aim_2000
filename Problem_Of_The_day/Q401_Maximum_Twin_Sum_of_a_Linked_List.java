package Problem_Of_The_day;

public class Q401_Maximum_Twin_Sum_of_a_Linked_List {
    public int pairSum(ListNode head) {
        ArrayList<Integer> twin = new ArrayList<>() ;
        
        while(head != null){
            twin.add(head.val) ;
            head = head.next ;
        }
        
        int ans = 0 ;
        int n = twin.size() ;
        
        for(int i = 0 ; i <= (twin.size()/2) - 1 ; i++){
            ans = Math.max(ans, twin.get(i) + twin.get(n - 1 - i)) ;
        }
        
        return ans;
    }    
}
