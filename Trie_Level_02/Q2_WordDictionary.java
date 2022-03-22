package Trie_Level_02;

//  actual question is => Design_Add_and_Search_Words_Data_Structure (leetcode 211)

class Q2_WordDictionary {

    // only this Node class is different from the previous Implementation question.
    static class Node {

        Node[] childs; // child array
        boolean isEnd;

        Node() {
            childs = new Node[26];
        }

        boolean finds(String word, int idx) {

            if (idx == word.length()) {
                return isEnd; // if true then true else false.
            }

            char ch = word.charAt(idx);

            if (ch == '.') {
                // accsses each child and check

                for (Node child : childs) {
                    if (child != null && child.finds(word, idx + 1)) { // if gives true then return true.
                        return true;
                    }
                }
                return false;
            } // when current ch is any letter.
            else { // check if that ch even exist here or not.

                if (childs[ch - 'a'] == null) {
                    return false; // when not present.
                } else { // when present then move to it's node
                    return childs[ch - 'a'].finds(word, idx + 1);
                }

            }

        }

    }

    // everything is same as previous( implementation of trie ) except the search
    // operation.
    static Node root;

    public Q2_WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if (curr.childs[ch - 'a'] == null) {
                curr.childs[ch - 'a'] = new Node();
            }

            curr = curr.childs[ch - 'a'];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        return root.finds(word, 0); // this new new only
    }
}