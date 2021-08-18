package Strings;

import java.util.HashMap;

public class Q24_Roman_Numerals_to_Decimal {
    public static void main(String[] args) {
        System.out.println(getNumeralOfRomanString("MCMIV"));
        System.out.println(getIntegerOfRoman("MCMIV"));
    }


    // time complexicity : o(n) and space complexicity : o(1) 
    public static int getNumeralOfRomanString(String s) {
        int result = 0 ;
        for (int i = 0; i < s.length(); i++) {
            
            // taking i th index character value .
            int s1 = getValueOfRoman(s.charAt(i));

            // checking if i+1 availabe and if i+1 index is larger then adding s2 - s1 to  result. 
            if( i + 1 < s.length()){
                int s2 = getValueOfRoman(s.charAt(i+1));

                if(s1 >= s2){

                    result += s1;
                }
                else{
                    result += s2 - s1;
                    i++;
                }
            }
            else{
                result += s1;
            }
        }
        return result;
    }

    public static int getValueOfRoman(char c) {
        
        switch (c) {
            case 'I':
                return 1;
            case 'V' :
                return 5;
            case 'X' :
                return 10;
            case 'L' :
                return 50;
            case 'C' :
                return 100;
            case 'D' :
                return 500;
            case 'M' :
                return 1000;

            default:
            return -1;
        }
    }

    // using hashmap.

    public static int getIntegerOfRoman(String s) {

        HashMap<Character ,Integer > map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


        // as hashmap took only 6 space so it is constant space o(1).

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            
            if(i !=s.length()-1 && map.get(s.charAt(i+1)) > map.get(s.charAt(i)) ){
                ans += map.get(s.charAt(i+1)) - map.get(s.charAt(i)) ;
                i++;
            }
            else{
                ans += map.get(s.charAt(i));
            }
        }
        
        return ans;
    }
}
