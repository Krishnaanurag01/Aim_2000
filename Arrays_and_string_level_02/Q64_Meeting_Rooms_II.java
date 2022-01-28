package Arrays_and_string_level_02;

import java.util.*;

public class Q64_Meeting_Rooms_II {

    public static int meetingRooms(int intervals[][]) {

        if (intervals.length == 0)
            return 0; // when length is 0 then return 0.

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // sorting based on the starting position.

        PriorityQueue<Integer> q = new PriorityQueue<>();

        q.add(intervals[0][1]); // adding the end time of the first meeting.

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= q.peek()) { // checking if the start time of new meeting is greater than the lowest
                                               // end time of previous meeting (stored in queue) then it means that we
                                               // can serve the new meeting in previous meeting room.
                q.poll(); // so removing the lowest end time meeting from queue
                q.add(intervals[i][1]); // and as we serving the new meeting in the same room so adding this meetings
                                        // end time.
            } else {
                q.add(intervals[i][1]); // else it denotes this meeting can't be served in previously occupied room so
                                        // serving this meeting in new room so adding the end time in q.
            }
        }

        return q.size(); // denotes the total room needed.
    }

    // method 02 : chronological way!, It's same as minimum platform
    // method(Striver's method)

    public static int meetingRooms2(int intervals[][]) {

        int n = intervals.length;

        if (n == 0)
            return 0;

        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int curr = 1;
        int total = 1;

        int i = 1;
        int j = 0;

        while (i < n) {

            if (j < i && start[i] >= end[j]) {
                curr--;
                j++;
            }

            curr++;
            i++;
            total = Math.max(total, curr);

        }

        return total;
    }

}
