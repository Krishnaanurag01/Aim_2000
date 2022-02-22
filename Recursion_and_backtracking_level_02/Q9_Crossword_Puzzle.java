package Recursion_and_backtracking_level_02;

import java.util.Scanner;

public class Q9_Crossword_Puzzle {

    public static void solution(char[][] arr, String[] words, int vidx) {

        //base case
        if(vidx == words.length ){
    
          print(arr) ;
          return ;
        }
        
        String word = words[vidx] ;
    
        for(int i = 0 ; i < arr.length ; i++){
          for(int j = 0 ; j < arr[0].length ; j++){
    
            if(arr[i][j] == '-' || word.charAt(0) == arr[i][j]){ /// if current cell is '-' or matches with our starting char then check
    
              if(canWePlaceHorizontally(arr,word,i,j)){ // check if we can place our word horizontally
    
                boolean[] wePlaced = placeHorizontally(arr,word,i,j) ; //place horizontally and return booolean array that store information about which character we actully placed in array
                solution(arr,words,vidx+1) ; // now check for next word
                unplaceHorizontally(arr,word,i,j,wePlaced) ; // unvisiting the word from the  array
              } // same for vertically
              else if(canWePlaceVertically(arr,word,i,j)){
    
                boolean[] wePlaced = placeVertically(arr,word,i,j) ;
                solution(arr,words, vidx+1) ;
                unplaceVertically(arr,word,i,j,wePlaced) ;
              }
            }
          }
        }
        
      }
    
      public static boolean canWePlaceHorizontally(char[][] arr , String word, int i , int j){
    
        // checking if both end has '+' if not then return false.
        if( j-1 >= 0 && arr[i][j-1] != '+' ){ 
          return false ;
        }
    
        if(j + word.length() < arr[0].length && arr[i][j+word.length()] != '+'){
          return false;
        }
        
        //  now check if there's space available for word
        for(int jj = 0 ; jj < word.length() ; jj++ ){
    
          if( j + jj >= arr[0].length)
          return false ;
          
          if(arr[i][j+jj] == '-' || arr[i][j + jj] == word.charAt(jj) ){
            continue ;
          }
          else
          return false ;
    
        }
    
        return true ;
    
      }
    
      // same as hroizontal check 
      public static boolean canWePlaceVertically(char[][] arr , String word, int i , int j){
    
        if( i-1 >= 0 && arr[i-1][j] != '+' ){
          return false ;
        }
    
        if(i + word.length() < arr.length && arr[i + word.length()][j] != '+'){
          return false;
        }
    
        for(int ii = 0 ; ii < word.length() ; ii++ ){
    
          if( i + ii >= arr.length)
          return false ;
          
          if(arr[i+ii][j] == '-' || arr[i+ii][j ] == word.charAt(ii) ){
            continue ;
          }
          else
          return false ;
    
        }
    
        return true ;
    
      }
    
     // now placinng each word character in our array
      public static boolean[] placeHorizontally(char[][] arr, String word , int i , int j){
        boolean[] wePlaced = new boolean[word.length()] ;
        for(int jj = 0 ; jj < word.length() ; jj++){
    
          if(arr[i][j + jj] == '-' ){
    
          arr[i][j+jj] = word.charAt(jj) ;
          wePlaced[jj] = true ;
          }
    
        }
    
        return wePlaced ;
      }

       public static boolean[] placeVertically(char[][] arr, String word , int i , int j){
    
         boolean[] wePlaced = new boolean[word.length()] ;
    
        for(int ii = 0 ; ii < word.length() ; ii++){
    
          if(arr[i+ii][j] == '-'){
          arr[i+ii][j] = word.charAt(ii) ;
          wePlaced[ii] = true ;
          }
    
        }
    
        return wePlaced ;
      }
    
      // for unvisting the character
      public static void unplaceHorizontally(char[][] arr , String word , int i , int j , boolean[] wePlaced){
    
        for(int jj = 0 ; jj < word.length() ; jj++){
          if(wePlaced[jj]){
            arr[i][j+jj] = '-' ;
          }
        }
      }
    
    
      public static void unplaceVertically(char[][] arr , String word , int i , int j , boolean[] wePlaced){
    
        for(int ii = 0 ; ii < word.length() ; ii++){
    
          if(wePlaced[ii]){
    
            arr[i + ii ][j] = '-' ;
          }
        }
      }
    
    
      public static void print(char[][] arr) {
        for (int i = 0 ; i < arr.length; i++) {
          for (int j = 0 ; j < arr.length; j++) {
            System.out.print(arr[i][j]);
          }
          System.out.println();
        }
    
      }
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0 ; i < arr.length; i++) {
          String str = scn.next();
          arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0 ; i  < words.length; i++) {
          words[i] = scn.next();
        }
        solution(arr, words, 0);
        scn.close();
      }
    
}
