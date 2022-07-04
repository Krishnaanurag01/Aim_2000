package Problem_Of_The_day;
import java.util.*;

public class Q76_Count_the_paths {

    // simple count of source to destination path

    public int possible_paths(int[][] edges, int n, int s, int d) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            graph.get(u).add(v);
        }
        boolean[] visited = new boolean[n];
        return helper(s, graph, d, visited);
    }

    int helper(int source, ArrayList<ArrayList<Integer>> graph, int dest, boolean[] visited) {
        if (source == dest)
            return 1;

        visited[source] = true;
        int count = 0;

        for (int nbr : graph.get(source)) {
            if (visited[nbr] == false) {
                count += helper(nbr, graph, dest, visited);
            }
        }

        visited[source] = false;
        return count;
    }
}
