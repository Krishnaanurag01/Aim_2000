package Problem_Of_The_day;


public class Q18_Kth_Smallest_Number_in_Multiplication_Table {

    // public int KthSmallest(int m, int n, int k) {
        
    //     PriorityQueue<Integer> queue = new PriorityQueue<>( Collections.reverseOrder() ) ;

    //    for (int i = 1 ; i <= m ; i++) {
    //        for (int j = 1 ; j <= n ; j++) {

    //            if(queue.size() < k){
    //                queue.add(i*j) ;
    //            }
    //            else{
    //                int num = i*j ;
    //                if(queue.peek() > num ){
    //                    queue.poll();
    //                    queue.add(num) ;
    //                }
    //            }
               
    //        }
           
    //    }

    //    return queue.peek() ;
 
    // }



    // method - 02



   public int KthSmallest(int m, int n, int k) {
    int low = 1 , high = m * n ;

    while (low < high) {
        int mid = low + (high - low) / 2;

        int capacity = count(mid, m, n); /// counting how many element are there till mid.
        if (capacity >= k) high = mid;
        else low = mid + 1;
    }

    return high;
}
private int count(int mid, int m, int n) {
    int count = 0;
    for (int i = 1; i <= m; i++) {
        int temp = Math.min(mid / i , n); // mid/ i  gives == j(col) , n (last col) // so if j becomes greater than n then it means its out of our table so we'll choose n.
        count += temp; // adding to count.
    }
    return count;
}
    
}
