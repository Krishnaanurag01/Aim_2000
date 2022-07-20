package Problem_Of_The_day;

public class Q103_Best_Sightseeing_Pair {

    public int maxScoreSightseeingPair(int[] values) {
 
        int maxI=values[0]+0;
        int res=-1;
        for(int i=1;i<values.length;i++) {
            res=Math.max(res,maxI+values[i]-i);
            maxI=Math.max(maxI,values[i]+i); // we will take the max values[i] + i because on addion larger values give max result
        }
        return res;
    }
}
