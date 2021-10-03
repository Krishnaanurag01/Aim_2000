package Strings;

import java.util.ArrayList;

public class Q30_Program_to_generate_all_possible_valid_IP_addresses_from_given_string {
    public static void main(String[] args) {
        System.out.println(getAllPosibleIP("25525511135"));
    }
    public static ArrayList<String> getAllPosibleIP(String s) {

        ArrayList<String> list = new ArrayList<>();

        int n = s.length();

        for (int i = 1 ; i < n && i < 4; ++i) {
            String firstPart = s.substring(0, i);

            // checking is valid or not.
            if (!isValid(firstPart)) 
            continue; // if not then started with next iteration.

            // else dive further means look for next part.
            for (int j = 1; i +  j < n && j < 4; ++j) {
                String secondPart = s.substring(i,i+j);

                //checking second part.
                if(!isValid(secondPart)) continue;

                // else.
                for (int k = 1; i + j + k < n && k < 4 ; ++k) {
                    String thirdPart = s.substring(i+j, i+j+k);
                    String fourthPart = s.substring(i + j + k) ;

                    if( !isValid(thirdPart) || !isValid(fourthPart)){
                        continue;
                    }
                    // otherwise add all parts and store it in the list.

                    list.add(firstPart + "." + secondPart + "." + thirdPart + "." + fourthPart);
                    
                }
            }
        }
        return list;  
    }


    // this function check whether the given string is valid or not.  demo ip : "123.456.11.135" or  "123.456.111.13" 
    public static boolean isValid(String s) {
        
        // each part should not be greater than length 3.
        if(s.length() > 3)
        return false;


        // zero is acceptable only when the length of string is 1 means string of only one char.
        if (s.startsWith("0") && s.length() > 1) {
            return false;
        }

        int value = Integer.parseInt(s);


        return value >= 0 && value <= 255 ;
        
    }
}
