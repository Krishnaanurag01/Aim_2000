package Dynamic_Programming_random ;

public class Q3_Minimum_Moves_to_Reach_Target_Score {
    public int minMoves(int target, int maxDoubles) {
        return helper(target,maxDoubles) ;
    }
    
    int helper(int target,int maxDoubles){
        if(target == 1) return 0 ; // when our target is 1 then return 0. as it is already on 1.
        if(maxDoubles == 0) return target - 1; // now if we can't do any double operation then it means we can only increasement( decreament in this function becuase it is top down) so it will take target -1 operation decreament to reach 1.
        else{// when doubles present
            if(target % 2 == 0){ // now if our target  is multiple of 2.
                return 1 + helper(target/2, maxDoubles-1) ;  // then use one operation for doubles operatin(dividing target into half)
            }
            else{ // when target is not even then it take 2 operations : 1 is for dividing and and another 1 for decreamenting once to make target even after divison.
                return 2 + helper(target/2, maxDoubles-1) ; 
            }
        } 
    }
}