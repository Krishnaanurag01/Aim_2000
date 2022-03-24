package Trie_Level_02;

import java.util.*;

public class Q10_Concatenated_Words {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        root = new Node();

        // first add the word in Trie
        for (String word : words) {
            if (!word.equals(""))
                insert(word);
        }

        ans = new ArrayList<>();

        find(root); // now find the combined stings

        return ans;
    }

    static class Node {
        Node[] childs = new Node[26];
        String str;
    }

    static ArrayList<String> ans;
    static Node root;

    public void find(Node curr) {

        if (curr.str != null) {  // when the string it holds is not null then find the concatenation by sending current node and root node to another find operation. now this another find function will try to match the next string and with root starting point. 
            find(curr, root);
        }

        for (Node node : curr.childs) {

            if (node != null) {
                find(node);
            }
        }

    }

    public void find(Node curr, Node nword) {

        if (curr.str != null && nword.str != null) { // if both curr and nword str is present then add to answer.
            ans.add(curr.str);
            curr.str = null; // doing this so that we can't add this string again in our answer.
        }

        if (nword.str != null) { // if only nword is present then find it's combination
            find(curr, root);
        }

        for (int i = 0; i < 26; i++) { 

            if (curr.childs[i] != null && nword.childs[i] != null) {
                find(curr.childs[i], nword.childs[i]);
            }
        }
    }

    // same old insert function

    public void insert(String word) {

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
