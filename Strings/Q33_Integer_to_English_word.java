package Strings;

public class Q33_Integer_to_English_word {

    static String[] till_twenty = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
            "Twenty" };

    static String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
    // static String[] hundreds = {"" , ""}

    public static String get_nums(int num) {
        
        String s = "" ;
        if (num > 19 && num < 100) {
            s += tens[num/10] ;
            
            if(num % 10 != 0){
            s += " " ;
            s += till_twenty[num % 10] ;
            }
        }
        else if(num >= 100){
            s += till_twenty[num / 100] ;
            s += " Hundred " ;
            num = num % 100 ;

            if(num > 19){
                s += tens[num/10] ;
                if(num % 10 != 0){
                s += " " ;
                s += till_twenty[num % 10] ;
                }
            }
            else{
                s = till_twenty[num] ;
            }

        }
        else{
            s = till_twenty[num] ;
        }

        return s ;
    }

    public static String numberToWords(int n) {

        int billion = (n / 1000000000);
        n = n % 1000000000;

        int million = (n / 1000000);
        n = n % 1000000;

        int thousand = (n / 1000);
        n = n % 1000;

        int hundread = (n / 100);
        n = n % 100;

        int tens = (n);
        n = n % 10;

        // System.out.println(crore + " crore ");
        // System.out.println(lakh + " lakh");
        // System.out.println(thousand + " thousand");
        // System.out.println(hundread + " hundred");
        // System.out.println(tens + " tens ");
        // // System.out.println(singleDigit);

        String word = "";

        // System.out.println(get_nums(crore) +" crore");

        if (billion != 0) {
            word += get_nums(billion) + " Billion ";
        }

        if (million != 0) {
            word += get_nums(million) + " Million ";
        }

        if (thousand != 0) {
            word += get_nums(thousand) + " Thousand ";
        }

        if (hundread != 0) {
            word += get_nums(hundread) + " Hundred ";
        }

        if (tens != 0 ) {
            word += get_nums(tens);
        }

        // System.out.println(word);

        return word;
    }

    public static void main(String[] args) {

        
        System.out.println(  numberToWords(123333333));

    }
}
