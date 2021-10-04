package Strings;

public class Q41_Recursively_print_all_sentences_that_can_be_formed_from_list_of_word_lists {
    public static void main(String[] args) {
        String [][]arr  = {{"you", "we", ""},
                     {"have", "are", ""},
                     {"sleep", "eat", "drink"}};
        printAllPosibleSentences(arr);
    }

    private static int  R = 0;
    private static int  C = 0;


    public static void printAllPosibleSentences(String[][] strArr) {
        R = strArr.length;
        C  = strArr[0].length;
        
        String output[] = new String[R];

        for (int i = 0; i < C; i++) {
           if(strArr[0][i] != "" ){
               printUntil(strArr, 0 , i , output);
           }

        }

    }


    private static void printUntil(String[][] strArr, int m , int n , String[] output) {

        output[m] = strArr[m][n] ; // stroring data.
        

        if( m == R-1){
            //means last row then print all of output.
            for (int i = 0; i < output.length; i++) {
                System.out.print(output[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < C ; i++) {
            if(strArr[m+1][i] != ""){
                printUntil(strArr, m+1 , i, output);
            }
        }


    }
}
