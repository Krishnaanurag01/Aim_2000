package Strings;



public class Q6_Count_and_Say {
    public static void main(String[] args) {

        System.out.println(countAndSayIt(5));
        
    }
    public static String countAndSayIt(int num) {
     
        if(num==1) return "1";
        if(num==2) return "11";

        String str ="11";

        for (int i = 3; i <=num; i++) {
            
            str+= '$'; // so that we can identify the last element.
            int count =1; // becauze every element have 1 count by default.
            char[] charArray = str.toCharArray();
            String temp = ""; /// will add the answer here.

            for (int j = 1 ; j < charArray.length; j++) {  // started from 1 so that we can compare with 1-0 index.
                
                if(charArray[j]!= charArray[j-1]){ // when nulll then add count and number and set count = 1 for next number

                    temp+=count ;
                    temp+= charArray[j-1];

                    count=1;
                }
                else{ // else increase the count.
                    count++;
                }
            }

            str = temp;
        }




        return str;
    }
}
