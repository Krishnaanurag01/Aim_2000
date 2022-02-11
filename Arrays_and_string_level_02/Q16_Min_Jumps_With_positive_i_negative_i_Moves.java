package Arrays_and_string_level_02;

public class Q16_Min_Jumps_With_positive_i_negative_i_Moves {

    public static int minJumps(int x) {

        int jump = 1; // this denotes intially we can do a jump of 1 unit.
        int sum = 0;

        while (sum < x) { // while our sum (sum + jump) is lesser than x, keep jumping.
            sum += jump;
            jump++; // increment jump size every time after a jump.
        }

        // the sum we reach will always be greater or equal to x.

        if ((sum - x) % 2 == 0) {  // this denotes that the distance between our sum we reach and the destination is if even length then return directly jump -1 becuase In the above loop we are incrementing jump then checking conditions. (when even then return the number of jump we done)
            return jump - 1;
        } else if ((sum + jump - x) % 2 == 0) { // this denotes that if the above condition is not true means distance is odd then do one more jump so adding jump now checking the distance between x and sum if now even then return jump.(when even then return the number of jump we done) here we are returning jump not jump-1 becuase In the above condition the junp we getting increment each time that's why we did -1 
            return jump;
        } else { // else this denotes that if the above elseif condition didn't give even distance after doing one more jump then it means if we do just one more jump then it will surely give even distance so returning jump +1 .( 1 extra jump was added by loop and 1 by ourselves) 
            return jump + 1;
        }
    }
    
}
