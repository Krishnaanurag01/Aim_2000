package Strings;

public class Q23_Search_a_Word_in_a_2D_Grid_of_characters {
    public static void main(String[] args) {
        char[][] grid = { { 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' },
                          { 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' },
                          { 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } };
       searchIn2D_Grid("GEEKS", grid);
    }
    public static void searchIn2D_Grid(String s , char[][] chArr) {
        
        int sSize = s.length();
        for (int i = 0; i < chArr.length; i++) {
            for (int j = 0; j < chArr[0].length; j++) {
                justDoIt(i,j,s,chArr,sSize,0);
            }
        }
    }
    private static void justDoIt(int i, int j, String s, char[][] chArr, int sSize, int k) {

        if(i >= 0 && i < chArr.length && j >= 0 && j < chArr.length && s.charAt(k) == chArr[i][j]){
            char temp = chArr[i][j];
            chArr[i][j] = '0';
            k++;

            if(k == sSize){
                System.out.println("Found it at "+ i +" , "+j);
                return;
            }
            else{
                justDoIt(i+1,j,s,chArr,sSize,0);
                justDoIt(i-1,j,s,chArr,sSize,0);
                justDoIt(i,j+1,s,chArr,sSize,0);
                justDoIt(i,j-1,s,chArr,sSize,0);
                justDoIt(i-1,j-1,s,chArr,sSize,0);
                justDoIt(i-1,j+1,s,chArr,sSize,0);
                justDoIt(i+1,j-1,s,chArr,sSize,0);
                justDoIt(i+1,j+1,s,chArr,sSize,0);

            }
            chArr[i][j] = temp;
        }
    }
}
