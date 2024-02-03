package com.anilstack.ds.trie;

import com.anilstack.ds.util.TrieNode;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class WordDictionary {

    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);
            int index = c - 'a';
            if (currentNode.getChildren()[index] == null) {
                TrieNode newNode = new TrieNode();
                currentNode.getChildren()[index] = newNode;
            }
            currentNode = currentNode.getChildren()[index];
        }
        currentNode.setWordEnd(Boolean.TRUE);
    }

    public boolean search(String word) {
        return searchHelper(word,0,root);
    }

    private boolean searchHelper(String word,int startIndex, TrieNode root) {

        if (word.length() == startIndex) {
            return root.isWordEnd();
        }

        char c = word.charAt(startIndex);
        if (c == '.') {

            for (int i = 0 ; i<26; i++) {
                if (root.getChildren()[i]!=null && searchHelper(word,startIndex+1,root.getChildren()[i])) {
                    return true;
                }
            }

        } else {
            int index = c - 'a';
            if (root.getChildren()[index]!=null && searchHelper(word,startIndex+1,root.getChildren()[index])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("code");
        wordDictionary.addWord("coding");
        wordDictionary.addWord("cool");
        System.out.println(wordDictionary.search("cool"));
        System.out.println(wordDictionary.search(".ode"));
    }
}
