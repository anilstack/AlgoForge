package com.anilstack.ds.trie;

import com.anilstack.ds.util.TrieNode;

import javax.swing.*;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class TrieOperations {

    private TrieNode root;
    public TrieOperations() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        String word = "rest";
        TrieOperations trieOperations = new TrieOperations();
        trieOperations.insert(word);
        System.out.println(trieOperations.search("rest"));
        System.out.println(trieOperations.startsWith("re"));
    }

    public void insert(String word) {

        TrieNode current = root;

        for (char c : word.toCharArray()) {

            int indexInTrieNode = c - 'a';
            TrieNode[] children = current.getChildren();
            if (children[indexInTrieNode] == null) {
                current.getChildren()[indexInTrieNode] = new TrieNode();
            }
            current = current.getChildren()[indexInTrieNode];
        }
        current.setWordEnd(true);
    }

    public boolean search(String word) {

        TrieNode current = root;
        for (char c : word.toCharArray()) {

            int indexInTrieNode = c - 'a';
            if (current.getChildren()[indexInTrieNode] == null) {
                return false;
            } else {
                current = current.getChildren()[indexInTrieNode];
            }
        }
        return current.isWordEnd();
    }


    public boolean startsWith(String prefix) {

        TrieNode current = root;
        for ( char c : prefix.toCharArray()) {
            int indexInTrieNode = c - 'a';
            if (current.getChildren()[indexInTrieNode] == null) {
                return false;
            } else {
                current = current.getChildren()[indexInTrieNode];
            }
        }
        return true;
    }
}
