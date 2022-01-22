package Arrays_and_string;

public class Q54_Bulb_Switcher_Iv {
    
    public static int minFlips(String target) {

        int count = 0 ; // total answer
        char last = '0' ; // this carry the information of last bulb, as intitally all bulbs are off so last will also be 0 (off).

        for(int i = 0 ; i < target.length() ; i++){

            if(target.charAt(i) == last){ // if current bulb is same as last bulb then skip it.
                continue ;
            }
            else{ // if current bulb is not same as last bulb ( like current bulb is on but the last bulb is off or current is off and last is on) then increase count and change last bulb to reverse(that is 0 -> 1 and 1 -> 0). 
                // we are changin last bulb becuase it is given that if flip current bulb then this will effect current bulb to last bulb so change in state of current bulb will also change same state to i - n bulb 
                count++ ;
                last = last == '0' ? '1' : '0' ;
            }
        }

        return count ;
    }


}
