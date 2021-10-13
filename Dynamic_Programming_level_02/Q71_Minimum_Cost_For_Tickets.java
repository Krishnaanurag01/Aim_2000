package Dynamic_Programming_level_02;

public class Q71_Minimum_Cost_For_Tickets {

    public static void main(String[] args) {
        
    }

    // recursive approach.

    public static int get_min_cost(int[] days, int[] cost) {
        
        return cost_finder(days[0],days,cost) ; 
    }

    private static int cost_finder(int currDay, int[] days, int[] cost) {

        if(currDay > days[days.length - 1]){ // if current day is greater than last day of days array then return 0
            return 0 ;
        }

        int ans = Integer.MAX_VALUE  ; // this will have min value.

        if(will_I_Travel_Today(currDay,days)){ // if yes then run

            // cost[0] = 1 day pass , cost[1] = 7 days pass , cost[2] = 3 days pass.
             ans = cost_finder(currDay+1, days, cost) + cost[0]; // we store the cost if we took 1 day pass and call function for next day(current day + 1).

             // same as we check min answer, we took 7 days pass (cost[1]) and called fucntion for current day + 7 days cost.
             ans = Math.min(ans, cost_finder(currDay+7, days, cost) + cost[1]);

             // same as we check min answer, we took 30 days pass (cost[2]) and called fucntion for current day + 30 days cost.
             ans = Math.min(ans, cost_finder(currDay+30, days, cost) + cost[2]);
        }
        else{
            return cost_finder(currDay+1, days, cost);
        }

        return ans;
    }

    private static boolean will_I_Travel_Today(int currDay, int[] days) {  // this method checks if current day we travel or not ? and days array have all the days detail when we travel

        for (int i = 0; i < days.length; i++) {
            if(currDay == days[i]) return true ;
        }
        return false;
    }



    // method :- 02

    // using memoization.
    // just simply add an dp array with recursion. check which part is changing in recursive code.

    public static int get_min_cost_2(int[] days, int[] cost) {

        int[] dp = new int[400] ; // making 400 days of dp as there 365 days in an year so if we buy 30 day pass at last day then that will check dp for 365+30 day , so for safer side directly made for 400 length.
        
        return cost_finder_2(days[0],days,cost,dp) ; 
    }

    private static int cost_finder_2(int currDay, int[] days, int[] cost, int[] dp) {

        if(currDay > days[days.length - 1]){ // if current day is greater than last day of days array then return 0
            return dp[currDay] = 0 ; // save and return
        }

        if(dp[currDay] != -1) return dp[currDay] ; // if already has data then return it.
        int ans = Integer.MAX_VALUE  ; // this will have min value.

        if(will_I_Travel_Today(currDay,days)){ // if yes then run

            // cost[0] = 1 day pass , cost[1] = 7 days pass , cost[2] = 3 days pass.
             ans = cost_finder_2(currDay+1, days, cost,dp) + cost[0]; // we store the cost if we took 1 day pass and call function for next day(current day + 1).

             // same as we check min answer, we took 7 days pass (cost[1]) and called fucntion for current day + 7 days cost.
             ans = Math.min(ans, cost_finder_2(currDay+7, days, cost,dp) + cost[1]);

             // same as we check min answer, we took 30 days pass (cost[2]) and called fucntion for current day + 30 days cost.
             ans = Math.min(ans, cost_finder_2(currDay+30, days, cost,dp) + cost[2]);
        }
        else{
            return dp[currDay] = cost_finder_2(currDay+1, days, cost,dp);
        }

        return dp[currDay] = ans; // save and return
    }


    // method - 03 :
    // using tabulations;   not giving correct output

    // private static int cost_finder_3(int[] days, int[] cost) {

    //     int[] dp = new int[400] ;

    //     for (int currDay = 399 ; currDay >= 0 ; currDay--) {

    //         if(currDay > days[days.length - 1]){ // if current day is greater than last day of days array then skip
    //            continue ;
    //         }

    //         int ans = Integer.MAX_VALUE ;
    
    //         if(will_I_Travel_Today(currDay,days)){ // if yes then run
    
    //             // cost[0] = 1 day pass , cost[1] = 7 days pass , cost[2] = 3 days pass.
    //              ans = dp[currDay+1] + cost[0]; // we store the cost if we took 1 day pass and call function for next day(current day + 1).
    
    //              // same as we check min answer, we took 7 days pass (cost[1]) and called fucntion for current day + 7 days cost.
    //              ans =  Math.min(ans , dp[currDay+7] + cost[1]);
    
    //              // same as we check min answer, we took 30 days pass (cost[2]) and called fucntion for current day + 30 days cost.
    //              ans = Math.min(ans , dp[currDay+30] + cost[2]);
    //         }
    //         else{
    //            dp[currDay] = dp[currDay+1] ;
    //         }
    
    //         dp[currDay] = ans;
    //     }



        
    //     return  dp[1] ; 
    
    // }



    
    
}
