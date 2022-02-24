package Recursion_and_backtracking_level_02;
import java.util.*;
import java.io.*;

public class Q25_Permutations_Words_2 {

    public static void generateWords(int cc, String str, Character[] spots,
            HashMap<Character, Integer> lastOccurence) {
        // write your code here

        if (cc == str.length()) {
            for (char ch : spots) {
                System.out.print(ch);
            }
            System.out.println();
            return;
        }

        char currChar = str.charAt(cc);
        int ls = lastOccurence.get(currChar); // last index

        for (int i = ls + 1; i < str.length(); i++) { // storing current char after the last occurance thats why starting from ls+1
            if (spots[i] == null) { // when box is empty the only we can store new char

                spots[i] = currChar;
                lastOccurence.put(currChar, i); // i becomes the new last occurance of char
                generateWords(cc + 1, str, spots, lastOccurence);
                lastOccurence.put(currChar, ls); // unvisiting
                spots[i] = null; // unvisiting

            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Character[] spots = new Character[str.length()];

        // this hashmap will help us in identifying the redundant character
        HashMap<Character, Integer> lastOccurence = new HashMap<>();
        for (char ch : str.toCharArray()) {
            lastOccurence.put(ch, -1); // -1 denotes that this ch char has not came before
        }

        generateWords(0, str, spots, lastOccurence);
    }
}
