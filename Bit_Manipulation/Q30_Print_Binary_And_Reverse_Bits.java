package Bit_Manipulation;

public class Q30_Print_Binary_And_Reverse_Bits {

    public static int reverseBits(int n) {

        // it will be used for forming the reverse number
        int rev = 0;
        int j = 0;

        // denotes whether any set bit came so far or not.
        boolean flag = false;


        for (int i = 31; i >= 0; i--) {

            int mask = (1 << i);

            if (flag) { // if flag is on.(means some set bit already came)

                if ((n & mask) != 0) {
                    // set bit is on
                    rev = rev | (1 << j);
                    System.out.print("1");
                    j++;
                } else {
                    // when set bit is off
                    // rev = rev | (0 << j) ;
                    System.out.print("0");
                    j++;
                }
            } else { // when flag is off and
                     // first set bit comes then turn on the flag and add first bit of reverse.
                if ((n & mask) != 0) {
                    flag = true;
                    System.out.print("1");  // printing bit.
                    rev = rev | (1 << j);
                    j++;
                } else {

                }
            }
        }
        System.out.println();
        System.out.println(rev);// printing reversed number 

        return rev;

    }

}
