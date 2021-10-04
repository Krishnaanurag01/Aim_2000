package Strings;



public class Q38_Function_to_find_Number_of_customers_who_could_not_get_a_computer {
    public static void main(String[] args) {
        System.out.println(getCustomerWhoDidntGetComputer(3, "GACCBDDBAGEE"));
        System.out.println(getCustomerWhoDidntGetComputer(2, "ABBAJJKZKZ"));
        System.out.println(getCustomerWhoDidntGetComputer(3, "GACCBDDBAGEE"));
        System.out.println(getCustomerWhoDidntGetComputer(3, "GACCBGDDBAEE"));
        System.out.println(getCustomerWhoDidntGetComputer(1, "ABCBCADEED"));

        // System.out.println('A' - 'A');

    }
    public static int getCustomerWhoDidntGetComputer(int total_computers , String s) {
        
        // took 26 length because alphabets are of 26 characters. 
       char[] seen = new char[26];

       int ans= 0 ;
       int occupied_comp = 0 ;

       for (int i = 0; i < s.length(); i++) {
           
        int index = s.charAt(i) - 'A' ;   // this will give index in 0,1,2,3.. ( ascii value - 65).

        // now check if the received index has no value.
        if(seen[index] == 0 ){
            // means new customer arrived.
            seen[index] = 1;

            // if computers available then assign it to the user.
            if(occupied_comp < total_computers){
                occupied_comp++;
                // here 2 denotes that the computer is assigned the user.
                seen[index] = 2;
            }
            else{
                // if computers are not available then add it to the result.
                ans++;
            }
        }
        else{
            if(seen[index] == 2){
                // means computer is already assigned to the computer.
                // so take computer back from the user.
                seen[index] = 0;
                // decreaing the occupied Computer.
                occupied_comp--;
            }
        
        }
       }

       return ans ;
    }
}
