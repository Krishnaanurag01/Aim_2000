package Strings;

public class Q23_Search_a_Word_in_a_2D_Grid_of_characters {
    public static void main(String[] args) {
        char[][] grid = { { 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' },
                          { 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' },
                          { 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } };
       searchPattern("GEEKS", grid);
    }

       // R,C = denotes ROW and COLUMN
    private static int R ,C;

    // x and y is direction array of row and column for example : when row is added with x[0] and column with y[0] then it will go to the previous row and previous col.
    private static int[] x = {-1,-1,-1, 0, 0, 1 , 1, 1 };
    private static int[] y = {-1, 0, 1,-1  ,1, -1 , 0 ,1};


    public static void searchPattern(String s , char[][] charArr) {
        R = charArr.length;
        C = charArr[0].length;

        // checking each character if the first character is same as string then we'll move forward o/w it'll start searching for next character.

        for (int i = 0; i < R ; i++) {
            for (int j = 0; j < C ; j++) {
                if(searchCharacters(charArr , i , j , s)){
                    System.out.println("present at " +i +" "+ j);
                }
            }
        }
    }


    private static boolean searchCharacters(char[][] charArr, int i, int j, String s) {

        // if first character is not same then it return false.
        if(charArr[i][j] != s.charAt(0))
        return false;

        int len =  s.length();

        // here giving all 8 direction (left , right , up , down and diagonally) to the new row and column.

        for (int direction = 0; direction < 8 ; direction++) {
            
            // intializing l outside so that we can compare length of l and len.
            // rd is temporary row and temporay col.
            int l , rd = i + x[direction] , cd = j + y[direction];
            // starting with 1 index because oth index is already mathched.
            for ( l = 1; l < len; l++) {
                
                // if out of bound then break .
                if(rd < 0 || rd >= R || cd < 0 || cd >= C){
                    break;
                }

                if(charArr[rd][cd] != s.charAt(l)){
                    break;
                }

                // this means adding same direction further till the bound.

                rd += x[direction];
                cd += y[direction];
            }
            // return true when size of string is equals to l.
            if(l == len) return true;
        }
        return false;
    }
}
