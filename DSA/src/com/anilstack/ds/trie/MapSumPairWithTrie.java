package com.anilstack.ds.trie;

import com.anilstack.ds.util.TrieNode;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class MapSumPairWithTrie {
    private TrieNode node = null;
    public MapSumPairWithTrie() {
        node = new TrieNode();
    }

    public void insert(String key, int value) {

        TrieNode current = node;
        for (char c : key.toCharArray()) {

            if (current.getChildren()[c-'a']==null) {
                current.getChildren()[c-'a'] = new TrieNode();
            }
            current = current.getChildren()[c-'a'];

        }
            current.setCount(value);
    }

    public int sum(String prefix) {

        TrieNode current = node;
        for (char c : prefix.toCharArray()) {

            if (current.getChildren()[c-'a']==null) {
                return 0;
            }
            current = current.getChildren()[c-'a'];

        }
        return dfs(current);
    }

    private int dfs(TrieNode node) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (node.getChildren()[i] != null) {
                sum += dfs(node.getChildren()[i]);
            }
        }
        return sum+node.getCount();
    }

    public static void main(String[] args) {

        MapSumPairWithTrie mapSumPairWithTrie = new MapSumPairWithTrie();
        mapSumPairWithTrie.insert("apple",3);
        System.out.println(mapSumPairWithTrie.sum("ap"));
        mapSumPairWithTrie.insert("app",2);
        System.out.println(mapSumPairWithTrie.sum("ap"));
        System.out.println(mapSumPairWithTrie.sum("pa"));

    }





}
