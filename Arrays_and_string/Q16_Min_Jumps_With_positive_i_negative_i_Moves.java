package Arrays_and_string;

public class Q16_Min_Jumps_With_positive_i_negative_i_Moves {

    public static int minJumps(int x) {

        int jump = 1;
        int sum = 0;

        while (sum < x) {
            sum += jump;
            jump++;
        }

        if ((sum - x) % 2 == 0) {
            return jump - 1;
        } else if ((sum + jump - x) % 2 == 0) {
            return jump;
        } else {
            return jump + 1;
        }
    }
    
}
