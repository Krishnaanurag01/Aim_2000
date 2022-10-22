package Problem_Of_The_day ;

public class Q258_Integer_to_Roman {

    public String intToRoman(int num) {
        
        // just start adding from last.
        
        String s = num + "" ;
        String ans = "" ;
        
        for(int i = s.length() - 1 ; i >= 0 ; i--){
            char digit = s.charAt(i)  ;
            int space = s.length() - i -1 ; // it denotes how many digits are there after current digit.
            
            if(space == 0){
                ans = getRoman(digit) + ans ;
            }
            else if(space == 1){ // for tens place
                
                if(digit == '1') ans = ("X")  + ans;
                if(digit == '2') ans = ("XX") + ans;
                if(digit == '3') ans = ("XXX")+ ans;
                if(digit == '4') ans = ("XL") + ans;
                if(digit == '5') ans = ("L")  + ans;
                if(digit == '6') ans = ("LX") + ans;
                if(digit == '7') ans = ("LXX")+ ans;
                if(digit == '8') ans = ("LXXX")+ans;
                if(digit == '9') ans = ("XC") + ans;

            }
            else if(space == 2){ // for hundreds
                
                if(digit == '1') ans = ("C") + ans;
                if(digit == '2') ans = ("CC") + ans ;
                if(digit == '3') ans = ("CCC") + ans;
                if(digit == '4') ans = ("CD") + ans;
                if(digit == '5') ans = ("D") + ans;
                if(digit == '6') ans = ("DC") + ans;
                if(digit == '7') ans = ("DCC") + ans ;
                if(digit == '8') ans = ("DCCC") + ans ;
                if(digit == '9') ans = ("CM")  + ans;
                
            }
            else if(space == 3){ // for thousands place.
                
                if(digit == '1') ans = ("M")  + ans ;
                if(digit == '2') ans = ("MM") + ans;
                if(digit == '3') ans = ("MMM")+ ans ;
            }

        }
        
        
        return ans ;
    }
    
    String getRoman(char digit){
        
        switch(digit){
            case '1' : return "I";
            case '2' : return "II" ;
            case '3' : return "III" ;
            case '4' : return "IV" ;
            case '5' : return "V" ;
            case '6' : return "VI" ;
            case '7' : return "VII" ;
            case '8' : return "VIII" ;
            case '9' : return "IX" ;
            default: return "" ;
        }
    }
}
