package _208;

import java.util.HashMap;

public class Trie {
    
    private class TrieNode {
        public char value;
        public HashMap<Character, TrieNode> child;
        public boolean isEndOfWord;
        
        TrieNode() {
            isEndOfWord = false;
            child = new HashMap<>();
        }
        
        TrieNode(char value) {
            this();
            this.value = value;
        }
    }
    
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        insert(word, root);
    }
    
    private void insert(String word, TrieNode node) {
        if (word.length() == 0) {
            node.isEndOfWord = true;
            return;
        }
        
        char firstChar = word.charAt(0);
        if (!node.child.containsKey(firstChar)) {
            node.child.put(firstChar, new TrieNode(firstChar));
        }
        
        TrieNode nextNode = node.child.get(firstChar);
        insert(word.substring(1), nextNode);
    }

    public boolean search(String word) {
        TrieNode finalNode = searchUtility(word, root);
        return finalNode != null && finalNode.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        return searchUtility(prefix, root) != null;
    }

    private TrieNode searchUtility(String prefix, TrieNode node) {
        if (prefix.length() == 0) {
            return node;
        }

        char firstChar = prefix.charAt(0);
        if (node.child.containsKey(firstChar)) {
            return searchUtility(
                    prefix.substring(1), node.child.get(firstChar)
            );
        }
        return null;
    }
}
