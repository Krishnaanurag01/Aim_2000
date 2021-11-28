package Problem_Of_The_day;
import java.util.*;

public class Q15_count_triplet_in_LL {

    static class Node{
        int data ; 
        Node next ;

        
    }

    public static void main(String[] args) {
        
    }

    static int countTriplets(Node head, int x) 
    { 
        ArrayList<Integer> a = new ArrayList<>();
        Node ptr =head;
        while(ptr!=null){
            a.add(ptr.data);
            ptr=ptr.next;
        }
        Collections.sort(a);
         int cnt =0;
        int n = a.size();
        for(int i=0;i< n - 2 ;i++ ){
            int target = x - a.get(i);
            int j=i+1, k = n-1;
            while(j < k){
                int sum = a.get(j) + a.get(k);
                if( sum == target ){
                    
                    j++;
                    k--;
                    cnt++;
                }
                else if( sum < target){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        
        return cnt;
    } 
    
}
