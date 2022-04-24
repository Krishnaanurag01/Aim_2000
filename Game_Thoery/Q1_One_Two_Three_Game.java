package Game_Thoery ;
import java.io.*;
public class Q1_One_Two_Three_Game {
    
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
    
        long n = Long.parseLong(br.readLine()) ;
    
        // int dp[] = new int[n+1] ;
    
        if(n % 3 == 0){
          System.out.println("BOB");
        }
        else{
          System.out.println("ALICE");
        }
    
      }
}
