package Problem_Of_The_day;

public class Q220_Count_Square_Sum_Triples {

    public int countTriples(int n) {
        var count = 0;
        for (var a = 1; a < n; a++)
            for (var b = 1; b < n; b++) {
                var c = Math.sqrt((a * a) + (b * b));
                if (c == (int) c && c <= n)
                    count++;
            }
        return count;
    }
}
