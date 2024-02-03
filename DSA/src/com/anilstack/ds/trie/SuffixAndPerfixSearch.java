package com.anilstack.ds.trie;

import com.anilstack.ds.util.TrieNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class SuffixAndPerfixSearch {

    Map<String,Integer> map;
    TrieNode node;
    public SuffixAndPerfixSearch() {
       map = new HashMap<>();
       node = new TrieNode();
    }
    public void addWord(String[] words) {

        int index = 0;

        for (String word:words) {

            for (int i=0; i < word.length(); i++) {

                for (int j=0; j < word.length(); j++) {

                    String perfixAndSuffix = word.substring(0,i) + "#" + word.substring(j);
                    map.put(perfixAndSuffix,index);

                }
            }
            index++;
        }

    }

    private int search(String suffix, String prefix) {
        String SEARCHQUERYFORMAT = prefix+"#"+suffix;
        return map.getOrDefault(SEARCHQUERYFORMAT,-1);
    }


    public void insertWithTrie(String word, int index) {

        TrieNode currentNode = node;

        for(char c:word.toCharArray()) {

            int indexNode = c - 'a';
            if (currentNode.getChildren()[indexNode]==null) {
                currentNode.getChildren()[indexNode] = new TrieNode();
            }
            currentNode = currentNode.getChildren()[indexNode];
            currentNode.setCount(index);
        }
    }


    public int startsWith(String prefix) {

        TrieNode currentNode = node;
        for (char c:prefix.toCharArray()) {

            TrieNode next = currentNode.getChildren()[c-'a'];

            if (next==null) {
              return -1;
            }

            currentNode = next;
        }
            return currentNode.getCount();
    }

    public int searchWithTrie(String perfix, String suffix) {
        return startsWith(suffix+"{"+perfix);
    }

    public static void main(String[] args) {
        SuffixAndPerfixSearch suffixAndPerfixSearch = new SuffixAndPerfixSearch();
//        suffixAndPerfixSearch.addWord(new String[]{"bat","cat","rat"});
//        System.out.println(suffixAndPerfixSearch.search("bat","t"));

        String[] words = {"apple","bat","cat","rat"};
        int len = words.length;
        for (int i = 0; i < len; i++) {
            String s = words[i];
            for (int j = 0; j <= s.length(); j++) {
                suffixAndPerfixSearch.insertWithTrie(s.substring(j, s.length()) + '{' + s, i);
            }
        }
        System.out.println(suffixAndPerfixSearch.searchWithTrie("b","at"));
    }


}
