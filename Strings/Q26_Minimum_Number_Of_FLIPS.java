package Strings;

public class Q26_Minimum_Number_Of_FLIPS {
    public static void main(String[] args) {
         System.out.println(getMinimumNumberOfFlips("0001010111"));
    }
    public static int getMinimumNumberOfFlips(String s) {

        int ans1 = 0;
        int ans2 = 0;
       
            for (int i = 0; i < s.length(); i++) {
                if(i%2 == 0){
                    if( s.charAt(i) != '0')
                    ans1 +=1;

                    if( s.charAt(i) != '1')
                    ans2 +=1;
                }
                else{
                    if(  s.charAt(i) != '1')
                    ans1++;

                    if(  s.charAt(i) != '0')
                    ans2++;
                }
            }


        return Math.min(ans1, ans2);
    }
}
