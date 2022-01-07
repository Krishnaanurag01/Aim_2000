package Problem_Of_The_day;

public class Q35_Longest_Common_Prefix_in_an_Array {


    // {geeksforgeeks, geeks, geek,
        // geezer}

    String longestCommonPrefix(String arr[], int n){
        
        int min = arr[0].length() ; // denotes the smallest length of string.

        for (int i = 1 ; i < arr.length; i++) {
            if(arr[i].length() < min){    // finding the length of smallest string.
                min = arr[i].length() ;
            }
        }

        StringBuilder sb = new StringBuilder() ;

        for (int i = 0 ; i < min ; i++) {
            char ch = arr[0].charAt(i) ; // taking each character till length of min string.

            int j ;
            for ( j = 1 ; j < arr.length; j++) {
                char ch2 = arr[j].charAt(i) ;

                if(ch != ch2){ // if character didn't match then return string if not empty else if it empty then return -1
                    return sb.toString().equals("") ? "-1" : sb.toString() ;
                }
            }

            if (j == arr.length) { // add the character if j runs completely and reach to arr.length value.
                sb.append(ch) ;
            }

        }
        // return string if not empty else if it empty then return -1
        return sb.toString().equals("") ? "-1" : sb.toString() ;
    }
    
}
