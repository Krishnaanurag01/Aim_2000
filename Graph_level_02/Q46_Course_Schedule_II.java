package Graph_level_02;

import java.util.*;

public class Q46_Course_Schedule_II {

    // using khans algorithm(iterative topological sort)

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> nbrs = new ArrayList<>(); // first storing source and nbrs for easiness

        for (int i = 0; i < numCourses; i++) {
            nbrs.add(new ArrayList<>());
        }

        // now finding the indegree
        int[] indeg = new int[numCourses];

        for (int[] c : prerequisites) {
            indeg[c[0]]++;
            nbrs.get(c[1]).add(c[0]);
        }

        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0)  // adding noes with degree 0
                q.add(i);
        }

        int idx = 0;
        int[] ans = new int[numCourses];

        while (q.size() > 0) {
            int rn = q.removeFirst();
            ans[idx++] = rn;

            for (int nbr : nbrs.get(rn)) {
                indeg[nbr]--; // subtracting 1 and checking if it's degree become 0 or not.
                if (indeg[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }

        return idx == numCourses ? ans : new int[] {};

    }
}
