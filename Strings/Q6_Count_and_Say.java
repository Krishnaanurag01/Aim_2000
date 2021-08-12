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
            
            str+= '$';
            int count =1;
            char[] charArray = str.toCharArray();
            String temp = "";

            for (int j = 1 ; j < charArray.length; j++) {
                
                if(charArray[j]!= charArray[j-1]){

                    temp+=count ;
                    temp+= charArray[j-1];

                    count=1;
                }
                else{
                    count++;
                }
            }

            str = temp;
        }




        return str;
    }
}
