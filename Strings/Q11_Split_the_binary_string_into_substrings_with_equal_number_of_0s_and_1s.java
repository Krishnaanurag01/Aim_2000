package Strings;

/**
 * Q11_Split_the_binary_string_into_substrings_with_equal_number_of_0s_and_1s
 */
public class Q11_Split_the_binary_string_into_substrings_with_equal_number_of_0s_and_1s {

    public static void main(String[] args) {
        System.out.println(splitIntoEqual0s1s("0100110101"));
    }
    public static int splitIntoEqual0s1s(String str) {
        
        int count0 = 0, count1 = 0;
        int cnt=0;

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='0'){
                count0++;
            }
            else{
                count1++;
            }

            if(count0 == count1){
                cnt ++;
            }
        }

        if(cnt == 0){
            
            return -1;
        } 

        return cnt;
    }
}