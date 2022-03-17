package Bit_Manipulation;

public class Q9_Single_Number_III {

    public int[] singleNumber(int[] nums) {
        
        // As there are only two numbers which appeares only once so if do the "XOR" operation then
        //it will give us the "XOR" of those two single numbers becuase rest of the numbers becomes zero on xor( as  X ^ X == 0).
        
        // step o1 : XOR numbers
        
        int mask = 0 ;
        
        for(int val : nums)
            mask = mask ^ val;
        
        // now the xor we got have some set bit so find the right most set bit. and create mask of it.
        
        int rsb = mask & -mask ; // got the right most set bit.
        
        int num1 = 0 ;
        int num2 = 0 ;
        
        // now check same bit (rsb) of every num of nums if the set bit matches in num then that will give us one number that comes once.
        // and second number will be segreggated from num of nums wwhose set bit does not match with rsb
        
        for(int val : nums){
            if( (rsb & val) == 0){
                /// means set bit does not matched.
                num2 = num2 ^ val ;
            }
            else{
                num1 = num1 ^ val ;
            }
        }
        
        
        return new int[]{num1,num2} ;
        
    }
    
}
