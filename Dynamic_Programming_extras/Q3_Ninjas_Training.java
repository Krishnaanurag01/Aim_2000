package Dynamic_Programming_extras;

public class Q3_Ninjas_Training {

    // optimal solution
    // Paint House - Many Colors same question. (done in dp lvl 1)
    // time : O(n) and space : O(1)

    public static int ninjaTraining(int n, int points[][]) {

        int t1 = points[0][0] ; // task 1
        int t2 = points[0][1] ; // task 2
        int t3 = points[0][2] ; // task 3
        // Write your code here..
        
        for(int i = 1 ; i < n ; i++){ // now running from task 2 
            int nt1 = points[i][0] + Math.max(t2,t3) ; // new task 1
            int nt2 = points[i][1] + Math.max(t1,t3) ; // new task 2
            int nt3 = points[i][2] + Math.max(t1,t2) ; // new taks 3
            
            // updating new task value
            t1 = nt1 ;
            t2 = nt2 ;
            t3 = nt3 ;
        }
        
        return Math.max(t1,Math.max(t2,t3)) ;
    }






    // using normal recursion : time : O(2^n) and space o(stack frames)

    public static int ninjaTraining2(int n, int points[][]) {

        // 3 -> all three task can be performed,
        // 0 -> 0 can't be performed,
        // 1 -> 1 can't be performed,
        // 2 -> 2 can't be performed
       return helper(n-1,points,3) ; 
    }
    
    static int helper(int day, int[][] merits, int last){ // last is the task that has been performed on last day so you can't do the same task today.
        if(day == 0){
            int max = Integer.MIN_VALUE ;
            for(int i = 0 ; i < 3 ; i++){
                if(i != last) max = Math.max(max,merits[day][i]) ; // when i not equals to last
            }
            return max;
        }
        
        int max = Integer.MIN_VALUE ;
        for(int i = 0 ; i < 3 ; i++){
            if(i != last){
                int pans = helper(day - 1, merits, i) + merits[day][i] ; // adding current day merit + check max in day -1 with i task restricted.
                max = Math.max(max, pans) ;
            }
        }
        
        return max ;
    }

    

    //using memoiation

    public static int ninjaTraining3(int n, int points[][]) {

        // 3 -> all three task can be performed,
        // 0 -> 0 can't be performed,
        // 1 -> 1 can't be performed,
        // 2 -> 2 can't be performed
        Integer[][] dp = new Integer[n][4] ; // using memoiation
       return helper(n-1,points,3, dp) ; 
    }
    
    static int helper(int day, int[][] merits, int last, Integer[][] dp){
        
        if(dp[day][last] != null) return dp[day][last] ;
        
        
        if(day == 0){
            int max = Integer.MIN_VALUE ;
            for(int i = 0 ; i < 3 ; i++){
                if(i != last) max = Math.max(max,merits[day][i]) ;
            }
            return max;
        }
        
        
        int max = Integer.MIN_VALUE ;
        for(int i = 0 ; i < 3 ; i++){
            if(i != last){
                int pans = helper(day - 1, merits, i,dp) + merits[day][i] ;
                max = Math.max(max, pans) ;
            }
        }
        
        return dp[day][last] = max ;
    }

}
