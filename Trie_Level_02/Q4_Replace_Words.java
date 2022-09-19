package Trie_Level_02 ;
import java.util.*;

public class Q4_Replace_Words {

    static class Node {
        Node[] childs = new Node[26];
        String str;
    }

    static Node root;

    public String replaceWords(List<String> dictionary, String sentence) {

        root = new Node(); // intializing root of trie.

        for (String word : dictionary) { // adding dictionary words in trie DS
            insert(word);
        }

        StringBuilder sb = new StringBuilder();

        for (String s : sentence.split(" ")) {
            String predecessor = find(s); // checking for each word in sentence whether it's predecessor(any prefix
                                          // substring that is in the dictionary) available or not.

            if (predecessor != null) { // when it is not available then yes it have a predeccessor
                sb.append(predecessor);
            } else { // else add original word
                sb.append(s);
            }
            // and space
            sb.append(" ");
        }

        return sb.toString().trim();

    }

    String find(String word) {

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (curr.str != null) { // checking if curr is an end point for any string
                return curr.str;
            }

            if (curr.childs[ch - 'a'] == null) { // else if next node is not available then break
                break;
            }

            curr = curr.childs[ch - 'a']; // moving to next Node (of ch)
        }

        if (curr.str != null) {
            return curr.str;
        }

        return null;

    }

    // inserting in trie.

    void insert(String word) {

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (curr.childs[ch - 'a'] == null) {
                curr.childs[ch - 'a'] = new Node();
            }

            curr = curr.childs[ch - 'a'];
        }

        curr.str = word;
    }

}
