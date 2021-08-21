package Arrays;

import java.util.Arrays;
import java.util.Stack;

public class MergeIntervals_Q19 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        intervals = mergingIntervals(intervals);
        for (int[] is : intervals) {
            System.out.print("["+is[0]+" "+is[1]+"]");
        }


    }



    public static int[][] mergingIntervals(int[][] intervals) {
        
        Arrays.sort(intervals , (a,b)-> Integer.compare(a[0], b[0]));
        Stack<int[]> stack = new Stack<>();
        stack.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int startpoint2 = intervals[i][0];
            int endpoint2 = intervals[i][1];

            int[] stackInterval = stack.pop();

            int startpoint1 = stackInterval[0];
            int endpoint1 = stackInterval[1];

            int maxendPoint = Math.max(endpoint1, endpoint2);
            if(endpoint1 >= startpoint2){
                int[] newInterval = new int[]{startpoint1,maxendPoint};
                stack.push(newInterval);
            }
            else{
                stack.push(stackInterval);
                stack.push(intervals[i]);
            }
        }

        int[][] outputIntervals = new int[stack.size()][2];
        for (int i = outputIntervals.length-1 ; i >= 0; i--) {
            int[] stackInterval = stack.pop();
            outputIntervals[i][0] = stackInterval[0];
            outputIntervals[i][1] = stackInterval[1];            
        }

        return outputIntervals;
    }
}
