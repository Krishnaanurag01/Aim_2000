package Strings;



public class Q19_Convert_a_sentence_into_its_equivalent_mobile_numeric_keypad_sequence {
    public static void main(String[] args) {

        String str[] = {"2","22","222",
                        "3","33","333",
                        "4","44","444",
                        "5","55","555",
                        "6","66","666",
                        "7","77","777","7777",
                        "8","88","888",
                        "9","99","999","9999"
                    };
 
        String input = "GEEKSFORGEEKS";
        System.out.println(printNumericSequence(str,input));
        
    }

    public static String printNumericSequence(String[] arr ,String s) {
        
        String output = "";

        for (int i = 0; i < s.length(); i++) {
            
            if(s.charAt(i)== ' '){
                output += "0";
            }
            else{
                int position = s.charAt(i) - 'A';
                output += arr[position];
            }
        }
        return output;
    }
}
