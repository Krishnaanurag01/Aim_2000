package Strings;


public class Q4_Check_if_strings_are_rotations_of_each_other_or_not {
 public static void main(String[] args) {
     System.out.println(isRotationOf("ABCDE", "CDEAB"));
     System.out.println(isRotation("ABCDE", "CDEAB"));

 }   

 // USING A BUILT-IN FUNCTION .
 public static boolean isRotationOf(String str1 , String str2) {
     
    return (str1.length()== str2.length() && (str1 + str1).indexOf(str2) !=-1);
 }

 //WITHOUT USING ANY BUILT-IN FUNCTION.

 public static boolean isRotation(String str1 , String str2) {
     
  
     if(str1 == str2){
         return true;
     }

    //  left shifting first char of string 2 to the end . and comparing with string 1 if it is is equal then returing true o/w false.
    for (int i = 0; i < str2.length(); i++) {
        str2 = rotateIt(str2);
        // System.out.println(str2);
        if(str1.equals(str2)) return true;
        
    }

    return false;
 }
 

 // function to left  rotate array.

 public static String rotateIt(String str2) {
     
    char[] charArray = str2.toCharArray();
    char temp = charArray[0];
    for (int j = 0; j < charArray.length-1; j++) {
        charArray[j]=charArray[j+1];
    }
    charArray[str2.length()-1] = temp;

    return String.valueOf(charArray);
 }
}
