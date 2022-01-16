package Arrays_and_string;

public class Q31_Complex_Number_Multiplication {

    /* multiplication of complex number is :


    (a + bi) * (c + di) =>  multiply a with c + di + multiply bi with c + di ,

    // i = root of -1 so i^2 = - 1 ;

    */ // check copy/pepcoding for better explanation


    public String complexNumberMultiply(String num1, String num2) {
        
        int a = Integer.parseInt(num1.substring(0, num1.indexOf('+') )) ;
        int b = Integer.parseInt(num1.substring( num1.indexOf('+') + 1 , num1.length() - 1 )) ;
        int c = Integer.parseInt(num2.substring(0, num2.indexOf('+') )) ;
        int d = Integer.parseInt(num2.substring( num2.indexOf('+') + 1 , num2.length() - 1 )) ;

        return "" + (a*c - b*d) + "+" + (a*d + b*c)+ "i" ; 
    }
    
}
